package conectaBD;

// Importar paquetes sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ModificaBBDD {

    public static void main(String[] args) {

        try {

            // 1. Crear Conexión
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // 2. Crear Objeto Statment
            Statement miStatement = miConexion.createStatement();

            // 3. Formas de acceso a la base de datos
            // Insetar Productos a la tabla de la base datos
            String instruccionSql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR77','PANTALÓN',25.35)";

            // Actualizar datos a la tabla de la base datos
            String instruccionSql1 = "UPDATE PRODUCTOS SET PRECIO = PRECIO*2 WHERE CÓDIGOARTÍCULO = 'AR77'";

            // Eliminar datos de la tabla de la base de datos
            String instruccionSql2 = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = 'AR77'";

            miStatement.executeUpdate(instruccionSql);
            miStatement.executeUpdate(instruccionSql1);

            System.out.println("Datos insertados correctamente");

        } catch (Exception e) {

            System.out.println("NO CONECTA!!");

            e.printStackTrace();

        }

    }

}
