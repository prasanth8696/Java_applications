import java.util.ArrayList;
import java.util.Scanner;

public class Customer{

	public Customer(){

	}
	static Scanner sc = new Scanner(System.in);
	int id;
	String name;
	String passkey;
	int age;
	ArrayList<String> bookingDetails = new ArrayList<>(); 

	public Customer(int id,String name,String passkey,int age){
		this.id = id;
		this.name = name;
		this.passkey = passkey;
		this.age = age;
	}

	public static boolean customerLogin(int id,String passkey){
		Customer cr;
		try{
			cr = Zulo.customers.get(id-1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Invalid Customer id... ");
			return false;
		}
		
			
		if(!(cr.passkey.equals(passkey))){
			System.out.println("Password Mismatched... ");
			return false;
		}
		System.out.println("Successfully logged... ");
		int ch;
		while(true){

			System.out.println("1. Book Cab \n2.Print Travel Details \n3. Exit");
			try{
				ch = sc.nextInt();
			}
			catch(NumberFormatException e){
				System.out.println("Invalid input... ");
				continue;
			}
			boolean res;
			switch(ch){
				case 1:
					res = bookCab(cr);
					break;
				case 2:
					printBookingDetails(cr);
					break;
				case 3:
					System.out.println("sucessfully logout... ");
					return true;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}


	}


	public static boolean bookCab(Customer cr){
		printTaxi();
		System.out.print("Enter Bording point A/C/D/F/B/G/H/R ");
		char boarding = sc.next().toUpperCase().charAt(0);


		System.out.print("Enter Destination point A/C/D/F/B/G/H/R ");
		char destination = sc.next().toUpperCase().charAt(0);
		if((indexOf(boarding) == -1) || (indexOf(destination) == -1)){
			System.out.println("Invalid source or destination");
			return false;
		}
		int min = Integer.MAX_VALUE;
		Cab c = null;
		for(Cab cb : Zulo.cabs){

			char currentLoc = cb.currentLoc;
			int distance = Math.abs(indexOf(currentLoc) - indexOf(boarding));

			if(distance < min){
				c = cb;
				min = distance;
			}
			else if( distance == min){
				if(cb.tripDetails.size() < c.tripDetails.size())
					c = cb;
				else if(cb.totalEarnings < c.totalEarnings)
					c = cb;

					
			}
		}
		
		int index1 = indexOf(boarding);
		int index2 = indexOf(destination);
		double fare =  (Math.abs(Zulo.distance[index1] - Zulo.distance[index2])) * 10.0;

		double commission = fare *(30.0/100);
		String bookDetail = " " + boarding +"       "+ destination + "             " + c.id     + "            " + fare;



		cr.bookingDetails.add(bookDetail);
		Zulo.customers.set((cr.id-1),cr);

		c.tripDetails.add(boarding + "        " + destination + "        " + cr.id + "        " + commission + "        " + fare);

		c.commission += commission;
		c.totalEarnings += fare;
		c.currentLoc = destination;

		Zulo.cabs.set((c.id-1),c);

		System.out.println("Cab "+ c.id + "  booked sucessfully "  );

		return true;

	}

	public static void printTaxi(){

		System.out.println("LOCATION" + "         " + "CAB ID'S");

		for(Cab cb : Zulo.cabs){
			System.out.println(cb.currentLoc + "        " + cb.id+ "\n");
		}

	}

	public static int indexOf(char ch ){

		for(int i=0;i<Zulo.location.length;i++){
			if(Zulo.location[i] == ch)
				return i;
		}

		return -1;
	}

	public static void printBookingDetails(Customer cr){
		System.out.println("CustemerId   : " + cr.id + "\n");
		System.out.println("CustemerName : " + cr.name);
		System.out.println("Trip details... \n");

		System.out.println("Source  "  +  "Destination  " + "CabDetail  " + "fare");

		for(String detail : cr.bookingDetails){

			System.out.println(detail + "\n");
		}

	}

}
