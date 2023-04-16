package arraylist;

// Importamos paquetes util
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class UsoEmpleado {

    public static void main(String[] args) {

        /*Empleado listaEmpleados[] = new Empleado[4];

        listaEmpleados[0] = new Empleado("Anny", 45, 2500);
        listaEmpleados[1] = new Empleado("Nestor", 55, 2000);
        listaEmpleados[2] = new Empleado("Fernando", 25, 2600);
        listaEmpleados[3] = new Empleado("Primitivo", 35, 2900);*/
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        // listaEmpleados.ensureCapacity(11);
        listaEmpleados.add(new Empleado("Anny", 45, 2500));
        listaEmpleados.add(new Empleado("Nestor", 55, 2000));
        listaEmpleados.add(new Empleado("Fernando", 25, 2600));
        listaEmpleados.add(new Empleado("Primitivo", 35, 2900));
        listaEmpleados.add(new Empleado("Hernan", 85, 2000));
        listaEmpleados.add(new Empleado("Fernanda", 55, 2700));
        listaEmpleados.add(new Empleado("Elias", 15, 2800));
        listaEmpleados.set(1, new Empleado("Olga", 22, 2200)); // Metodo set
        System.out.println("El empleado buscado es: " + listaEmpleados.get(4).dameDatos()); // Metodo get

        // listaEmpleados.trimToSize();
        // System.out.println(listaEmpleados.size());
        
        // Bucle for-each
        /*for (Empleado e : listaEmpleados) {

            System.out.println(e.dameDatos());

        }*/
        
        // Iterator - Utilización de Iteradores
        Iterator<Empleado> mi_iterador = listaEmpleados.iterator();

        while (mi_iterador.hasNext()) {

            System.out.println(mi_iterador.next().dameDatos());

        }

        // Bucle for tradicional
        /*for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            System.out.println(e.dameDatos());
        }*/
 /*Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];
        listaEmpleados.toArray(arrayEmpleados);

        // Bucle for
        for (int i = 0; i < arrayEmpleados.length; i++) {
            System.out.println(arrayEmpleados[i].dameDatos());
        }*/
    }

}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años. " + " Y un salario de " + salario;
    }

}
