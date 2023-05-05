package procAlmacenado;

// Importamos paquetes sql y swing
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Actualiza_Productos {

    public static void main(String[] args) {

        int nPrecio = Integer.parseInt(JOptionPane.showInputDialog("Introduce precio"));
        String nArticulo = JOptionPane.showInputDialog("Introduce nombre artículo");

        try {

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");

            miSentencia.setInt(1, nPrecio);
            miSentencia.setString(2, nArticulo);

            miSentencia.execute();

            System.out.println("Actualización OK");

        } catch (Exception e) {

        }
    }

}
