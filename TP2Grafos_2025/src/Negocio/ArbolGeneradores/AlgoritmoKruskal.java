package Negocio.ArbolGeneradores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Negocio.Arista;
import Negocio.Grafo;
import Negocio.Usuario;
//import Negocio.ArbolesGeneradores.Union_Find;

public class AlgoritmoKruskal {
	// se encarga de : 
	// Tomar todas las aristas del grafo.
	// Ordenarlas por peso (ascendente).
	// Usar Union-Find para ir agregando las que no generen ciclos.
	// Construir el Árbol Generador Mínimo (MST) como resultado (lista de aristas).




	public AlgoritmoKruskal() {
		
	}
	 
	 public List<Arista> obtenerMST(Grafo grafo) {
	        
		 	//Clonamos y ordenamos las aristas por peso
	        List<Arista> aristas = new ArrayList<>(grafo.getAristas());	//clonamos
	        Collections.sort(aristas);		//ordenamos  
	       
	        //Creamos la estructura de datos Union_Find
	        Union_Find unionFind = new Union_Find(grafo.getUsuarios());		//creamos el objeto de Union Find

	        List<Arista> mst = new ArrayList<>();		//Creamos el arbol generador minimo
	        
	        int aristasContadas = 0;
	        int pesoTotal = 0;
	        int numVertices = grafo.getUsuarios().size();	//obtenemos cantidad de aristas

	        
	        for (Arista arista : aristas) {		//Recorremos las aristas ordenadas
	            if (aristasContadas == numVertices - 1) {
	                break;
	            }

	            //verificamos que no hayan ciclos y unimos las partes
	            if (unionFind.union(arista.getU1(), arista.getU2())) { 
	                mst.add(arista);					//agregamos la arista a el arbol
	                pesoTotal += arista.getPeso();		//agregamos el peso a 
	                aristasContadas++;					//sumamos la cantidad de aristas 
	            }
	        }
	        
	        System.out.println("Peso del Arbol Generador Minimo: " + pesoTotal);

	        return mst;
	    }
	 
	 
	 
	//mostrar arbol por consola.
	public void mostrarArbolGeneradorMinimo(List <Arista> _Aristas) {
		
		for (Arista arista : _Aristas) {
			Usuario usuario_1 = arista.getU1();	
			Usuario usuario_2 = arista.getU2();
			System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
		}
	}


}
