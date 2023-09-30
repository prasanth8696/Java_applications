
import java.util.Scanner;

public class Admin{

	static Scanner sc = new Scanner(System.in);
	public static boolean  adminLogin(int id,String passkey){
		if(id != 1){
			System.out.println("Inavalid userId");
		return false;
		}

		if(!(passkey.equals("12345"))){
			System.out.println("Password mismatched... ");
			return false;
		}

		System.out.println("Successfully looged... ");

		while(true){

			System.out.println("1. print Taxi details \n2. print All taxi details \n3. Exit");

			int ch = sc.nextInt();

			switch(ch){

				case 1:
					System.out.print("Enter taxidriver id... ");
					int cabId = sc.nextInt();
					printDetails(Zulo.cabs.get(cabId-1));
					break;
				case 2:
					for(Cab cb : Zulo.cabs){
						printDetails(cb);
					}
					break;

				case 3:
					System.out.println("Successfully loggedOut... ");
					return true;
					

			}

		}


	}


	public static void printDetails(Cab cb){

		System.out.println("------------------------------------------");

                System.out.println("Cab Id    : " + cb.id + "\n");

                System.out.println("Total Number of Trips : "+ cb.tripDetails.size()+ "\n");

		System.out.println("Total fare Collected : " + cb.totalEarnings + "\n");

		System.out.println("Total ZULA Commission : " + cb.commission + "\n");

                
		if(cb.tripDetails.size() == 0){
			System.out.println("Trip details : No details given ");
			return;
		}
		System.out.println("Trip details...\n");

                System.out.println("Source      " + "destination       " + "CustomerId     " + "Commision      " + " Fare");

                for(String details : cb.tripDetails){
                        System.out.println(details + "\n");
                }
                System.out.println("----------------------------------------");

        }

}


	
