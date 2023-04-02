package poo;

// Importar el paquete util, swing y event
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaTemporizador {

	public static void main(String[] args) {

		DameLaHora oyente = new DameLaHora();

		Timer miTemporizador = new Timer(5000, oyente);

		miTemporizador.start();

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener");

		System.exit(0);
	}
}

class DameLaHora implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		Date ahora = new Date();

		System.out.println("Te pongo la hora cada 5 seg: " + ahora);
		
		Toolkit.getDefaultToolkit().beep();
	}
}
