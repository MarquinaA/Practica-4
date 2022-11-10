package banco.main;

import java.util.Scanner;

import banco.entidad.Transferencia;
import banco.util.DatabaseTransferencia;

public class MainTransferenciaActualizar {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		DatabaseTransferencia databaseTransferencia = new DatabaseTransferencia();
		

		System.out.print("Ingrese id de la transferencia a actualizar: ");
		int id = keyboard.nextInt();
		
		
		
		Transferencia transferencia = null;
		
		transferencia = databaseTransferencia.getTransferencia(id);
		
		if(transferencia!=null) {
			System.out.println("Nota: En caso de no querer cambiar el campo ingrese 0");
			System.out.print("Ingrese nuevo concepto: ");
			String concepto = keyboard.next();
			
			if(!concepto.equals("0")) {
				transferencia.setConcepto(concepto);
			}
			
			boolean transferenciaActualizado = databaseTransferencia.actualizarTransferencia(transferencia);

			if(transferenciaActualizado) {
				System.out.println("Se actualizo la transfernecia! \n Datos actualizado:");
				transferencia.showInfo();
			}else {
				System.out.println("No se actualizo");
			}
			
			
		}else {
			System.out.println("No hay un transferencia con esa id");
		}
		keyboard.close();
		

	}

}
