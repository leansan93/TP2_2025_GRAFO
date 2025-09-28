package Negocio.ArbolGeneradores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Negocio.Usuario;

public class Union_Find {
	// se usara para que no se forme circuitos en el arbol generador minimo este lo usara kruskal 

	 // Mapeo: {Hijo -> Padre}
    private Map<Usuario, Usuario> padre;
    
    // Mapeo: {Raíz -> Tamaño del conjunto}
    private Map<Usuario, Integer> tamanio_conjunto; 

   
    
    
    public Union_Find(List<Usuario> usuarios) {
        this.padre = new HashMap<>();
        this.tamanio_conjunto = new HashMap<>();
        
        for (Usuario usuario : usuarios) {
            this.padre.put(usuario, usuario);		//Al prncipio el padre de cada usuario es él mismo.
            
            this.tamanio_conjunto.put(usuario, 1);	//El tamaño inicial de cada conjunto es 1.
        }
    }

    
    //Busca el Usuario/vertice raiz 
    public Usuario find(Usuario usuario) {
        // Caso base: Si el usuario es su propio padre, es la raíz.
        if (padre.get(usuario) == usuario) {
            return usuario;
        }
        // Paso recursivo: Encuentra la raíz
        Usuario raiz = find(padre.get(usuario));
        
        // Optimización: Compresión de Caminos (Path Compression)
        // Apunta directamente al padre a la raíz encontrada.
        padre.put(usuario, raiz);
        
        return raiz;
    }

    
    public boolean union(Usuario usuario1, Usuario usuario2) {
        Usuario raiz1 = find(usuario1);
        Usuario raiz2 = find(usuario2);
        
        if (raiz1.equals(raiz2)) {		// Si ya tienen la misma raíz, ya están en el mismo conjunto.
            return false;
        }

        //obtenemos el tamaño
        int tamanio1 = tamanio_conjunto.get(raiz1);
        int tamanio2 = tamanio_conjunto.get(raiz2);

        
        if (tamanio1 < tamanio2) {		// raiz1 se convierte en hijo de raiz2 si cumple la condicion
            padre.put(raiz1, raiz2);
            tamanio_conjunto.put(raiz2, tamanio1 + tamanio2); 		//Actualiza el tamaño del nuevo conjunto
        } 
        
        else {							// raiz2 se convierte en hijo de raiz1 (o son iguales, se elige raiz1)     	
            padre.put(raiz2, raiz1);
            tamanio_conjunto.put(raiz1, tamanio1 + tamanio2); 		//Actualiza el tamaño del nuevo conjunto
        }

        return true;
    }




}
