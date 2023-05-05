package procAlmacenado;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ConsultaClientes {

    public static void main(String[] args) {

        try {

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}");

            ResultSet rs = miSentencia.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (Exception e) {

        }

    }

}
