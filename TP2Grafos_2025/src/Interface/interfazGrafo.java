package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class interfazGrafo {

	private JFrame frame;
	private JTextField textField;

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
		frame.setBounds(100, 100, 468, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afinidades musicales");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(96, 11, 172, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCrearUsuario = new JButton("crear usuario");
		btnCrearUsuario.setBounds(22, 255, 129, 23);
		frame.getContentPane().add(btnCrearUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 48, 57, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(77, 51, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
//------------------------------------------------------------------------------------------------------
		// LABELS 
		
		JLabel lblNewLabel_2 = new JLabel("Rock nacional");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 82, 98, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tango:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 109, 47, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Folclore:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 150, 57, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("Genero Urbano:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 184, 111, 23);
		frame.getContentPane().add(lblNewLabel_5);


//--------------------------------------------------------------------------
		//SE CREAN  COMBOBOX  PARA CADA GENERO DE 1 A 5 
		JComboBox <String> cmboxRcokNacional = new JComboBox<String>();
		cmboxRcokNacional.setBounds(141, 84, 47, 22);
		cmboxRcokNacional.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxRcokNacional);
		
		
		
		JComboBox<String> cmboxTango = new JComboBox<String>();
		cmboxTango.setBounds(141, 117, 47, 22);
		cmboxTango.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxTango);
		
		
		
		
		JComboBox<String> cmboxFolclore = new JComboBox<String>();
		cmboxFolclore.setBounds(141, 150, 47, 22);
		cmboxFolclore.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxFolclore);
		
		
		
		JComboBox<String> cmboxGeneroUrbano = new JComboBox<String>();
		cmboxGeneroUrbano.setBounds(142, 183, 46, 22);
		cmboxGeneroUrbano.setModel(new DefaultComboBoxModel<>(ValoresCmbox));
		frame.getContentPane().add(cmboxGeneroUrbano);
//----------------------------------------------------------------------------------		
		
		
		
		
	}
}
