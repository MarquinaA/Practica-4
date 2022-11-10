package banco.main;

import java.util.Scanner;
import banco.util.DatabaseMensaje;

public class MainMensajeEliminar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		
		

		System.out.print("Ingrese id del mensaje a eliminar: ");
		int id = keyboard.nextInt();
		
		boolean mensajeBorrado = databaseMensaje.borrarMensaje(id);
		
		if (mensajeBorrado) {
			System.out.print("Se ha eliminado el mensaje " + id);
		}else {
			System.out.print("No se ha eliminado el mensaje " + id);
		}
		keyboard.close();

	}

}