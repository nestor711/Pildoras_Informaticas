package swingAvanzado;

// Importamos paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ArbolSencillo {

    public static void main(String[] args) {

        JFrame marco = new MarcoArbol();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);

    }

}

class MarcoArbol extends JFrame {

    public MarcoArbol() {

        setTitle("Árbol Sencillo");
        setBounds(350, 300, 600, 600);

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Mundo");
        DefaultMutableTreeNode pais = new DefaultMutableTreeNode("Colombia");

        raiz.add(pais);

        DefaultMutableTreeNode comunidad = new DefaultMutableTreeNode("Bogotá");

        pais.add(comunidad);

        DefaultMutableTreeNode cali = new DefaultMutableTreeNode("Cali");

        comunidad.add(cali);

        DefaultMutableTreeNode florida = new DefaultMutableTreeNode("Florida");

        comunidad.add(florida);

        comunidad = new DefaultMutableTreeNode("Medellin");

        pais.add(comunidad);

        DefaultMutableTreeNode envigado = new DefaultMutableTreeNode("Envigado");

        comunidad.add(envigado);

        pais = new DefaultMutableTreeNode("Alemania");

        raiz.add(pais);

        comunidad = new DefaultMutableTreeNode("Baviera");

        pais.add(comunidad);

        DefaultMutableTreeNode munich = new DefaultMutableTreeNode("Munich");

        comunidad.add(munich);

        JTree arbol = new JTree(raiz);
        // LaminaArbol milamina = new LaminaArbol(arbol);
        // add(milamina);

        Container laminaContenido = getContentPane();
        laminaContenido.add(new JScrollPane(arbol));

    }

}

class LaminaArbol extends JPanel {

    public LaminaArbol(JTree miarbol) {

        setLayout(new BorderLayout());

        add(miarbol, BorderLayout.NORTH);

    }

}
