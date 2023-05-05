package Controlador;

// Importamos paquetes awt, Modelo y Vista
import Modelo.EjecutaConsultas;
import Vista.Marco_Aplicacion2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class ControladorBotonEjecuta implements ActionListener {
    
    private Marco_Aplicacion2 elmarco;
    EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;
    
    public ControladorBotonEjecuta(Marco_Aplicacion2 elmarco) {
        
        this.elmarco = elmarco;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
        String seleccionPais = (String) elmarco.paises.getSelectedItem();

        /*elmarco.resultado.append(obj.filtraBBDD(seleccionSeccion, seleccionPais));
        elmarco.resultado.append("\n");*/
        resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
        
        try {
            
            elmarco.resultado.setText("");
            
            while (resultadoConsulta.next()) {
                
                elmarco.resultado.append(resultadoConsulta.getString(1));
                elmarco.resultado.append(", ");
                
                elmarco.resultado.append(resultadoConsulta.getString(2));
                elmarco.resultado.append(", ");
                
                elmarco.resultado.append(resultadoConsulta.getString(3));
                elmarco.resultado.append(", ");
                
                elmarco.resultado.append(resultadoConsulta.getString(4));
                elmarco.resultado.append("\n");
                
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
    }
    
}
