package Controller;


	
	
	import java.util.ArrayList;
	import java.util.List;

	import Negocio.Arista;
	import Negocio.Grafo;
	import Negocio.Usuario;
	import Negocio.ArbolGeneradores.*; // importa todo los paquetes de Negocio 
 
	import Negocio.ArbolGeneradores.AlgoritmoKruskal;




	public class ControllerGrafo {
		private Grafo grafo;								//grafo original
		List <Usuario> _Usuarios;							//Lista de usuarios
		List <Arista> _Aristas;								//Lista de aristas entre todos los usuarios
		List <Arista> ArbolGeneradorMinimo;					//AGM del Grafo Original
		List <Arista> SubGrafos;							//SubGrafos conexos del grafo original
		List <Arista> SubGrafo_1;							//Primer subgrafo del grafo original separado
															//El segundo subgrafo queda en la lista SubGrafos
		
		
		public ControllerGrafo(Grafo grafo) {	
			this.grafo = grafo;
			this._Usuarios= grafo.getUsuarios();
			this._Aristas= grafo.getAristas();	
			this.ArbolGeneradorMinimo = generarAGM();
			this.SubGrafos = eliminarAristaConMayorPesoo();
			this.SubGrafo_1 = separarSubGrafos();
		}
		
		
		
		
		
	//------------------------------------Generar Aristas--------------------------------------------------------//	
		
		//Generar aristas con sus pesos correspondientes entre todos los usuarios 
			public void generarAristas() {

				for (int i = 0 ; i < _Usuarios.size() ; i ++ ) {
					for (int j = i + 1 ; j < _Usuarios.size() ; j ++ ) {
						Usuario u1= _Usuarios.get(i);
						Usuario u2 = _Usuarios.get(j);		
						int peso = u1.CalcularSimilaridad(u2);
						this._Aristas.add(new Arista(u1, u2 , peso));
					}	
				}	
			}	

	//---------------------------------------------Generar AGM-------------------------------------------------------//
			
			//Generar el AGM del grafo
			public List<Arista> generarAGM() {
				
				 AlgoritmoKruskal kruskal = new AlgoritmoKruskal();
				 List <Arista> AGM = kruskal.obtenerMST(grafo);
				 this.ArbolGeneradorMinimo = AGM;
				 return AGM;		 
			}
			
			
	//----------------------------------------Eliminar Arista Pesada-------------------------------------------------//
			
		
			//Eliminamos la arista con mayor peso
			public List <Arista> eliminarAristaConMayorPesoo() {		
			
				List <Arista> subGrafo = new ArrayList<>();
				subGrafo = ArbolGeneradorMinimo;						//Creamos una copia de las aristas originales
		
				SubGrafos SubGrafos = new SubGrafos();			
				SubGrafos.eliminarAristaConMayorPeso(subGrafo);
						
				this.SubGrafos = subGrafo;
				return subGrafo;
			}
			
		
	//----------------------------------------------Separar Sub Grafos-----------------------------------------------//
			
			public List <Arista> separarSubGrafos(){
				
				SubGrafos SubGrafos = new SubGrafos();				
				List <Arista> subGrafo_1 = SubGrafos.extraerSubGrafoYRemover(this.SubGrafos);
		
				this.SubGrafo_1 = subGrafo_1;
				return subGrafo_1;
				
			}
			
		
	//------------------------------------------Usuarios por grupo---------------------------------------------------//		
			
			//muestra los usuarios por consola 
			public List<Usuario> mostrarUsuariosGrupo(List<Arista> subGrupos) {
				
				List<Usuario> usuariosSubGrupo = new ArrayList<>();
				
				for (Arista arista : subGrupos) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					
					if (!usuariosSubGrupo.contains(usuario_1)) {
						usuariosSubGrupo.add(usuario_1);
					}
					
					if (!usuariosSubGrupo.contains(usuario_2)) {
						usuariosSubGrupo.add(usuario_2);
					}		
				}
				
				//los mostramos por consola
//				for (Usuario usuario: usuariosSubGrupo) {
//					System.out.println(usuario.getNombre());		
//				}
				
				return usuariosSubGrupo;
					
			}
			
			
	//--------------------------------------Metodos para mostrar por consola------------------------------------------//		
			
			
			//mostrar grafo por consola.
			public void mostrarGrafo() {
				for (Arista arista : _Aristas) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
				}
			}
			

			//mostrar AGM
			public void mostrarAGM() {
				for (Arista arista : ArbolGeneradorMinimo) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
				}
			}
			
			
			//mostrar arbol minimo sin aristas
			public void mostrarAGMSinArista(){
				System.out.println("\nArbol generador minimo sin Arista mas pesada: \n");
				for (Arista arista : SubGrafos) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
				}			
			}
			
			
		
			//mostrar primer subgrafo
			public void mostrarPrimerSubGrafo(){
				System.out.println("\nSubGrafo 1: \n");
				for (Arista arista : SubGrafo_1) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
				}			
			}
			
			//mostrar segundo subgrafo
			public void mostrarSegundoSubGrafo(){
				System.out.println("\nSubGrafo 2: \n");
				for (Arista arista : SubGrafos) {
					Usuario usuario_1 = arista.getU1();	
					Usuario usuario_2 = arista.getU2();
					System.out.println(usuario_1.getNombre() + "----" + arista.getPeso() + "----" + usuario_2.getNombre());			
				}			
			}
			
			
			
			public List <Arista> getAristas(){
				return this._Aristas;
			}
			public List <Arista> getGrupo1(){
				return this.SubGrafo_1;
			}
			public List <Arista> getGrupo2(){
				return this.SubGrafos;
			}
			


}
