package ficheros_directorios;

// Importamos paquetes io
import java.io.File;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Eliminar {

    public static void main(String[] args) {

        File ruta = new File("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/prueba_texto.txt");

        ruta.delete();

    }

}
