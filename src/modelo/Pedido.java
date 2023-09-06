package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

public class Pedido {
	
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private Producto itemsPedido;
	private ArrayList<HashMap<String, Integer>> arr;
	
	
	
	public Pedido(String nombreCliente, String direccionCliente, ArrayList<HashMap<String, Integer>> arr)
	{
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.arr = arr;
		
		
		Pedido.numeroPedidos = numeroPedidos + 1;
		this.idPedido = (int) Math.random();
		
	}
	
	
	public String iniciarPedido(){
		String Estado = "En proceso";
		return Estado;
	}
	
	
	public String GenerarTextoFactura(Pedido pedido_cliente) {
		
		int valor = 0;
		String str1 = pedido_cliente.getNombreCliente();
		String str2 = pedido_cliente.getDireccionCliente();
		ArrayList<HashMap<String, Integer>> array = pedido_cliente.getArr();
		
		for (HashMap<String, Integer> map : array) {
			for (Integer num: map.values()) {
				valor = valor + num;
			}
		 
		}
		
		String str3 = "Valor total " + Integer.toString(valor);
		String str4 = "IVA: " + Double.toString(valor * 0.19);
		String str5 = "Valor Neto a pagar: " + Double.toString(valor + valor * 0.19);
		int idped = (int) (Math.random() * 100) + 1;
		String str6 = "ID Pedido: " + Integer.toString(idped);
		
		
		return str6 + "\n" + str1 + "\n" + str2 + "\n" + str3 + "\n" + str4+ "\n" + str5;
		
	}
	

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}



	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}





	public static int getNumeroPedidos() {
		return numeroPedidos;
	}
	public static void setNumeroPedidos(int numeroPedidos) {
		Pedido.numeroPedidos = numeroPedidos;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public Producto getItemsPedido() {
		return itemsPedido;
	}


	public void setItemsPedido(Producto itemsPedido) {
		this.itemsPedido = itemsPedido;
	}


	public ArrayList<HashMap<String, Integer>> getArr() {
		return arr;
	}


	public void setArr(ArrayList<HashMap<String, Integer>> arr) {
		this.arr = arr;
	}
	
	
	

}
