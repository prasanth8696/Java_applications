import java.util.*;

public class Accounts{
	static ArrayList<Accounts> accounts = new ArrayList<>();
	static ArrayList<String> accNo = new ArrayList<>();

	String name;
	String accNumber;
	int age;
	double balance;
	String passkey;
	static String clear = "\033[H\033[2J";

	public Accounts(){

	}

	public Accounts(String name,String accNum,int age,double balance,String passkey){
		this.name = name;
		this.accNumber = accNum;
		this.age = age;
		this.balance = balance;
		this.passkey = passkey;
	}


	public static boolean createAcc(String name,String accNumber,int age,double balance, String passkey){

		if(name == null || accNumber == null || passkey == null){
			System.out.println(clear + "invalid name or accNumber or passkey... ");
			return false;
		}

		else if(age <= 0){
			System.out.println(clear + "invalid age... ");
			return false;
		}

		else if(balance <=0.0){
			System.out.println(clear  + "Invalid balance");
			return false;
		}
		int index = accNo.indexOf(accNumber);
                if(index != -1){                                                      			System.out.println(clear + "User already exist... ");
                        return false;
		}
		Accounts customer = new Accounts(name,accNumber,age,balance,passkey);
		accounts.add(customer);
		accNo.add(accNumber);
		return true;
		


	}

	public static boolean login(String accNum,String passkey){
		Scanner sc = new Scanner(System.in);
		Customer cr = new Customer();
		int index = accNo.indexOf(accNum);
		if (index == -1){
			System.out.println(clear + "User doesnt Exist... ");
			return false;
		}
		Accounts user = accounts.get(index);

		if (!(user.passkey.equals(passkey))){
			System.out.println(clear + "Password mismatched... ");
			return false;
		}

		System.out.println(clear + "User successfully logged... \n");
		int ch;

		while(true){
			System.out.println("1. your profile\n2. deposit \n3.withdraw \n4. Money transfer \n5. logout\n");

			try{

			ch = sc.nextInt();
			}
			catch (Exception e){
				System.out.println("Invalid choice... ");
				continue;
			}
			double amt;
			boolean res;

			switch(ch){

				case 1:
					cr.getDetails(user);
					break;
				case 2:
					System.out.print("Enter amt... ");
					amt = sc.nextDouble();
					res = cr.deposit(user,amt,index);
					break;
				case 3:
					System.out.print("Enter amt... ");
					amt = sc.nextDouble();
					res = cr.withdraw(user,amt,index);
					break;
				case 4:
					System.out.print("Enter receiver accNo ");
					String recAccNo = sc.next();
					int index1 = accNo.indexOf(recAccNo);
					if(index1 == -1){
						System.out.println(clear + "Invalid receiver accNo... ");
						continue;
					}
					Accounts receiver = accounts.get(index1);
					System.out.print("Enter amt... ");
					amt = sc.nextDouble();
					res = cr.moneyTransfer(user,receiver,index,index1,amt);
					break;

				case 5:
					System.out.println(clear + "logout sucessfully... ");
					return true;
				default:
					System.out.println(clear + "Invalid choice...");

				}
		}
	}



}





