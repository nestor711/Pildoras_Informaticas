package excepciones_I;

// Importamos los paquetes de util
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Entrada_datos {

    public static void main(String[] args) {

        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Introducir Datos");
        System.out.println("2. Sair del Programa");

        Scanner entrada = new Scanner(System.in);

        int decision = entrada.nextInt();

        if (decision == 1) {
            try {
                pedirDatos();
            } catch (Exception e) {
                System.out.println("Qué demonios has introduciod en la edad");
            }

        } else {
            System.out.println("Adios");
            System.exit(0);
        }

        entrada.close();

    }

    static void pedirDatos() throws InputMismatchException {

        //try {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu nombre, por favor");
        String nombre_usuario = entrada.nextLine();

        System.out.println("Introduce tu edad, por favor");
        int edad = entrada.nextInt();

        System.out.println("Hola " + nombre_usuario + ". El año que viene tendrás " + (edad + 1) + " años.");

        entrada.close();

        //} catch (Exception e) {
        //System.out.println("Qué demonios has introduciod en la edad");
        //}
        System.out.println("Hemos terminado");

    }

}
