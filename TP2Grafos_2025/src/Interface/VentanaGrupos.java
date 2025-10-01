package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaGrupos extends JFrame {

	private JPanel contentPane;
	private JTable tablaGrupos;
	private JFrame interfazGrafo; // referencia a la ventana principal 


	/**
	 * Create the frame.
	 */
	
	 
	public VentanaGrupos(JFrame ventanaPrincipal) {
		this.interfazGrafo=ventanaPrincipal;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupos = new JLabel("Grupos ");
		lblGrupos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGrupos.setBounds(157, 11, 62, 31);
		contentPane.add(lblGrupos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(25, 233, 380, -163);
		contentPane.add(scrollPane);
		
		tablaGrupos = new JTable();
		tablaGrupos.setForeground(new Color(0, 0, 0));
		tablaGrupos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Grupo 1", "Grupo 2"
			}
		));
		tablaGrupos.setBounds(35, 233, 348, -151);
		contentPane.add(tablaGrupos);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGrupos.DISPOSE_ON_CLOSE();
				ventanaPrincipal.setVisible(true);
			}
		});
		btnVolver.setBounds(10, 310, 89, 23);
		contentPane.add(btnVolver);
	}


	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
