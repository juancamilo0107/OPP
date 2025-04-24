import java.util.Scanner;

// Clase principal del programa
public class Main {
    public static void main(String[] args) {
        // Usamos Scanner para leer los números que el usuario escriba
            Scanner scanner = new Scanner(System.in);
            // Pedimos el primer número
            System.out.print("Ingrese el primer número: ");
            int numero1 = scanner.nextInt();

            // Pedimos el segundo número
            System.out.print("Ingrese el segundo número: ");
            int numero2 = scanner.nextInt();

            // Creamos un objeto de la clase Operations y le pasamos los dos números
            Operaciones operacion = new Operaciones(numero1, numero2);

            // Mostramos los resultados de las operaciones matemáticas básicas
            operacion.sumar();
            System.out.println(operacion.getResult());
            /*
            System.out.println("Suma: " + operacion.sumar());
            System.out.println("Resta: " + operacion.restar());
            System.out.println("Multiplicación: " + operacion.multiplicar());
            */
        }        
}