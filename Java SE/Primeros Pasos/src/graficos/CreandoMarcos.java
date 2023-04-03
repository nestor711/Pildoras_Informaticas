package graficos;

// Importamos el paquete swing
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class CreandoMarcos {
	
	public static void main(String[] args) {
		
		miMarco marco1 = new miMarco();
		
		marco1.setVisible(true);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class miMarco extends JFrame {
	
	public miMarco() {

		// setSize(500, 300);
		// setLocation(500, 300);
		setBounds(500, 300, 550, 250);

		//setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Mi ventana");
	}
	
}
