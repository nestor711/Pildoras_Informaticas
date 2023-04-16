package arraylist;

// Importamo paquetes io
import java.io.File;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class UsoArrayList {

    public static void main(String[] args) {

        ArrayList archivos = new ArrayList(5);

        archivos.add("Nestor");
        archivos.add("Eduardo");
        archivos.add("Natalia");
        archivos.add("Maria");
        archivos.add(new File("gestion_Pedidos.accdb"));

        String nombrePersona = (String) archivos.get(4);

        /*archivos.add(new File("gestion_Pedidos.accdb"));
        File nombrePersona = (File) archivos.get(0);*/
        
        System.out.println(nombrePersona);

    }

}
