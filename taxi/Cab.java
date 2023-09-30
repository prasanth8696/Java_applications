import java.util.ArrayList;
import java.util.Scanner;
public class Cab{

	int id;
	String name;
	String passkey;
	int age;
	char currentLoc;
	double totalEarnings;
	double commission;
	ArrayList<String> tripDetails = new ArrayList<>();;
	static Scanner sc = new Scanner(System.in);

	public Cab(){

	}

	public Cab(int id,String name,String passkey,int age,char currLoc){
		this.id = id;
		this.name = name;
		this.passkey = passkey;
		this.age = age;
		this.currentLoc = currLoc;

	}


	public static boolean driverLogin(int id,String passkey){
		Cab cb;

		try{
			cb = Zulo.cabs.get(id-1);
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("Invalid user id... ");
			return false;
		}

		if(!(cb.passkey.equals(passkey))){
			System.out.println("Password mismatch... ");
			return false;
		}

		while(true){

			System.out.println("1. Print booked details...\n2.Logout...\n");
			int ch = sc.nextInt();

			switch(ch){
				case 1:
					printDetails(cb);
					break;
				case 2:
					System.out.println("Successfully logout...");
					return true;
				default:
					System.out.println("Invalid choice... ");
			}

		}

	}

	public static void printDetails(Cab cb){

		System.out.println("CabDriver Id    : " + cb.id + "\n");

		System.out.println("Cab Driver Name : " + cb.name + "\n");

		System.out.println("Trip details...\n");
		System.out.println("------------------------------------------");

		System.out.println("Source      " + "destination       " + "CustomerId     " + "Commision      " + " Fare");

		for(String details : cb.tripDetails){
			System.out.println(details + "\n");
		}
		System.out.println("----------------------------------------");

	}





}
