import java.util.Scanner;


public class Patient{
	static int val = 1;
	int id;
	String name;
	int age;
	String phoneNo;
	String aadhar;
	String visitedDoctor;
	String problem;

	public Patient(){
	}
	public Patient(String  name,int age,String phoneNo,String problem,String aadhar){
		this.id = val++;
		this.name = name;
		this.age = age;
		this.phoneNo = phoneNo;
		this.problem = problem;
		this.aadhar = aadhar;
	}


}
