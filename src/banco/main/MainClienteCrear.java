package banco.main;

import java.util.Scanner;
import banco.entidad.Cliente;
import banco.util.DatabaseCliente;

public class MainClienteCrear {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		DatabaseCliente databaseCliente5 = new DatabaseCliente();
		
		
		System.out.print("Ingrese el id del gestor: ");
		int id_gestor = keyboard.nextInt();
		
		System.out.print("Ingrese el usuario del cliente: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese el contraseña del cliente: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo del cliente: ");
		String correo = keyboard.next();
		
		System.out.print("Ingrese el saldo del cliente: ");
		double saldo = keyboard.nextDouble();
		
		
		
		
		Cliente cliente = new Cliente(1, id_gestor, username, password, correo, saldo);
		databaseCliente5.insertarCliente(cliente);
		keyboard.close();

	}

}
