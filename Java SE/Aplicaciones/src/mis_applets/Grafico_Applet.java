package mis_applets;

// Importamos paquetes swing y awt
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JApplet;
// import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Grafico_Applet extends JApplet {

    public void init() {
        // MarcoGrafico mimarco = new MarcoGrafico();
        // mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mimarco.setVisible(true);
        // setBounds(250, 400, 300, 400);

        /*int numero1 = Integer.parseInt(getParameter("barra.1"));
        int numero2 = Integer.parseInt(getParameter("barra.2"));
        int numero3 = Integer.parseInt(getParameter("barra.3"));

        LaminaGrafico milamina = new LaminaGrafico(numero1, numero2, numero3);*/
        String numero = getParameter("graficos");

        int n_graficos = Integer.parseInt(numero);
        int arrayGraficos[] = new int[n_graficos];

        for (int i = 0; i < arrayGraficos.length; i++) {
            arrayGraficos[i] = Integer.parseInt(getParameter("barra." + (i + 1)));
        }

        LaminaGrafico milamina = new LaminaGrafico(arrayGraficos);

        add(milamina);

        // setVisible(true);
    }

}

/*class MarcoGrafico extends JFrame {

    public MarcoGrafico() {
        setBounds(250, 400, 300, 400);
        LaminaGrafico milamina = new LaminaGrafico();
        add(milamina);
        setVisible(true);
    }

}*/
class LaminaGrafico extends JPanel {

    // private int g1, gr2, g3;
    int[] valores_graficos;

    /*public LaminaGrafico(int a, int b, int c) {
        g1 = a;
        gr2 = b;
        g3 = c;
    }*/
    public LaminaGrafico(int valores[]) {

        valores_graficos = valores;

    }

    public void paint(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.rotate(180 / 180.0 * Math.PI, 125, 100);

        /*Rectangle2D graf1 = new Rectangle2D.Double(50, 0, 50, g1);
        Rectangle2D graf2 = new Rectangle2D.Double(100, 0, 50, gr2);
        Rectangle2D graf3 = new Rectangle2D.Double(150, 0, 50, g3);

        g2.setPaint(Color.RED);
        g2.fill(graf1);
        g2.setPaint(Color.YELLOW);
        g2.fill(graf2);
        g2.setPaint(Color.GREEN);
        g2.fill(graf3);*/
        int pos_x = 0;

        for (int i = 0; i < valores_graficos.length; i++) {
            Rectangle2D graf = new Rectangle2D.Double(pos_x, 0, 25, valores_graficos[i]);

            int color_rojo = (int) Math.round(Math.random() * 200);
            int color_verde = (int) Math.round(Math.random() * 200);
            int color_azul = (int) Math.round(Math.random() * 200);

            Color color_barra = new Color(color_rojo, color_verde, color_azul);

            g2.setPaint(color_barra);
            g2.fill(graf);
            pos_x += 25;
        }

    }

}
