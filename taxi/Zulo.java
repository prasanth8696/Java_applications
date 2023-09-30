import java.util.Scanner;
import java.util.ArrayList;

public class Zulo{

	static ArrayList<Cab> cabs = new ArrayList<>();
	static ArrayList<Customer> customers = new ArrayList<>();
	static int[] age = {25,36,31,28,29};
	static char[] initialLoc = {'D','G','H','A'};
	static char[] location = {'A','C','D','F','B','G','H','R'};
	static int[] distance = {0,4,7,9,15,18,20,23};

	static Scanner sc = new Scanner(System.in);

	public static void createTaxi(){
		char ch = 97;

		for(int i=1;i<=4;i++){
			String name = ""+ ch + ch + ch;
			String pass = ("" + i + i + i);

			Cab cb = new Cab(i,name,pass,age[i-1],initialLoc[i-1]);
			cabs.add(cb);
			ch++;
		}

	}

	public static void createCustomer(){

		char ch = 87;
		int j = 5; 

		for(int i=1;i<=4;i++){
			String name = "" + ch + ch + ch;
			String pass = ("" + j + j);

			Customer cr = new Customer(i,name,pass,age[i-1]);
			customers.add(cr);
			ch++;
			j++;

		}

	}



	public static void main(String[] args){

		createTaxi();
		createCustomer();

		int ch ;

		while(true){

			System.out.println("\t\tWelcome to Zulo !!  \n");

			System.out.println("1. Cab Driver Login \n2. Customer Login \n3. Administrator Login \n4. Exit ");
			try{
				ch = sc.nextInt();
			}
			catch(NumberFormatException e){
				System.out.println("Enter valid input... ");
				continue;
			}
			boolean res;
			String passkey;
			int id;
			switch(ch){

				case 1:
					System.out.print("Enter Driver Id... ");
					id = sc.nextInt();
					System.out.print("Enter passkey... ");
					passkey = sc.next();
					res = Cab.driverLogin(id,passkey);
					break;
				case 2:
					System.out.print("Enter customer id... ");
					id = sc.nextInt();
					System.out.print("Enter passkey... ");
					passkey = sc.next();
					res = Customer.customerLogin(id,passkey);

					break;
				case 3: 
					System.out.print("Enter Admin id... " );
					id = sc.nextInt();
					System.out.print("Enter passkey... ");
					passkey = sc.next();
					res = Admin.adminLogin(id,passkey);
					break;
				case 4:
					System.out.println("Exitting.... ");
					System.exit(0);
				default:
					System.out.println("Invalid choice");
			}

		}


			


	}



}
