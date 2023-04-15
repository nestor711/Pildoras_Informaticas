package escribiendo;

// Importamos los paquetes io
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Escribir_Fichero {

    public static void main(String args[]) {

        Escribiendo accede_es = new Escribiendo();
        accede_es.escribir();

    }

}

class Escribiendo {

    public void escribir() {

        String frase = "Esto es una prueba de Escritura";

        try {

            FileWriter escritura = new FileWriter("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/escribiendo/texto_nuevo.txt");

            for (int i = 0; i < frase.length(); i++) {
                escritura.write(frase.charAt(i));
            }

            escritura.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
