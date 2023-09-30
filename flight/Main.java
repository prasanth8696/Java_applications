import java.util.Scanner;
import java.util.ArrayList;


public class Main{
	static ArrayList<Flight> flights = new ArrayList<>();

	public static void book(int fId,int seats){
		Flight f;
		try{
			f = flights.get(fId-1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("\033[H\033[2J"+ "Invalid Flight id...");
			return;
		}

		if(f.available < seats){
			System.out.println("\033[H\033[2J" + "Insufficient seats...");
			return;
		}

		f.bookFlight(seats);
	}

	public static void cancel(int fId,int pId){
		Flight f;
		Pass p;
		int index;
		try{
                        f = flights.get(fId-1);
			index = f.passIdList.indexOf(pId);
			if(index < 0){
				System.out.println("\033[H\033[2J" + "Invalid passenger id...");
				return;
			}
			
			p = f.passenger.get(index);
                }                                                 catch(IndexOutOfBoundsException e){                                                                         System.out.println("\033[H\033[2J" + "Invalid Flight id ");
                        return;                                   }

		f.cancelFlight(p,index);

	}

	public static void printPassenger(){

		for(Flight f : flights){
			f.printPass();
		}

	}




	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		for(int i=0;i<2;i++){
			flights.add(new Flight());
		}
		System.out.println("\033[H\033[2J");

		while(true){

			                        
			for(Flight f : flights){                                  System.out.println("FLIGHT ID : " + f.id + "\n------------- ");                                    
				System.out.println("Available tickets : " + f.available + "      "+ "Fare  : " + f.fare  + "\n");                                             }

			System.out.println("1 . Book Flight... \n2.Cancel Flight... \n3.print passengers list...\n4.Exit");
			int ch = sc.nextInt();

			int fId;

			switch(ch){

				case 1:
					System.out.print("Enter Flight id... ");
					fId = sc.nextInt();
					System.out.print("Enter no of seats... ");
					int seats = sc.nextInt();
					book(fId,seats);
					break;
				case 2:
					System.out.print("Enter Flight id... ");
					fId = sc.nextInt();
					System.out.print("Enter passenger id... ");
					int pId = sc.nextInt();
					cancel(fId,pId);
					break;

				case 3:
					printPassenger();
					break;

				case 4:
					System.out.println("Excitting");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice...");
			}



		}


	}


}



		
