package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Usuario;

public class PantallaPrincipal {

	private JFrame frame;

	private JFrame PantallaPrincipal;
	List<Usuario> grupo_1;
	List<Usuario> grupo_2;

	public PantallaPrincipal(List<Usuario> grupo_1, List<Usuario> grupo_2) {
		
		this.grupo_1 = grupo_1;
		this.grupo_2 = grupo_2;	
		initialize();
	}
	
	

	private void initialize() {
		
		
		PantallaPrincipal = new JFrame();
		PantallaPrincipal.setBounds(350, 100, 600, 500);
		PantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaPrincipal.getContentPane().setLayout(null);
		PantallaPrincipal.setTitle("Pantalla Grupos - Trabajo Práctico 2");

		Font fuenteBoton = new Font("Trebuchet MS", Font.BOLD, 15);	
		
		
		

		
//---------------------------------------------JLabels--------------------------------------------------------//
		
		JLabel LBL_presentacion = new JLabel("Pantalla Principal");
		LBL_presentacion.setBounds(217, 11, 198, 14);
		LBL_presentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		PantallaPrincipal.getContentPane().add(LBL_presentacion);
	
		JLabel LBL_grupo1 = new JLabel("Grupo 1");
		LBL_grupo1.setBounds(130, 53, 91, 14);
		LBL_grupo1.setFont(fuenteBoton);
		PantallaPrincipal.getContentPane().add(LBL_grupo1);
		
		JLabel LBL_grupo2 = new JLabel("Grupo 2");
		LBL_grupo2.setBounds(389, 53, 96, 14);
		LBL_grupo2.setFont(fuenteBoton);
		PantallaPrincipal.getContentPane().add(LBL_grupo2);
		
		
//---------------------------------------------Paneles---------------------------------------------------------//		

		//Panel para el promer grupo
		JPanel panelGrupo1 = new JPanel(new GridLayout(grupo_2.size(), 1));
		for (Usuario usuario : grupo_1) {
			panelGrupo1.add(new JLabel (usuario.getNombre()));
		}
		panelGrupo1.setBounds(21, 78, 258, 298);
		panelGrupo1.setBackground(new Color(245, 245, 245));
		panelGrupo1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PantallaPrincipal.getContentPane().add(panelGrupo1);
				
		
		//Panel para el segundo grupo
		JPanel panelGrupo2 = new JPanel(new GridLayout(grupo_2.size(), 1));
		for (Usuario usuario : grupo_2) {
			panelGrupo2.add(new JLabel (usuario.getNombre()));
		}
		
		panelGrupo2.setBounds(307, 78, 258, 298);
		panelGrupo2.setBackground(new Color(245, 245, 245));
		panelGrupo2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		PantallaPrincipal.getContentPane().add(panelGrupo2);
		
		
//---------------------------------------------Buttons--------------------------------------------------------//

		JButton BTN_cerrarPantalla = new JButton("volver ");
		BTN_cerrarPantalla.setBounds(218, 406, 137, 23);
		BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
		BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_cerrarPantalla.setForeground(Color.black);
		PantallaPrincipal.getContentPane().add(BTN_cerrarPantalla);
		
		

		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaPrincipal.setVisible(false);
			}
		});		


		
		
		
		
		
		
		

	}
	
	
	
	
	// Método para mostrar la ventana
    public void displayPantallaPrincipal() {
    	PantallaPrincipal.setVisible(true);
    }

}
