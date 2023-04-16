package clases_propias;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class HerenciaGenericos {

    public static void main(String[] args) {

        /*Empleado Administrativa = new Empleado("Elena", 45, 1500);

        Jefe DirectoraComercial = new Jefe("Anny", 27, 3500);

        Empleado nuevoEmpleado = DirectoraComercial;*/
        
        Pareja<Empleado> Administrativa = new Pareja<Empleado>();

        Pareja<Jefe> DirectoraComercial = new Pareja<Jefe>();

        // Pareja<Empleado> nuevoEmpleado = DrectoraComercial;
        
        Pareja.imprimirTrabajador(Administrativa);
        Pareja.imprimirTrabajador(DirectoraComercial);

    }

}
