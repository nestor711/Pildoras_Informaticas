package Modelo;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Conexión {

    Connection miConexion = null;

    public Conexión() {

    }

    public Connection dameConexion() {

        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

        } catch (Exception e) {

        }

        return miConexion;
    }

}
