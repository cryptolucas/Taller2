package modelo;

import java.util.HashMap;

public class ProductoAjustado {

	private ProductoMenu base;
	private Ingrediente agregados;
	private Ingrediente eliminados;
	private HashMap<String, String> pedidosPorId;
	private String factura;
	
	public ProductoAjustado (String factura) {
		this.factura = factura; 
		pedidosPorId = new HashMap<>();
		String[] partes = factura.split("\n");
		pedidosPorId.put(partes[0], " " + partes[1] + ", " + partes[2] + ", " + partes[3] + ", " + partes[4] + ", "+ partes[5]);
		
	}
	
	
	
	
	
	public void guardarpedidosId (String factura) {
		String[] partes = factura.split("\n");
		pedidosPorId.put(partes[0], " " + partes[1] + ", " + partes[2] + ", " + partes[3] + ", " + partes[4] + ", "+ partes[5]);
	}

	
	
	public HashMap<String, String> getPedidosporId(){
		return pedidosPorId;
	}





	public HashMap<String, String> getPedidosPorId() {
		return pedidosPorId;
	}





	public void setPedidosPorId(HashMap<String, String> pedidosPorId) {
		this.pedidosPorId = pedidosPorId;
	}
	
	
}
