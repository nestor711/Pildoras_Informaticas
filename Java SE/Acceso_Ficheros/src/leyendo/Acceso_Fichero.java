package leyendo;

// Importamos los paquetes io
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Acceso_Fichero {

    public static void main(String[] args) {

        Leer_Fichero accediendo = new Leer_Fichero();
        accediendo.lee();

    }

}

class Leer_Fichero {

    public void lee() {
        try {
            FileReader entrada = new FileReader("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/leyendo/ejemplo.txt");

            BufferedReader mibuffer = new BufferedReader(entrada);

            // int c = entrada.read();
            String linea = "";

            /*while (c != -1) {
                c = entrada.read();
                char letra = (char) c;
                System.out.print(letra);
            }*/
            while (linea != null) {

                linea = mibuffer.readLine();

                if (linea != null) {
                    System.out.println(linea);
                }

            }

            // entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

}
