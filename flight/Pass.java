public class Pass{

	int flightId;
	int passId;
	int totalTicket;
	int fare;

	public Pass(){
	}
	public Pass(int flightId,int passId,int seats,int fare){

		this.flightId = flightId;
		this.passId = passId;
		this.totalTicket = seats;
		this.fare = fare;

	}


}
