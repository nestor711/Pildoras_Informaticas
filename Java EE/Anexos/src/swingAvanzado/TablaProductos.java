package swingAvanzado;

// Importamos paquetes swing, sql y awt
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class TablaProductos {

    public static void main(String[] args) {

        JFrame mimarco = new MarcoProductos();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}

class MarcoProductos extends JFrame {

    private JComboBox nombresDeTablas;
    private DatabaseMetaData datosBBDD;
    private ResultSet rs;
    private Connection miconexion;
    private Statement sentencia;
    private ResultSetModeloTabla modelo;

    public MarcoProductos() {

        setTitle("Productos");
        setBounds(500, 300, 800, 400);

        JPanel superior = new JPanel();

        nombresDeTablas = new JComboBox();

        try {

            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");

            datosBBDD = miconexion.getMetaData();

            rs = datosBBDD.getTables(null, null, null, null);

            while (rs.next()) {
                nombresDeTablas.addItem(rs.getString("TABLE_NAME"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        nombresDeTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tablaSeleccionada = (String) nombresDeTablas.getSelectedItem();
                String consulta = "SELECT * FROM " + tablaSeleccionada;

                try {

                    sentencia = miconexion.createStatement();

                    rs = sentencia.executeQuery(consulta);

                    /*while (rs.next()) {

                        System.out.println(rs.getString("NOMBREARTÍCULO") + " " + rs.getString("CÓDIGOARTÍCULO"));

                    }*/
                    modelo = new ResultSetModeloTabla(rs);

                    JTable tabla = new JTable(modelo);
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    validate();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        superior.add(nombresDeTablas);

        add(superior, BorderLayout.NORTH);

    }

}

class ResultSetModeloTabla extends AbstractTableModel {

    private ResultSet rsRegistros;
    private ResultSetMetaData resmd;

    public ResultSetModeloTabla(ResultSet unResultset) {
        rsRegistros = unResultset;

        try {
            resmd = rsRegistros.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getRowCount() {
        try {
            rsRegistros.last();
            return rsRegistros.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return resmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistros.absolute(rowIndex + 1);
            return rsRegistros.getObject(columnIndex + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getColumnName(int c) {
        try {
            return resmd.getColumnName(c + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
