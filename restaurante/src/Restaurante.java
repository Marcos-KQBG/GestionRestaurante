import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    Scanner sc = new Scanner(System.in);
    LinkedList<Mesa> mesas = new LinkedList<>();


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

    public void RegistrarPedido() {


    }

}
