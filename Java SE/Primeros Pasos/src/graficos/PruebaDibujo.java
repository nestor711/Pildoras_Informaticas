package graficos;

// Importamos los paquetes swing y awt
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaDibujo {
	
	public static void main(String[] args) {
		
		MarcosConDibujos mimarco = new MarcosConDibujos();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class MarcosConDibujos extends JFrame {
	
	public MarcosConDibujos() {
		
		setTitle("Prueba de Dibujo");
		setSize(400, 400);
		laminaConFiguras milamina = new laminaConFiguras();
		add(milamina);
		
	}
	
}

class laminaConFiguras extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// g.drawRect(50, 50, 200, 200);
		// g.drawLine(100, 100, 300, 200);
		// g.drawArc(50, 100, 100, 200, 120, 150);

		Graphics2D g2 = (Graphics2D) g;

		// Clase Rectangle2D
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.draw(rectangulo);

		// Clase Ellipse2D
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.draw(elipse);

		// Clase Line2D
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		// Circulo2D
		double CentroenX = rectangulo.getCenterX();
		double CentroenY = rectangulo.getCenterY();
		
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX + radio, CentroenY + radio);
		g2.draw(circulo);
		
	}
	
}
