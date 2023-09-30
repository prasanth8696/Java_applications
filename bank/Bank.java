import java.util.Scanner;

public class Bank {
	static String clear = "\033[H\033[2J";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int choice;
		Accounts acc = new Accounts();
		System.out.println(clear);

		while(true){
			System.out.println( "\t\t $$$$_____YOUR BANK_____$$$$\n");
			System.out.println("1. Create account... ");
			System.out.println("2. Login Account... ");
			System.out.println("3. Exit");

			System.out.println("Enter choice ");
			
			try{
				choice = sc.nextInt();
			}
			catch(NumberFormatException e){
				System.out.println( clear +"Invalid choice... \n");
				continue;

			}

			switch(choice){

				case 1:
					try{
						System.out.print("Enter name... ");
						String name = sc.next();
						System.out.print("Enter Accno... ");
						String accno = sc.next();
						System.out.print("Enter age... ");
						int age = sc.nextInt();
						System.out.print("Enter balance... ");
						double balance = sc.nextDouble();
						System.out.print("Enter Passkey... ");
						String passkey = sc.next();
						if(acc.createAcc(name,accno,age,balance,passkey))
							System.out.println(clear +"Accounts successfully created... ");
						else
                                                	System.out.println(clear + "account doesnt created... ");
					
					}
					
					catch(Exception e){
						System.out.println("account doesnt created... ");
					}
					break;

				case 2 :
					try{
						System.out.print("Enter account no... ");
						String accNo = sc.next();
						System.out.print("Enter passkey... ");
						String password = sc.next();
						boolean res  = acc.login(accNo,password);
					}
					catch(Exception e){
						System.out.println("Login falied... ");
					}
					break;

				case 3 :
					System.out.println(clear + "Program successfully terminated... ");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println(clear + "Invalid choice... ");
					break;

			}

		}
	}


}
