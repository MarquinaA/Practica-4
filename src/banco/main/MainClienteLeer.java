package banco.main;

import banco.util.DatabaseCliente;
import banco.entidad.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClienteLeer {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		
		DatabaseCliente databaseCliente6 = new DatabaseCliente();
		
		
		ArrayList<Cliente> clientes = null;		
		clientes = databaseCliente6.getClientes();
				
		if(clientes != null) {
			System.out.println("--------------------------------------------------");
			System.out.println("Todos los clientes");
			System.out.println("--------------------------------------------------");
			clientes.forEach((cliente)-> {
				cliente.showInfo();
			});
		}else {
			System.out.println("No hay clientes en la base de datos");
		}
				

		
		
		
		System.out.println("Buscar por id");
		System.out.println("--------------------------------------");
		System.out.print("Ingrese el id del cliente: ");
		int id = keyboard.nextInt();
		
		
		
		Cliente cliente = null;
	
		cliente = databaseCliente6.getCliente(id);
		if(cliente != null) {
			cliente.showInfo();
		}else {
			System.out.print("El cliente solicitado no existe");
		}
		keyboard.close();
	}

}
