package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	private ArrayList<HashMap<String, String>> pedidosPorId;
	

	
	
	
	public Restaurante () throws FileNotFoundException  {
		
		CargarInformacionRestaurante();
		
		int numeroPedidos = 0;
		pedidos = new ArrayList<Pedido>();
		this.pedidoEnCurso = false;
		pedidosPorId = new ArrayList<HashMap<String, String>>();
		
		
		
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
			
			linea = br.readLine();
			
			
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
			
			linea = br.readLine();
			
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
			
			linea = br.readLine();
			
		}
		this.combos = combos;
		}
		catch(Exception e)  
		{ e.printStackTrace();
		
		}
			
		}
	
	
	
	
	

	@Override
	public String toString() {
		return "Restaurante [pedidos=" + pedidos + ", combos=" + combos + ", pedidoEnCurso=" + pedidoEnCurso
				+ ", ingredientes=" + ingredientes + ", menuBase=" + menuBase + "]";
	}






	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}



	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}








	public ArrayList<HashMap<String, String>> getPedidosPorId() {
		return pedidosPorId;
	}








	public void setPedidosPorId(ArrayList<HashMap<String, String>> pedidosPorId) {
		this.pedidosPorId = pedidosPorId;
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
	
	
	
	public HashMap<String, Integer> AgregarProductoMenuPedido(int codigo_num)
	{
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_num >= 0 | codigo_num <= 21) {
			
			ProductoMenu prd = getMenuBase().get(codigo_num);
			int precioBase = prd.getPrecioBase();
			String nombreprod = prd.getNombre();
			mapa.put(nombreprod, precioBase);
			
		}
		
		return mapa;
		
	}
		
		
	
	

	public HashMap<String, Integer> AgregarIngredientePedido (int codigo_num) {
		
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_num >= 26 | codigo_num <= 40) {
			
			int codnuevo = codigo_num - 26;
			
			Ingrediente ingr = getIngredientes().get(codnuevo);
			int precioingr = ingr.getCostoAdicional();
			String nombreingr = ingr.getNombre();
			mapa.put(nombreingr, precioingr);
			
		}
		return mapa;
		
	}

	
	public HashMap<String, Integer> AgregarComboPedido (int codigo_num) {
		
		HashMap<String, Integer> mapa = new HashMap<>();
		
		if (codigo_num == 22) {
			Combo cmb = getCombos().get(0);
			double precio = 24500 - (24500*0.10);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo, (int) precio);
		}
		
		if (codigo_num == 23) {
			Combo cmb = getCombos().get(1);
			double precio = 26500 - (26500*0.10);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo, (int) precio);
		}
		
		if (codigo_num == 24) {
			Combo cmb = getCombos().get(2);
			double precio = 36900 - (36900*0.07);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo,(int) precio);
		}
		
		if (codigo_num == 25) {
			Combo cmb = getCombos().get(3);
			double precio = 34500 - (34500*0.07);
			String nombrecombo = cmb.getNombreCombo();
			mapa.put(nombrecombo,(int) precio);
		}
		
		
		return mapa;
		
		
	}

	public void GuardarFactura(String factura, String nombreArchivo) {
		try {
            
			String ruta = "data/" + nombreArchivo + ".txt";
			File file = new File(ruta);
			
			if (!file.exists()) {
				file.createNewFile();
			}
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(factura);
            bufferedWriter.close();
            System.out.println("El archivo " + nombreArchivo + " se ha creado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
		
    }

	public String obtenerFactura(int id) {
	    String strId = Integer.toString(id);
	    File archivo = new File("data/" + strId + ".txt");

	    if (!archivo.exists()) {
	        System.out.println("El archivo " + archivo.getName() + " no existe.");
	        return null; // o un valor de retorno apropiado en tu caso
	    }

	    try (FileInputStream inputStream = new FileInputStream(archivo);
	         Scanner scanner = new Scanner(inputStream)) {

	        System.out.println("Contenido de " + archivo.getName() + ":");

	        while (scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            System.out.println(linea); // Imprime cada línea del archivo
	        }

	        System.out.println("---------------------------");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return strId;
	}
}
	
	




	
	
	
	
	



	
		

		
		
		









