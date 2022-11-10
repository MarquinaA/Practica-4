package banco.main;

import banco.util.DatabaseGestor;
import banco.entidad.Gestor;
import java.util.Scanner;

public class MainGestorCrear {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		DatabaseGestor databaseGestor = new DatabaseGestor();
		System.out.print("Ingrese el usuario del gestor: ");
		String username = keyboard.next();
		
		System.out.print("Ingrese el contraseña del gestor: ");
		String password = keyboard.next();
		
		System.out.print("Ingrese el correo del gestor: ");
		String correo = keyboard.next();
		
		Gestor gestor = new Gestor(1, username, password, correo);
		databaseGestor.insertarGestor(gestor);
		keyboard.close();
		
		
		
		
	}

}
