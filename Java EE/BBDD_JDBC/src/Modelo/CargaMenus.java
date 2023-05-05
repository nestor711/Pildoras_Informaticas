package Modelo;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class CargaMenus {

    public Conexión miConexion;
    public ResultSet rs, rs2;

    public CargaMenus() {
        miConexion = new Conexión();
    }

    public String ejecutaConsultas() {

        Productos miProducto = null;

        Connection accesoBBDD = miConexion.dameConexion();

        try {

            Statement secciones = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();

            rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
            rs2 = paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");

            //while (rs.next()) {
            miProducto = new Productos();

            miProducto.setSeccion(rs.getString(1));
            miProducto.setpOrigen(rs2.getString(1));

            // return miProducto.getSeccion();
            //}
            rs.close();
            rs2.close();

            accesoBBDD.close();

        } catch (Exception e) {

        }

        return miProducto.getSeccion();

    }

    /*public ResultSet ejecutaConsultas() {

        Connection accesoBBDD = miConexion.dameConexion();

        try {

            Statement secciones = accesoBBDD.createStatement();
            return rs = secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }*/
}
