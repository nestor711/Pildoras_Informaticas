package introspeccion;

// Importamos paquetes util y lang
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaIntrospeccion {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el nombre de la clase");

        String nombreClase;
        nombreClase = entrada.next();

        // Imprimir clase y superclase
        try {

            Class c1 = Class.forName(nombreClase);
            Class superC1 = c1.getSuperclass();

            System.out.println("Clase " + nombreClase);

            if (superC1 != null && superC1 != Object.class) {

                System.out.println(" extends " + superC1.getName());

            }
            System.out.println("");

            imprimirConstructores(c1);

            System.out.println("");

            imprimirMetodos(c1);

            System.out.println("");

            imprimirCampos(c1);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static void imprimirConstructores(Class c1) {

        Constructor[] constructores = c1.getDeclaredConstructors();

        for (Constructor c : constructores) {
            String nombre = c.getName();

            System.out.print("  " + Modifier.toString(c.getModifiers()));
            System.out.print("  " + nombre + "(");

            // Imprimir parámetros
            Class[] tipoParams = c.getParameterTypes();
            for (int i = 0; i < tipoParams.length; i++) {
                if (i > 0) {
                    System.out.print(",   ");
                }
                System.out.print(tipoParams[i].getName());
            }
            System.out.print(");");
        }
    }

    // Imprime todos los metodos de la clase
    public static void imprimirMetodos(Class c1) {

        Method[] metodos = c1.getDeclaredMethods();

        for (Method m : metodos) {
            Class tipoDevuelto = m.getReturnType();
            String nombre = m.getName();

            // Imprimir modificadores, tipo y nombre
            System.out.print("  " + Modifier.toString(m.getModifiers()));
            System.out.print("  " + tipoDevuelto.getName() + "  " + nombre + "(");

            // Imprimir Parametros
            Class[] tipoParams = m.getParameterTypes();

            for (int i = 0; i < tipoParams.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(tipoParams[i].getName());
            }
            System.out.println(");");

        }

    }

    // Imprimir los Campos de la Clase
    public static void imprimirCampos(Class c1) {

        Field[] campos = c1.getDeclaredFields();

        for (Field f : campos) {

            Class tipoCampo = f.getType();

            String nombre = f.getName();

            System.out.print("  " + Modifier.toString(f.getModifiers()));
            System.out.println("  " + tipoCampo.getName() + " " + nombre + ";");

        }

    }

}
