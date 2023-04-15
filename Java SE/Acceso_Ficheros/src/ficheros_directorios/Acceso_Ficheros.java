package ficheros_directorios;

// Importamos los paquetes io
import java.io.File;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Acceso_Ficheros {

    public static void main(String[] args) {

        File ruta = new File("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE");
        System.out.println(ruta.getAbsolutePath());

        String[] nombres_archivos = ruta.list();

        for (int i = 0; i < nombres_archivos.length; i++) {

            System.out.println(nombres_archivos[i]);

            File f = new File(ruta.getAbsolutePath(), nombres_archivos[i]);

            if (f.isDirectory()) {

                String[] archivos_subcarpeta = f.list();

                for (int j = 0; j < archivos_subcarpeta.length; j++) {

                    System.out.println(archivos_subcarpeta[j]);

                }

            }
        }

    }

}
