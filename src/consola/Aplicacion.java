package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Combo;
import modelo.Ingrediente;
import modelo.Pedido;
import modelo.ProductoAjustado;
import modelo.ProductoMenu;
import modelo.Restaurante;

public class Aplicacion {
	
	private Restaurante restaurante;

	public Aplicacion () throws FileNotFoundException {
		
		restaurante = new Restaurante();
		
		
	}
	public static void main(String[] args) throws FileNotFoundException   {
		
		Aplicacion app = new Aplicacion();
		app.mostrarMenu();
		app.ejecutarAplicacion();
		
	}
	
	

	public void mostrarMenu()
	{
		
		{
			System.out.println("Bienvenido al menu...\n");
			System.out.println("1. Mostrar Menú");
			System.out.println("2. Hacer Pedido");
			System.out.println("3. Consultar Pedido por ID");
			System.out.println("4. Salir de la App...");
			
		
		}
	}	
	
	
	public void ejecutarAplicacion()
	{
		System.out.println("Menu hamburguesas...\n");
		
		

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
				if (opcion_seleccionada == 1) {
					
					int i = 0;
					int j = 22;
					int h = 26;
					
					for (ProductoMenu prd: restaurante.getMenuBase()) {
						
						System.out.println( i + ". " + prd);
						i++;
					}
					
					System.out.println("                              ");
					
					for (Combo cmb: restaurante.getCombos()) {
						
						System.out.println( j + ". " + cmb);
						j++;
					}
					
					System.out.println("                              ");
					
					for (Ingrediente ingr: restaurante.getIngredientes()) {
						
						System.out.println( h + ". " + ingr);
						h++;
					}
				}
					
				
					
			    if (opcion_seleccionada == 2) {
			    	
			    	ArrayList<HashMap<String, Integer>> arr = new ArrayList<>();
			    	
			    	Scanner scanner = new Scanner(System.in);
			        System.out.println("Ingresa el codigo del producto que quieres (0-21) o el Combo que te gustaría (22-25):  ");
			        int numero = scanner.nextInt();

			        if (numero >= 22 | numero <= 25 ) {
			        	HashMap<String, Integer> combo = restaurante.AgregarComboPedido(numero);
			        	System.out.println(combo);
			        	arr.add(combo);
			        }
			        
			        if (numero <= 21) {
			        	HashMap<String, Integer> prod = restaurante.AgregarProductoMenuPedido(numero);
			        	System.out.println(prod);
			        	arr.add(prod);
			        }
			        
			        
			        
			        System.out.println("                                                                            ");
			        System.out.println("                                                                            ");
			        System.out.println("                                                                            ");
			        
			        Scanner scanner2 = new Scanner(System.in);
			        System.out.println("¿Te gustaría agregar un ingrediente? Pon '1' para SI o '0' para NO    ");
			        int si_no = scanner.nextInt();
			        
			        if (si_no == 1) {
	
						Scanner scanner3 = new Scanner(System.in);
					    System.out.println("Pon el codigo del ingrediente que quieres agregar (26 - 40):    ");
					    int agregar = scanner.nextInt();
					    
					    HashMap<String, Integer> ingr = restaurante.AgregarIngredientePedido(agregar);
			        	System.out.println(ingr);
					    arr.add(ingr);
					    
						}
			        
			        String nombre_persona = input("Para continuar ingresa tu nombre:  ");
			        String direccion_cliente = input("Ingresa tu dirección:   ");
			        Pedido ped = new Pedido(nombre_persona, direccion_cliente, arr);
			        
			        System.out.println(ped.GenerarTextoFactura(ped));
			        String factura = ped.GenerarTextoFactura(ped);
			        
			        int posicionInicio = factura.indexOf("ID Pedido: ") + "ID Pedido: ".length();
			        int posicionFin = factura.indexOf("\n", posicionInicio);
			        String numId = factura.substring(posicionInicio, posicionFin);
			        restaurante.GuardarFactura(factura, numId);
			        System.out.println("                                           ");
			        System.out.println("                                           ");
			        System.out.println("Gracias por ordenar!!!");
			        ProductoAjustado mapFacturas = new ProductoAjustado(factura);
			        
			        //restaurante.getPedidosPorId().add(mapFacturas);
			        
			        
			        
			        
			        	
			        }

	
			    
			    if (opcion_seleccionada == 3) {
			    	
			    	int Idpedido = Integer.parseInt(input("Ingresa el ID del pedido a consultar:  "));
			    	String texto = restaurante.obtenerFactura(Idpedido);
			    	
			        
			    }
			    

				else if (opcion_seleccionada == 4)
				
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
					
			    }
			
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
				
			}
			
		}
		}
		
		
	
		
	


	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String toString() {
		return "Aplicacion [restaurante=" + restaurante + "]";
	}
	
	
	
}	
	