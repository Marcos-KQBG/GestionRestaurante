import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    Scanner sc = new Scanner(System.in);
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> platos = new LinkedList<>();


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
        sc.nextLine();
        
        System.out.println("Ingresa el nombre del plato: ");
        nombrePlato = sc.nextLine();
        sc.nextLine();

        
        do{
            System.out.println("Ingresa el precio del plato: ");
            precioPlato = sc.nextDouble();
        }while(precioPlato <= 0);
        
        Plato plato = new Plato(codigoPlato, nombrePlato, precioPlato);

        platos.add(plato);


        System.out.println("Plato creado correctamente!");


    }

    public void RegistrarPedido() {
        
    }
}
