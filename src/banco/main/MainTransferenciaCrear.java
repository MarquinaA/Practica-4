package banco.main;

import banco.util.DatabaseTransferencia;
import banco.entidad.Transferencia;

import java.sql.Timestamp;
import java.util.Scanner;

public class MainTransferenciaCrear {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
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
		
	
		
		
		Transferencia transferencia = new Transferencia(1, id_ordenante9, id_beneficiario9, importe9, concepto9, fecha9);
		databaseTransferencia9.insertarTransferencia(transferencia);
		keyboard.close();
	}

}
