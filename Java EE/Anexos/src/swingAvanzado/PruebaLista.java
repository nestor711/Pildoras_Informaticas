package swingAvanzado;

// Importamos paquetes swing, util y awt
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaLista {

    public static void main(String[] args) {

        JFrame mimarco = new MarcoDeLista();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);

    }

}

class MarcoDeLista extends JFrame {

    private JList<String> listaDeMeses;
    private JPanel laminaDeLista, laminaDeTexto;
    private JLabel rotulo;

    public MarcoDeLista() {

        setTitle("Prueba de Lista");
        setBounds(400, 300, 400, 300);

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        listaDeMeses = new JList<String>(meses);
        listaDeMeses.setVisibleRowCount(4);

        JScrollPane laminaDeDesplazamiento = new JScrollPane(listaDeMeses);
        laminaDeLista = new JPanel();
        laminaDeLista.add(laminaDeDesplazamiento);
        listaDeMeses.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                List<String> valores = listaDeMeses.getSelectedValuesList();
                StringBuilder texto = new StringBuilder("Mes seleccionado: ");

                for (String elemento : valores) {
                    String palabra = elemento;
                    texto.append(palabra);
                    texto.append(" ");
                }

                rotulo.setText(texto.toString());

            }

        });

        laminaDeTexto = new JPanel();
        rotulo = new JLabel("Mes seleccionado: ");
        laminaDeTexto.add(rotulo);

        add(laminaDeLista, BorderLayout.NORTH);
        add(laminaDeTexto, BorderLayout.SOUTH);

    }

}
