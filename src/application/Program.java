package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Check-in date (dd/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.nextLine());
		
		System.out.print("Check-Out date (dd/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.nextLine());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva. A data de saída e anterior a data de entrada !");
		}
		else {
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			
			System.out.println("Entre com as datas para atualização da Reserva: ");
			System.out.print("Check-in date (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.nextLine());
			
			System.out.print("Check-Out date (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.nextLine());
			
			Date now= new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva, utilize datas futuras ! ");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva, a data de saida tem que ser posterior a de entrada !");
			}
			else {
				reserva.updateDates(checkIn, checkOut);
				System.out.println("Reserva atualizada: " + reserva);
			}
			
		}
		
		
		sc.close();
		

	}

}
