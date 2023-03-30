package primeros.pasos;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class manipula_cadenas2 {

	public static void main(String[] args) {

		String frase = "Hoy es un estupendo día para aprender a programar en Java";
		
		// Metodo subString
		String frase_resumen = frase.substring(0, 29) + "irnos a la playa y olvidarnos de todo..." + "y " + frase.substring(29, 57);

		System.out.println(frase_resumen);

	}

}
