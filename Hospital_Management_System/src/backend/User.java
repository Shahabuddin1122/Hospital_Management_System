package backend;

import java.time.LocalDate;

//import java.time.LocalTime;
//import java.time.Period;
//import java.time.temporal.ChronoUnit;

public abstract class User {
	private String name,email,password,number,gender;
	private String birthdate;
	//default constructor
	public User(){ };
	//constructor
	public User(String name, String email, String password ,String number ,String gender,String birthdate){
		this.name=name;
		this.email=email;
		this.password=password;
		this.number=number;
		this.gender=gender;
		this.birthdate=birthdate;
	}
	
	//setter methods
	public  void setName(String name) {
		this.name=name;
	}
	public  void setEmail(String email) {
		this.email=email;
	}
	public  void setPassword(String password) {
		this.password=password;
	}
	public  void setNumber(String number) {
		this.number=number;
	}
	public  void setGender(String gender) {
		this.gender=gender;
	}
	public  void setBirthdate(String birthdate) {
		this.birthdate=birthdate;
	}
	
	//getter methods
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
	public String getNumber() {
		return this.number;
	}
	public String getGender() {
		return this.gender;
	}
	public String getBirthdate() {
		return this.birthdate;
	}
	public int getAge() {
		
		int x=-2022+Integer.parseInt(birthdate.substring(0,4));
		return x;


	}
	//method for storing data in a file which is overridden in the child class 
	public abstract void storingData();
	//method to check whether any account is already created or not
	public abstract boolean checkData();
	public abstract void deleteData();
	public abstract boolean checkPassword();
	
}
