package primeros.pasos;

// Importar el paquete util
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Tallas {

	// Tipos enumerados o enum
	
	/*enum Talla {
		Mini, Mediano, Grande, Muy_Grande
	};*/
	
	enum Talla {

		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");

		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}

		private String abreviatura;

		// Metodo Get
		public String dameAbreviatura() {
			return abreviatura;
		}
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Escribe una talla: MINI, MEDIANO, GRANDE, MUY_GRANDE");
		String entrada_datos = entrada.next().toUpperCase();

		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);

		System.out.println("Talla = " + la_talla);
		System.out.println("Abreviatura = " + la_talla.dameAbreviatura());
	}
}
