package graficos;

// Importamos los paquetes swing
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class EjemploArea {

	public static void main(String[] args) {

		MarcoArea mimarco = new MarcoArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoArea extends JFrame {

	public MarcoArea() {
		setBounds(500, 300, 500, 350);
		LaminaArea milamina = new LaminaArea();
		add(milamina);
		setVisible(true);
	}

}

class LaminaArea extends JPanel {

	private JTextArea miarea;

	public LaminaArea() {

		miarea = new JTextArea(8, 20);
		JScrollPane laminaBarras = new JScrollPane(miarea);
		// miarea.setLineWrap(true);
		add(laminaBarras);
		JButton miboton = new JButton("Dale");
		miboton.addActionListener(new GestionaArea());
		add(miboton);

	}

	private class GestionaArea implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(miarea.getText());
		}

	}

}
