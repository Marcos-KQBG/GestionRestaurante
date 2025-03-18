import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    Scanner sc = new Scanner(System.in);
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> platos = new LinkedList<>();
    LinkedList<Pedido> pedidos = new LinkedList<>();


    public void RegistrarMesa() {
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

    public void RegistrarPlato() {

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

        platos.add(plato);


        System.out.println("Plato creado correctamente!");


    }

    public void RegistrarPedido() {

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

            if (codigo.equals('0')) {
                terminar = true;
            } else {

                for(Plato plato : this.platos) {
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
}
