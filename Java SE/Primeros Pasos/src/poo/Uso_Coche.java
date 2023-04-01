package poo;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Coche {
	
	public static void main(String[] args) {
		/*
		Coche Renault = new Coche(); //Instanciar una Clase. Ejemplar de Clase
		Coche micoche = new Coche();
		
		micoche.establece_color(JOptionPane.showInputDialog("Introduce color"));
		
		System.out.println(micoche.dime_datos_generales());
		
		System.out.println(micoche.dime_color());
		
		micoche.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero?"));
		System.out.println(micoche.dime_asientos());
		
		micoche.configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador?"));
		System.out.println(micoche.dime_climatizador());
		
		System.out.println(micoche.dime_peso_coche());
		
		System.out.println("El precio final del coche es: " + micoche.precio_coche());
		
		System.out.println("Este Coche tiene " + Renault.getRuedas() + " ruedas.");
		System.out.println("El largo del coche es " + Renault.getLargo());
		*/
		
		Coche micoche1 = new Coche();
		
		micoche1.configura_asientos("Rojo");
		
		Furgoneta miFurgoneta1 = new Furgoneta(7, 580);
		
		miFurgoneta1.establece_color("azul");
		miFurgoneta1.configura_asientos("Si");
		miFurgoneta1.configura_climatizador("Si");
		
		System.out.println(micoche1.dime_datos_generales() + " " + micoche1.dime_color());
		System.out.println(miFurgoneta1.dime_datos_generales() + " " + miFurgoneta1.dimeDatosFurgoneta());
		
	}
}
