package graficos;

// Importamos paquetes swing y awt
import java.awt.Dimension;
//import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
//import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class MarcoSpinner {

	public static void main(String[] args) {
		FrameSpinner mimarco = new FrameSpinner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class FrameSpinner extends JFrame {

	public FrameSpinner() {
		setBounds(550, 350, 550, 350);
		setVisible(true);
		add(new LaminaSpinner());
	}

}

class LaminaSpinner extends JPanel {

	public LaminaSpinner() {

		/*String lista[] = {
			"Enero", "Febrero", "Marzo", "Abril"
		};*/
		//String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
			@Override
			public Object getNextValue() {
				return super.getPreviousValue();
			}

			@Override
			public Object getPreviousValue() {
				return super.getNextValue();
			}
		});
		Dimension d = new Dimension(200, 20);
		control.setPreferredSize(d);
		add(control);

	}

	/*private class MiModeloJSpinner extends SpinnerNumberModel {

		public MiModeloJSpinner() {
			super(5, 0, 10, 1);
		}

		@Override
		public Object getNextValue() {
			return super.getPreviousValue();
		}

		@Override
		public Object getPreviousValue() {
			return super.getNextValue();
		}

	}*/
}
