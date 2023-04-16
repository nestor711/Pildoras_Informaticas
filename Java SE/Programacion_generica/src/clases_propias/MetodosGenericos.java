package clases_propias;

// Importamos paquetes util
import java.util.GregorianCalendar;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class MetodosGenericos {

    public static void main(String[] args) {

        String nombres[] = {"Jose", "Alejo", "Nestor"};

        System.out.println(MisMatrices.getMenor(nombres));

        /*String elementos = MisMatrices.getElementos(nombres);

        System.out.println(elementos);

        Empleado listaEmpleados[] = {new Empleado("Nestor", 25, 2500),
            new Empleado("David", 48, 2500),
            new Empleado("Leonardo", 35, 2800),
            new Empleado("Nestor Fernando", 45, 3000),
            new Empleado("Claudia", 20, 4000)
        };

        System.out.println(MisMatrices.getElementos(listaEmpleados));*/
        
        GregorianCalendar fechas[] = {new GregorianCalendar(2015, 07, 12),
            new GregorianCalendar(2015, 05, 12),
            new GregorianCalendar(2002, 07, 11)
        };

        System.out.println(MisMatrices.getMenor(fechas));

    }

    class MisMatrices {

        public static <T extends Comparable> T getMenor(T[] a) {

            if (a == null || a.length == 0) {
                return null;
            }

            T elementoMenor = a[0];

            for (int i = 1; i < a.length; i++) {
                if (elementoMenor.compareTo(a[i]) > 0) {
                    elementoMenor = a[i];
                }
            }
            return elementoMenor;
        }

    }
}
