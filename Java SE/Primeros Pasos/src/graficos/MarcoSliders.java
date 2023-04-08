package graficos;

// Importamos los paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import javax.swing.SwingConstants;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class MarcoSliders {
	
	public static void main(String[] args) {
		Frame_Sliders mimarco = new Frame_Sliders();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class Frame_Sliders extends JFrame {
	
	public Frame_Sliders() {
		setBounds(550, 400, 550, 350);
		Lamina_Sliders milamina = new Lamina_Sliders();
		add(milamina);
		setVisible(true);
	}
	
}

class Lamina_Sliders extends JPanel {
	
	private JLabel rotulo;
	private JSlider control;
	//private static int contador;
	
	public Lamina_Sliders() {
		/*JSlider control = new JSlider(0, 100, 50);
		control.setOrientation(SwingConstants.VERTICAL);
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		control.setPaintTicks(true);
		control.setFont(new Font("Serif", Font.ITALIC, 12));
		control.setPaintLabels(true);
		control.setSnapToTicks(true);
		add(control);*/
		
		setLayout(new BorderLayout());
		rotulo = new JLabel("En un lugar de la Mancha cuyo nombre...");
		add(rotulo, BorderLayout.CENTER);
		control = new JSlider(8, 50, 12);
		control.setMajorTickSpacing(20);
		control.setMinorTickSpacing(5);
		control.setPaintTicks(true);
		control.setPaintLabels(true);
		control.setFont(new Font("Serif", Font.ITALIC, 10));
		control.addChangeListener(new EventoSlider());
		JPanel laminaSlider = new JPanel();
		laminaSlider.add(control);
		add(laminaSlider, BorderLayout.NORTH);
	}
	
	private class EventoSlider implements ChangeListener {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			//contador++;
			//System.out.println("Estas manipulando el deslizante: " + control.getValue());
			rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
		}
		
	}
	
}
