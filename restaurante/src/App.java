import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();

        

        System.out.println("¿Que funcion desea utilizar?");

        System.out.println("1. Registrar Mesa");
        System.out.println("2. Registrar Plato");
        System.out.println("3. Registrar Pedido");
        System.out.println("4. Modificar Pedido");
        System.out.println("5. Borrar pedido");
        System.out.println("6. Modificar o Borrar Plato");
        System.out.println("7. Guardar Datos");
        System.out.println("8. Cargar Datos");
        System.out.println("9. Salir");

        int eleccion = sc.nextInt();

        switch(eleccion) {
            case 1 -> {
                restaurante.RegistrarMesa();
            } 
            case 2 -> {
                //RegistrarPlato()
            }
            case 3 -> {
                //RegistrarPedido()
            }
            case 4 -> {
                //ModificarPedido()
            }
            case 5 -> {
                //BorrarPedido()
            }
            case 6 -> {
                //ModificarPlato()
                //BorrarPlato()
            }
            case 7 -> {
                //GuardarDatos()
            }
            case 8 -> {
                //CargarDatos()
            }
            case 9 -> {
                //Salir()
            }
        }
        sc.close();
        
    }
}
