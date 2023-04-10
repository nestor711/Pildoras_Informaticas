package graficos;

// Importamos los paquetes swing
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class MarcoMenu {
    
    public static void main(String[] args) {
        MenuFrame mimarco = new MenuFrame();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class MenuFrame extends JFrame {
    
    public MenuFrame() {
        setBounds(500, 300, 550, 400);
        MenuLamina milamina = new MenuLamina();
        add(milamina);
        setVisible(true);
    }
}

class MenuLamina extends JPanel {
    
    public MenuLamina() {
        
        JMenuBar mibarra = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edición");
        JMenu herramientas = new JMenu("Herramientas");
        JMenu opciones = new JMenu("Opciones");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem guardar_como = new JMenuItem("Guardar Como");
        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("bin/graficos/cortar.gif"));
        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("bin/graficos/copiar.gif"));
        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("bin/graficos/pegar.gif"));
        copiar.setHorizontalTextPosition(SwingConstants.LEFT);
        JMenuItem generales = new JMenuItem("Generales");
        JMenuItem opcion1 = new JMenuItem("Opcion 1");
        JMenuItem opcion2 = new JMenuItem("Opcion 2");
        archivo.add(guardar);
        archivo.add(guardar_como);
        edicion.add(cortar);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.addSeparator();
        edicion.add(opciones);
        herramientas.add(generales);
        opciones.add(opcion1);
        opciones.add(opcion2);
        mibarra.add(archivo);
        mibarra.add(edicion);
        mibarra.add(herramientas);
        add(mibarra);
        
    }
    
}
