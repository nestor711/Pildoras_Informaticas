package excepciones_I;

// Importamos los paquetes swing y io
// import java.io.EOFException;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Comprueba_mail {

    public static void main(String[] args) {

        String el_mail = JOptionPane.showInputDialog("Introduce mail");

        try {
            examina_mail(el_mail);
        } catch (Exception e) {
            System.out.println("La direccion de email no es correcta");
            e.printStackTrace();
        }
    }

    static void examina_mail(String mail) throws Longitud_mail_erronea {

        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3) {

            // ArrayIndexOutOfBoundsException mi_excepcion = new ArrayIndexOutOfBoundsException();
            // throw new EOFException();
            throw new Longitud_mail_erronea("El mail es demasiado corto");

        } else {

            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba++;
                }
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }

            if (arroba == 1 && punto == true) {
                System.out.println("Es correcto");
            } else {
                System.out.println("No es correcto");
            }

        }
    }

}

class Longitud_mail_erronea extends Exception {

    public Longitud_mail_erronea() {

    }

    public Longitud_mail_erronea(String msj_error) {

        super(msj_error);

    }

}
