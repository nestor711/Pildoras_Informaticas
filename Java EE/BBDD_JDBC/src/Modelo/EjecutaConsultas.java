package Modelo;

// Importamos paquetes sql
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class EjecutaConsultas {

    //private String pruebas;
    private Conexión miConexion;
    private ResultSet rs;
    private PreparedStatement enviaConsultaSeccion, enviaConsultaPais, enviaConsultaTodos;
    private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ?";
    private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN = ?";
    private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?";

    public EjecutaConsultas() {
        miConexion = new Conexión();
    }

    public ResultSet filtraBBDD(String seccion, String pais) {

        //pruebas = "";
        Connection conecta = miConexion.dameConexion();

        rs = null;

        try {

            if (!seccion.equals("Todos") && pais.equals("Todos")) {

                //pruebas = "Has escogido sección";
                enviaConsultaSeccion = conecta.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);
                rs = enviaConsultaSeccion.executeQuery();

            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {

                //pruebas = "Has escogido país";
                enviaConsultaPais = conecta.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs = enviaConsultaPais.executeQuery();

            } else {

                //pruebas = "Has escogido ambos";
                enviaConsultaTodos = conecta.prepareStatement(consultaTodos);
                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);
                rs = enviaConsultaTodos.executeQuery();

            }

        } catch (Exception e) {

        }

        //return pruebas;
        return rs;
    }

}
