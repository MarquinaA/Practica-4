package banco.main;

import java.util.Scanner;
import banco.util.DatabaseGestor;

public class MainGestorEliminar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseGestor databaseGestor4 = new DatabaseGestor();
		
		

		System.out.print("Ingrese id del gestor a eliminar: ");
		int id4 = keyboard.nextInt();
		
		boolean gestorBorrado = databaseGestor4.borrarGestor(id4);
		
		if (gestorBorrado) {
			System.out.print("Se ha eliminado el gestor " + id4);
		}else {
			System.out.print("No se ha eliminado el gestor " + id4);
		}
		keyboard.close();

	}

}

