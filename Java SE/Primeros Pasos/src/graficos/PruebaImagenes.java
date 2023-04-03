package graficos;

// Importamos los paquetes swing, awt, imageio y io
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaImagenes {

	public static void main(String[] args) {

		MarcoImagen mimarco = new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoImagen extends JFrame {

	public MarcoImagen() {

		setTitle("Prueba con Imagen");
		setBounds(750, 300, 300, 200);
		laminaConImagen milamina = new laminaConImagen();
		add(milamina);

	}

}

class laminaConImagen extends JPanel {

	private Image imagen;

	public laminaConImagen() {

		// Clases Image - ImageIO
		// File miimagen = new File("src/graficos/coche.png");
		try {
			// imagen = ImageIO.read(new File("src/graficos/coche.png"));
			imagen = ImageIO.read(new File("src/graficos/bola.gif"));
		} catch (IOException e) {
			System.out.println("La Imagen no se encuentra");
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// g.drawImage(imagen, 5, 5, null);
		int anchuraImagen = imagen.getWidth(this);
		int alturaImagen = imagen.getHeight(this);

		g.drawImage(imagen, 0, 0, null);

		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 200; j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen * i, alturaImagen * j);
				}
			}
		}

	}

}
