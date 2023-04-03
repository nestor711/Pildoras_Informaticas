package graficos;

// Importamos los paquetes swing y awt
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class TrabajandoColores {

	public static void main(String[] args) {

		MarcosConColor mimarco = new MarcosConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcosConColor extends JFrame {

	public MarcosConColor() {

		setTitle("Prueba con Colores");
		setSize(400, 400);
		laminaConColor milamina = new laminaConColor();
		add(milamina);
		milamina.setBackground(Color.PINK);
		// milamina.setBackground(SystemColor.window);

	}

}

class laminaConColor extends JPanel {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Clase Rectangle2D - Dibujo de Rectángulo
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.setPaint(Color.BLUE);
		g2.draw(rectangulo);
		g2.setPaint(Color.RED);
		g2.fill(rectangulo);

		// Clase Ellipse2D - Dibujo Elipse
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		Color micolor = new Color(125, 189, 200);
		g2.setPaint(micolor);
		// g2.setPaint(new Color(109, 172, 59).brighter());
		// g2.setPaint(new Color(109, 172, 59).darker());
		g2.fill(elipse);

	}

}
