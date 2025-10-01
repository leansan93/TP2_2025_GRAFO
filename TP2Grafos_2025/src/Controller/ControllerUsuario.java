package Controller;

import java.util.List;

import Negocio.Arista;
import Negocio.Grafo;
import Negocio.Usuario;

public class ControllerUsuario {
	
	private List <Arista> _Aristas;
	private List <Usuario> _Usuarios;
	private Grafo grafo;

	public ControllerUsuario(Grafo grafo) {
		
		this.grafo = grafo;
		this._Usuarios = grafo.getUsuarios();
		this._Aristas = grafo.getAristas();
	
	}
	
	
	
//-------------------------------------Agregamos nuevo Usuario---------------------------------------------------//	
	
	public void agregarNuevoUsuario(String nombre , Integer  InteresTango , Integer InteresRockNacional, Integer InteresFolclore , Integer InteresUrbano) {

		Usuario usuario = new Usuario(nombre , InteresTango , InteresRockNacional, InteresFolclore , InteresUrbano);
		usuarioValido(usuario);							
		_Usuarios.add(usuario);					//agregamos a la lista de usuarios del controller
		grafo.setUsuarios(_Usuarios);			//lo setteamos a el grafo original
	}
	
	

	//Valdaciones para agregar Usuarios
	private void usuarioValido(Usuario usuario) {
		if(usuario == null || usuario.getNombre().length() == 0) {
			throw new IllegalArgumentException("El usuario no puede ser null. ");
		}
		if(usuario.getNombre().length() > 15) {
			throw new IllegalArgumentException("El nombre no puede ser mayor a 15 caracteres. ");
		}

		if(usuario.getNombre() == null || usuario.getNombre().length() == 0) {
			throw new IllegalArgumentException("El usuario no puede ser null. ");
		}
		
		if(usuario.getInteres_Folclore() == null || (usuario.getInteres_Folclore() < 1 && usuario.getInteres_Folclore() > 5)) {
			throw new IllegalArgumentException("El interes por el Floclore debe estar entre 1 y 5. ");
		}
		if(usuario.getInteres_rockNacional() == null || (usuario.getInteres_rockNacional() < 1 && usuario.getInteres_rockNacional() > 5)) {
			throw new IllegalArgumentException("El interes por el Rock Nacional debe estar entre 1 y 5. ");
		}
		if(usuario.getInteres_tango() == null || (usuario.getInteres_tango() < 1 && usuario.getInteres_tango() > 5)) {
			throw new IllegalArgumentException("El interes por el Tango debe estar entre 1 y 5. ");
		}
		
		if(usuario.getInteres_Urbano() == null || (usuario.getInteres_Urbano() < 1 && usuario.getInteres_Urbano() > 5)) {
			throw new IllegalArgumentException("El interes por el Urbano debe estar entre 1 y 5. ");
		}
		
		for (Usuario usuario_ : _Usuarios) {
			if(usuario.getNombre().equals(usuario_.getNombre())){
				throw new IllegalArgumentException("Nombre de usuario ya ocupado, elegir otro. ");
			}
		}
	}
	
//----------------------------------------------------------------------------------------------------------------//	
	
	
	
	public void mostrarUsuarios() {
		System.out.println("\nSe agregaron hasta el momento los usuarios: ");
		for(Usuario usuario : _Usuarios) {
			System.out.println(usuario.getNombre());
		}
	}
	
	

}
