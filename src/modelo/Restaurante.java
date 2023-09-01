package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.InputStream;
import java.lang.Object;
import java.io.InputStream;
import java.io.FileInputStream;



public class Restaurante {
	
	private ArrayList<Pedido> pedidos;
	private ArrayList<Combo> combos;
	private boolean pedidoEnCurso;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	

	
	
	
	public Restaurante () throws FileNotFoundException  {
		
		CargarInformacionRestaurante();
		
		int numeroPedidos = 0;
		pedidos = new ArrayList<Pedido>();
		this.pedidoEnCurso = false;
		
		
		
		}
		
		
		
	
	
	public void CargarInformacionRestaurante() throws FileNotFoundException
	
	{
		String archivoMenu = "data/menu.txt";
		String archivoCombos = "data/combos.txt";
		String archivoIngredientes = "data/ingredientes.txt";
		
		loaderIngredientes(archivoIngredientes);
		loaderCombos(archivoCombos);
		loaderMenu(archivoMenu);
		
		
	}
	
		
	public void loaderIngredientes(	String archivoIngredientes) throws FileNotFoundException
	{
		
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes)))
		{
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreProd = partes[0];
			int precioProd = Integer.parseInt(partes[1]);
			Ingrediente nuevo = new Ingrediente(nombreProd, precioProd);
			ingredientes.add(nuevo);
			
			
		}
	    this.ingredientes = ingredientes;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	
	
	
	public void loaderMenu(String archivoMenu) throws FileNotFoundException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu)))
		{
		ArrayList<ProductoMenu> menuBase = new ArrayList<>();
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombre = partes[0];
			int PrecioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevo = new ProductoMenu(nombre, PrecioBase);
			menuBase.add(nuevo);
			
		}
		this.menuBase = menuBase;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	public void loaderCombos(String archivoCombos) throws FileNotFoundException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos)))
		{
		ArrayList<Combo> combos = new ArrayList<>();
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String porcentaje = partes[1];
			porcentaje = porcentaje.replace("%","");
		 	double descuento = Double.parseDouble(porcentaje);
			Combo nuevo = new Combo(nombreCombo, descuento);
			combos.add(nuevo);
			
		}
		this.combos = combos;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	
	
	

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public boolean isPedidoEnCurso() {
		return pedidoEnCurso;
	}


	public void setPedidoEnCurso(boolean pedidoEnCurso) {
		this.pedidoEnCurso = pedidoEnCurso;
	}


	public ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}


	public void setMenuBase(ArrayList<ProductoMenu> menuBase) {
		this.menuBase = menuBase;
	}





	



	
		

		
		
		
	}








