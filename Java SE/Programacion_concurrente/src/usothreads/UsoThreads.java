package usothreads;

// Importamos paquetes awt, util y swing
import java.awt.BorderLayout;
import java.awt.Component;
// import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class UsoThreads {

    public static void main(String[] args) {

        JFrame marco = new MarcoRebote();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);

    }

}

// Creación de los hilos con la clase Thread con el Método Runnable
class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponente) {
        pelota = unaPelota;
        componente = unComponente;
    }

    @Override
    public void run() {

        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        //for (int i = 1; i <= 3000; i++) {
        // while (!Thread.interrupted()) {
        while (!Thread.currentThread().isInterrupted()) {

            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                // e.printStackTrace();
                // System.out.println("Hilo Bloqueado. Imposible su Interrupción");
                // System.exit(0);
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
    }

}

// Movimiento de la Pelota
class Pelota {

    private double x = 0, y = 0, dx = 1, dy = 1;
    private static final int TAMX = 15, TAMY = 15;

    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites) {

        x += dx;
        y += dy;

        if (x < limites.getMinX()) {
            x = limites.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            x = limites.getMaxX() - TAMX;
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }

    }

    // Forma de la pelota en su posición inicial
    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, TAMX, TAMY);
    }

}

// Lamina que dibuja las pelotas
class LaminaPelota extends JPanel {

    private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();

    // Añadimos la pelota a la lámina
    public void add(Pelota b) {
        pelotas.add(b);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Pelota b : pelotas) {
            g2.fill(b.getShape());
        }

    }

}

// Marco con lámina y botones 
class MarcoRebote extends JFrame {

    private LaminaPelota lamina;
    Thread t1, t2, t3;
    JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;

    public MarcoRebote() {

        setBounds(600, 300, 600, 350);
        setTitle("Rebotes");
        lamina = new LaminaPelota();
        add(lamina, BorderLayout.CENTER);
        JPanel laminaBotones = new JPanel();

        arranca1 = new JButton("Hilo1");
        arranca1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego(evento);
            }
        });
        laminaBotones.add(arranca1);

        arranca2 = new JButton("Hilo2");
        arranca2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego(evento);
            }
        });
        laminaBotones.add(arranca2);

        arranca3 = new JButton("Hilo3");
        arranca3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego(evento);
            }
        });
        laminaBotones.add(arranca3);

        detener1 = new JButton("Detener1");
        detener1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                detener(evento);
            }
        });
        laminaBotones.add(detener1);

        detener2 = new JButton("Detener2");
        detener2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                detener(evento);
            }
        });
        laminaBotones.add(detener2);

        detener3 = new JButton("Detener3");
        detener3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                detener(evento);
            }
        });
        laminaBotones.add(detener3);

        /*
        // Dibuja el botón de dale
        ponerBoton(laminaBotones, "Dale!", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });

        // Dibuja el botón de salir
        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });

        // Dibuja el botón de detener
        ponerBoton(laminaBotones, "Detener", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                detener();
            }
        });*/
        add(laminaBotones, BorderLayout.SOUTH);

    }

    // Ponemos los botones
    /*public void ponerBoton(Container c, String titulo, ActionListener oyente) {

        JButton boton = new JButton(titulo);
        c.add(boton);
        boton.addActionListener(oyente);

    }*/
    // Añade pelota y la bota 1000 veces 
    public void comienza_el_juego(ActionEvent e) {

        Pelota pelota = new Pelota();
        lamina.add(pelota);

        Runnable r = new PelotaHilos(pelota, lamina);

        // Thread t = new Thread(r);
        if (e.getSource().equals(arranca1)) {
            t1 = new Thread(r);
            t1.start();
        } else if (e.getSource().equals(arranca2)) {
            t2 = new Thread(r);
            t2.start();
        } else if (e.getSource().equals(arranca3)) {
            t3 = new Thread(r);
            t3.start();
        }

    }

    public void detener(ActionEvent e) {

        // t.stop();
        if (e.getSource().equals(detener1)) {
            t1.interrupt();
        } else if (e.getSource().equals(detener2)) {
            t2.interrupt();
        } else if (e.getSource().equals(detener3)) {
            t3.interrupt();
        }

    }

}
