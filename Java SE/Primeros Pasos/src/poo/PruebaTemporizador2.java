package poo;

// Importamos paquetes event, util y swing
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaTemporizador2 {

	public static void main(String[] args) {

		Reloj mireloj = new Reloj();
		mireloj.enMarcha(3000, true);

		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para terminar");

		System.exit(0);
	}
}

class Reloj {

	public void enMarcha(int intervalo, final boolean sonido) {

		class DameLaHora2 implements ActionListener {

			public void ActionPerformed(ActionEvent evento) {

				Date ahora = new Date();

				System.out.println("Te pongo la hora cada 3 seg " + ahora);

				if (sonido) {
					ToolKit.getDefaultToolkit().beep();
				}
			}

		}

		ActionListener oyente = new DameLaHora2();

		Timer miTemporizador = new Timer(intervalo, oyente);

		miTemporizador.start();
	}

}
