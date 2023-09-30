import java.util.Scanner;
import java.util.ArrayList;

public class Flight{
	int id;
	static int val = 1;
	ArrayList<Pass>  passenger;
	ArrayList<Integer> passIdList;

	int available;

	int fare;

	int passId;

	public Flight(){
		this.id = val++;
		this.available = 50;
		this.fare = 5000;
		this.passenger = new ArrayList<>();
		this.passIdList = new ArrayList<>();
		this.passId = 1;
	}


	void bookFlight(int seats){
		this.available -= seats;
		int amt = this.fare * seats;
		this.fare += (200 * seats);
		Pass p = new Pass(this.id,this.passId,seats,amt);
		this.passenger.add(p);
		this.passIdList.add(p.passId);
		this.passId++;

		System.out.println( "\033[H\033[2J"+ "Booked sucessfully*********************\n");

		System.out.println("Available tickets : " + this.available + "      "+ "Fare  : " +  this.fare );

	}

	void cancelFlight(Pass p,int index){
		this.available += p.totalTicket;

		this.fare -= (200 * p.totalTicket);

		this.passenger.remove(index);
		this.passIdList.remove(index);

		System.out.println("\033[H\033[2J" + "Cancel ticket sucessfully***************\n");
		System.out.println("Refundable Amt : " + p.fare + "\n");

		System.out.println("Available tickets : " + this.available + "      "+ "Fare  : " +  this.fare );

	}

	void printPass(){

		if(this.passenger.size() == 0){
			return;
		}
		System.out.println("\033[H\033[2J" + "FLIGHT ID  :"   + this.id);
		System.out.println("--------------------------------------------");

		for(Pass p : this.passenger){
			System.out.println("passenger Id      :  " + p.passId );
			System.out.println("Total Tickets     :  " + p.totalTicket  );
			System.out.println("Total Amt         :  " + p.fare);

		System.out.println("--------------------------------------------");
		
		}

	}


}
		

		 


