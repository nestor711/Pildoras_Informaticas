package graficos;

// Importamos los paquetes swing y awt
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class CambioEstado {

	public static void main(String[] args) {

		MarcoEstado mimarco = new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEstado extends JFrame {

	public MarcoEstado() {

		setVisible(true);
		setBounds(300, 300, 500, 350);
		CambiaEstado nuevo_estado = new CambiaEstado();
		addWindowStateListener(nuevo_estado);

	}

}

class CambiaEstado implements WindowStateListener {

	@Override
	public void windowStateChanged(WindowEvent e) {
		// System.out.println("La Ventana ha cambiado de Estado");
		// System.out.println(e.getNewState());

		if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
			System.out.println("La Ventana está a pantalla completa");
		} else if (e.getNewState() == JFrame.NORMAL) {
			System.out.println("La Ventana está Normal");
		} else if (e.getNewState() == JFrame.ICONIFIED) {
			System.out.println("La Ventana está Minimizada");
		}
	}
}
