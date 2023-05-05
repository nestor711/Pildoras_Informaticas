package transacciones;

// Importamos paquetes sql y swing
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Transaccion_Productos {

    public static void main(String[] args) {

        Connection miConexion = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            miConexion.setAutoCommit(false);

            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "DELETE FROM PRODUCTOS WHERE PAÍSDEORIGEN = 'ITALIA'";
            String instruccionSql_2 = "DELETE FROM PRODUCTOS WHERE PRECIO > 300";
            String instruccionSql_3 = "UPDATE PRODUCTOS SET PRECIO = PRECIO * 1.15";

            boolean ejecutar = ejecutar_transaccion();

            if (ejecutar) {
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);
                miConexion.commit();

                System.out.println("Se ejecutó la transacción correctamente");
            } else {
                System.out.println("No se realizó cambio alguno en BBDD");
            }

        } catch (Exception e) {
            try {
                miConexion.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println("Algo salió mal y no se realizó cambio alguno en BBDD");
        }
    }

    static boolean ejecutar_transaccion() {

        String ejecucion = JOptionPane.showInputDialog("¿Ejecutamos transacción?");

        if (ejecucion.equals("Sí")) {
            return true;
        } else {
            return false;
        }

    }

}
