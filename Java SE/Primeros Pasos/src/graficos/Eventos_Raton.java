package graficos;

// Importamos los paquetes de swing y awt
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
// import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Eventos_Raton {

	public static void main(String[] args) {

		MarcoRaton mimarco = new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoRaton extends JFrame {

	public MarcoRaton() {

		setVisible(true);
		setBounds(700, 300, 600, 450);

		EventosDeRaton EventoRaton = new EventosDeRaton();
		addMouseMotionListener(EventoRaton);

	}

}

class EventosDeRaton implements MouseMotionListener {

	/*
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Has hecho Click");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Acabas de Presionar");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Acabas de Levantar");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Acabas de Entrar");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Acabas de Salir");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// System.out.println("Coordenada X: " + e.getX() + " Coordenada Y: " + e.getY());
		System.out.println(e.getClickCount());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// System.out.println(e.getModifiersEx());

		if (e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			System.out.println("Has pulsado el botón Izquierdo");
		} else if (e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) {
			System.out.println("Has pulsado la rueda del ratón");
		} else if (e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			System.out.println("Has pulsado el botón Derecho");
		}
	}*/
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estás arrastrando");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estás moviendo");
	}

}
