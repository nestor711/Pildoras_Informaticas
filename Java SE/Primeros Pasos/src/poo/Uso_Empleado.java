package poo;

// Importamos el paquete util
import java.util.Arrays;
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
		Jefatura jefe_RRHH = new Jefatura("Néstor", 55000, 2006, 9, 25);
		jefe_RRHH.estableceIncentivo(2570);

		Empleado[] misEmpleados = new Empleado[6];

		misEmpleados[0] = new Empleado("Néstor Gutierrez", 85000, 1990, 12, 17);
		misEmpleados[1] = new Empleado("David Heredia", 95000, 1995, 06, 02);
		misEmpleados[2] = new Empleado("Fernando Gomez", 105000, 2002, 03, 15);
		misEmpleados[3] = new Empleado("Primitivo Heredia");
		misEmpleados[4] = jefe_RRHH; // Polimorfismo. Principio de sustitución
		misEmpleados[5] = new Jefatura("María", 95000, 1999, 5, 26);

		Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5];
		jefa_Finanzas.estableceIncentivo(55000);

		/*
		Empleado director_comercial = new Jefatura("Sandra", 85000, 2012, 05, 05);

		Comparable ejemplo = new Empleado("Elisabeth", 95000, 2011, 06, 07);
		
		if(director_comercial instanceof Empleado){
			System.out.println("Es de tipo Jefatura");
		}
		
		if(ejemplo instanceof Comparable){
			System.out.println("Implementa la interfaz comparable");
		}*/
		System.out.println(jefa_Finanzas.tomar_decisiones("Dar más dias de vacaciones a los empleados"));
		
		System.out.println("El jefe " + jefa_Finanzas.dameNombre() + " tiene un bonus de " + jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].dameNombre() + " tiene un bonus de: " + misEmpleados[3].establece_bonus(200));

		// Bucle o Ciclo for
		for (int i = 0; i < 6; i++) {
			misEmpleados[i].subeSueldo(5);
		}

		Arrays.sort(misEmpleados);

		for (int i = 0; i < 6; i++) {
			System.out.println("Nombre: " + misEmpleados[i].dameNombre() + " Sueldo: " + misEmpleados[i].dameSueldo() + " Fecha de Alta: " + misEmpleados[i].dameFechaContrato());
		}

	}

}

class Empleado implements Comparable, Trabajadores {

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

	@Override
	public int compareTo(Object miObjeto) {
		Empleado otroEmpleado = (Empleado) miObjeto;

		if (this.sueldo < otroEmpleado.sueldo) {
			return -1;
		}
		if (this.sueldo > otroEmpleado.sueldo) {
			return 1;
		}
		return 0;
	}

	@Override
	public double establece_bonus(double gratificacion) {
		return Trabajadores.bonus_base + gratificacion;
	}
}

class Jefatura extends Empleado implements Jefes {

	private double incentivo;

	public Jefatura(String nombre, double sueldo, int anio, int mes, int dia) {

		super(nombre, sueldo, anio, mes, dia);
	}

	public void estableceIncentivo(double b) {
		incentivo = b;
	}

	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo();
		return sueldoJefe + incentivo;
	}

	@Override
	public String tomar_decisiones(String decision) {
		return "Un miembro de la direccion ha tomado la decision de: " + decision;
	}

	@Override
	public double establece_bonus(double gratificacion) {

		double prima = 2000;

		return Trabajadores.bonus_base + gratificacion + prima;

	}
}
