package aplicacionFinal;

// Importamos paquetes swing, util, io, awt y aql
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class AplicacionUniversal {

    public static void main(String[] args) {

        MarcoBBDD mimarco = new MarcoBBDD();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}

class MarcoBBDD extends JFrame {

    public MarcoBBDD() {

        setBounds(300, 300, 700, 700);
        laminaBBDD milamina = new laminaBBDD();
        add(milamina);

    }

}

class laminaBBDD extends JPanel {

    private JComboBox comboTablas;
    private JTextArea areaInformacion;
    private Connection miConexion;
    private FileReader entrada;

    public laminaBBDD() {

        setLayout(new BorderLayout());

        comboTablas = new JComboBox();
        areaInformacion = new JTextArea();

        add(areaInformacion, BorderLayout.CENTER);

        conectarBBDD();

        obtenerTablas();

        comboTablas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreTabla = (String) comboTablas.getSelectedItem();

                mostrarInfoTabla(nombreTabla);
            }
        });

        add(comboTablas, BorderLayout.NORTH);

    }

    public void conectarBBDD() {

        miConexion = null;

        String datos[] = new String[3];

        try {

            entrada = new FileReader("c:/Users/Nestor/Desktop/datos_config.txt");

        } catch (IOException e) {

            JFileChooser chooser = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");

            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                try {
                    entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        }

        try {
            BufferedReader mibuffer = new BufferedReader(entrada);

            for (int i = 0; i <= 2; i++) {

                datos[i] = mibuffer.readLine();

            }

            miConexion = DriverManager.getConnection(datos[0], datos[1], datos[2]);

            entrada.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obtenerTablas() {

        ResultSet miResultSet = null;

        try {

            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            miResultSet = datosBBDD.getTables(null, null, null, null);

            while (miResultSet.next()) {

                comboTablas.addItem(miResultSet.getString("TABLE_NAME"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarInfoTabla(String tabla) {

        ArrayList<String> campos = new ArrayList<String>();

        String consulta = "SELECT * FROM " + tabla;

        try {

            areaInformacion.setText("");

            Statement miStatement = miConexion.createStatement();

            ResultSet miResultSet = miStatement.executeQuery(consulta);

            ResultSetMetaData rsBBDD = miResultSet.getMetaData();

            for (int i = 1; i <= rsBBDD.getColumnCount(); i++) {
                campos.add(rsBBDD.getColumnLabel(i));
            }

            while (miResultSet.next()) {
                for (String nombreCampo : campos) {
                    areaInformacion.append(miResultSet.getString(nombreCampo) + " ");
                }
                areaInformacion.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
