package serializacion;

// Importamos paquetes util y io
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Serializando {

    public static void main(String[] args) {

        Administrador jefe = new Administrador("Néstor", 80000, 2002, 07, 11);

        jefe.setIncentivo(5000);

        Empleado[] personal = new Empleado[3];
        personal[0] = jefe;
        personal[1] = new Empleado("Anny", 25000, 2008, 10, 1);
        personal[2] = new Empleado("David", 18000, 2012, 9, 15);

        try {

            ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/serializacion/empleado.dat"));

            escribiendo_fichero.writeObject(personal);
            escribiendo_fichero.close();

            ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/serializacion/empleado.dat"));

            Empleado[] personal_recuperado = (Empleado[]) recuperando_fichero.readObject();
            recuperando_fichero.close();

            for (Empleado e : personal_recuperado) {
                System.out.println(e);
            }

        } catch (Exception e) {

        }

    }

}

class Empleado implements Serializable {

    // Huella o SerialVersionUID
    private static final long serialVersionUID = 1L;

    private String nombre;
    private double sueldo;
    public Date fechaContrato;

    public Empleado(String n, double s, int agno, int mes, int dia) {
        nombre = n;
        sueldo = s;
        GregorianCalendar calendario = new GregorianCalendar(agno, mes - 1, dia);
        fechaContrato = calendario.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void subirSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }

    public String toString() {
        return "El Nombre es: " + nombre + ", y su sueldo es: " + sueldo + ", fecha de contrato: " + fechaContrato;
    }

}

class Administrador extends Empleado {

    // Huella o SerialVersionUID
    private static final long serialVersionUID = 1L;

    private double incentivo;

    public Administrador(String n, double s, int agno, int mes, int dia) {
        super(n, s, agno, mes, dia);
        incentivo = 0;
    }

    public double getSueldo() {
        double sueldoBase = super.getSueldo();
        return sueldoBase + incentivo;
    }

    public void setIncentivo(double b) {
        incentivo = b;
    }

    public String toString() {
        return super.toString() + " Incentivo: " + incentivo;
    }

}
