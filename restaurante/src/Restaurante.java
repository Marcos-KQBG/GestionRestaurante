import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    Scanner sc = new Scanner(System.in);
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> cartaPlatos = new LinkedList<>();
    LinkedList<Pedido> pedidos = new LinkedList<>();


    public void registrarMesa() {

        int numeroMesa;
        int capacidad;
        do{
            System.out.println("Ingresa un numero de mesa: ");
            numeroMesa = sc.nextInt();
        }while(numeroMesa <= 0);

        do { 
            System.out.println("Ingresa la capacidad de la mesa: ");
            capacidad = sc.nextInt();
        } while (capacidad <= 0);
        
        Mesa mesa = new Mesa(numeroMesa, capacidad);

        mesas.add(mesa);


        System.out.println("Mesa creada correctamente!");


    }

    private Plato crearPlato() {
        String codigoPlato;
        String nombrePlato;
        double precioPlato;

       
        System.out.println("Ingresa un codigo de plato: ");
        codigoPlato = sc.nextLine();
        sc.next();
        
        System.out.println("Ingresa el nombre del plato: ");
        nombrePlato = sc.nextLine();
        sc.next();

        
        do{
            System.out.println("Ingresa el precio del plato: ");
            precioPlato = sc.nextDouble();
        }while(precioPlato <= 0);
        
        Plato plato = new Plato(codigoPlato, nombrePlato, precioPlato);

        return plato;
    }

    public void registrarPlatoCarta() {

        Plato plato = crearPlato();

        this.cartaPlatos.add(plato);

        System.out.println("Plato creado correctamente!");

    }

    public void registrarPedido() {


        Mesa mesaEncontrada = null;
        int numeroMesa;
        
        do { 
            System.out.println("Introduce el numero de una mesa existente: ");
            numeroMesa = sc.nextInt();
            
            
            for (Mesa mesa : this.mesas) {
                if (numeroMesa == mesa.getNumero()){
                    mesaEncontrada = mesa;
                    break;
                }
            }
            if(mesaEncontrada == null){
                System.out.println("No se ha encontrado esa mesa");
            }
            
        } while (mesaEncontrada == null);
        
        LinkedList<Plato> listaPlatosPedidos = new LinkedList<>();
        
        boolean terminar = false;
        String codigo;
        
        
        while(!terminar) {
            System.out.println("Introduce el codigo de los platos: ");
            System.out.println("Si se introduce un 0 parará");
            codigo = sc.next();

            if (codigo.equals("0")) {
                terminar = true;
            } else {

                for(Plato plato : this.cartaPlatos) {
                    if (codigo.equals(plato.getCodigo())) {
                        listaPlatosPedidos.add(plato);
                        break;
                    }
                }
            }


        }

        Pedido pedido = new Pedido(mesaEncontrada, listaPlatosPedidos);

        pedidos.add(pedido);
        System.out.println("Pedido añadido correctamente");

    }

    private Pedido getPedidoNumeroMesa() {
        
        if(!pedidos.isEmpty()){
            do { 
                
                System.out.println("Introduce un numero de mesa asociado al pedido: ");
                int numero = sc.nextInt();
                
                
                for(Pedido pedido: this.pedidos){
                    if (numero == pedido.getNumeroMesa()) {
                        
                        return pedido;
                    }
                    System.out.println("Introduce un número válido");
            } 
            }while (true);
        }
            return null;
        
    }

    private Plato platoByCodigo() {
        String codigo;

        if (!this.cartaPlatos.isEmpty()) {

            do { 
                System.out.println("Introduce un código: ");
                codigo = sc.nextLine();sc.next();
                for(Plato plato : this.cartaPlatos){
                    if(plato.getCodigo().equals(codigo)) {
                        return plato;
                    }
                }
                System.out.println("No se ha encontrado");
            } while (true);
        }
         return null;
    }

    private Mesa mesaByNumber() {
        int numeroMesa;
        if (mesas.isEmpty()){
            
            do { 
                System.out.println("Introduce un número de mesa: ");
                numeroMesa = sc.nextInt();
                for(Mesa mesa : this.mesas) {
                    if (numeroMesa == mesa.getNumero() ){
                        
                        return mesa;
                    }
                } 
                System.out.println("No se ha encontrado la mesa");
                
            } while (true);
        }
        return null;
        
    }

    public void menuModificarPedido() {
        Pedido pedido = this.getPedidoNumeroMesa();
        int decision;
        
        do{
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Cambiar estado (Completado/No completado)");
            System.out.println("2. Añadir Plato");
            System.out.println("3. Borrar Plato");
            System.out.println("4. Cambiar Mesa");
            System.out.println("5. Aplicar descuento");
            System.out.println("6. Eliminar Pedido");
            System.out.println("7. Salir");

            System.out.println("Introduce una opción:");

            decision = sc.nextInt();

        }while(decision != 7);

        switch(decision){
            case 1 -> {
                pedido.cambiarCompletado();
            }
            case 2 -> {
                System.out.println("1. Nuevo Plato");
                System.out.println("2. Añadir Plato desde Carta");
                int subopcion;

                subopcion = sc.nextInt();

                switch(subopcion){
                    case 1 -> {pedido.addPlato(this.crearPlato());}
                    case 2 -> { 
                        System.out.println("Introduce un código de un plato: ");
                        pedido.addPlato(this.platoByCodigo()); 
                    }
                    case 3 -> {
                        String codigo;
                        boolean control;
                        do { 
                            System.out.println("Introduce un código de un plato");
                            codigo = sc.nextLine();sc.next();
                            control = pedido.removePlato(codigo);
                            if(control){
                                System.out.println("Se ha borrado el plato: ");
                            } else {
                                System.out.println("No se ha borrado");
                            }
                            
                        } while (control);

                    }
                    case 4 -> {
                        Mesa nuevaMesa = this.mesaByNumber();
                        pedido.setMesa(nuevaMesa);
                        System.out.println("Mesa cambiada correctamente");
                    }

                }
                
            }
        }
        
    }


}
