package graficos;

// Importamos los paquetes swing y awt
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class EscribiendoEnMarco {

	public static void main(String[] args) {

		MarcoConTexto mimarco = new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConTexto extends JFrame {

	public MarcoConTexto() {

		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("Primer Texto - Néstor");
		Lamina milamina = new Lamina();
		add(milamina);

	}

}

class Lamina extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawString("Estamos aprendiendo Swing", 100, 100);

	}

}
