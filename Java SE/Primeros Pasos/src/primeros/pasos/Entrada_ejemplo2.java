package primeros.pasos;

// Importar el paquete swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Entrada_ejemplo2 {

	public static void main(String[] args) {

		String nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre, por favor");

		String edad = JOptionPane.showInputDialog("Introduce la edad, por favor");
		
		int edad_usuario = Integer.parseInt(edad);
		
		System.out.println("Hola " + nombre_usuario + ". Tienes " + edad_usuario + " años.");

	}

}
