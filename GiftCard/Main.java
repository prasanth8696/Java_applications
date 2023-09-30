import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<String> userIds = new ArrayList<>();


	public static void initilizeCustomer(){
		String[] user = {"shan","master","ayyappan"};

		for(int i=0;i<user.length;i++){
			userIds.add(user[i]);
			customers.add(new Customer(user[i],"Apple007"));

		}


	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		initilizeCustomer();

		while(true){
			System.out.println("1 . Account  Login \n 2. Purchase");
			/*
			try {
				int ch = sc.nextInt();

			}
			catch(NumberFormatException e){
				System.out.println("Invalid input" + e );

			}*/
			int ch = sc.nextInt();

			switch(ch){
				case 1 :
					accLogin();
					break;
				case 2 :
					purchase();
					break;
				case 3 :
					System.exit(0);
				default :
					System.out.println("Invalid input");
					break;




			}
			





		}





	}

	public static void accLogin(){
		Scanner sc = new Scanner(System.in);

		System.out.print("enter userId ");
		String userId = sc.next();

		int index = userIds.indexOf(userId);
		if (index == -1 ){
			System.out.println("Invalid userId");
			return;
		}
		Customer customer = customers.get(index);

		System.out.print("Enter password ");
		String password = sc.next();

		if (! customer.comparePassword(password)){
			System.out.println("Incorrect password... ");
			return;

		}

		
		Account loggedAccount = new Account(customer);
		loggedAccount.menu();



		





	}

	public static void purchase(){

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Gift Card Id ");
		String id = sc.next();

		int index = Account.cardIds.indexOf(id);

		if (index == -1){
			System.out.println("Gift card Not Found... ");
			return;

		}
		GiftCard card = Account.giftCards.get(index);
		int userId = userIds.indexOf(card.customerId);
		Customer customer = customers.get(userId);

		System.out.print("Enter PIN ");
		String pin = sc.next();

		if (! pin.equals(card.pin)){
			System.out.println("Invalid PIN ");
			return;
		}

		System.out.print("Enter Purchase Amt... ");
		double purchaseAmt = sc.nextDouble();

		if(purchaseAmt > card.amount ){
			System.out.println("Insufficint Funds");
			return;

		}

		card.amount -= purchaseAmt;

		int  rewardPoint = (int) purchaseAmt/100;

		Transaction tr = new Transaction(card.customerId,"DEBIT",purchaseAmt,card.id,rewardPoint);

		card.transactions.add(tr);
		card.rewardPoints += rewardPoint;

		if (card.rewardPoints > 10 ){
			double rewardAmt = (double) card.rewardPoints;

			
			customer.amount += rewardAmt;

			customer.rewardAmts += rewardAmt;
			card.rewardPoints = 0;


			System.out.println( rewardAmt + " redeemd successfully... ");


		}

		System.out.println("Purchase successfully...");

		return;




	}




}
