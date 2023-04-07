package graficos;

// Importamos el paquete swing y awt
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Néstor David Heredia Gutierrez (2058558-2711)
 */
public class PruebaArea {
	
	public static void main(String[] args) {
		
		MarcoPruebaArea mimarco = new MarcoPruebaArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
	}
	
}

class MarcoPruebaArea extends JFrame {
	
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
	
	public MarcoPruebaArea() {
		setTitle("Probando Área de Texto");
		setBounds(500, 300, 500, 350);
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		botonInsertar = new JButton("Insertar");
		botonInsertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				areaTexto.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme");
			}
			
		});
		
		laminaBotones.add(botonInsertar);
		botonSaltoLinea = new JButton("Salto Línea");
		botonSaltoLinea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean saltar = !areaTexto.getLineWrap();
				areaTexto.setLineWrap(saltar);
				/*if (saltar) {
					botonSaltoLinea.setText("Quitar salto");
				} else {
					botonSaltoLinea.setText("Salto Linea");
				}*/
				botonSaltoLinea.setText(saltar ? "Quitar salto" : "Salto Linea");
			}
			
		});
		
		laminaBotones.add(botonSaltoLinea);
		add(laminaBotones, BorderLayout.SOUTH);
		areaTexto = new JTextArea(8, 20);
		laminaConBarras = new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);
	}
	
}
