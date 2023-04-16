package clases_propias;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Pareja<T> {

    private T primero;

    public Pareja() {
        primero = null;
    }

    public void setPrimero(T nuevoValor) {
        primero = nuevoValor;
    }

    public static void imprimirTrabajador(Pareja<? extends Empleado> p) {
        Empleado primero = p.getPrimero();
        System.out.println(primero);
    }

    public T getPrimero() {
        return primero;
    }

}
