package primeros.pasos;

// Importamos el paquete util
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Adivina_Numero {

	public static void main(String[] args) {

		int aleatorio = (int) (Math.random() * 100);

		Scanner entrada = new Scanner(System.in);

		int numero = 0;
		int intentos = 0;

		// Bucle o Ciclo While
		while (numero != aleatorio) {

			intentos++;

			System.out.println("Introduce un número, por favor");

			numero = entrada.nextInt();

			if (aleatorio < numero) {
				System.out.println("Más bajo");
			} else if (aleatorio > numero) {
				System.out.println("Más alto");
			}
		}
		System.out.println("Correcto. Lo has conseguido en " + intentos + " intentos.");
	}
}
