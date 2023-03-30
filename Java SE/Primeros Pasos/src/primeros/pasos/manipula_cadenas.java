package primeros.pasos;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class manipula_cadenas {

	public static void main(String[] args) {

		String nombre = "Néstor";

		System.out.println("Mi nombre es: " + nombre);
		
		// Metodo Lenght
		System.out.println("Mi nombre tiene " + nombre.length() + "letras.");
		
		// Metodo charAt
		System.out.println("La primera letra de mi nombre es: " + nombre.charAt(0));
		
		int ultima_letra;
		
		ultima_letra = nombre.length();
		
		System.out.println("Y la última letra es la " + nombre.charAt(ultima_letra-1));
	}	
}
