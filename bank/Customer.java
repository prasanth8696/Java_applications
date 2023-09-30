
public class Customer{


	public static void getDetails(Accounts user){
		System.out.println(Bank.clear + "---------Your accounts details-----------------");
		System.out.println("NAME       :  " + user.name  + "\n");
		System.out.println("ACC NUMBER :  " + user.accNumber + "\n");
		System.out.println("AGE        :  " + user.age + "\n");
		System.out.println("$BALANCE   :  " + user.balance + "\n");
		System.out.println("------------------------------------------------");

	}

	public static boolean deposit(Accounts user, double amt,int id){

		if(amt <= 0.0){
			System.out.println("Invalid balance... ");
			return false;
		}

		user.balance += amt;
		Accounts.accounts.set(id,user);

		System.out.println("\nYour current Balance :" + user.balance);

		return true;

	}

	public static boolean withdraw(Accounts user,double amt,int id){

		if(amt <= 0.0){
			System.out.println(Bank.clear + "Invalid Balance... ");
		return false;
		}
		if(amt > user.balance){
			System.out.println( Bank.clear + "Insufficient Balance... ");
			return false;
		}

		user.balance = user.balance - amt;

		Accounts.accounts.set(id,user);

		System.out.println(Bank.clear + "Money whidrawed successfully... ");

		System.out.println("Your current Balnce is :" + user.balance);
		return true;
	}

	public static boolean moneyTransfer(Accounts sender,Accounts receiver,int id1,int id2,double amt){
		if(amt <= 0.0){
			System.out.println(Bank.clear + "Invalid Balance... ");
			return false;
		}

		if(amt > sender.balance ){
			System.out.println(Bank.clear + "Insufficient Balance... ");
			return false;
		}
		sender.balance -= amt;
		receiver.balance += amt;
		Accounts.accounts.set(id1,sender);
		Accounts.accounts.set(id2,receiver);
		System.out.println(Bank.clear + "Money Transferred Succssfully... \n");

		System.out.println("Your current Balance is :" + sender.balance);
		return true;

	}



}
