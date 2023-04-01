package poo;

// Importamos el paquete util
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Persona {

	public static void main(String[] args) {

		Persona[] lasPersonas = new Persona[2];

		// Creación de Objetos
		lasPersonas[0] = new Empleado2("Luis Conde", 50000, 2009, 02, 25);
		lasPersonas[1] = new Alumno("Ana López", "Informatica");

		// Ciclo o Bucle for-each
		for (Persona p : lasPersonas) {
			System.out.println(p.dameNombre() + ", " + p.dameDiscripcion());
		}

	}
}

abstract class Persona {

	private String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	// Metodo get
	public String dameNombre() {
		return nombre;
	}

	// Metodo abstract
	public abstract String dameDiscripcion();

}

class Empleado2 extends Persona {

	private double sueldo;
	private Date altaContrato;
	private static int IdSiguiente;
	private int Id;

	// Constructor con Parametros
	public Empleado2(String nombre, double sueldo, int anio, int mes, int dia) {

		super(nombre);

		this.sueldo = sueldo;

		GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
		this.altaContrato = calendario.getTime();

		++IdSiguiente;
		Id = IdSiguiente;
	}

	// Metodos Get
	public double dameSueldo() {
		return sueldo;
	}

	public Date dameFechaContrato() {
		return altaContrato;
	}

	// Metodos Set
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo * porcentaje / 100;
		sueldo += aumento;
	}

	@Override
	public String dameDiscripcion() {
		return "Este empleado tiene un Id = " + Id + " con un sueldo = " + sueldo;
	}
}

class Alumno extends Persona {

	private String carrera;

	public Alumno(String nombre, String carrera) {

		super(nombre);
		this.carrera = carrera;

	}

	@Override
	public String dameDiscripcion() {
		return "Este alumno está estudiando la carrera de " + carrera;
	}

}