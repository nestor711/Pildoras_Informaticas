
/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class UsoLibro {

    public static void main(String[] args) {

        Libro libro1 = new Libro("P en JAVA", "Nestor", 758441225);
        Libro libro2 = new Libro("P en JAVA", "Nestor", 758441225);
        //libro1 = libro2;

        if (libro1.equals(libro2)) {
            System.out.println("Es el mismo Libro");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        } else {
            System.out.println("No es el mismo Libro");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        }

    }

}
