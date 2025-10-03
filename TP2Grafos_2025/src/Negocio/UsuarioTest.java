package Negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario usuario , usu2;
	@Before
	public void setUp() throws Exception {
		 usuario = new Usuario ("pepe",2,3,4,5);
		 usu2= new Usuario("jose", 2, 2, 2,2);
			}

	@Test // (expected = IllegalArgumentException.class)
	public void testNombreUsuarioValido() {
		

        assertTrue(usuario.nombreValido(usuario.getNombre()));
         assertTrue(usuario.nombreValido("Juan Perez"));
        assertTrue(usuario.nombreValido("Maria"));  
        assertTrue(usuario.nombreValido("Luis Alberto"));
	}
	
	
	@Test   
	public void testNombreUsuarioInvalido() {
		Usuario u = new Usuario("Ana", 1,2,3,4);

        // solo n�meros
        assertFalse(u.nombreValido("1234"));
        // solo s�mbolos
        assertFalse(u.nombreValido("@@@@"));
        // combinaci�n de letras + n�meros
        assertFalse(u.nombreValido("Ana123"));
        // vac�o
        assertFalse(u.nombreValido(""));
        // solo espacios
        assertFalse(u.nombreValido("   "));
        // null (deber�as modificar el m�todo para cubrir este caso con != null)
        assertFalse(u.nombreValido(null));
	}
	
 
	@Test
	public void testCalcularSimilaridadOK() {
		 
		Integer similaridad= usuario.CalcularSimilaridad(usu2);
		Integer esperado= 6;
		assertEquals(esperado, similaridad);
	}
	
	
}
