package clases_propias;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class UsoPareja {

    public static void main(String[] args) {

        Pareja<String> una = new Pareja<String>();

        una.setPrimero("Nestor");
        System.out.println(una.getPrimero());

        Persona per1 = new Persona("Anny");
        Pareja<Persona> otra = new Pareja<Persona>();

        otra.setPrimero(per1);
        System.out.println(otra.getPrimero());

    }

}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre;
    }

}
