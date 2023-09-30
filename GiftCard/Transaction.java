
public class Transaction{
	String customerId;
	String type;
	Double amount;
	String giftCardId;
	int rewardPoints;


	public Transaction(){

	}

	public Transaction(String customerId,String type,double amount,String giftCardId ,int rewardPoints ){
		this.customerId = customerId;
		this.type = type;
		this.amount = amount;
		this.giftCardId = giftCardId;
		this.rewardPoints = rewardPoints;

	}

	public String toString(){
		return this.customerId + "\t" + this.type + "\t" + this.amount + "\t" + this.giftCardId + "\t" + this.rewardPoints;


	}


}
