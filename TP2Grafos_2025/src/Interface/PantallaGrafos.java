package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Negocio.Arista;
import Negocio.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaGrafos extends JPanel {

	private JFrame PantallaGrafo;
	private List<Arista> grupo1; 
	private List<Arista> grupo2;
	private  Map<Usuario, Point.Double> posiciones;

	
	public PantallaGrafos(List<Arista> grupo1, List<Arista> grupo2) {
		this.grupo1 = grupo1;
		this.grupo2= grupo2;
		regenerarLayout();
		
		initialize();
	}
	
///////////////////////////////////////////---------------------------------------------------
	// se decide donde se dibuja el nodo y no se encime 
	private void regenerarLayout() {
	    posiciones = new HashMap<>();
	    Set<Usuario> usuarios = new HashSet<>();
	    for (Arista a : grupo1) { usuarios.add(a.getU1()); usuarios.add(a.getU2()); }
	    for (Arista a : grupo2) { usuarios.add(a.getU1()); usuarios.add(a.getU2()); }

	    int n = usuarios.size();
	    int radio = 160; // tamaño del círculo en donde se va a expandir el grafo
	    int centroX = 350; 
	    int centroY = 175;

	    int i = 0;
	    for (Usuario u : usuarios) {
	        double angulo = 2 * Math.PI * i / n;
	        double x = centroX + radio * Math.cos(angulo);
	        double y = centroY + radio * Math.sin(angulo);
	        posiciones.put(u, new Point.Double(x, y));
	        i++;
	    }
	    }
		
/////////-------------------------- METODOS PARA QUE SE DIBUJE EL GRAFO---------------	
	// dibuja el grafo del grupo, usando las posiciones generadas, recorre las aristas del grupo busca las posiciones 
	// sus dos extremos (u1 , u2 ) en el map posiciones y llama a dibujarNodo para cada extremo para el grupo1 azul , grupo2 rojo 
	private void dibujarGrupo(Graphics2D g2, List<Arista> grupo, Color color) {
        g2.setColor(color);
        for (Arista a : grupo) {
            Point.Double p1 = posiciones.get(a.getU1());
            Point.Double p2 = posiciones.get(a.getU2());
            g2.drawLine((int)p1.x, (int)p1.y, (int)p2.x, (int)p2.y);
        }

        for (Arista a : grupo) {
            dibujarNodo(g2, a.getU1(), color);
            dibujarNodo(g2, a.getU2(), color);
        }
    }

	/// dibuja el nodo individualmente, con su etiqueta y color. Usa las posiciones almacenadas en posiciones.get(u)
	// se dibuja en un obalo el nombre con el color del grupo que tenga que ser 
    private void dibujarNodo(Graphics2D g2, Usuario u, Color color) {
        Point.Double p = posiciones.get(u);
        g2.setColor(color);
        g2.fillOval((int)p.x - 15, (int)p.y - 15, 50, 30); // tamaño del nodo en donde se dibujan los nombres 
        g2.setColor(Color.WHITE);
        g2.drawString(u.getNombre(), (int)p.x - 10, (int)p.y + 5);
    }
    
    
///--------------------------------------------------------------------------------------------------------------------
    private void initialize() {
		
		PantallaGrafo = new JFrame();
		PantallaGrafo.setBounds(350, 100, 876, 871);
		PantallaGrafo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaGrafo.getContentPane().setLayout(null);
		PantallaGrafo.setTitle("Pantalla Similaridad - Trabajo Practico 2");	
		
		
		
//---------------------------------------------JLabel---------------------------------------------------------//				
		
		JLabel LBL_presentacion = new JLabel("Grafo de grupos de Usuarios: grupo1 azul , grupo2 rojo");
		LBL_presentacion.setBounds(118, 11, 497, 24);
		LBL_presentacion.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		PantallaGrafo.getContentPane().add(LBL_presentacion);
				
//---------------------------------------------Paneles---------------------------------------------------------//		
		
		//Panel para el promer grupo
		JPanel panelGrupo1 = new JPanel(new GridLayout(1, 1)) {
		    @Override
		    protected void paintComponent(java.awt.Graphics g) {
		        super.paintComponent(g);
		        Graphics2D g2 = (Graphics2D) g;
		        dibujarGrupo(g2, grupo1, Color.BLUE);
		    }
		};
		
		panelGrupo1.setBounds(0, 46, 850, 390);
		panelGrupo1.setBackground(new Color(245, 245, 245));
		panelGrupo1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		PantallaGrafo.getContentPane().add(panelGrupo1);
		
		
		//Panel para el segundo grupo
		JPanel panelGrupo2 = new JPanel(new GridLayout(1, 1)) {
		    @Override
		    protected void paintComponent(java.awt.Graphics g) {
		        super.paintComponent(g);
		        Graphics2D g2 = (Graphics2D) g;
		        dibujarGrupo(g2, grupo2, Color.RED);
		    }
		};
		
		panelGrupo2.setBounds(0, 433, 850, 354);
		panelGrupo2.setBackground(new Color(245, 245, 245));
		panelGrupo2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		PantallaGrafo.getContentPane().add(panelGrupo2);
		
				
//---------------------------------------------Buttons---------------------------------------------------------//		
			
		JButton BTN_cerrarPantalla = new JButton("volver ");
		BTN_cerrarPantalla.setBounds(548, 798, 137, 23);
		BTN_cerrarPantalla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		BTN_cerrarPantalla.setPreferredSize(new Dimension(40, 40));
		BTN_cerrarPantalla.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		BTN_cerrarPantalla.setForeground(Color.black);
		PantallaGrafo.getContentPane().add(BTN_cerrarPantalla);
		
		
		
		
		
//------------------------------------------Eventos Buttons--------------------------------------------------//		

		BTN_cerrarPantalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGrafo.setVisible(false);
			}
		});
				
	}

	
	
	// M�todo para mostrar la ventana
    public void displayPantallaGrafos() {
    	PantallaGrafo.setVisible(true);
    }

}
