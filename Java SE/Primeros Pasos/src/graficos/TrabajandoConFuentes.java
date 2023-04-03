package graficos;

// Importamos los paquetes swing y awt
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class TrabajandoConFuentes {
	
	public static void main(String[] args) {
		
		MarcosConFuentes mimarco = new MarcosConFuentes();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class MarcosConFuentes extends JFrame {
	
	public MarcosConFuentes() {
		
		setTitle("Prueba con Fuentes");
		setSize(400, 400);
		laminaConFuentes milamina = new laminaConFuentes();
		add(milamina);
		milamina.setForeground(Color.BLUE);
		
	}
	
}

class laminaConFuentes extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;

		// Clase Font
		Font mifuente = new Font("Arial", Font.BOLD, 26);
		g2.setFont(mifuente);
		// g2.setColor(Color.BLUE);
		g2.drawString("Néstor", 100, 100);
		
		g2.setFont(new Font("Courier", Font.ITALIC, 24));
		//g2.setColor(new Color(128, 90, 50).brighter());
		g2.drawString("Curso de Java", 100, 200);
		
	}
	
}
