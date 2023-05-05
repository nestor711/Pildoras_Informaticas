package aplicacionFinal;

// Importamos paquetes swing
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Tirar {

    public static void main(String[] args) {

        Marco mimarco = new Marco();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFileChooser chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");

        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(mimarco);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath());
        }

    }

}

class Marco extends JFrame {

    public Marco() {

        setBounds(300, 300, 300, 300);
        setVisible(true);

    }

}
