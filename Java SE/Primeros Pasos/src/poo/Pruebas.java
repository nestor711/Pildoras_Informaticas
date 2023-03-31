package poo;

/**
 *
 * @author Néstor David Heredia Gutierrez (20585558-2711)
 */
public class Pruebas {

	public static void main(String[] args) {

		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Anny");

		trabajador1.cambiaSeccion("RRHH");

		//trabajador1.cambiaNombre("Néstor");
		
		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos());
	}
}

class Empleados {

	// Encapsulación
	private final String nombre;
	private String seccion;

	// Constructor
	public Empleados(String nombre) {
		this.nombre = nombre;
		this.seccion = "Administración";
	}

	// Metodos Set
	public void cambiaSeccion(String seccion) {
		this.seccion = seccion;
	}

	/*
	public void cambiaNombre(String nombre){
		this.nombre = nombre;
	}
	 */
	
	// Metodos Get
	public String devuelveDatos() {
		return "El nombre es: " + nombre + " y la sección es " + seccion;
	}

}
