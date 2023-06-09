package poo;

/**
 *
 * @author Néstor David Heredia Gutierrez (20585558-2711)
 */
public class Pruebas {

	public static void main(String[] args) {

		//Creación de Objetos Empleados
		Empleados trabajador1 = new Empleados("Paco");
		Empleados trabajador2 = new Empleados("Anny");
		Empleados trabajador3 = new Empleados("Antonio");
		Empleados trabajador4 = new Empleados("Andres");

		trabajador1.cambiaSeccion("RRHH");

		//trabajador1.cambiaNombre("Néstor");
		
		System.out.println(trabajador1.devuelveDatos() + "\n" + trabajador2.devuelveDatos() + "\n" + trabajador3.devuelveDatos() + "\n" + trabajador4.devuelveDatos());
		
		// Imprimir el método static
		System.out.println(Empleados.dameIdSiguiente());
	}
}

class Empleados {

	// Encapsulación
	private final String nombre;
	private String seccion;

	// Uso de static
	private int Id;
	private static int IdSiguiente = 1;

	// Constructor
	public Empleados(String nombre) {
		this.nombre = nombre;
		this.seccion = "Administración";
		Id = IdSiguiente;
		IdSiguiente++;
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
		return "El nombre es: " + nombre + " y la sección es " + seccion + " y el Id = " + Id;
	}

	// Metodo static
	public static String dameIdSiguiente() {
		return "El IdSiguiente es: " + IdSiguiente;
	}

}
