package conectaBD;

// Importamos paquetes swing, awt y sql
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Aplicacion_Consulta {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame mimarco = new Marco_Aplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Marco_Aplicacion extends JFrame {

    private JComboBox secciones, paises;
    private JTextArea resultado;
    private PreparedStatement enviaConsultaSeccion, enviaConsultaPais, enviaConsultaTodos;
    private Connection miConexion;
    private final String consultaSeccion = "SELECT NOMBREÁRTICULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCÍON = ?";
    private final String consultaPais = "SELECT NOMBREÁRTICULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN = ?";
    private final String consultaTodos = "SELECT NOMBREÁRTICULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCÍON = ? AND PAÍSDEORIGEN = ?";

    public Marco_Aplicacion() {

        setTitle("Consulta BBDD");

        setBounds(500, 300, 400, 400);

        setLayout(new BorderLayout());

        JPanel menus = new JPanel();

        menus.setLayout(new FlowLayout());

        secciones = new JComboBox();

        secciones.setEditable(false);

        secciones.addItem("Todos");

        paises = new JComboBox();

        paises.setEditable(false);

        paises.addItem("Todos");

        resultado = new JTextArea(4, 50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta = new JButton("Consulta");

        botonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsulta();
            }

        });

        add(botonConsulta, BorderLayout.SOUTH);

        // Conexión con base de Datos
        try {

            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // Crear Objeto Statment
            Statement sentencia = miConexion.createStatement();

            // Carga JComboBox Secciones
            String consulta = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";

            // Ejecutar SQL
            ResultSet rs = sentencia.executeQuery(consulta);

            // Bucle while
            while (rs.next()) {

                secciones.addItem(rs.getString(1));

            }

            rs.close();

            // Carga JComboBox Paises
            consulta = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";

            // Ejecutar SQL
            rs = sentencia.executeQuery(consulta);

            // Bucle while
            while (rs.next()) {

                paises.addItem(rs.getString(1));

            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ejecutaConsulta() {

        ResultSet rs = null;

        try {

            resultado.setText("");

            String seccion = (String) secciones.getSelectedItem();

            String pais = (String) paises.getSelectedItem();

            if (!seccion.equals("Todos") && pais.equals("Todos")) {

                enviaConsultaSeccion = miConexion.prepareStatement(consultaSeccion);

                enviaConsultaSeccion.setString(1, seccion);

                rs = enviaConsultaSeccion.executeQuery();

            } else if (seccion.equals("Todos") && !pais.equals("Todos")) {

                enviaConsultaPais = miConexion.prepareStatement(consultaPais);

                enviaConsultaPais.setString(1, pais);

                rs = enviaConsultaPais.executeQuery();

            } else if (!seccion.equals("Todos") && !pais.equals("Todos")) {

                enviaConsultaTodos = miConexion.prepareStatement(consultaTodos);

                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);

                rs = enviaConsultaTodos.executeQuery();

            }

            while (rs.next()) {

                resultado.append(rs.getString(1));
                resultado.append(", ");
                resultado.append(rs.getString(2));
                resultado.append(", ");
                resultado.append(rs.getString(3));
                resultado.append(", ");
                resultado.append(rs.getString(4));
                resultado.append("\n");
            }

        } catch (Exception e) {

        }

    }

}
