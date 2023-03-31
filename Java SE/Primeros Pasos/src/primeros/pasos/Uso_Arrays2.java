package primeros.pasos;

// Importamos el paquete swing
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Arrays2 {

	public static void main(String[] args) {

		String paises[] = new String[8];

		/*paises[0] = "España";
		paises[1] = "México";
		paises[2] = "Colombia";
		paises[3] = "Perú";
		paises[4] = "Chile";
		paises[5] = "Argentina";
		paises[6] = "Ecuador";
		paises[7] = "Venezuela";*/
		
		//String paises[] = {"España", "México", "Colombia", "Perú", "Chile", "Argentina", "Ecuador", "Venezuela"};  
		
		// Bucle o ciclo for
		/*for (int i = 0; i < paises.length; i++) {
			System.out.println("País " + (i + 1) + " " + paises[i]);
		}*/
		
		for (int i = 0; i < 8; i++) {

			paises[i] = JOptionPane.showInputDialog("Introduce el país" + (i + 1));

		}

		// Bucle o ciclo for-each
		for (String elemento : paises) {

			System.out.println("País: " + elemento);
		}
	}

	public static void main2(String[] args) {

		int[] matriz_aleatorios = new int[150];

		for (int i = 0; i < matriz_aleatorios.length; i++) {
			matriz_aleatorios[i] = (int) Math.round(Math.random() * 100);
		}

		for (int numeros : matriz_aleatorios) {
			System.out.print(numeros + " ");
		}
	}
}
