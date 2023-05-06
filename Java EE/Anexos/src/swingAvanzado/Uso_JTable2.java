package swingAvanzado;

// Importamos paquetes swing
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Uso_JTable2 {

    public static void main(String[] args) {

        JFrame mimarco = new MarcoTablaPersonalizado();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}

class MarcoTablaPersonalizado extends JFrame {

    public MarcoTablaPersonalizado() {

        setTitle("Tabla Personalizada");
        setBounds(300, 300, 400, 200);

        TableModel mimodelo = new ModeloTablaPersonalizada();

        JTable mitabla = new JTable(mimodelo);
        add(new JScrollPane(mitabla));

    }

}

class ModeloTablaPersonalizada extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        int z = rowIndex + 1;
        int y = columnIndex + 2;

        return " " + z + " " + y;

    }

    @Override
    public String getColumnName(int c) {
        return "Columna " + c;
    }

}
