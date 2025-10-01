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

import Negocio.Usuario;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class VentanaGrupos extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Create the frame.
	 */
	
	 
	public VentanaGrupos() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrupos = new JLabel("Formacion de Grupos");
		lblGrupos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGrupos.setBounds(136, 0, 174, 41);
		contentPane.add(lblGrupos);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setForeground(UIManager.getColor("Button.foreground"));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		JLabel lblNewLabel = new JLabel("Grupo 1");
		lblNewLabel.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblNewLabel.setBounds(72, 52, 83, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Grupo 2");
		lblNewLabel_1.setFont(new Font("Unispace", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(UIManager.getColor("Button.foreground"));
		lblNewLabel_1.setBounds(290, 51, 96, 33);
		contentPane.add(lblNewLabel_1);
		
		JPanel panelGrupo1 = new JPanel();
		panelGrupo1.setForeground(new Color(255, 255, 255));
		panelGrupo1.setBounds(31, 92, 165, 207);
		contentPane.add(panelGrupo1);
		
		JPanel panelGrupo2 = new JPanel();
		panelGrupo2.setBounds(248, 92, 162, 207);
		contentPane.add(panelGrupo2);
	
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
			}
		});
		btnVolver.setBounds(10, 310, 89, 23);
		contentPane.add(btnVolver);
	
	}


	
}
