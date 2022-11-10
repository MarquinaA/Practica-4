package banco.main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import banco.entidad.Cliente;
import banco.entidad.Gestor;
import banco.entidad.Mensaje;
import banco.entidad.Transferencia;
import banco.util.DatabaseCliente;
import banco.util.DatabaseGestor;
import banco.util.DatabaseMensaje;
import banco.util.DatabaseTransferencia;

public class Main {
	public static void main(String[] args) throws SQLException {

		Scanner keyboard = new Scanner(System.in);
		int opcion = 0;

		do {

			for (int i = 0; i < 1; i++) {
				System.out.println("_________________________________________________________");
				System.out.println("GESTORES: ");
				System.out.println("1.Crear Gestores");
				System.out.println("2. Obtener Gestor ");
				System.out.println("3. Actualizar Gestor ");
				System.out.println("4. Borrar Gestor ");
				System.out.println("CLIENTES: ");
				System.out.println("5. Crear Clientes");
				System.out.println("6. Obtener Clientes ");
				System.out.println("7. Actualizar Clientes ");
				System.out.println("8. Borrar Clientes ");
				System.out.println("TRANSFERENCIA: ");
				System.out.println("9. Crear Transferencia");
				System.out.println("10. Obtener Transferencia ");
				System.out.println("11. Actualizar Transferencia ");
				System.out.println("12. Borrar Transferencia ");
				System.out.println("MENSAJE: ");
				System.out.println("13.Crear Mensaje");
				System.out.println("14. Obtener Mensaje ");
				System.out.println("15. Actualizar Mensaje");
				System.out.println("16. Borrar Mensaje");
				System.out.println("17. FINALIZAR");
				System.out.print("Introduce un número: ");
			}

			opcion = keyboard.nextInt();

			switch (opcion) {

			case 1:
				DatabaseGestor databaseGestor = new DatabaseGestor();
				System.out.print("Ingrese el usuario del gestor: ");
				String username = keyboard.next();
				
				System.out.print("Ingrese el contraseña del gestor: ");
				String password = keyboard.next();
				
				System.out.print("Ingrese el correo del gestor: ");
				String correo = keyboard.next();
				
				Gestor gestor = new Gestor(1, username, password, correo);
				databaseGestor.insertarGestor(gestor);
				break;

			case 2:
				DatabaseGestor databaseGestor2 = new DatabaseGestor();
				
				System.out.println("--------------------------------------------------");
				System.out.println("Todos los gestores");
				System.out.println("--------------------------------------------------");
						ArrayList<Gestor> gestores = databaseGestor2.getGestores();
						for(int i = 0 ; i<gestores.size(); i++)
						{
							gestores.get(i).showInfo();;
						}
				
				
				
				System.out.println("Buscar por id");
				System.out.println("--------------------------------------");
				System.out.print("Ingrese el id del gestor: ");
				int id = keyboard.nextInt();
				
				
				
				Gestor gestor2 = null;
			
				gestor2 = databaseGestor2.getGestor(id);
				if(gestor2 != null) {
					gestor2.showInfo();
				}else {
					System.out.print("El gestor solicitado no existe");
				}

				break;

			case 3:
				DatabaseGestor databaseGestor3 = new DatabaseGestor();
				

				System.out.print("Ingrese id del gestor a actualizar: ");
				int id3 = keyboard.nextInt();
				
				
				
				Gestor gestor3 = null;
				
				gestor3 = databaseGestor3.getGestor(id3);
				System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
				System.out.print("Ingrese nuevo username: ");
				String username3 = keyboard.next();
				
				System.out.print("Ingrese nuevo password: ");
				String password3 = keyboard.next();
				
				System.out.print("Ingrese nuevo correo: ");
				String correo3 = keyboard.next();
				
				if(!username3.equals("0")) {
					gestor3.setUsuario(username3);
				}
				
				if(!password3.equals("0")) {
					gestor3.setPassword(password3);
				}
				
				if(!correo3.equals("0")) {
					gestor3.setCorreo(correo3);
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
				
				

				break;

			case 4:
				DatabaseGestor databaseGestor4 = new DatabaseGestor();
				
				

				System.out.print("Ingrese id del gestor a eliminar: ");
				int id4 = keyboard.nextInt();
				
				boolean gestorBorrado = databaseGestor4.borrarGestor(id4);
				
				if (gestorBorrado) {
					System.out.print("Se ha eliminado el gestor " + id4);
				}else {
					System.out.print("No se ha eliminado el gestor " + id4);
				}
				
				

				break;

			case 5:
				DatabaseCliente databaseCliente5 = new DatabaseCliente();
				
				
				System.out.print("Ingrese el id del gestor: ");
				int id_gestor5 = keyboard.nextInt();
				
				System.out.print("Ingrese el usuario del cliente: ");
				String username5 = keyboard.next();
				
				System.out.print("Ingrese el contraseña del cliente: ");
				String password5 = keyboard.next();
				
				System.out.print("Ingrese el correo del cliente: ");
				String correo5 = keyboard.next();
				
				System.out.print("Ingrese el saldo del cliente: ");
				double saldo5 = keyboard.nextDouble();
				
				
				
				
				Cliente cliente = new Cliente(1, id_gestor5, username5, password5, correo5, saldo5);
				databaseCliente5.insertarCliente(cliente);

				break;

			case 6:

				
				DatabaseCliente databaseCliente6 = new DatabaseCliente();
				
				
				ArrayList<Cliente> clientes = null;		
				clientes = databaseCliente6.getClientes();
						
				if(clientes != null) {
					System.out.println("--------------------------------------------------");
					System.out.println("Todos los clientes");
					System.out.println("--------------------------------------------------");
					clientes.forEach((cliente6)-> {
						cliente6.showInfo();
					});
				}else {
					System.out.println("No hay clientes en la base de datos");
				}
						

				
				
				
				System.out.println("Buscar por id");
				System.out.println("--------------------------------------");
				System.out.print("Ingrese el id del cliente: ");
				int id6 = keyboard.nextInt();
				
				
				
				Cliente cliente6 = null;
			
				cliente6 = databaseCliente6.getCliente(id6);
				if(cliente6 != null) {
					cliente6.showInfo();
				}else {
					System.out.print("El cliente solicitado no existe");
				}
				break;

			case 7:
				DatabaseCliente databaseCliente7 = new DatabaseCliente();
				

				System.out.print("Ingrese id del Cliente a actualizar: ");
				int id7 = keyboard.nextInt();
				
				
				
				Cliente cliente7 = null;
				
				cliente7 = databaseCliente7.getCliente(id7);
				System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
				
				System.out.print("Ingrese nuevo Id del Gestor: ");
				int id_gestor7 = keyboard.nextInt();
				
				System.out.print("Ingrese nuevo username: ");
				String username7 = keyboard.next();
				
				System.out.print("Ingrese nuevo password: ");
				String password7 = keyboard.next();
				
				System.out.print("Ingrese nuevo correo: ");
				String correo7 = keyboard.next();
				
				System.out.print("Ingrese nuevo correo: ");
				Double saldo7 = keyboard.nextDouble();
				
				if(!(id_gestor7 != 0)) {
					cliente7.setId_gestor(id_gestor7);
				}
				
				if(!username7.equals("0")) {
					cliente7.setUsuario(username7);
				}
				
				if(!password7.equals("0")) {
					cliente7.setPassword(password7);
				}
				
				if(!correo7.equals("0")) {
					cliente7.setCorreo(correo7);
				}
				
				if(!(saldo7 != 0) ) {
					cliente7.setSaldo(saldo7);
				}
				
				boolean clienteActualizado = databaseCliente7.actualizarCliente(cliente7);

				if(clienteActualizado) {
					System.out.println("Se actualizo el gestor! \n Datos actualizado:");
					System.out.println("Gestor id " + cliente7.getId());
					System.out.println("Usuario: " + cliente7.getUsuario());
					System.out.println("Contraseña: " + cliente7.getPassword());
					System.out.println("Correo: " + cliente7.getCorreo());
				}else {
					System.out.println("No se actualizo");
				}
				break;

			case 8:
				DatabaseCliente databaseCliente8 = new DatabaseCliente();
				
				

				System.out.print("Ingrese id del cliente a eliminar: ");
				int id8 = keyboard.nextInt();
				
				boolean clienteBorrado = databaseCliente8.borrarCliente(id8);
				
				if (clienteBorrado) {
					System.out.print("Se ha eliminado el cliente " + id8);
				}else {
					System.out.print("No se ha eliminado el cliente " + id8);
				}
				
				
				break;

			case 9:
				
				DatabaseTransferencia databaseTransferencia9 = new DatabaseTransferencia();
				
				
				System.out.print("Ingrese el id del ordenante: ");
				int id_ordenante9 = keyboard.nextInt();
				
				System.out.print("Ingrese el id del beneficiario: ");
				int id_beneficiario9 = keyboard.nextInt();
				
				System.out.print("Ingrese el importe: ");
				Double importe9 = keyboard.nextDouble();
				
				System.out.print("Ingrese el concepto: ");
				String concepto9 = keyboard.next();
				
				Timestamp fecha9 = new Timestamp(System.currentTimeMillis());
				
			
				
				
				Transferencia transferencia9 = new Transferencia(1, id_ordenante9, id_beneficiario9, importe9, concepto9, fecha9);
				databaseTransferencia9.insertarTransferencia(transferencia9);
				break;

			case 10:
				DatabaseTransferencia databaseTransferencia10 = new DatabaseTransferencia();
				
				
				ArrayList<Transferencia> transferencias = null;		
				transferencias = databaseTransferencia10.getTransferencias();
					
				if(transferencias != null) {
					System.out.println("--------------------------------------------------");
					System.out.println("Todas las transferencias");
					System.out.println("--------------------------------------------------");
					transferencias.forEach((transferencia)-> {
						transferencia.showInfo();
					});
				}
						
				
			
				
				System.out.println("Buscar por id");
				System.out.println("--------------------------------------");
				System.out.print("Ingrese el id de la transferencia: ");
				int id10 = keyboard.nextInt();
				
				
				
				Transferencia transferencia10 = null;
			
				transferencia10 = databaseTransferencia10.getTransferencia(id10);
				if(transferencia10 != null) {
					transferencia10.showInfo();
				}else {
					System.out.print("La transferencia solicitada no existe");
				}
				
				break;

			case 11:
				DatabaseTransferencia databaseTransferencia11 = new DatabaseTransferencia();
				

				System.out.print("Ingrese id de la transferencia a actualizar: ");
				int id11 = keyboard.nextInt();
				
				
				
				Transferencia transferencia11 = null;
				
				transferencia11 = databaseTransferencia11.getTransferencia(id11);
				
				if(transferencia11!=null) {
					System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
					System.out.print("Ingrese nuevo concepto: ");
					String concepto11 = keyboard.next();
					
					if(!concepto11.equals("0")) {
						transferencia11.setConcepto(concepto11);
					}
					
					boolean transferenciaActualizado = databaseTransferencia11.actualizarTransferencia(transferencia11);

					if(transferenciaActualizado) {
						System.out.println("Se actualizo la transfernecia! \n Datos actualizado:");
						transferencia11.showInfo();
					}else {
						System.out.println("No se actualizo");
					}
					
					
				}else {
					System.out.println("No hay un transferencia con esa id");
				}
				break;

			case 12:
				DatabaseTransferencia databaseTransferencia12 = new DatabaseTransferencia();

				System.out.print("Ingrese id de la transferencia a eliminar: ");
				int id12 = keyboard.nextInt();
				
				boolean transferenciaBorrado = databaseTransferencia12.borrarTransferencia(id12);
				
				if (transferenciaBorrado) {
					System.out.print("Se ha eliminado la transferencia " + id12);
				}else {
					System.out.print("No se ha eliminado la transferencia " + id12);
				}
				
				break;

			case 13:
				DatabaseMensaje databaseMensaje13 = new DatabaseMensaje();
				
				
				System.out.print("Ingrese el id del origen: ");
				int id_origen13 = keyboard.nextInt();
				
				System.out.print("Ingrese el id del destino: ");
				int id_destino13 = keyboard.nextInt();
				
				System.out.print("Ingrese el texto: ");
				keyboard.nextLine();
				String texto13 = keyboard.nextLine();
				
				Timestamp fecha13 = new Timestamp(System.currentTimeMillis());
				
				
				
				
				Mensaje mensaje13 = new Mensaje(1, id_origen13, id_destino13, texto13, fecha13);
				
				
				boolean mensajeInsertado = databaseMensaje13.insertarMensaje(mensaje13);
				
				if(mensajeInsertado) {
					System.out.println("El mensaje se inserto correctamente");
				}else {
					System.out.println("No se pudo insertar el mensaje");
				}
				break;

			case 14:
				
				DatabaseMensaje databaseMensaje14 = new DatabaseMensaje();
				
				
				ArrayList<Mensaje> mensajes14 = null;		
				mensajes14 = databaseMensaje14.getMensajes();
					
				if(mensajes14 != null) {
					System.out.println("--------------------------------------------------");
					System.out.println("Todos los mensajes");
					System.out.println("--------------------------------------------------");
					mensajes14.forEach((mensaje14)-> {
						mensaje14.showInfo();
					});
				}
						
				
				
				
				System.out.println("Buscar por id");
				System.out.println("--------------------------------------");
				System.out.print("Ingrese el id del mensaje: ");
				int id14 = keyboard.nextInt();
				
				
				Mensaje mensaje14 = null;
			
				mensaje14 = databaseMensaje14.getMensaje(id14);
				if(mensaje14 != null) {
					mensaje14.showInfo();
				}else {
					System.out.print("El mensaje solicitado no existe");
				}
				break;

			case 15:
				
				DatabaseMensaje databaseMensaje15 = new DatabaseMensaje();
				

				System.out.print("Ingrese id del mensaje a actualizar: ");
				int id15 = keyboard.nextInt();
				
				
				
				Mensaje mensaje15 = null;
				
				mensaje15 = databaseMensaje15.getMensaje(id15);
				
				if(mensaje15!=null) {
					System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
					System.out.print("Ingrese nuevo texto: ");
					String texto15 = keyboard.next();
					
					if(!texto15.equals("0")) {
						mensaje15.setTexto(texto15);
					}
					
					boolean mensajeActualizado = databaseMensaje15.actualizarMensaje(mensaje15);

					if(mensajeActualizado) {
						System.out.println("Se actualizo el mensaje! \n Datos actualizado:");
						mensaje15.showInfo();
					}else {
						System.out.println("No se actualizo");
					}
					
					
				}else {
					System.out.println("No hay un mensaje con esa id");
				}
				break;

			case 16:
				
				DatabaseMensaje databaseMensaje16 = new DatabaseMensaje();
				
				

				System.out.print("Ingrese id del mensaje a eliminar: ");
				int id16 = keyboard.nextInt();
				
				boolean mensajeBorrado16 = databaseMensaje16.borrarMensaje(id16);
				
				if (mensajeBorrado16) {
					System.out.print("Se ha eliminado el mensaje " + id16);
				}else {
					System.out.print("No se ha eliminado el mensaje " + id16);
				}
				
				
				break;

			case 17:
				System.out.println("Programa finalizado");
				break;

			

			default:
				System.out.println("ERROR: Debes pulsar un número entre el 1 y el 16.");
			}

			if (opcion != 16) {

				System.out.println("\nPulsa x para continuar");

				String readString = keyboard.next();

				while (!readString.equals("x")) {
					readString = keyboard.next();
				}
			}

		} while (opcion != 16);
		
		keyboard.close();
	}
}
