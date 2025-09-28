package Negocio;

import java.util.ArrayList;
import java.util.List;



public class Grafo {
	// creo lista de usuarios y de aristas para el grafo 
	List <Usuario> _Usuarios;
	List <Arista> _Aristas;
	
	public Grafo () {
		
		this._Usuarios= new ArrayList<>();
		this._Aristas= new ArrayList<>();
	}
	
	// agrega usuario que no este registrado  o no este en la lista 
	public void agregarUsuarios(Usuario usuario) {
		
		if (!existeUsuario(usuario)) {
		_Usuarios.add(usuario);
		}
	}
	

	
// me aseguro que el usuario que se va a agregar no este en la lista 
	private boolean existeUsuario(Usuario usuario) {
		 for (int i = 0 ; i < _Usuarios.size() ; i ++ ) {
			 if (!_Usuarios.get(i).getNombre().equals(usuario.getNombre())) {
				 return true;
			 }
		 }
		return false;
	}

	//// nota poner otro para el nombre que seria algo asi como un nombre valido para que no 
	// se ingrese numeros 
	
	
	
	
	public List<Usuario> getUsuarios(){
		return _Usuarios;
	}


	public List<Arista> getAristas() {
		return _Aristas;
	}


	public void setAristas(List<Arista> aristas) {
		_Aristas = aristas;
	}


	public void setUsuarios(List<Usuario> usuario) {
		_Usuarios= usuario;
	}
	
	// generar aristas con peso todos los pares de usuarios con su peso
	// esto se crea cuando se agrega a la lista de usuarios que seria el vertice 
	// y este se genera de manera automatica dando la union de los dos usuarios generando el peso de la arista
	public void generarAristas() {

		for (int i = 0 ; i < _Usuarios.size() ; i ++ ) {
			for (int j = i + 1 ; j < _Usuarios.size() ; j ++ ) {
				Usuario u1= _Usuarios.get(i); // creo el usuario 1 
				Usuario u2 = _Usuarios.get(j); // creo el usuario 2 
				
				int peso = u1.CalcularSimilaridad(u2); // aqui se agrega el peso con calcular similaridad
				
				_Aristas.add(new Arista(u1, u2 , peso));
			}
			
		}
		
		
	}
	 
}
