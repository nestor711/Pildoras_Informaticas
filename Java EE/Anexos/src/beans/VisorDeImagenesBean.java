package beans;

// Importamos paquetes swing, awt, imageio y io
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase Pretende construir un Bean para incluir Imágenes
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class VisorDeImagenesBean extends JLabel {

    /**
     *
     * El tamaño máximo en Megas
     */
    public static int PruebaConstante = 5;
    private File archivo = null;

    public VisorDeImagenesBean() {

        setBorder(BorderFactory.createEtchedBorder());

    }

    /**
     * Método clave para escoger imagen
     *
     * @param elegirImagen. El parámetro te permitira escoger una imagen
     */
    public void setEscogeImagen(String elegirImagen) {

        try {

            archivo = new File(elegirImagen);
            setIcon(new ImageIcon(ImageIO.read(archivo)));

        } catch (IOException e) {
            archivo = null;
            setIcon(null);
        }

    }

    /**
     *
     * @return Devuelve la ruta de la imagen escogida con setEscogeImagen
     * @param No recibe párametro alguno
     */
    public String getEscogeImagen() {
        if (archivo == null) {
            return null;
        } else {
            return archivo.getPath();
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

}
