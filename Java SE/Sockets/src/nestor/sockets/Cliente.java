package nestor.sockets;

// Importamos paquetes swing, io y awt
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        MarcoCliente mimarco = new MarcoCliente();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class MarcoCliente extends JFrame {
    
    public MarcoCliente() {
        
        setBounds(600, 300, 280, 350);
        
        LaminaMarcoCliente milamina = new LaminaMarcoCliente();
        
        add(milamina);
        
        setVisible(true);
        
        addWindowListener(new EnvioOnline());
    }
    
}

// Envio de Señal Online
class EnvioOnline extends WindowAdapter {
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        try {
            
            Socket misocket = new Socket("192.168.0.13", 9999);
            
            PaqueteEnvio datos = new PaqueteEnvio();
            
            datos.setMensaje(" Online ");
            
            ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
            
            paquete_datos.writeObject(datos);
            
            misocket.close();
            
        } catch (Exception ex) {
            
        }
        
    }
    
}

class LaminaMarcoCliente extends JPanel implements Runnable {
    
    private JTextField campo1;
    private JLabel nick;
    private JComboBox ip;
    private JButton miboton;
    private JTextArea campochat;
    
    public LaminaMarcoCliente() {
        
        String nick_usuario = JOptionPane.showInputDialog("Nick: ");
        
        JLabel n_nick = new JLabel("Nick: ");
        
        add(n_nick);
        
        nick = new JLabel();
        
        nick.setText(nick_usuario);
        
        add(nick);
        
        ip = new JComboBox();
        
        /*ip.addItem("Usuario 1");
        ip.addItem("Usuario 2");
        ip.addItem("Usuario 3");*/
        
        ip.addItem("192.168.0.15");
        ip.addItem("192.168.0.16");
        
        add(ip);
        
        JLabel texto = new JLabel("Chat - Nestor Heredia");
        
        add(texto);
        
        campochat = new JTextArea(12, 20);
        
        add(campochat);
        
        campo1 = new JTextField(20);
        
        add(campo1);
        
        miboton = new JButton("Enviar");
        
        EnviaTexto mievento = new EnviaTexto();
        
        miboton.addActionListener(mievento);
        
        add(miboton);
        
        Thread mihilo = new Thread(this);
        
        mihilo.start();
        
    }

    // Metodo Run de la clase Runnable
    @Override
    public void run() {
        try {
            
            ServerSocket servidor_cliente = new ServerSocket(9090);
            Socket cliente;
            PaqueteEnvio paqueteRecibido;

            // Bucle while-true (Bucle infinito)
            while (true) {
                cliente = servidor_cliente.accept();
                ObjectInputStream flujoentrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) flujoentrada.readObject();
                campochat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private class EnviaTexto implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            campochat.append("\n" + campo1.getText());
            
            try {
                // System.out.println("Hola Funciona");
                // System.out.println(campo1.getText());
                Socket misocket = new Socket("192.168.0.13", 9999);
                
                PaqueteEnvio datos = new PaqueteEnvio();
                
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());
                
                ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
                paquete_datos.writeObject(datos);
                misocket.close();

                /*DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                flujo_salida.writeUTF(campo1.getText());
                flujo_salida.close();*/
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
}

class PaqueteEnvio implements Serializable {
    
    private String nick, ip, mensaje;

    // Getters y Setters
    public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String getIp() {
        return ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
