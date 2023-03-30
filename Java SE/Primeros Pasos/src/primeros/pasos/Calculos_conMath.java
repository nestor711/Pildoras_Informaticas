
/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Calculos_conMath {
	
	// Metodo sqrt
	public static void main(String[] args) {
		
		double raiz = Math.sqrt(9);
		
		System.out.println("La raiz es: " + raiz);	
	}	
	
	// Metodo round
	public static void main2(String[] args) {
		
		float num1 = (float) 5.85;
		
		int resultado = Math.round(num1);
		
		System.out.println(resultado);	
	}	
	
	// Metodo pow
	public static void main3(String[] args) {
		
		double base = 5;
		
		double exponente = 3;
		
		int resultado = (int) Math.pow(base, exponente);
		
		System.out.println("El Resultado de " + base + "elevado a " + exponente + "es " + resultado);	
	}	
	
}
