package leyendo_escribiendo;

// Importamos los paquetes io
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Lectura_Escritura {

    public static void main(String[] args) {

        int contador = 0;

        int datos_entrada[] = new int[40682];

        try {

            FileInputStream archivo_lectura = new FileInputStream("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/leyendo_escribiendo/imagen.jpg");

            boolean final_ar = false;

            while (!final_ar) {

                int byte_entrada = archivo_lectura.read();

                if (byte_entrada != -1) {
                    datos_entrada[contador] = byte_entrada;
                } else {
                    final_ar = true;
                }

                System.out.println(datos_entrada[contador]);

                contador++;

            }

            archivo_lectura.close();

        } catch (IOException e) {

            System.out.println("Error al acceder a la Imagen");

        }

        System.out.println(contador);

        crea_fichero(datos_entrada);

    }

    static void crea_fichero(int datos_nuevo_fichero[]) {

        try {

            FileOutputStream fichero_nuevo = new FileOutputStream("D:/UNIVALLE/Sexto Semestre/Programación Interactiva/Píldoras Informaticas/Java SE/Acceso_Ficheros/src/leyendo_escribiendo/imagen_copia.jpg");

            for (int i = 0; i < datos_nuevo_fichero.length; i++) {
                fichero_nuevo.write(datos_nuevo_fichero[i]);
            }

            fichero_nuevo.close();

        } catch (IOException e) {

            System.out.println("Error al crear el archivo");

        }

    }

}
