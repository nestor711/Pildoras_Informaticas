package transacciones;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Inserta_Clientes_Pedidos {

    public static void main(String[] args) {

        Connection miConexion = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'CRA 15 # 6-42')";
            miStatement.executeUpdate(instruccionSql_1);

            String instruccionSql_2 = "INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE, FECHADEPEDIDO) VALUES ('82', 'CT84', '11/07/2023')";
            miStatement.executeUpdate(instruccionSql_2);

            miConexion.commit();

            System.out.println("Datos INSERTADOS correctamente");

        } catch (Exception e) {

            System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
            try {
                miConexion.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

        }

    }

}
