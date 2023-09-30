
public class Customer {

	String userId;
	String password;
	double amount;
	double rewardAmts;


	public Customer() {

	}

	public Customer(String userId,String password){
		this.userId = userId;
		this.password = encryptPassword(password);
		this.amount = 5000.0;

	}


	public static String encryptPassword(String plainPassword){
		String encryptPassword = "";
		for(int i=0;i<plainPassword.length();i++){
			encryptPassword += (char) (plainPassword.charAt(i) + 1);


		}
		System.out.println(encryptPassword);

		return encryptPassword;


	}

	public  String decryptPassword(String encryptPassword){
		String decryptPassword = "";

		for(int i=0;i<encryptPassword.length();i++){
			decryptPassword += (char) (encryptPassword.charAt(i) - 1 );

		}
		System.out.println(decryptPassword);

		return decryptPassword;



	}

	public boolean comparePassword(String password){

		return this.decryptPassword(this.password).equals(password);


	}





}
