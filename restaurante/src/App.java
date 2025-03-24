import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
         
        Restaurante restaurante = new Restaurante();
        int eleccion;
        
        do{ 
            System.out.println("¿Que funcion desea utilizar?");

            System.out.println("1. Registrar Mesa");
            System.out.println("2. Registrar Plato");
            System.out.println("3. Registrar Pedido");
            System.out.println("4. Modificar Pedido");
            System.out.println("5. Modificar o Borrar Plato");
            System.out.println("6. Guardar Datos");
            System.out.println("7. Cargar Datos");
            System.out.println("8. Salir");

            eleccion = sc.nextInt();

            switch(eleccion) {
                case 1 -> {
                    restaurante.registrarMesa();
                } 
                case 2 -> {
                    restaurante.registrarPlatoCarta();
                }
                case 3 -> {
                    restaurante.registrarPedido();
                }
                case 4 -> {
                    restaurante.menuModificarPedido();
                }
                
                case 5 -> {
                    //ModificarPlato()
                    //BorrarPlato()
                }
                case 6 -> {
                    //GuardarDatos()
                }
                case 7 -> {
                    //CargarDatos()
                }
                case 8 -> {
                    //Salir()
                }
            }
            sc.close();
        }while (eleccion != 8);
    } 
}
