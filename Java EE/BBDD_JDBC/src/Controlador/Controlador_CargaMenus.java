package Controlador;

// Importamos paquetes awt, Modelo y Vista
import Modelo.CargaMenus;
import Vista.Marco_Aplicacion2;
import java.awt.event.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class Controlador_CargaMenus extends WindowAdapter {

    CargaMenus obj = new CargaMenus();
    private Marco_Aplicacion2 elmarco;

    public Controlador_CargaMenus(Marco_Aplicacion2 elmarco) {

        this.elmarco = elmarco;

    }

    public void WindowOpened(WindowEvent e) {

        obj.ejecutaConsultas();

        try {

            while (obj.rs.next()) {

                elmarco.secciones.addItem(obj.rs.getString(1));

            }

            while (obj.rs2.next()) {

                elmarco.paises.addItem(obj.rs2.getString(1));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
