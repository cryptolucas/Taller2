package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import modelo.Ingrediente;
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
			System.out.println("1. Iniciar un nuevo pedido");
			System.out.println("2. Consultar pedido con ID");
			System.out.println("3. Consultar las medallas de un atleta en un periodo");
			System.out.println("4. Consultar los atletas de un país dado");
			
		
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
				if (opcion_seleccionada == 1)
					 
					System.out.println(restaurante.getIngredientes());
				
				else if (opcion_seleccionada == 2)
					
					System.out.println(restaurante.getCombos());
					
				else if (opcion_seleccionada == 3)
					
					System.out.println(restaurante.getMenuBase());
				
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
	
	
	
}	
	