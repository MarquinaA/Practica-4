package banco.main;

import java.util.Scanner;

import banco.entidad.Gestor;
import banco.util.DatabaseGestor;

public class MainGestorActualizar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseGestor databaseGestor3 = new DatabaseGestor();
		

		System.out.print("Ingrese id del gestor a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Gestor gestor3 = null;
		
		gestor3 = databaseGestor3.getGestor(id);
		System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
		System.out.print("Ingrese nuevo username: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese nuevo password: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese nuevo correo: ");
		String correo = keyboard.next();
		
		if(!username.equals("0")) {
			gestor3.setUsuario(username);
		}
		
		if(!password.equals("0")) {
			gestor3.setPassword(password);
		}
		
		if(!correo.equals("0")) {
			gestor3.setCorreo(correo);
		}
		
		boolean gestorActualizado = databaseGestor3.actualizarGestor(gestor3);

		if(gestorActualizado) {
			System.out.println("Se actualizo el gestor! \n Datos actualizado:");
			System.out.println("Gestor id " + gestor3.getId());
			System.out.println("Usuario: " + gestor3.getUsuario());
			System.out.println("Contraseña: " + gestor3.getPassword());
			System.out.println("Correo: " + gestor3.getCorreo());
		}else {
			System.out.println("No se actualizo");
		}
		
		keyboard.close();

	}

}
