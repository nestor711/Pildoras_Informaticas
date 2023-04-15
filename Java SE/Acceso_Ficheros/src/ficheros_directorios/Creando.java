package ficheros_directorios;

// Importamos los paquetes io
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Creando {

    public static void main(String[] args) {

        File ruta = new File("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/prueba_texto.txt");
        // ruta.mkdir();

        String archivo_destino = ruta.getAbsolutePath();

        try {
            ruta.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Escribiendo accede_es = new Escribiendo();
        accede_es.escribir(archivo_destino);
    }

}

class Escribiendo {

    public void escribir(String ruta_archivo) {

        String frase = "Esto es un ejemplo. Espero que salga";

        try {

            FileWriter escritura = new FileWriter(ruta_archivo);

            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();

        } catch (IOException e) {

        }

    }

}
