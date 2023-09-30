import java.util.ArrayList;

public class Doctor extends Main implements DocInterface{
	static int val = 1;
	int id;
	String name;
	String email;
	String specialist;
	int roomNo ;
	ArrayList<Patient> patients;
	ArrayList<Integer> patientsId;
	ArrayList<Patient> seenPatinets;
	ArrayList<Integer> seenPatientsId;
	public Doctor(){
	}

	public Doctor(String name,String email,String specialist,int roomNo){
		this.id = val++;
		this.name = name;
		this.email = email;
		this.roomNo = roomNo;
		this.specialist = specialist;
		this.patients = new ArrayList<>();
		this.patientsId = new ArrayList<>();
		this.seenPatientsId = new ArrayList<>();
		this.seenPatientsId = new ArrayList<>();
	}


	public void showUpcomingPatients(){
	}

	public void showAttendedPatients(){
	}

	public void showAllPatients(){
	}

	public void attend(){
	}



}
