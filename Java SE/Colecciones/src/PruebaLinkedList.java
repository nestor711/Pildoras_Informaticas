
// Importamos paquetes util
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaLinkedList {
    
    public static void main(String[] args) {
        
        LinkedList<String> personas = new LinkedList<String>();
        
        personas.add("Pepe");
        personas.add("Fernando");
        personas.add("Sandra");
        personas.add("Laura");
        
        System.out.println(personas.size());
        
        ListIterator<String> it = personas.listIterator();
        it.next();
        
        it.add("James");
        
        for (String persona : personas) {
            System.out.println(persona);
        }
        
    }
    
}
