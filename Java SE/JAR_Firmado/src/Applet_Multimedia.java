
// Importamos los paquetes swing y awt
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Applet_Multimedia extends JApplet {

    Image logo;

    public void init() {

        logo = getImage(getDocumentBase(), "logo.png");

    }

    public void paint(Graphics g) {
        g.drawImage(logo, 50, 50, this);
    }

}
