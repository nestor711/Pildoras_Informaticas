package ficheros_directorios;

// Importamos los paquetes io
import java.io.File;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Pruebas_rutas {

    public static void main(String[] args) {

        File archivo = new File("ejemplo_archivo");

        System.out.println(archivo.getAbsolutePath());

        System.out.println(archivo.exists());

    }

}
