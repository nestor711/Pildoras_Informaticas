package graficos;

// Importamos los pquetes swing y awt
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Eventos_Ventana {
	
	public static void main(String[] args) {
		
		MarcoVentana mimarco = new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MarcoVentana mimarco2 = new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		mimarco.setTitle("Ventana 1");
		mimarco2.setTitle("Ventana 2");
		mimarco.setBounds(300, 300, 500, 350);
		mimarco2.setBounds(900, 300, 500, 350);
	}
	
}

class MarcoVentana extends JFrame {
	
	public MarcoVentana() {

		// setTitle("Respondiendo");
		// setBounds(300, 300, 500, 350);
		setVisible(true);

		/*M_Ventana oyente_ventana = new M_Ventana();
		addWindowListener(oyente_ventana);*/
		addWindowListener(new M_Ventana());
		
	}
}

class M_Ventana extends WindowAdapter {

	/*
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Ventana Activada");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("La Ventana ha sido Cerrada");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Cerrando Ventana");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Ventana Desactivada");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Ventana Restaurada");
	}*/
	
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Ventana Minimizada");
	}

	/*
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Ventana Abierta");
	}*/
}
