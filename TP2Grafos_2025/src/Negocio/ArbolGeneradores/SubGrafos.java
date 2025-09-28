package Negocio.ArbolGeneradores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Negocio.Arista;
import Negocio.Usuario;

public class SubGrafos {
	// este se va a encargar de que no se formen circuitos en el grafo con kruskcal
	// se encargara de : 
	// Eliminás la arista de mayor peso en el MST.
	// ecorrer desde un nodo cualquiera y así encontrar los 2 componentes (los grupos).
	// el grupo 1 seran los visitados y el grupo2 los que no se llegaron a visitar


public SubGrafos() {
		
	}
	
	 public static void eliminarAristaConMayorPeso(List <Arista> Aristas) {
		 int mayorPeso = 0;
		 Arista mayorArista = null; 
		 
		 for (Arista arista : Aristas) {
			 if (arista.getPeso() > mayorPeso) {
				 mayorPeso = arista.getPeso();
				 mayorArista = arista;
			 }
		 }
		 Aristas.remove(mayorArista);	
		 System.out.println("Se elimino la arista con peso: " + mayorArista.getPeso());		 
	 }
	 
	

	 
	 //la maopa de adyacencia nos sirve para recorrer el grafo directamente ya que nos permite saber los 
	 //vecinos que tiene nuestra clave
	 //clave = Usuario
	 //valor = lista de Vecinos de el usuario clave
	 
	//retorna una nueva lista con las aristas de un sub grafo y saca las aristas de la lista inicial
	
	 
    public  List<Arista> extraerSubGrafoYRemover(List<Arista> aristasOriginales) {
        if (aristasOriginales == null || aristasOriginales.isEmpty()) {
            return new ArrayList<>();
        }

        //Creamos una lista de Adyacencia o vecinos 
        Map<Usuario, List<Usuario>> adyacencia = new HashMap<>();
        
        //agarra el primer usuario de la primera arista como punto de partida.
        Usuario verticeInicial = aristasOriginales.get(0).getU1(); 

        //Rellenar la lista de adyacencia para poder usar DFS
        for (Arista arista : aristasOriginales) {
            Usuario u1 = arista.getU1();
            Usuario u2 = arista.getU2();
            
            List<Usuario> listaVecinos = adyacencia.get(u1);
            if (listaVecinos == null) {						//Si la clave 'u1' no existe creamos la lista
            	listaVecinos = new ArrayList<>();
            	adyacencia.put(u1, listaVecinos);
            }
            listaVecinos.add(u2); 							//Agregamos el vecino 'u2' a la lista
         
            
            List<Usuario> listaVecinosU2 = adyacencia.get(u2);
            if (listaVecinosU2 == null) {					// Si la clave 'u2' no existe, creamos la lista.               
                listaVecinosU2 = new ArrayList<>();
                adyacencia.put(u2, listaVecinosU2);
            }           
            listaVecinosU2.add(u1); 						//Agregamos el vecino 'u1' a la lista de 'u2'.      
        }
        
        
        
        //DFS recorre el subgrafo y recolecta los vertices que estan unidos a partir del vertice inicial
        //usamos DFS para encontrar todos los vértices del subgrafo
        Set<Usuario> verticesSubGrafo = new HashSet<>();
        depthFirstSearch(verticeInicial, adyacencia, verticesSubGrafo);

        
        //Nuevo SubGrafo
        List<Arista> aristasSubGrafo = new ArrayList<>();
        

        //Obtener el iterador para modificar la lista
        Iterator<Arista> iterador = aristasOriginales.iterator();

        
        while (iterador.hasNext()) {					//recorremos la lista usando el iterador.
            Arista arista = iterador.next();

            // Chequea si ambos vértices de la arista fueron visitados por el DFS.
            if (verticesSubGrafo.contains(arista.getU1()) && verticesSubGrafo.contains(arista.getU2())) {
            	
                aristasSubGrafo.add(arista); 				// Agrega la arista al nuevo subgrafo
                iterador.remove(); 							// Eliminamos la arista de la lista original
            }
        }

        //aristasOriginales solo contendrá el otro subgrafo
        return aristasSubGrafo;
    }


    
    
    //DFS para encontrar todos los nodos conectados.
    private static void depthFirstSearch(Usuario u, Map<Usuario, List<Usuario>> adyacencia, Set<Usuario> visitados) {
        if (visitados.contains(u) || !adyacencia.containsKey(u)) {
            return;
        }

        visitados.add(u);
        
        // Recorre todos los vecinos del usuario actual
        for (Usuario vecino : adyacencia.getOrDefault(u, new ArrayList<>())) {
            depthFirstSearch(vecino, adyacencia, visitados);
        }
    }



















}
