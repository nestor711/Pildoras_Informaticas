package excepciones_I;

// Importamos los paquetes swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Varias_Excepciones {

    public static void main(String[] args) {

        try {
            division();
        } catch (ArithmeticException e) {
            System.out.println("No se permite la división por 0");
        } catch (NumberFormatException e) {
            System.out.println("No has introducido un número entero");
            // System.out.println(e.getMessage());
            System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
        }

    }

    static void division() {

        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));

        System.err.println("El resultado es: " + num1 / num2);
    }

}
