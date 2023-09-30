import java.util.Scanner;
import java.util.ArrayList;

public class Account {

	static ArrayList<GiftCard> giftCards = new ArrayList<>();
	static ArrayList<String> cardIds = new ArrayList<>();
	static Customer customer;

	public Account() {

	}

	public Account(Customer customer){
		this.customer = customer;

	}



	public  void menu(){

		Scanner sc = new Scanner(System.in);
		int ch;

		while(true){
			try{
				ch = sc.nextInt();

			}
			catch(Exception e){
				System.out.println("Invalid input" + e);
				continue;

			}

			switch(ch){

				case 1 :
					createGiftCard();
					break;
				case 2 :
					topUpGiftCard();
					break;
				case 3 :
					printTransactionHistory();
					break;
				case 4 :
					blockGiftCard();
					break;
				case 5 :
					System.out.println("Account logout Successfully... ");
					return;
				default :
					System.out.println("Invalid choice... ");
					break;


			}




		}



	}

	public static void  createGiftCard(){

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter GiftCard Name ");
		String name = sc.next();

		System.out.print("Enter 4 digit PIN ");

		String pin = sc.next();

		if (pin.length() != 4 ){
			System.out.println("Invalid PIN");
			return;

		}

		GiftCard newCard = new GiftCard(name,pin,customer.userId);
		cardIds.add(newCard.id);
		giftCards.add(newCard);

		System.out.println("New Gift card created " + newCard.id);

		return;

	}

	public static void topUpGiftCard(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter gift Card Id.. ");
		String id = sc.next();

		int index = cardIds.indexOf(id);

		if (index == -1){
			System.out.println("GiftCard Not Found...");
			return;

		}

		GiftCard card = giftCards.get(index);
		
		if(! checkGiftCard(card)){
			return;
		}

		System.out.print("Enter topup amt ");

		double topUpAmt = sc.nextDouble();	

		if (customer.amount < topUpAmt){
			System.out.println("Insufficient Balance... ");
			return;

		}

		card.amount += topUpAmt;

		customer.amount -= topUpAmt;

		System.out.println( topUpAmt + " topup successfully");

		return;




	}

	public static void printTransactionHistory(){

		Scanner sc = new Scanner(System.in);
                System.out.print("Enter giftcard Id... "
);

                String id = sc.next();
                                                                        int index = cardIds.indexOf(id);
                if (index == -1 ){
                        System.out.println("GiftCard notFound... ");
                        return;

                }
                GiftCard card = giftCards.get(index);
                if (! checkGiftCard(card)){
                        return;
                }
		System.out.println("CUSTOMER\tTYPE\tAMOUNT\tGIFTCARD_ID\tREWARD_POINTS\n");

		for(Transaction tr : card.transactions ){
			System.out.println(tr);
			System.out.println();

		}

		System.out.println("Available Balance " + card.amount );
		System.out.println("Total reward Points " + card.rewardPoints );

	} 

	public static void blockGiftCard(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter giftcard Id... ");

		String id = sc.next();

		int index = cardIds.indexOf(id);

		if (index == -1 ){
			System.out.println("GiftCard not Found... ");
			return;

		}
		GiftCard card = giftCards.get(index);
		if (! checkGiftCard(card)){
			return;

		}

		boolean res = card.blockGiftCard(customer);
		if (res){
			System.out.println("card blocked successfully");
			return;

		}



	}

	public static boolean checkGiftCard(GiftCard card){

                if (card.customerId != customer.userId){                        System.out.println("GiftCard Not Found... {user invalid}");
			return false;

		}
                                                                        if (card.active == false){
                        System.out.println("The Gift Card is blocked...");
                        return false;
                }
		return true;

	}




}
