
package primeros.pasos;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Declaraciones_Operadores {
	
	public static void main(String[] args) {
		int a = 5;
		
		int b;
		
		b = 7;
		
		int c = b + a;
		
		c+=6;
		
		System.out.println(c);
	}
	
	public static void main2(String[] args) {
		final double apulgadas = 2.54;
		
		double cm = 6;
		
		double resultado = cm / apulgadas;
		
		
		System.out.println("En " + cm + "cm hay " + resultado + "pulgadas");
	}
}
