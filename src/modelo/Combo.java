package modelo;

public class Combo {
	
	private double descuento;
	private String nombreCombo;
	private ProductoMenu itemsCombo;
	
	
	
	public Combo (String nombreCombo, double descuento)
	{
		this.nombreCombo = nombreCombo;
		this.descuento = descuento;
		
			
	}



	@Override
	public String toString() {
		return "Combo [descuento=" + descuento + ", nombreCombo=" + nombreCombo + "]";
	}
	
	
	


	public double getDescuento() {
		return descuento;
	}



	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}



	public String getNombreCombo() {
		return nombreCombo;
	}



	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}



	public ProductoMenu getItemsCombo() {
		return itemsCombo;
	}



	public void setItemsCombo(ProductoMenu itemsCombo) {
		this.itemsCombo = itemsCombo;
		
	}
	
	
		
	
	
	}
		
	
	
	
	






	

