package modelo;

public class Ingrediente {
	
	private String nombre;
	private int CostoAdicional;
	
	
	public Ingrediente(String nombre, int CostoAdicional)
	{
		this.nombre = nombre;
		this.CostoAdicional = CostoAdicional;
		
	}


	
	
	
	
	
	








	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", CostoAdicional=" + CostoAdicional + "]";
	}
















	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCostoAdicional() {
		return CostoAdicional;
	}


	public void setCostoAdicional(int costoAdicional) {
		CostoAdicional = costoAdicional;
	}
	

}

