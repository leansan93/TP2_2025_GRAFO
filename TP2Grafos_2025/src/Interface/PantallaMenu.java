package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.ControllerGrafo;
import Negocio.Grafo;
import Negocio.Usuario;

public class PantallaMenu {

	private JFrame PantallaMenu;
	private Grafo grafo;

	public PantallaMenu(Grafo grafo) {
		this.grafo = grafo;
		initialize();
	}

	private void initialize() {

		PantallaMenu = new JFrame();
		PantallaMenu.setBounds(350, 100, 600, 500);
		PantallaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaMenu.setTitle("Descubriendo afinidades musicales - Trabajo Pr�ctico 2");
		PantallaMenu.getContentPane().setLayout(null);

		ControllerGrafo controllerGrafo = new ControllerGrafo(grafo);
		Font fuenteBoton = new Font("Trebuchet MS", Font.BOLD, 15);	

		
		
//------------------------------------------jLabels--------------------------------------------------------------//		
		
		JLabel LBL_presentacion = new JLabel("Pagina principal");
		LBL_presentacion.setBounds(229, 137, 150, 34);
		LBL_presentacion.setFont(fuenteBoton);
		PantallaMenu.getContentPane().add(LBL_presentacion);

		
//------------------------------------------Buttons--------------------------------------------------------------//		
		
		JButton BTN_Nuevo_Usuario = new JButton("Crear Nuevo Usuario.");
		BTN_Nuevo_Usuario.setBounds(75, 230, 150, 20);
		BTN_Nuevo_Usuario.setOpaque(true);
        BTN_Nuevo_Usuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        BTN_Nuevo_Usuario.setPreferredSize(new Dimension(40, 40));
        BTN_Nuevo_Usuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        BTN_Nuevo_Usuario.setForeground(Color.black);
        PantallaMenu.getContentPane().add(BTN_Nuevo_Usuario);
		
        
        
		JButton BTN_mostrarGrupos = new JButton("Mostrar Grupos ");
		BTN_mostrarGrupos.setBounds(343, 230, 150, 20);
		BTN_mostrarGrupos.setOpaque(true);
		BTN_mostrarGrupos.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_mostrarGrupos.setPreferredSize(new Dimension(40, 40));
		BTN_mostrarGrupos.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_mostrarGrupos.setForeground(Color.black);
		PantallaMenu.getContentPane().add(BTN_mostrarGrupos);
		
		
		
		JButton BTN_cerrarPantalla = new JButton("cerrar ");
		BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
		BTN_cerrarPantalla.setForeground(Color.BLACK);
		BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_cerrarPantalla.setBounds(428, 407, 137, 23);
		PantallaMenu.getContentPane().add(BTN_cerrarPantalla);
		
		
			
		
//----------------------------------------Acciones Buttons-------------------------------------------------------//
		
		BTN_Nuevo_Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//llamar a la pantalla para agregar un nuevo usuario
				PantallaNuevoUsuario nuevoUsuario = new PantallaNuevoUsuario(grafo);
				nuevoUsuario.displayNuevoUsuario();
			}
		});
		
		
		BTN_mostrarGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				//aplicamos todos los metodos
				controllerGrafo.generarAristas();
				controllerGrafo.generarAGM();
				controllerGrafo.eliminarAristaConMayorPesoo();
				controllerGrafo.separarSubGrafos();
				
//				System.out.println("\nGrupo 1\n");
				List<Usuario> grupo_1 = controllerGrafo.mostrarUsuariosGrupo(controllerGrafo.getGrupo1());
//				System.out.println("\nGrupo 2\n");
				List<Usuario> grupo_2 = controllerGrafo.mostrarUsuariosGrupo(controllerGrafo.getGrupo2());

				//llamar a la pantalla que muestra los grupos
				PantallaPrincipal principal = new PantallaPrincipal(controllerGrafo, grupo_1, grupo_2);
				principal.displayPantallaPrincipal();							
			}
		});	
		
		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaMenu.setVisible(false);
			}
		});
		
	}
	
	
	
	
	// M�todo para mostrar la ventana
    public void displayMenu() {
    	PantallaMenu.setVisible(true);
    }
}

