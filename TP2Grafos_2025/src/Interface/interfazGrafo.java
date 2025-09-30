package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Negocio.Grafo;
import Negocio.Usuario;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class interfazGrafo {

	private JFrame frame;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazGrafo window = new interfazGrafo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazGrafo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String [] ValoresCmbox= {"1","2","3","4","5"};  // valores del combobox
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afinidades musicales");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(163, 11, 172, 35);
		frame.getContentPane().add(lblNewLabel);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 94, 57, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(77, 97, 111, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
//------------------------------------------------------------------------------------------------------
		// LABELS 
		
		JLabel lblNewLabel_2 = new JLabel("Rock nacional");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 128, 98, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tango:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 162, 47, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Folclore:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 208, 57, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("Genero Urbano:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 242, 111, 23);
		frame.getContentPane().add(lblNewLabel_5);


//--------------------------------------------------------------------------
		//SE CREAN  COMBOBOX  PARA CADA GENERO DE 1 A 5 
		JComboBox <String> cmboxRcokNacional = new JComboBox<String>();
		cmboxRcokNacional.setBounds(141, 130, 47, 22);
		cmboxRcokNacional.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxRcokNacional);
		
		
		
		JComboBox<String> cmboxTango = new JComboBox<String>();
		cmboxTango.setBounds(141, 170, 47, 22);
		cmboxTango.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxTango);
		
		
		
		
		JComboBox<String> cmboxFolclore = new JComboBox<String>();
		cmboxFolclore.setBounds(141, 208, 47, 22);
		cmboxFolclore.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxFolclore);
		
		
		
		JComboBox<String> cmboxGeneroUrbano = new JComboBox<String>();
		cmboxGeneroUrbano.setBounds(142, 244, 46, 22);
		cmboxGeneroUrbano.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxGeneroUrbano);
//----------------------------------------------------------------------------------		
		// BOTON CREAR USUARIO 
		JButton btnCrearUsuario = new JButton("crear usuario");
		btnCrearUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grafo grafo = new Grafo();
				String nombre = textNombre.getText();
				int interesTango = Integer.parseInt((String) cmboxTango.getSelectedItem());
				int interesRockNacional= Integer.parseInt((String) cmboxRcokNacional.getSelectedItem());
				int interesFolclore= Integer.parseInt((String) cmboxFolclore.getSelectedItem());;
				int interesGeneroUrbano= Integer.parseInt((String) cmboxGeneroUrbano.getSelectedItem());;
				Usuario usuario = new Usuario(nombre,interesTango ,interesRockNacional , interesFolclore , interesGeneroUrbano);
				grafo.agregarUsuarios(usuario);
				
				
				System.out.println(usuario.toString());
			}
		});
		
		
		btnCrearUsuario.setBounds(10, 287, 129, 23);
		frame.getContentPane().add(btnCrearUsuario);
		
		JButton btnConfirmar = new JButton("confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(142, 366, 147, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JTextArea txtrCreeLosUsuarios = new JTextArea();
		txtrCreeLosUsuarios.setText("cree los usuarios y luego para que se formen los\r\ngrupos por afinidades musicales clickee en confirmar");
		txtrCreeLosUsuarios.setBounds(21, 41, 432, 42);
		frame.getContentPane().add(txtrCreeLosUsuarios);
		
		
	}
}
