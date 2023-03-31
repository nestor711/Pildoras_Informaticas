package poo;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Coche {

	// Encapsulación
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;

	// Constructores
	public Coche() {
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		peso_plataforma = 500;
	}
	
	public Coche(int ruedas, int largo, int ancho, int motor, int peso) {
		this.ruedas = ruedas;
		this.largo = largo;
		this.ancho = ancho;
		this.motor = motor;
		this.peso_plataforma = peso;
	}

	// Metodos Getter and Setter
	public int getRuedas() {
		return ruedas;
	}
	
	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}
	
	public int getLargo() {
		return largo;
	}
	
	public void setLargo(int largo) {
		this.largo = largo;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public int getMotor() {
		return motor;
	}
	
	public void setMotor(int motor) {
		this.motor = motor;
	}
	
	public int getPeso_Plataforma() {
		return peso_plataforma;
	}
	
	public void setPeso_Plataforma(int peso_plataforma) {
		this.peso_plataforma = peso_plataforma;
	}
	
	public void establece_color(String color_coche) { //Setter
		this.color = color_coche;
	}
	
	public String dime_color() { //Getter
		return "El color del coche es " + color;
	}
	
	public String dime_datos_generales() {
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas " + " . Mide " + largo / 1000 + " metros con un ancho de " + ancho + " cm y un peso de plataforma de " + peso_plataforma + " kg";
	}
	
	public void configura_asientos(String asientos_cuero) {//Setter asientos cuero
		if (asientos_cuero.equalsIgnoreCase("si")) {
			this.asientos_cuero = true;
		} else {
			this.asientos_cuero = false;
		}
	}
	
	public String dime_asientos() {//Getter asientos 
		if (asientos_cuero == true) {
			return "El coche tiene asientos de cuero";
		} else {
			return "El coche tiene asientos de serie";
		}
	}
	
	public void configura_climatizador(String climatizador) {//Setter climatizador
		if (climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}
	
	public String dime_climatizador() {//Getter climatizador
		if (climatizador == true) {
			return "El coche incorpora climatizador";
		} else {
			return "El coche lleva aire acondicionado";
		}
	}
	
	public String dime_peso_coche() {
		int peso_carroceria = 500;
		
		peso_total = peso_total + peso_carroceria;
		
		if (asientos_cuero == true) {
			peso_total = peso_total + 50;
		}
		if (climatizador == true) {
			peso_total = peso_total + 20;
		}
		
		return "El peso del coche es " + peso_total;
	}
	
	public int precio_coche() {//Getter precio coche
		int precio_final = 10000;
		
		if (asientos_cuero == true) {
			precio_final += 2000;
		}
		if (climatizador == true) {
			precio_final += 1500;
		}
		return precio_final;
	}
}
