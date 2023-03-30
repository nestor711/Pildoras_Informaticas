package primeros.pasos;

// Importamos el Paquete swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Entrada_Numeros {
	
	public static void main(String[] args) {
		
		double x = 10000.0;
		
		System.out.printf("%1.2f", x / 3);
		
	}
	
	public static void main2(String[] args) {
		
		String num1 = JOptionPane.showInputDialog("Introduce un número: ");
		
		double num2 = Double.parseDouble(num1);
		
		System.out.print("La raíz de " + num2 + " es ");
		
		System.out.printf("%1.2f", Math.sqrt(num2));
		
	}
}
