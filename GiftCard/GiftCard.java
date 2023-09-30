import java.util.ArrayList;

public class GiftCard {

	String name;
	String id;
	String customerId;
	String pin;
	boolean active;
	int rewardPoints;
	double amount;
	ArrayList<Transaction> transactions = new ArrayList<>();


	public GiftCard() {

	}

	public GiftCard(String name,String pin,String customerId){
		this.name = name;
		this.id = generateId();
		this.customerId = customerId;
		this.pin = pin;
		this.active = true;

	}


	public static String generateId(){
		int id =  (int) Math.floor( Math.random() * 100000);
		System.out.println(id);
		return String.valueOf(id);

	}

	public boolean blockGiftCard(Customer customer){

		this.active = false;

		customer.amount += this.amount;

		this.amount = 0.0;

		return true;

	}


}
