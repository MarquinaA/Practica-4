package banco.main;

import java.util.Scanner;

import banco.entidad.Cliente;

import banco.util.DatabaseCliente;


public class MainClienteActualizar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseCliente databaseCliente = new DatabaseCliente();
		

		System.out.print("Ingrese id del Cliente a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Cliente cliente = null;
		
		cliente = databaseCliente.getCliente(id);
		System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
		
		System.out.print("Ingrese nuevo Id del Gestor: ");
		int id_gestor = keyboard.nextInt();
		
		System.out.print("Ingrese nuevo username: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese nuevo password: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese nuevo correo: ");
		String correo = keyboard.next();
		
		System.out.print("Ingrese nuevo correo: ");
		Double saldo = keyboard.nextDouble();
		
		if(!(id_gestor != 0)) {
			cliente.setId_gestor(id_gestor);
		}
		
		if(!username.equals("0")) {
			cliente.setUsuario(username);
		}
		
		if(!password.equals("0")) {
			cliente.setPassword(password);
		}
		
		if(!correo.equals("0")) {
			cliente.setCorreo(correo);
		}
		
		if(!(saldo != 0) ) {
			cliente.setSaldo(saldo);
		}
		
		boolean clienteActualizado = databaseCliente.actualizarCliente(cliente);

		if(clienteActualizado) {
			System.out.println("Se actualizo el gestor! \n Datos actualizado:");
			System.out.println("Gestor id " + cliente.getId());
			System.out.println("Usuario: " + cliente.getUsuario());
			System.out.println("Contraseña: " + cliente.getPassword());
			System.out.println("Correo: " + cliente.getCorreo());
		}else {
			System.out.println("No se actualizo");
		}
		
		keyboard.close();

	
	}

}
