package pildorasinformaticas.com.jsptags;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Empleado {

    private String nombre, apellido, puesto;
    private double salario;

    public Empleado(String nombre, String apellido, String puesto, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
