package primeros.pasos;

// Importamos el paquete swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Acceso_aplicacion {

	public static void main(String[] args) {

		String clave = "Nestor";

		String pass = "";

		// Bucle o Ciclo While
		while (clave.equals(pass) == false) {

			pass = JOptionPane.showInputDialog("Introduce la Contraseña");

			if (clave.equals(pass) == false) {

				System.out.println("Contraseña Incorrecta");

			}
		}

		System.out.println("Contraseña Correcta. Acceso permitido");
	}
}
