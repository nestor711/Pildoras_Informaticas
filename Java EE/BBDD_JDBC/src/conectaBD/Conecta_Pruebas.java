package conectaBD;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Conecta_Pruebas {

    public static void main(String[] args) {

        try {

            // 1. Crear Conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2. Crear Objeto Statment
            Statement miStatement = miConexion.createStatement();

            // 3. Ejecutar SQL
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");

            // 4. Recorrer o Leer el ResulSet
            while (miResultSet.next()) {

                System.out.println(miResultSet.getString("NOMBREARTÍCULO") + " " + miResultSet.getString("CÓDIGOARTÍCULO") + " " + miResultSet.getDouble("PRECIO") * 2 + " " + miResultSet.getDate("FECHA"));

            }

        } catch (Exception e) {

            System.out.println("NO CONECTA!!");

            e.printStackTrace();

        }

    }

}
