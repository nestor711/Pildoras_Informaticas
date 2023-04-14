package mis_applets;

// Importamos los paquetes swing y awt
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
// import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Calculadora extends JApplet {

    public void init() {
        // setTitle("Calculadora");
        // setBounds(500, 300, 450, 300);

        laminaCalculadora milamina = new laminaCalculadora();
        add(milamina);
        //pack();

    }

}

/*class MarcoCalculadora extends JFrame {

    public MarcoCalculadora() {
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);

        laminaCalculadora milamina = new laminaCalculadora();
        add(milamina);
        //pack();

    }
}*/

class laminaCalculadora extends JPanel {

    private JPanel milamina2;
    private JButton pantalla;
    private boolean principio;
    private double resultado;
    private String ultimaOperacion;

    public laminaCalculadora() {

        principio = true;
        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);
        milamina2 = new JPanel();
        milamina2.setLayout(new GridLayout(4, 4));
        ActionListener insertar = new InsertarNumero();
        ActionListener orden = new AccionOrden();
        ponerBoton("7", insertar);
        ponerBoton("8", insertar);
        ponerBoton("9", insertar);
        ponerBoton("/", orden);
        ponerBoton("4", insertar);
        ponerBoton("5", insertar);
        ponerBoton("6", insertar);
        ponerBoton("*", orden);
        ponerBoton("1", insertar);
        ponerBoton("2", insertar);
        ponerBoton("3", insertar);
        ponerBoton("-", orden);
        ponerBoton("0", insertar);
        ponerBoton(".", insertar);
        ponerBoton("=", orden);
        ponerBoton("+", orden);
        /*
		JButton boton1 = new JButton("1");
		milamina2.add(boton1);
		JButton boton2 = new JButton("2");
		milamina2.add(boton2);
		JButton boton3 = new JButton("3");
		milamina2.add(boton3);
		JButton boton4 = new JButton("4");
		milamina2.add(boton4);
		JButton boton5 = new JButton("5");
		milamina2.add(boton5);
		JButton boton6 = new JButton("6");
		milamina2.add(boton6);
		JButton boton7 = new JButton("7");
		milamina2.add(boton7);
		JButton boton8 = new JButton("8");
		milamina2.add(boton8);
		JButton boton9 = new JButton("9");
		milamina2.add(boton9);*/
        add(milamina2, BorderLayout.CENTER);
        ultimaOperacion = "=";
    }

    private void ponerBoton(String rotulo, ActionListener oyente) {
        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente);
        milamina2.add(boton);
    }

    private class InsertarNumero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand();
            if (principio) {
                pantalla.setText("");
                principio = false;
            }
            pantalla.setText(pantalla.getText() + entrada);
        }

    }

    private class AccionOrden implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand();
            // System.out.println(operacion);
            calcular(Double.parseDouble(pantalla.getText()));
            ultimaOperacion = operacion;
            principio = true;
        }

        public void calcular(double x) {
            if (ultimaOperacion.equals("+")) {
                resultado += x;
            } else if (ultimaOperacion.equals("-")) {
                resultado -= x;
            } else if (ultimaOperacion.equals("*")) {
                resultado *= x;
            } else if (ultimaOperacion.equals("/")) {
                resultado /= x;
            } else if (ultimaOperacion.equals("=")) {
                resultado = x;
            }
            pantalla.setText("" + resultado);
        }

    }

}
