package Negocio;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	
	private Grafo grafo ;
	
	private Usuario usuario, usu2, usu3 , usu4 , usu5;

	@Before
	public void setUp() throws Exception {
		 grafo = new Grafo();
		 usuario= new Usuario("pablo", 1 ,2,5,4);
		 usu2= new Usuario("jose",2,5,4,1);
		 usu3= new Usuario("ermac",5,2,5,4);
		 usu4= new Usuario ("perez",1,3,1,3);
		 usu5 = new Usuario("pepe",4,5,3,1);
		
	}

	
	@Test 
	public void testAgregarUsuariosOK_SinRepetirUsuario() throws Exception{
		Grafo grafoPrueba= new Grafo();
		grafoPrueba.agregarUsuarios(usu3);
		grafoPrueba.agregarUsuarios(usu4);
		assertEquals(2, grafoPrueba.getUsuarios().size());
	    assertTrue(grafoPrueba.getUsuarios().contains(usu3));
	    assertTrue(grafoPrueba.getUsuarios().contains(usu4));
	
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAgregarUsuarioRepetidoError() {
		 Grafo grafoPrueba2= new Grafo ();
		 Usuario usu= new Usuario("pepe",4,5,4,2);
		 Usuario usuRepetido= new Usuario ("pepe", 1,2,3,4);
		 grafoPrueba2.agregarUsuarios(usu);
		 grafoPrueba2.agregarUsuarios(usuRepetido);
		 
	}

	@Test
	public  void generarAristaOk() {
		Usuario usu1= new Usuario("xoxo", 1 ,2,5,4);
		Usuario usu2=  new Usuario("ululul",2,5,4,1);;
		grafo.agregarUsuarios(usu1);
		grafo.agregarUsuarios(usu2);
		grafo.generarAristas();
		Arista arista = grafo.getAristas().get(0);
		Integer esperado = usu1.CalcularSimilaridad(usu2) ;
		assertEquals(esperado, arista.getPeso());
		 
	}
	
 
	
	
	

	

}
