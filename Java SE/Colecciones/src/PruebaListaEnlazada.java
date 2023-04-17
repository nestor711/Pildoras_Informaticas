
// Importamos paquetes util
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaListaEnlazada {

    public static void main(String[] args) {

        LinkedList<String> paises = new LinkedList<String>();

        paises.add("España");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Perú");

        LinkedList<String> capitales = new LinkedList<String>();

        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("DF");
        capitales.add("Lima");

        //System.out.println(paises);
        //System.out.println(capitales);
        
        // Iterador
        ListIterator<String> iterA = paises.listIterator();
        ListIterator<String> iterB = capitales.listIterator();

        // Bucle while
        while (iterB.hasNext()) {
            if (iterA.hasNext()) {
                iterA.next();
            }
            iterA.add(iterB.next());
        }
        System.out.println(paises);

        iterB = capitales.listIterator();

        // Bucle while
        while (iterB.hasNext()) {
            iterB.next();
            if (iterB.hasNext()) {
                iterB.next();
                iterB.remove();
            }
        }
        System.out.println(capitales);

        paises.removeAll(capitales);

        System.out.println(paises);
    }

}
