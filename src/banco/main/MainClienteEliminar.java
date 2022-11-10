package banco.main;

import java.util.Scanner;
import banco.util.DatabaseCliente;

public class MainClienteEliminar {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		DatabaseCliente databaseCliente8 = new DatabaseCliente();
		
		

		System.out.print("Ingrese id del cliente a eliminar: ");
		int id8 = keyboard.nextInt();
		
		boolean clienteBorrado = databaseCliente8.borrarCliente(id8);
		
		if (clienteBorrado) {
			System.out.print("Se ha eliminado el cliente " + id8);
		}else {
			System.out.print("No se ha eliminado el cliente " + id8);
		}
		keyboard.close();

	}

}