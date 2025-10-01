package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import Controller.ControllerUsuario;
import Negocio.Grafo;

public class PantallaNuevoUsuario {

	private JFrame PantallaNuevoUsuario;
	private Grafo grafo;
	public PantallaNuevoUsuario(Grafo grafo) {
		this.grafo = grafo;
		
		
		initialize();
	}

	private void initialize() {
		PantallaNuevoUsuario = new JFrame();
		PantallaNuevoUsuario.setBounds(350, 100, 600, 400);
		PantallaNuevoUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaNuevoUsuario.getContentPane().setLayout(null);
		PantallaNuevoUsuario.setTitle("Agregar Usuario - Trabajo Práctico 2");

		ControllerUsuario controllerUsuario = new ControllerUsuario (grafo);	
		Font fuenteBoton = new Font("Trebuchet MS", Font.BOLD, 15);	
		
//-------------------------------------------------Panel---------------------------------------------------------//
		
		JTextPane textPane_nombre = new JTextPane();
		textPane_nombre.setBounds(198, 26, 222, 22);
		textPane_nombre.setFont(new Font("Trebuchet MS", Font.ITALIC, 15));
		textPane_nombre.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		PantallaNuevoUsuario.getContentPane().add(textPane_nombre);
		
		
//-----------------------------------------------JLabels-----------------------------------------------------------//		

		JLabel LBL_Nombre = new JLabel("Colocar su Nombre:");
		LBL_Nombre.setFont(fuenteBoton);
		LBL_Nombre.setBounds(35, 34, 188, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_Nombre);
		
		JLabel LBL_Folclore = new JLabel("Folclore");
		LBL_Folclore.setBounds(322, 119, 46, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_Folclore);
		
		JLabel LBL_RockNacional = new JLabel("Rock Nacional");
		LBL_RockNacional.setBounds(180, 119, 99, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_RockNacional);
		
		JLabel LBL_Tango = new JLabel("Tango");
		LBL_Tango.setBounds(35, 119, 46, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_Tango);
		
		JLabel LBL_Urbano = new JLabel("Urbano");
		LBL_Urbano.setBounds(463, 119, 46, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_Urbano);
		
		JLabel LBL_UsuarioAgregado = new JLabel("");
		LBL_UsuarioAgregado.setBounds(129, 220, 324, 14);
		PantallaNuevoUsuario.getContentPane().add(LBL_UsuarioAgregado);
		
		
//------------------------------------------Combo Box-------------------------------------------------------------//
		
		JComboBox comboBox_Tango = new JComboBox();
		comboBox_Tango.setBounds(35, 153, 89, 22);
		comboBox_Tango.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		comboBox_Tango.setPreferredSize(new Dimension(40, 40));
		comboBox_Tango.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox_Tango.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(comboBox_Tango);
		comboBox_Tango.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5})) ;
		
			
		JComboBox comboBox_RockNacional = new JComboBox();
		comboBox_RockNacional.setBounds(180, 153, 89, 22);
		comboBox_RockNacional.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		comboBox_RockNacional.setPreferredSize(new Dimension(40, 40));
		comboBox_RockNacional.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox_RockNacional.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(comboBox_RockNacional);
		comboBox_RockNacional.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5})) ;
		
		
		JComboBox comboBox_Folclore = new JComboBox();
		comboBox_Folclore.setBounds(322, 153, 89, 22);
		comboBox_Folclore.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		comboBox_Folclore.setPreferredSize(new Dimension(40, 40));
		comboBox_Folclore.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox_Folclore.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(comboBox_Folclore);
		comboBox_Folclore.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5})) ;
		
		
		JComboBox comboBox_Urbano = new JComboBox();
		comboBox_Urbano.setBounds(463, 153, 89, 22);
		comboBox_Urbano.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		comboBox_Urbano.setPreferredSize(new Dimension(40, 40));
		comboBox_Urbano.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		comboBox_Urbano.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(comboBox_Urbano);
		comboBox_Urbano.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5})) ;
		
		
		
		
//------------------------------------------Button-------------------------------------------------------------//
		
		JButton BTN_crearUsuario = new JButton("Crear Usuario");		
		BTN_crearUsuario.setBounds(219, 297, 125, 23);
		BTN_crearUsuario.setOpaque(true);
        BTN_crearUsuario.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        BTN_crearUsuario.setPreferredSize(new Dimension(40, 40));
        BTN_crearUsuario.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        BTN_crearUsuario.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(BTN_crearUsuario);
	
		
		JButton BTN_cerrarPantalla = new JButton("Volver");
		BTN_cerrarPantalla.setBounds(463, 297, 89, 23);
		BTN_cerrarPantalla.setOpaque(true);
        BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
        BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        BTN_cerrarPantalla.setForeground(Color.black);
		PantallaNuevoUsuario.getContentPane().add(BTN_cerrarPantalla);
	
		
		BTN_crearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LBL_UsuarioAgregado.setText("");					//Colocamos en blanco el label
				String str = textPane_nombre.getText();				//obtenemos el nombre cargado por el usuario
				
				//obtenemos los valores seleccionados por el usuario en los comboBox
				Integer valorFolclore = (Integer)comboBox_Folclore.getSelectedItem();		
				Integer valorRockNacional = (Integer)comboBox_RockNacional.getSelectedItem();		
				Integer valorTango = (Integer)comboBox_Tango.getSelectedItem();		
				Integer valorUrbano = (Integer)comboBox_Urbano.getSelectedItem();		
				
				controllerUsuario.agregarNuevoUsuario(str, valorFolclore, valorRockNacional, valorTango, valorUrbano);
				LBL_UsuarioAgregado.setText("Se agrego al usuario: " + str);		//colocamos el nombre del usuario en el label
			}
		});
		
		
		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaNuevoUsuario.setVisible(false);							//cerramos la pantalla 
			}
		});
		
	}
	
	// Método para mostrar la ventana
    public void displayNuevoUsuario() {
    	PantallaNuevoUsuario.setVisible(true);
    }
}
