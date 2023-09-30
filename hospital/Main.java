import java.util.Scanner;
import java.util.ArrayList;

public class Main{

	public static final String clear = "\033[H\033[2J";
	//database
	static ArrayList<Doctor> doctorsList = new ArrayList<>();
	static ArrayList<Patient> patientsList = new ArrayList<>();



	public static boolean checkUser(String aadhar){
		for(Patient p : patientsList){
			if(p.aadhar.equals(aadhar))
				return true;
		}
		return false;
	}

	public static Doctor getDoctor(Patient p){

		Doctor resDoc = null;
		int min = Integer.MAX_VALUE;

		for(Doctor d : doctorsList){

			if(d.specialist.equals(p.problem)){
				if(min > d.patients.size()){
					min = d.patients.size();
					resDoc = d;
				}
			}
		}
		return resDoc;
	}





	public static void opRegistration(){

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter aadhar no without space... ");                                                    String aadhar = sc.next().trim();

		if(aadhar.length() != 12 ){
			System.out.println(clear + "Inavalid Aadhar id...");
			return;
		}

		if (checkUser(aadhar)){
			System.out.println(clear + "Patient alredy endrolled... ");
			return;
		}

		

		System.out.print("Enter name ");
		String name = sc.next().trim();
		System.out.print("Enter age... ");
		int age = sc.nextInt();
		System.out.print("Enter phoneNo ");
		String phoneNo = sc.next().trim();
		System.out.print("Enter your problem...eye/ear/brain/cancer  ");
		String problem = sc.next().trim();

		Patient p = new Patient(name,age,phoneNo,problem,aadhar);
		patientsList.add(p);

		Doctor d = getDoctor(p);

		d.patients.add(p);

		d.patientsId.add(p.id);

		System.out.println(clear + "registered sucessfully...");
		System.out.println("Go to room No " + d.roomNo + " then meet " + d.name );
		return;

	}

	public static void doctorLogin(){
	}





	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		System.out.println(clear);

		while(true){

			System.out.println("1. OP Register login... \n2. Doctor Login... \n3. Exit...");

			int ch = sc.nextInt();

			switch(ch){
				case 1 :
					opRegistration();
					break;
				case 2 :
					doctorLogin();
					break;
				case 3 :
					System.out.println(clear + "Exiting...");
					break;
				default :
					System.out.println(clear + "Invalid choice...");
			}


		}

	}


}

