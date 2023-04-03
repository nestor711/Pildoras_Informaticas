package graficos;

// Importamos los paquetes swing y awt
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class CreandoMarcoCentrado {

	public static void main(String[] args) {

		MarcoCentrado mimarco = new MarcoCentrado();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoCentrado extends JFrame {

	public MarcoCentrado() {

		Toolkit mipantalla = Toolkit.getDefaultToolkit();

		Dimension tamanoPantalla = mipantalla.getScreenSize();

		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);
		setTitle("Marco Centrado");
		Image miIcono = mipantalla.getImage("src/graficos/icono.gif");
		setIconImage(miIcono);
	}

}
