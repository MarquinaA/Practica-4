package banco.main;

import java.sql.Timestamp;
import java.util.Scanner;

import banco.entidad.Mensaje;
import banco.util.DatabaseMensaje;

public class MainMensajeCrear {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseMensaje databaseMensaje = new DatabaseMensaje();
		
		
		System.out.print("Ingrese el id del origen: ");
		int id_origen = keyboard.nextInt();
		
		System.out.print("Ingrese el id del destino: ");
		int id_destino = keyboard.nextInt();
		
		System.out.print("Ingrese el texto: ");
		keyboard.nextLine();
		String texto = keyboard.nextLine();
		
		Timestamp fecha = new Timestamp(System.currentTimeMillis());
		
		
		
		
		Mensaje mensaje = new Mensaje(1, id_origen, id_destino, texto, fecha);
		
		
		boolean mensajeInsertado = databaseMensaje.insertarMensaje(mensaje);
		
		if(mensajeInsertado) {
			System.out.println("El mensaje se inserto correctamente");
		}else {
			System.out.println("No se pudo insertar el mensaje");
		}
		keyboard.close();
		
	}
	

}
