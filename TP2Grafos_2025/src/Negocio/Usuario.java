package Negocio;

public class Usuario {
	private String nombre;
	private Integer Interes_tango;
	private Integer Interes_rockNacional;
	private Integer Interes_Folclore;
	private Integer Interes_Urbano;
	
	
	public Usuario( String nombre , Integer  Interes_tango , Integer Interes_rockNacional, Integer Interes_Folclore , Integer Interes_Urbano) {
		// aseguro que el nombre sea valido 
		if (!nombreValido(nombre) ) {
			 throw new IllegalArgumentException("El nombre ingresado no es válido.");
		}
		this.nombre= nombre;
		this.Interes_rockNacional = Interes_rockNacional;
		this.Interes_Folclore= Interes_Folclore;
		this.Interes_tango= Interes_tango;
		this.Interes_Urbano= Interes_Urbano;
		
		
	}

	public int CalcularSimilaridad(Usuario Usuariosegundo) {
		return Math.abs(Interes_rockNacional - Usuariosegundo.getInteres_rockNacional()) + 
			   Math.abs(Interes_Folclore - Usuariosegundo.getInteres_Folclore())+
			   Math.abs(Interes_tango - Usuariosegundo.getInteres_tango()) + 
			   Math.abs(Interes_Urbano - Usuariosegundo.getInteres_Urbano());
	}

	// se fija que el nombre sea valido y no tenga solo numeros o signos raros 
	private boolean nombreValido (String nombre ) {
		return nombre.matches(".*[a-zA-Z].*") && nombre.matches("[a-zA-Z\\s]+");
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getInteres_tango() {
		return Interes_tango;
	}

	public void setInteres_tango(Integer interes_tango) {
		Interes_tango = interes_tango;
	}

	public Integer getInteres_rockNacional() {
		return Interes_rockNacional;
	}

	public void setInteres_rockNacional(Integer interes_rockNacional) {
		Interes_rockNacional = interes_rockNacional;
	}

	public Integer getInteres_Folclore() {
		return Interes_Folclore;
	}

	public void setInteres_Folclore(Integer interes_Folclore) {
		Interes_Folclore = interes_Folclore;
	}

	public Integer getInteres_Urbano() {
		return Interes_Urbano;
	}

	public void setInteres_Urbano(Integer interes_Urbano) {
		Interes_Urbano = interes_Urbano;
	}


}
