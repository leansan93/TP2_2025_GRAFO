package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	List <Usuario> Usuario;
	List <Aristas> Aristas;
	
	public Grafo () {
		
		this.Usuario= new ArrayList<>();
		this.Aristas= new ArrayList<>();
	}
	
	
	public void agregarUsuario(Usuario usuario) {
		
		 if (Esvalido(usuario)) {
			 
			 Usuario.add(usuario);
			 
		 }
		
	}


	private boolean Esvalido(Negocio.Usuario usuario2) {
		 
		return false;
	}

}
