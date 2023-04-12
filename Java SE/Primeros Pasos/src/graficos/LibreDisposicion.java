package graficos;

// Importamos paquetes swing y awt
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class LibreDisposicion {

    public static void main(String[] args) {

        MarcoLibre mimarco = new MarcoLibre();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoLibre extends JFrame {

    public MarcoLibre() {

        setBounds(450, 350, 600, 400);
        LaminaLibre milamina = new LaminaLibre();
        add(milamina);
        setVisible(true);

    }

}

class LaminaLibre extends JPanel {

    public LaminaLibre() {

        setLayout(new EnColumnas());

        /* Primer Ejemplo
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        boton1.setBounds(50, 50, 150, 50);
        boton2.setBounds(50, 90, 150, 50);
        add(boton1);
        add(boton2);*/
        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel edad = new JLabel("Edad: ");
        JLabel telefono = new JLabel("Teléfono: ");
        JTextField c_nombre = new JTextField();
        JTextField c_apellido = new JTextField();
        JTextField c_edad = new JTextField();
        JTextField c_telefono = new JTextField();

        /*nombre.setBounds(20, 20, 80, 10);
        c_nombre.setBounds(100, 20, 100, 20);
        apellido.setBounds(20, 60, 80, 15);
        c_apellido.setBounds(100, 55, 100, 20);*/
        add(nombre);
        add(c_nombre);
        add(apellido);
        add(c_apellido);
        add(edad);
        add(c_edad);
        add(telefono);
        add(c_telefono);

    }
}

class EnColumnas implements LayoutManager {

    private int x;
    private int y = 20;

    @Override
    public void addLayoutComponent(String arg0, Component arg1) {
    }

    @Override
    public void removeLayoutComponent(Component arg0) {
    }

    @Override
    public Dimension preferredLayoutSize(Container arg0) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container arg0) {
        return null;
    }

    @Override
    public void layoutContainer(Container micontenedor) {

        int d = micontenedor.getWidth();
        x = d / 2;
        int contador = 0;
        int n = micontenedor.getComponentCount();

        for (int i = 0; i < n; i++) {
            contador++;
            Component c = micontenedor.getComponent(i);
            c.setBounds(x - 100, y, 100, 20);
            x += 100;

            if (contador % 2 == 0) {
                x = d / 2;
                y += 40;
            }
        }

    }

}
