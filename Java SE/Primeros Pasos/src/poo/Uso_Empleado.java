package poo;

// Importamos el paquete util
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_Empleado {

	public static void main(String[] args) {

		/*Empleado empleado1 = new Empleado("Néstor Gutierrez", 85000, 1990, 12, 17);
		Empleado empleado2 = new Empleado("David Heredia", 95000, 1995, 06, 02);
		Empleado empleado3 = new Empleado("Fernando Gomez", 105000, 2002, 03, 15);

		empleado1.subeSueldo(5);
		empleado2.subeSueldo(5);
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + " Sueldo: " + empleado1.dameSueldo()+ " Fecha de Alta: " + empleado1.dameFechaContrato());
		System.out.println("Nombre: " + empleado2.dameNombre() + " Sueldo: " + empleado2.dameSueldo()+ " Fecha de Alta: " + empleado2.dameFechaContrato());
		System.out.println("Nombre: " + empleado3.dameNombre() + " Sueldo: " + empleado3.dameSueldo()+ " Fecha de Alta: " + empleado3.dameFechaContrato());
		 */
		
		Empleado[] misEmpleados = new Empleado[4];

		misEmpleados[0] = new Empleado("Néstor Gutierrez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("David Heredia", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("Fernando Gomez", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Primitivo Heredia");

		// Bucle o Ciclo for
		for (int i = 0; i < 4; i++) {
			misEmpleados[i].subeSueldo(5);
		}

		for (int i = 0; i < 4; i++) {
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + " Sueldo: " + misEmpleados[i].dameSueldo() + " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}

	}

}

class Empleado {

	private String nombre;
	private double sueldo;
	private Date altaContrato;

	// Constructor Vacio
	public Empleado() {
	}
	
	// Constructor con Parametros
	public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {

		this.nombre = nombre;
		this.sueldo = sueldo;
		GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
		this.altaContrato = calendario.getTime();
	}

	public Empleado(String nombre) {
		this(nombre, 30000, 2000, 01, 01);
	}

	// Metodos Get
	public String dameNombre() {
		return nombre;
	}

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
}
