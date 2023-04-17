
// Importamos paquetes util
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaMapas {

    public static void main(String[] args) {

        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();
        personal.put("145", new Empleado("Nestor"));
        personal.put("146", new Empleado("Andres"));
        personal.put("147", new Empleado("Mauricio"));
        personal.put("148", new Empleado("Camilo"));

        System.out.println(personal);

        personal.remove("147");

        System.out.println(personal);

        personal.put("148", new Empleado("Natalia"));

        System.out.println(personal);

        // System.out.println(personal.entrySet());
        
        for (Map.Entry<String, Empleado> entrada : personal.entrySet()) {

            String clave = entrada.getKey();
            Empleado valor = entrada.getValue();

            System.out.println("Clave: " + clave + ", Valor: " + valor);

        }

    }

}

class Empleado {

    private String nombre;
    private double sueldo;

    public Empleado(String n) {

        nombre = n;
        sueldo = 2000;

    }

    public String toString() {
        return "[Nombre: " + nombre + ", sueldo: " + sueldo + "]";
    }

}
