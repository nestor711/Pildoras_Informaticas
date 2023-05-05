package Vista;

// Importamos paquetes awt, swing y Controlador
import Controlador.ControladorBotonEjecuta;
import Controlador.Controlador_CargaMenus;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Marco_Aplicacion2 extends JFrame {
    
    public JComboBox secciones;
    public JComboBox paises;
    public JTextArea resultado;
    
    public Marco_Aplicacion2() {
        
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
        
        add(botonConsulta, BorderLayout.SOUTH);
        
        botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
        
        addWindowListener(new Controlador_CargaMenus(this));
        
    }
}
