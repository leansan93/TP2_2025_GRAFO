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

public class AlgoritmoKruskalTest {
	private Grafo grafo;
	
	private Usuario usu1, usu2, usu3, usu4, usu5, usu6;
	
	
	
	@Before
	public void setUp() throws Exception {
		
		grafo= new Grafo();
		usu1= new Usuario ("carlos",2,3,4,1);
		usu2= new Usuario("pepe",2,3,5,4);
		usu3= new Usuario("mario",5,4,3,4);
		usu4= new Usuario("pedro",5,5,4,4);
		usu5= new Usuario("jhon",5,3,4,4);
		usu6= new Usuario("geralt",5,2,4,4);
		
	}

	

	@Test
	public void testMostrarArbolGeneradorMinimo() {
		AlgoritmoKruskal kruskal = new AlgoritmoKruskal();
		List <Arista> mst = new ArrayList <Arista>();
		
		grafo.agregarUsuarios(usu1);
		grafo.agregarUsuarios(usu2);
		grafo.agregarUsuarios(usu3);
		grafo.agregarUsuarios(usu4);
		grafo.agregarUsuarios(usu5);
		grafo.agregarUsuarios(usu6);
		
		grafo.generarAristas();
		mst=  kruskal.obtenerMST(grafo);
		 // Verificar que el número de aristas sea correcto (V-1)
	    assertEquals(grafo.getUsuarios().size() - 1, mst.size());

	    // Verificar que no haya ciclos implícitamente (Union-Find hace esto)
	    Set<Usuario> nodosConectados = new HashSet<>();
	    for (Arista a : mst) {
	        nodosConectados.add(a.getU1());
	        nodosConectados.add(a.getU2());
	    }
	    assertEquals(grafo.getUsuarios().size(), nodosConectados.size());
		
	}

}
