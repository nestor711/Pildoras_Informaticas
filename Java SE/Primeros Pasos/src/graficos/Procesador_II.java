package graficos;

// Importamos paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
// import javax.swing.JCheckBoxMenuItem;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Procesador_II {

    public static void main(String[] args) {
        MenuProcesador_II mimarco = new MenuProcesador_II();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuProcesador_II extends JFrame {

    public MenuProcesador_II() {
        setBounds(500, 300, 550, 400);
        LaminaProcesador_II milamina = new LaminaProcesador_II();
        add(milamina);
        setVisible(true);
    }

}

class LaminaProcesador_II extends JPanel {

    JTextPane miarea;
    JMenu fuente, estilo, tamano;
    Font letras;

    public LaminaProcesador_II() {
        setLayout(new BorderLayout());
        JPanel laminamenu = new JPanel();
        JMenuBar mibarra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamano = new JMenu("Tamaño");
        /*
        JMenuItem arial = new JMenuItem("Arial");
        arial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miarea.setFont(new Font("Arial", Font.PLAIN, 12));
            }
        });
        JMenuItem courier = new JMenuItem("Courier");
        // Gestiona_menus tipo_letra = new Gestiona_menus();
        courier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miarea.setFont(new Font("Courier", Font.PLAIN, 12));
            }
        });
        JMenuItem verdana = new JMenuItem("Verdana");
        verdana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miarea.setFont(new Font("Verdana", Font.PLAIN, 12));
            }
        });

        fuente.add(arial);
        fuente.add(courier);
        fuente.add(verdana);
        JMenuItem negrita = new JMenuItem("Negrita");
        JMenuItem cursiva = new JMenuItem("Cursiva");
        estilo.add(negrita);
        estilo.add(cursiva);
        JMenuItem tam_12 = new JMenuItem("12");
        JMenuItem tam_16 = new JMenuItem("16");
        JMenuItem tam_20 = new JMenuItem("20");
        JMenuItem tam_24 = new JMenuItem("24");
        tamano.add(tam_12);
        tamano.add(tam_16);
        tamano.add(tam_20);
        tamano.add(tam_24);*/

        configura_menu("Arial", "fuente", "Arial", 9, 10, "");
        configura_menu("Courier", "fuente", "Courier", 9, 10, "");
        configura_menu("Verdana", "fuente", "Verdana", 9, 10, "");

        configura_menu("Negrita", "estilo", "", Font.BOLD, 1, "bin/graficos/negrita.gif");
        configura_menu("Cursiva", "estilo", "", Font.ITALIC, 1, "bin/graficos/cursiva.gif");

        /*JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/graficos/negrita.gif"));
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/graficos/cursiva.gif"));
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilo.add(negrita);
        estilo.add(cursiva);

        configura_menu("12", "tamaño", "", 9, 12, "");
        configura_menu("16", "tamaño", "", 9, 16, "");
        configura_menu("20", "tamaño", "", 9, 20, "");
        configura_menu("24", "tamaño", "", 9, 24, "");*/
        ButtonGroup tamano_letra = new ButtonGroup();
        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
        // veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        tamano_letra.add(doce);
        tamano_letra.add(dieciseis);
        tamano_letra.add(veinte);
        tamano_letra.add(veinticuatro);
        doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));
        dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 20));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));
        tamano.add(doce);
        tamano.add(dieciseis);
        tamano.add(veinte);
        tamano.add(veinticuatro);

        laminamenu.add(mibarra);
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamano);
        add(laminamenu, BorderLayout.NORTH);
        miarea = new JTextPane();
        add(miarea, BorderLayout.CENTER);

        JPopupMenu emergente = new JPopupMenu();
        JMenuItem negritaE = new JMenuItem("Negrita");
        JMenuItem cursivaE = new JMenuItem("Cursiva");
        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
        emergente.add(negritaE);
        emergente.add(cursivaE);
        miarea.setComponentPopupMenu(emergente);
    }

    public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono) {
        JMenuItem elem_menu = new JMenuItem(rotulo, new ImageIcon(ruta_icono));
        if (menu == "fuente") {
            fuente.add(elem_menu);
            if (tipo_letra == "Arial") {
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
            } else if (tipo_letra == "Courier") {
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Courier"));
            } else if (tipo_letra == "Verdana") {
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
            } else if (menu == "estilo") {
                estilo.add(elem_menu);
                if (estilos == Font.BOLD) {
                    elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                    elem_menu.addActionListener(new StyledEditorKit.BoldAction());
                } else if (estilos == Font.ITALIC) {
                    elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                    elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
                }
            }
            /*else if (menu == "tamaño") {
            tamano.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
        }*/
            // elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
        }

        /*
    private class Gestiona_Eventos implements ActionListener {

        String tipo_texto, menu;
        int estilo_letra, tamano_letra;

        public Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {
            menu = elemento;
            tipo_texto = texto2;
            estilo_letra = estilo2;
            tamano_letra = tam_letra;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            letras = miarea.getFont();
            if (menu == "Arial" || menu == "Courier" || menu == "Verdana") {
                estilo_letra = letras.getStyle();
                tamano_letra = letras.getSize();
            } else if (menu == "Cursiva" || menu == "Negrita") {
                if (letras.getStyle() == 1 || letras.getStyle() == 2) {
                    estilo_letra = 3;
                }
                tipo_texto = letras.getFontName();
                tamano_letra = letras.getSize();
            } else if (menu == "12" || menu == "16" || menu == "20" || menu == "24") {
                estilo_letra = letras.getStyle();
                tipo_texto = letras.getFontName();
            }
            miarea.setFont(new Font(tipo_texto, estilo_letra, tamano_letra));
            System.out.println("Tipo: " + tipo_texto + " Estilo: " + estilo_letra + " Tamaño: " + tamano_letra);
        }
    }*/
    }
}
