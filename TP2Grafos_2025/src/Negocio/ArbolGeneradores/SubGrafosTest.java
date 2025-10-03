package Negocio.ArbolGeneradores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;



import Negocio.Arista;
import Negocio.Grafo;
import Negocio.Usuario;

public class SubGrafosTest {
	private Grafo grafo ;
	private Usuario usuario , usu2 , usu3 ,usu4, usu5 , usu6;
	

	@Before
	public void setUp() throws Exception {
		grafo = new Grafo();
		usuario= new Usuario ("jorge",2,3,1,4);
		usu2= new Usuario("pablo",2,3,1,3);
		usu3= new Usuario("axel",2,3,1,4);
		usu4= new Usuario("pedro",2,4,1,5);
		usu5= new Usuario("cristiano",5,5,5,5);
		usu6= new Usuario("Roberto",5,5,5,5);
		
	
	}

	

	@Test
	public void testEliminarAristaConMayorPeso() {
		SubGrafos subgrafo= new SubGrafos();
		
		 
		grafo.agregarUsuarios(usuario);
		grafo.agregarUsuarios(usu2);
		grafo.agregarUsuarios(usu3);
		grafo.agregarUsuarios(usu4);
		grafo.agregarUsuarios(usu5);
		grafo.agregarUsuarios(usu6);
		grafo.generarAristas();
		int cantidadAntes= grafo.getAristas().size();
	
		subgrafo.eliminarAristaConMayorPeso(grafo.getAristas());
		assertEquals(cantidadAntes -1, grafo.getAristas().size() );
		
	}

	@Test
	public void testSepararGrupos() {
		SubGrafos subgrafo= new SubGrafos();
		List <Arista> grupo1= new ArrayList<Arista>();
		List<Arista> grupo2= new ArrayList<Arista>();
		Set<Usuario> usuariosGrupo1;
		Set<Usuario> usuariosGrupo2;
		
		grafo.agregarUsuarios(usuario);
		grafo.agregarUsuarios(usu2);
		grafo.agregarUsuarios(usu3);
		grafo.agregarUsuarios(usu4);
		grafo.agregarUsuarios(usu5);
		grafo.agregarUsuarios(usu6);
		
		grafo.generarAristas();
		
		subgrafo.eliminarAristaConMayorPeso(grafo.getAristas());
		
		// extraigo grupo 1 
		 grupo1= subgrafo.extraerSubGrafoYRemover(grafo.getAristas());
		
		// extraigo grupo 2 
		 grupo2 =grafo.getAristas();
		 
		 // verifico que no esten vacios las aristas 
		 assertFalse(grupo1.isEmpty());
		// assertFalse(grupo2.isEmpty());
		 
		 // Verificar que los usuarios de cada grupo estén conectados internamente
		    usuariosGrupo1 = new HashSet<>();
		    for (Arista a : grupo1) {
		        usuariosGrupo1.add(a.getU1());
		        usuariosGrupo1.add(a.getU2());
		    }
		     usuariosGrupo2 = new HashSet<>();
		     for (Arista a : grupo2) {
		        usuariosGrupo2.add(a.getU1());
		        usuariosGrupo2.add(a.getU2());
		    }
		    
		 // Asegurarse de que no haya usuarios compartidos entre grupos
		    Set<Usuario> interseccion = new HashSet<>(usuariosGrupo1);
		    interseccion.retainAll(usuariosGrupo2);
		    assertTrue(interseccion.isEmpty());
		 
	}

}
