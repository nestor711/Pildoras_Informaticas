package nestor.sockets;

// Importamos paquetes swing, io, awt y net
import javax.swing.*;
import java.awt.*;
// import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Servidor {

    public static void main(String[] args) {

        MarcoServidor mimarco = new MarcoServidor();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidor extends JFrame implements Runnable {

    private JTextArea areatexto;

    public MarcoServidor() {

        setBounds(1200, 300, 280, 350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread mihilo = new Thread(this);
        mihilo.start();

    }

    @Override
    public void run() {
        try {
            // System.out.println("Estoy a la escucha");
            ServerSocket servidor = new ServerSocket(9999);

            String nick, ip, mensaje;

            PaqueteEnvio paquete_recibido;

            // Bucle while
            while (true) {

                Socket misocket = servidor.accept();

                ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());

                paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();

                nick = paquete_recibido.getNick();
                ip = paquete_recibido.getIp();
                mensaje = paquete_recibido.getMensaje();

                /*DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());

                String mensaje_texto = flujo_entrada.readUTF();

                areatexto.append("\n" + mensaje_texto);*/
                
                if (!mensaje.equals(" Online ")) {

                    areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);

                    Socket enviaDestinatario = new Socket(ip, 9090);

                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

                    paqueteReenvio.writeObject(paquete_recibido);

                    paqueteReenvio.close();

                    enviaDestinatario.close();

                    misocket.close();
                } else {
                    // Detecta Online
                    InetAddress localizacion = misocket.getInetAddress();

                    String IpRemota = localizacion.getHostAddress();

                    System.out.println("Online " + IpRemota);
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
