package modelo;

public class ProductoMenu {
	
	private String nombre;
	private int PrecioBase;
	
	
	public ProductoMenu(String nombre, int PrecioBase)
	{
		this.nombre = nombre;
		this.PrecioBase = PrecioBase;
			
	}

	
	
	
	
	
	
	
	

	@Override
	public String toString() {
		return "ProductoMenu [nombre=" + nombre + ", PrecioBase=" + PrecioBase + "]";
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getPrecioBase() {
		return PrecioBase;
	}


	public void setPrecioBase(int precioBase) {
		PrecioBase = precioBase;
	}
	
}
