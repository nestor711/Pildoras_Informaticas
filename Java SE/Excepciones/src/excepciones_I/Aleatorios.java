package excepciones_I;

// Importamos los paquetes swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Aleatorios {

    public static void main(String[] args) {

        int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce elementos de la matriz"));
        int num_aleat[] = new int[elementos];

        for (int i = 0; i < num_aleat.length; i++) {
            num_aleat[i] = (int) (Math.random() * 100);
        }
        for (int elem : num_aleat) {
            System.out.println(elem);
        }

    }

}
