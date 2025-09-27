package Negocio;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	List <Usuario> _Usuarios;
	List <Arista> _Aristas;
	
	public Grafo () {
		
		this._Usuarios= new ArrayList<>();
		this._Aristas= new ArrayList<>();
	}
	
	
	public void agregarUsuario(Usuario usuario) {
		
		_Usuarios.add(usuario);
		
	}

	public List<Usuario> getUsuario(){
		return _Usuarios;
	}


	public List<Arista> getAristas() {
		return _Aristas;
	}


	public void setAristas(List<Arista> aristas) {
		_Aristas = aristas;
	}


	public void setUsuario(List<Usuario> usuario) {
		_Usuarios= usuario;
	}
	
	// generar aristas con peso todos los pares de usuarios con su peso 
	public void generarAristas() {

		for (int i = 0 ; i < _Usuarios.size() ; i ++ ) {
			for (int j = i + 1 ; j < _Usuarios.size() ; j ++ ) {
				Usuario u1= _Usuarios.get(i);
				Usuario u2 = _Usuarios.get(j);
				
				int peso = u1.CalcularSimilaridad(u2);
				
				_Aristas.add(new Arista(u1, u2 , peso));
			}
			
		}
		
		
	}
	 
}
