package conectaBD;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ConsultaPreparada {

    public static void main(String[] args) {

        try {
            // 1. Crear Conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2. Preparar Consulta
            PreparedStatement miSentencia = miConexion.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?");

            // 3. Establecer Parámetros de Consulta
            miSentencia.setString(1, "deportes");
            miSentencia.setString(2, "USA");

            // 4. Ejecutar y Recorrer Consulta
            ResultSet rs = miSentencia.executeQuery();

            // Bucle while 
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

            }
            rs.close();

            // 5. Reutilización de Consulta SQL
            System.out.println("Ejecución segunda consulta");
            System.out.println("");

            miSentencia.setString(1, "cerámica");
            miSentencia.setString(2, "China");

            rs = miSentencia.executeQuery();

            // Bucle while 
            while (rs.next()) {

                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

            }
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
