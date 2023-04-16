package clases_propias;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Jefe extends Empleado {

    public Jefe(String nombre, int edad, double salario) {
        super(nombre, edad, salario);
    }

    double incentivo(double inc) {
        return inc;
    }

}
