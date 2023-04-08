package graficos;

// Importamos los paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Ejemplo_radio {

	public static void main(String[] args) {
		Marco_radio mimarco = new Marco_radio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco_radio extends JFrame {

	public Marco_radio() {

		setVisible(true);
		setBounds(550, 300, 500, 300);
		Lamina_radio milamina = new Lamina_radio();
		add(milamina);

	}

}

class Lamina_radio extends JPanel {

	private JLabel texto;
	private JRadioButton boton1, boton2, boton3, boton4;
	private ButtonGroup migrupo;
	private JPanel lamina_botones;

	public Lamina_radio() {

		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
		texto.setFont(new Font("Serif", Font.PLAIN, 12));
		add(texto, BorderLayout.CENTER);
		colocarBotones("Pequeño", false, 10);
		colocarBotones("Mediano", true, 12);
		colocarBotones("Grande", false, 18);
		colocarBotones("Muy Grande", false, 26);
		add(lamina_botones, BorderLayout.SOUTH);
		lamina_botones = new JPanel();
		migrupo = new ButtonGroup();
		/*ButtonGroup migrupo = new ButtonGroup();
		boton1 = new JRadioButton("Pequeño", false);
		boton2 = new JRadioButton("Mediano", true);
		boton3 = new JRadioButton("Grande", false);
		boton4 = new JRadioButton("Muy Grande", false);
		JPanel lamina_radio2 = new JPanel();
		Evento_radio mievento = new Evento_radio();
		boton1.addActionListener(mievento);
		boton2.addActionListener(mievento);
		boton3.addActionListener(mievento);
		boton4.addActionListener(mievento);
		migrupo.add(boton1);
		migrupo.add(boton2);
		migrupo.add(boton3);
		migrupo.add(boton4);
		lamina_radio2.add(boton1);
		lamina_radio2.add(boton2);
		lamina_radio2.add(boton3);
		lamina_radio2.add(boton4);
		add(lamina_radio2, BorderLayout.SOUTH);*/
	}

	/*
	private class Evento_radio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == boton1) {
				// System.out.println("Has pulsado el 1");
				texto.setFont(new Font("Serif", Font.PLAIN, 10));
			} else if (e.getSource() == boton2) {
				texto.setFont(new Font("Serif", Font.PLAIN, 12));
			} else if (e.getSource() == boton3) {
				texto.setFont(new Font("Serif", Font.PLAIN, 18));
			} else if (e.getSource() == boton4) {
				texto.setFont(new Font("Serif", Font.PLAIN, 24));
			}
		}
	}*/
	public void colocarBotones(String nombre, boolean seleccionado, final int tamano) {
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		migrupo.add(boton);
		lamina_botones.add(boton);
		ActionListener mievento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setFont(new Font("Serif", Font.PLAIN, tamano));
			}
		};
		boton.addActionListener(mievento);
	}
}
