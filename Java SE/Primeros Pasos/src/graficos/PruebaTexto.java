package graficos;

// Importamos paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaTexto {

	public static void main(String[] args) {

		MarcoTexto mimarco = new MarcoTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoTexto extends JFrame {

	public MarcoTexto() {

		setBounds(600, 300, 600, 350);
		LaminaTexto milamina = new LaminaTexto();
		add(milamina);
		setVisible(true);

	}

}

class LaminaTexto extends JPanel {

	private JTextField campo1;
	private JLabel resultado;

	public LaminaTexto() {
		setLayout(new BorderLayout());
		JPanel milamina2 = new JPanel();
		milamina2.setLayout(new FlowLayout());
		resultado = new JLabel("", JLabel.CENTER);
		JLabel texto1 = new JLabel("Email: ");
		milamina2.add(texto1);
		campo1 = new JTextField(20);
		milamina2.add(campo1);
		add(resultado, BorderLayout.CENTER);
		JButton miboton = new JButton("Comprobar");
		DameTexto mievento = new DameTexto();
		miboton.addActionListener(mievento);
		milamina2.add(miboton);
		add(milamina2, BorderLayout.NORTH);
	}

	private class DameTexto implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int correcto = 0;
			String email = campo1.getText().trim();
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					correcto++;
				}
			}
			if (correcto != 1) {
				resultado.setText("Incorrecto");
			} else {
				resultado.setText("Correcto");
			}
		}

	}

}
