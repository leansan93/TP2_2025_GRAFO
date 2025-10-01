package Main;

import javax.swing.SwingUtilities;

import Controller.ControllerUsuario;
import Interface.PantallaMenu;
import Negocio.Grafo;

public class main {

	public static void main(String[] args) {
		 
		 SwingUtilities.invokeLater(() -> {

	        	Grafo grafo = new Grafo();
	        	ControllerUsuario controllerUsuario = new ControllerUsuario(grafo);

	        	
	        	//lista previa de usuarios pre cargados
	        	controllerUsuario.agregarNuevoUsuario("Axel", 3, 5, 3, 1);
	        	controllerUsuario.agregarNuevoUsuario("Marcos", 1, 1, 1, 5);
	        	controllerUsuario.agregarNuevoUsuario("Damian", 1, 2, 1, 4);
	        	controllerUsuario.agregarNuevoUsuario("Leandro", 2, 5, 3, 1);
	        	controllerUsuario.agregarNuevoUsuario("Franco", 1, 2, 2, 5);
	        	controllerUsuario.agregarNuevoUsuario("Nacho", 2, 3, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Barbi", 1, 3, 2, 5);
	        	controllerUsuario.agregarNuevoUsuario("Dylan", 1, 5, 5, 1);
	        	controllerUsuario.agregarNuevoUsuario("Nicolas", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Maria", 1, 1, 2, 2);
	        	controllerUsuario.agregarNuevoUsuario("Roberto", 4, 1, 1, 5);
	        	controllerUsuario.agregarNuevoUsuario("Nico", 4, 5, 4, 5);
	        	controllerUsuario.agregarNuevoUsuario("Patrico", 2, 1, 1, 5);
	        	controllerUsuario.agregarNuevoUsuario("Norma", 4, 5, 4, 5);
	        	controllerUsuario.agregarNuevoUsuario("Pepe", 1, 1, 1, 1);
	        	controllerUsuario.agregarNuevoUsuario("Yamila", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Tatiana", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Mario", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Martin", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("David", 4, 5, 4, 1);
	        	controllerUsuario.agregarNuevoUsuario("Agustina", 4, 5, 4, 1);
	        	
	        	  	
	        	//mostrar pantalla
	        	PantallaMenu PantallaMenu = new PantallaMenu(grafo);		
	        	PantallaMenu.displayMenu();
	        	
	        	
	        });	 
		 }
}
