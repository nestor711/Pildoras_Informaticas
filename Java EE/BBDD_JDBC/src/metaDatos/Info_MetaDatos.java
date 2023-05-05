package metaDatos;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Info_MetaDatos {

    public static void main(String[] args) {

        // mostrarInfo_BBDD();
        mostrarInfo_Tablas();

    }

    static void mostrarInfo_BBDD() {
        Connection miConexion = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost::3306/pruebas", "root", "");

            // Obtención de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            // Mostramos información de la BBDD
            System.out.println("Gestor de BBDD" + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del Gestor" + datosBBDD.getDatabaseProductVersion());
            System.out.println("Nombre del Driver" + datosBBDD.getDriverName());
            System.out.println("Versión del Driver" + datosBBDD.getDriverVersion());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void mostrarInfo_Tablas() {

        Connection miConexion = null;
        ResultSet miResulset = null;

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost::3306/pruebas", "root", "");

            // Obtención de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            // Lista de Tablas
            System.out.println("Lista de Tablas");

            miResulset = datosBBDD.getTables(null, null, null, null);

            while (miResulset.next()) {
                System.out.println(miResulset.getString("TABLE_NAME"));
            }

            // Lista de Columnas de Productos
            System.out.println("");
            System.out.println("Campos de Productos");

            miResulset = datosBBDD.getColumns(null, null, "productos", null);

            while (miResulset.next()) {
                System.out.println(miResulset.getString("COLUMN_NAME"));
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                miConexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
