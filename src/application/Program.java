package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Check-in date (dd/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.nextLine());
			
			System.out.print("Check-Out date (dd/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.nextLine());
			
	
			Reservation reserva = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			
			System.out.println("Entre com as datas para atualização da Reserva: ");
			System.out.print("Check-in date (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.nextLine());
			
			System.out.print("Check-Out date (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.nextLine());
			
	
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva atualizada: " + reserva);
	
			sc.close();
		}
		catch (ParseException e) {
			System.out.println("Data inválida !");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado !");
		}

	}

}
