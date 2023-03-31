package primeros.pasos;

// Importamos el paquete swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Factorial {

	public static void main(String[] args) {

		long resultado = 1L;

		int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));

		// Ciclo For
		for (int i = numero; i > 0; i--) {
			resultado = resultado * i;
		}

		System.out.println("El factorial de " + numero + " es " + resultado);
	}
}