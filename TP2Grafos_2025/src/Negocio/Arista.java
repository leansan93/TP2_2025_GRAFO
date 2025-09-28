package Negocio;


// clase arista para ver y crear las aristas que lo usa la clase Grafo 
 
public class Arista  implements Comparable<Arista> {
	private Integer peso;
	private Usuario u1;
	private Usuario u2;
	
	public Arista ( Usuario u1 , Usuario u2 ,Integer peso ) {
		this.peso= peso;
		this.u1 = u1;
		this.u2= u2;
		
	}
	


	public Integer getPeso() {
		return peso;
	}
	
	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Usuario getU1() {
		return u1;
	}


	public void setU1(Usuario u1) {
		this.u1 = u1;
	}

	public Usuario getU2() {
		return u2;
	}
	
	
	public void setU2(Usuario u2) {
		this.u2 = u2;
	}

////// compara los pesos entre aristas 
	@Override
	public int compareTo(Arista otro) {
		return Integer.compare(peso , otro.peso);
	}

	
}
