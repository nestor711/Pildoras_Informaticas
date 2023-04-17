
// Importamos paquetes util
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class CuentasUsuarios {

    public static void main(String[] args) {

        Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
        Cliente cl2 = new Cliente("Lionel Messi", "00002", 500000);
        Cliente cl3 = new Cliente("Rafael Nadal", "00003", 250000);
        Cliente cl4 = new Cliente("Cristiano Ronaldo", "00004", 450000);
        Cliente cl5 = new Cliente("Lionel Messi", "00005", 500000);

        Set<Cliente> clientesBanco = new HashSet<Cliente>();

        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);

        // Bucle for-each
        /*for (Cliente cliente : clientesBanco) {
            // System.out.println(cliente.getNombre() + " " + cliente.getN_cuenta() + " " + cliente.getSaldo());
            if(cliente.getNombre().equals("Antonio Banderas")){
                clientesBanco.remove(cliente);
            }
        }*/
        Iterator<Cliente> it = clientesBanco.iterator();

        while (it.hasNext()) {
            String nombre_cliente = it.next().getNombre();
            if (nombre_cliente.equals("Antonio Banderas")) {
                it.remove();
            }
        }

        for (Cliente cliente : clientesBanco) {
            System.out.println(cliente.getNombre() + " " + cliente.getN_cuenta() + " " + cliente.getSaldo());
        }

        // Iterador
        /*Iterator<Cliente> it = clientesBanco.iterator();

        while (it.hasNext()) {
            String nombre_cliente = it.next().getNombre();
            System.out.println(nombre_cliente);
            String n_cuenta = it.next().getN_cuenta();
            System.out.println(n_cuenta);
        }*/
    }

}
