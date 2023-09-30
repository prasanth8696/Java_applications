import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Ticket{
	int id;
	String name;
	int age;
	char gender;
	char preBirth;
	String bookedBirth;
	int number;
	static int val = 1;
	static int lower = 1;
	static int specialResLower = 1;  //for age>60,ladies 
	static int upper = 1;
	static int middle = 1;
	static int rac = 1;
	static int waiting = 1;
	static ArrayList<Integer> lowerBirth = new ArrayList<> (Arrays.asList(1));

	static ArrayList<Integer> middleBirth = new ArrayList<> (Arrays.asList(1));

	static ArrayList<Integer> upperBirth = new ArrayList<> (Arrays.asList(1));

	static ArrayList<Integer> racBirth = new ArrayList<> (Arrays.asList(1));

	static ArrayList<Integer> waitingBirth = new ArrayList<> (Arrays.asList(1));

	static ArrayList<Integer> specialLowerBirth = new ArrayList<> (Arrays.asList(1));



	public Ticket(){
	}
	public Ticket(String name,int age,char gender,char birth,String bookBirth,int num){   
		this.id = val++;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.preBirth = birth;
		this.bookedBirth = bookBirth;
		this.number = num;
	}


	public static boolean booking(String name,int age,char gender,char birth){
		if(waiting == 0 && specialResLower ==0){
			System.out.println("No tickets Available");
			return false;
		}

		Ticket ticket;
		int num;

		if(age <= 5){
			ticket = new Ticket(name,age,gender,birth,"FreeTicket",-1);
			Railway.tickets.add(ticket);
			System.out.println("child ticket bookd sucessfully...");
			return true;
		}
			//for preferred birth...
			if((birth=='L' && lower>0) || (birth=='M' && middle >0) || (birth == 'U' && upper>0)){
				
		
				if(birth == 'M'){
					num = middleBirth.get(0);
					middle--;
					middleBirth.remove(0);
				}
				else if(birth == 'U'){
					num = upperBirth.get(0);
					upper--;
					upperBirth.remove(0);
			}
				else{
					num = lowerBirth.get(0);
					lower--;
					lowerBirth.remove(0);
				}
				ticket = new Ticket(name,age,gender,birth,String.valueOf(birth),num);                                          		  Railway.tickets.add(ticket);
				System.out.println("Preferred birth Available");
				System.out.println("Ticket information : \nBooked Perth : " + ticket.number + ticket.bookedBirth + "\nTicket Id : " + ticket.id);                                                                                                               System.out.println("Ticket booked sucessfully---------------------");                                     return true;

			}

			if( (gender == 'F' && specialResLower >0) || age >= 60 && specialResLower >0){
				num = specialLowerBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"SPL",num);
				specialLowerBirth.remove(0);
				Railway.tickets.add(ticket);
				specialResLower--;
				System.out.println("Lower birth given\n");
				System.out.println("Ticket information : \nBooked Perth : " + ticket.number + ticket.bookedBirth + "\nTicket Id : " + ticket.id);

				System.out.println("Ticket booked sucessfully---------------------");
				return true;
			
			}
			else if( lower >0){
				num = lowerBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"L",num);
				Railway.tickets.add(ticket);
				lowerBirth.remove(0);
				lower--;
				System.out.println("Lower birth given...\n");
				System.out.println("Ticket information : \nBooked Perth : " + num + "L" + "\nTicket Id : " + ticket.id);
				System.out.println("ticket booked sucessfully---------------------");
				return true;
			}
			else if( middle > 0){
				num = middleBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"M",num);
				Railway.tickets.add(ticket);
				middleBirth.remove(0);
				middle--;

				System.out.println("Middle birth is given...\n");
				System.out.println("Ticket information : \nBooked Perth : " + num + "M" + "\nTicket Id : " + ticket.id);
				System.out.println("ticket booked sucessfully---------------------");
				return true;
			}
			else if(upper>0){
				num = upperBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"U",num);
				upperBirth.remove(0);
				Railway.tickets.add(ticket);                                                                              upper--;                                             System.out.println("Middle birth is given...\n");  
				System.out.println("Ticket information : \nBooked Perth : " + num + "U"+ "\nTicket Id : " + ticket.id);

				System.out.println("ticket booked sucessfully---------------------");
                                return true;
                        }
			else if(rac > 0){
				num = racBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"RAC",num);
				racBirth.remove(0);

				Railway.rac.add(ticket);
				rac--;
				System.out.println("Rac is given\n");
				System.out.println("Ticket information : \nBooked Perth : " + num + "RAC" + "\nTicket Id : " + ticket.id);

				System.out.println("ticket booked sucessfully--------------------- ");
				return true;
			}
			else if(waiting > 0){
				num = waitingBirth.get(0);
				ticket = new Ticket(name,age,gender,birth,"WL",num);
				waitingBirth.remove(0);
				Railway.waitingList.add(ticket);
				waiting--;
				System.out.println("Waiting List given...\n ");
				System.out.println("Ticket information : \nBooked Perth : " + num + "WL" + "\nTicket Id : " + ticket.id);
				System.out.println("ticket booked sucessfully-----------------------");
				return true;

			}
		
		return false;


	}

	public static void printAvailable(){

		System.out.println("Available births...\n");

		System.out.println("Available lower birth    :  " + lower + "\n" );

		System.out.println("Available Middle births  :  " + middle + "\n");

		System.out.println("Available Upper births   :  " + upper + "\n");

		System.out.println("Special Lower births     :  " + specialResLower + "\n");

		System.out.println("Available rac            :  " + rac + "\n");

		System.out.println("Available Waiting list   :  " + waiting + "\n");

	}

	public static void printAllBooked(){
		
		System.out.println("-----------------------------------------------");

		for(Ticket tic : Railway.tickets){
			System.out.println("Passenger id        :   " + tic.id );
			System.out.println("Passenger name      :   " + tic.name );
			System.out.println("Allocated birth     :   " + tic.number +tic.bookedBirth );
			System.out.println();

		System.out.println("-----------------------------------------------");
		}
	}

	public static int[] createArr(int n){
		int[] arr = new int[n];

		for(int i=0;i<n;i++){
			arr[i] = i+1;
		}
		return arr;
	}





}

