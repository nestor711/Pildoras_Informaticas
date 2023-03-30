package primeros.pasos;

// Importamos el paquete java.util
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Evalua_edad {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce tu edad, por favor");

		int edad = entrada.nextInt();

		if (edad >= 18) {
			System.out.println("Eres mayor de edad");

		} else {
			System.out.println("Eres menor de edad");
		}
	}

	public static void main2(String[] args) {

		Scanner entrada2 = new Scanner(System.in);

		System.out.println("Introduce tu edad, por favor");

		int edad2 = entrada2.nextInt();

		if (edad2 < 18) {
			System.out.println("Eres un adolescente");
		} else if (edad2 < 40) {
			System.out.println("Eres joven");
		} else if (edad2 < 65) {
			System.out.println("Eres maduro");
		} else {
			System.out.println("Cuídate");
		}
	}
}
