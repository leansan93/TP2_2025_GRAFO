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

import Controller.ControllerGrafo;
import Negocio.Arista;
import Negocio.Usuario;

public class PantallaPrincipal {

	private JFrame PantallaPrincipal;
	private ControllerGrafo controllerGrafo;
	private List<Usuario> grupo_1;
	private List<Usuario> grupo_2;

	public PantallaPrincipal(ControllerGrafo controllerGrafo, List<Usuario> grupo_1, List<Usuario> grupo_2) {
		
		this.controllerGrafo = controllerGrafo;
		this.grupo_1 = grupo_1;
		this.grupo_2 = grupo_2;	
		initialize();
	}
	
	

	private void initialize() {
		
		
		PantallaPrincipal = new JFrame();
		PantallaPrincipal.setBounds(350, 100, 600, 500);
		PantallaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaPrincipal.getContentPane().setLayout(null);
		PantallaPrincipal.setTitle("Pantalla Grupos - Trabajo Practico 2");

		
		
//---------------------------------------------JLabels--------------------------------------------------------//
		
		Font fuenteBoton = new Font("Trebuchet MS", Font.BOLD, 15);	
		
		JLabel LBL_presentacion = new JLabel("Grupos de Usuarios");
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
		JPanel panelGrupo1 = new JPanel(new GridLayout(grupo_1.size(), 1));
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
		BTN_cerrarPantalla.setBounds(428, 407, 137, 23);
		BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
		BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_cerrarPantalla.setForeground(Color.black);
		PantallaPrincipal.getContentPane().add(BTN_cerrarPantalla);
		
		JButton BTN_Similaridad = new JButton("Mostrar Similaridad");
		BTN_Similaridad.setPreferredSize(new Dimension(40, 40));
		BTN_Similaridad.setForeground(Color.BLACK);
		BTN_Similaridad.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_Similaridad.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_Similaridad.setBounds(21, 407, 137, 23);
		PantallaPrincipal.getContentPane().add(BTN_Similaridad);
		
		JButton BTN_Similaridad_1 = new JButton("Mostrar Grafo");
		BTN_Similaridad_1.setPreferredSize(new Dimension(40, 40));
		BTN_Similaridad_1.setForeground(Color.BLACK);
		BTN_Similaridad_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_Similaridad_1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_Similaridad_1.setBounds(229, 407, 137, 23);
		PantallaPrincipal.getContentPane().add(BTN_Similaridad_1);
		
		
//----------------------------------------Eventos Buttons------------------------------------------------//		


		//activa la pantalla que muestra la similaridad entre usuarios 
		BTN_Similaridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Arista> grupo_1 = controllerGrafo.getGrupo1();
				List<Arista> grupo_2 = controllerGrafo.getGrupo2();
						
				PantallaGruposSimilaridad pantallaSimilaridad = new PantallaGruposSimilaridad(grupo_1, grupo_2);
				pantallaSimilaridad.displayPantallaGruposSimilaridad();			
			}
		});
		
		
		//pantalla que mostraria los grafos 
		BTN_Similaridad_1.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				List<Arista> grupo_1 = controllerGrafo.getGrupo1();
				List<Arista> grupo_2 = controllerGrafo.getGrupo2();
				
				PantallaGrafos pantallaGrafos = new PantallaGrafos(grupo_1 , grupo_2);
				
				pantallaGrafos.displayPantallaGrafos();
			}
		});
		
		
		//evento que cierra la pantalla
		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaPrincipal.setVisible(false);
			}
		});		

	}
	
	
	
	
	// M�todo para mostrar la ventana
    public void displayPantallaPrincipal() {
    	PantallaPrincipal.setVisible(true);
    }
}
