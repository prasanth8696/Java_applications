import java.util.Scanner;
import java.util.ArrayList;

public class Railway{
	static Scanner sc = new Scanner(System.in);

	static ArrayList<Ticket> tickets = new ArrayList<>();
	static ArrayList<Ticket> rac = new ArrayList<>();
	static ArrayList<Ticket> waitingList = new ArrayList<>();

	public static void book(String name,int age,char gender,char birth){

		if(age <=0){
			System.out.println("Invalid age");
			return;
		}

		boolean res = Ticket.booking(name,age,gender,birth);
		

	}


	public static void main(String[] args){

		String name;
		char birth,gender;
		int age;
		while(true){

			System.out.println("Welcome to Railway Booking System !!\n");

			System.out.println("1. Book ticket \n2. Cancel ticket \n3.Print booked tickets \n4.Print Available tickets");

			int ch = sc.nextInt();

			switch(ch){
				case 1:
					System.out.print("Enter name... ");
					name = sc.next();
					System.out.print("Enter age... ");
					age = sc.nextInt();
					System.out.print("Enter your Gender...M/F/T ");
					gender = sc.next().toUpperCase().charAt(0);
					System.out.print("Enter preferred birth...L/M/U ");
					birth = sc.next().toUpperCase().charAt(0);
					book(name,age,gender,birth);

					break;
				case 2:
					System.out.println("Enter Ticket id... ");
					int id = sc.nextInt();
					break;
				case 3:
					Ticket.printAllBooked();
					break;
				case 4:
					Ticket.printAvailable();
					break;
				case 5:
					System.out.println("Exitiing");

					System.exit(0);
				default:
					System.out.println("Invalid choice... ");

			}

		}



	}



}

