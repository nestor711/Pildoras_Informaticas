package mis_applets;

// Importamos los paquetes swing
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Hola_Alumnos extends JApplet {

    public void init() {
        JLabel rotulo = new JLabel("Hola Alumnos", SwingConstants.CENTER);
        add(rotulo);
    }

}
