package primeros.pasos;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Arrays {

	public static void main(String[] args) {

		// Primera forma de declarar matrices
		/*int mi_matriz[] = new int[5];

		mi_matriz[0] = 5;
		mi_matriz[1] = 38;
		mi_matriz[2] = -15;
		mi_matriz[3] = 92;
		mi_matriz[4] = 71;
		 */
		// Segunda forma de declarar matrices
		int mi_matriz[] = {5, 38, -15, 92, 71};

		for (int i = 0; i < mi_matriz.length; i++) {
			System.out.println("Valor del índice " + i + " es: " + mi_matriz[i]);
		}
	}
}