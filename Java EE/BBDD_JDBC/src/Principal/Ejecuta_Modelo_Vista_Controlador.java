package Principal;

// Importamos paquete vista y swing
import Vista.Marco_Aplicacion2;
import javax.swing.JFrame;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Ejecuta_Modelo_Vista_Controlador {

    public static void main(String[] args) {

        Marco_Aplicacion2 mimarco = new Marco_Aplicacion2();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}
