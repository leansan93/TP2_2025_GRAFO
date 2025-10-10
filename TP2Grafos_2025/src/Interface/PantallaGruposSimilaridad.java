package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Arista;
import Negocio.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaGruposSimilaridad {

	private JFrame PantallaSimilaridad;
	private List<Arista> grupo_1;
	private List<Arista> grupo_2;

	public PantallaGruposSimilaridad(List<Arista> grupo_1, List<Arista> grupo_2) {
		
		this.grupo_1 = grupo_1;
		this.grupo_2 = grupo_2;
		initialize();
	}

	private void initialize() {
		
		PantallaSimilaridad = new JFrame();
		PantallaSimilaridad.setBounds(350, 100, 600, 500);
		PantallaSimilaridad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaSimilaridad.getContentPane().setLayout(null);
		PantallaSimilaridad.setTitle("Pantalla Similaridad - Trabajo Practico 2");	
		
		
		
//---------------------------------------------JLabel---------------------------------------------------------//				
		
		JLabel LBL_presentacion = new JLabel("Grupos de usuarios con Similaridad");
		LBL_presentacion.setBounds(139, 11, 334, 24);
		LBL_presentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		PantallaSimilaridad.getContentPane().add(LBL_presentacion);
				
//---------------------------------------------Paneles---------------------------------------------------------//		
		
		//Panel para el promer grupo
		JPanel panelGrupo1 = new JPanel(new GridLayout(grupo_1.size(), 1));
		for (Arista arista : grupo_1) {
			Usuario usuario_1 = arista.getU1();	
			Usuario usuario_2 = arista.getU2();
			panelGrupo1.add(new JLabel (usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre()));
		}
		panelGrupo1.setBounds(21, 46, 258, 330);
		panelGrupo1.setBackground(new Color(245, 245, 245));
		panelGrupo1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PantallaSimilaridad.getContentPane().add(panelGrupo1);
			
		
		//Panel para el segundo grupo
		JPanel panelGrupo2 = new JPanel(new GridLayout(grupo_2.size(), 1));
		for (Arista arista : grupo_2) {
			Usuario usuario_1 = arista.getU1();	
			Usuario usuario_2 = arista.getU2();
			panelGrupo2.add(new JLabel (usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre()));
		}
		panelGrupo2.setBounds(307, 46, 258, 330);
		panelGrupo2.setBackground(new Color(245, 245, 245));
		panelGrupo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PantallaSimilaridad.getContentPane().add(panelGrupo2);
		
				
//---------------------------------------------Buttons---------------------------------------------------------//		
			
		JButton BTN_cerrarPantalla = new JButton("volver ");
		BTN_cerrarPantalla.setBounds(428, 407, 137, 23);
		BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
		BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_cerrarPantalla.setForeground(Color.black);
		PantallaSimilaridad.getContentPane().add(BTN_cerrarPantalla);
		
		
//------------------------------------------Eventos Buttons--------------------------------------------------//		

		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSimilaridad.setVisible(false);
			}
		});
				
	}

	
	
	// M�todo para mostrar la ventana
    public void displayPantallaGruposSimilaridad() {
    	PantallaSimilaridad.setVisible(true);
    }

}
