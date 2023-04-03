package graficos;

// Importamos los paquetes swing y awt
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaEventos {

	public static void main(String[] args) {

		MarcoBotones mimarco = new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoBotones extends JFrame {

	public MarcoBotones() {

		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		laminaBotones milamina = new laminaBotones();
		add(milamina);

	}

}

class laminaBotones extends JPanel {

	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amrillo");
	JButton botonRojo = new JButton("Rojo");

	public laminaBotones() {
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);

		ColorFondo Azul = new ColorFondo(Color.blue);
		ColorFondo Amarillo = new ColorFondo(Color.yellow);
		ColorFondo Rojo = new ColorFondo(Color.red);

		botonAzul.addActionListener(Azul);
		botonAmarillo.addActionListener(Amarillo);
		botonRojo.addActionListener(Rojo);
	}

	/*
	@Override
	public void actionPerformed(ActionEvent e) {

		Object botonPulsado = e.getSource();

		if (botonPulsado == botonAzul) {
			setBackground(Color.blue);
		} else if (botonPulsado == botonAmarillo) {
			setBackground(Color.yellow);
		} else {
			setBackground(Color.red);
		}

	}
	 */
	
	private class ColorFondo implements ActionListener {

		private Color ColorDeFondo;

		public ColorFondo(Color c) {

			ColorDeFondo = c;

		}

		@Override
		public void actionPerformed(ActionEvent e) {

			setBackground(ColorDeFondo);

		}

	}
}
