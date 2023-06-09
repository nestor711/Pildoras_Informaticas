package graficos;

// Importamos los paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaCombo {
	
	public static void main(String[] args) {
		MarcoCombo mimarco = new MarcoCombo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class MarcoCombo extends JFrame {
	
	public MarcoCombo() {
		setVisible(true);
		setBounds(550, 300, 550, 400);
		LaminaCombo milamina = new LaminaCombo();
		add(milamina);
	}
}

class LaminaCombo extends JPanel {
	
	private JLabel texto;
	private JComboBox micombo;
	
	public LaminaCombo() {
		
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha cuyo nombre...");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto, BorderLayout.CENTER);
		JPanel lamina_norte = new JPanel();
		micombo = new JComboBox();
		micombo.setEditable(true);
		micombo.addItem("Serif");
		micombo.addItem("SansSerif");
		micombo.addItem("Monospaced");
		micombo.addItem("Dialog");
		Evento_combo mievento = new Evento_combo();
		micombo.addActionListener(mievento);
		lamina_norte.add(micombo);
		add(lamina_norte, BorderLayout.NORTH);
	}
	
	private class Evento_combo implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			texto.setFont(new Font((String) micombo.getSelectedItem(), Font.PLAIN, 18));
		}
		
	}
	
}
