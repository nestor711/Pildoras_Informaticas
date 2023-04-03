package graficos;

// Importar los paquetes awt y swing
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Pruebas {

	public static void main(String[] args) {

		String fuente = JOptionPane.showInputDialog("Introduce fuente");

		boolean estalafuente = false;

		String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

		for (String nombredelafuente : nombresDeFuentes) {
			if (nombredelafuente.equals(fuente)) {
				estalafuente = true;
			}
		}

		if (estalafuente) {
			System.out.println("Fuente Instalada");
		} else {
			System.out.println("Fuente No Instalada");
		}

	}
}
