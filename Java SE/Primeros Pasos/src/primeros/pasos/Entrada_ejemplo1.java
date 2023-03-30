package primeros.pasos;

// Importar Paquete - Scanner
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558 - 2711)
 */
public class Entrada_ejemplo1 {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu Nombre, por favor: ");

		String nombre_usario = entrada.nextLine();

		System.out.println("Introduce edad, por favor: ");

		int edad = entrada.nextInt();

		System.out.println("Hola " + nombre_usario + " . El año que viene tendrás " + (edad + 1) + " años.");

	}

}
