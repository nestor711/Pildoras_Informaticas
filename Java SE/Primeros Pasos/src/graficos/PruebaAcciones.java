package graficos;

// Importamos los paquetes swing y awt
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaAcciones {

	public static void main(String[] args) {

		MarcoAccion marco = new MarcoAccion();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

class MarcoAccion extends JFrame {

	public MarcoAccion() {
		setTitle("Prueba Acciones");
		setBounds(600, 350, 600, 300);
		PanelAccion lamina = new PanelAccion();
		add(lamina);
	}

}

class PanelAccion extends JPanel {

	public PanelAccion() {

		AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/bola_amarilla.gif"), Color.yellow);
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/graficos/bola_azul.gif"), Color.blue);
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/bola_roja.gif"), Color.red);

		/*JButton botonAmarrillo = JButton(accionAmarrillo);
		add(botonAmarrillo);*/
		add(new JButton(accionAmarillo));
		add(new JButton(accionAzul));
		add(new JButton(accionRojo));

		/*JButton botonAmarrillo = new JButton("Amarrillo");
		JButton botonAzul = new JButton("Azul");
		JButton botonRojo = new JButton("Rojo");
		
		add(botonAmarrillo);
		add(botonAzul);
		add(botonRojo);*/
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		// KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
		
		ActionMap mapaAccion = getActionMap();
		mapaAccion.put("fondo_amarillo", accionAmarillo);
		mapaAccion.put("fondo_azul", accionAzul);
		mapaAccion.put("fondo_rojo", accionRojo);
	}

	private class AccionColor extends AbstractAction {

		public AccionColor(String nombre, Icon icono, Color color_boton) {

			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
			putValue("Color_de_Fondo", color_boton);
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Color c = (Color) getValue("Color_de_Fondo");
			setBackground(c);
			System.out.println("Nombre: " + getValue(Action.NAME) + " Descripción: " + getValue(Action.SHORT_DESCRIPTION));

		}

	}

}