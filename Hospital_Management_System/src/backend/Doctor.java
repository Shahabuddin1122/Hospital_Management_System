package backend;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor extends User{
	private String dept;
	public Doctor(){ };
	public Doctor(String name, String email, String password ,String number ,String gender,String birthdate,String dept){
		super(name,email,password,number,gender,birthdate);
		this.dept=dept;
	}
	public void setDepartment(String dept) {
		this.dept=dept;
	}
	public String getDepartment() {
		return this.dept;
	}
	void display()
	{
		System.out.println(dept);
	}
	//checks whether an account is already created or not
	public boolean checkData() {
		boolean valid = true;
		String em=new String();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from doctor";
			ResultSet result=ppt.executeQuery(sql);
			while(result.next()){
				if(this.getEmail().equals(result.getString("email"))){
					valid=false;
				}
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("value is "+valid+" "+em);
			e.printStackTrace();
		}
		return valid;
	}
	
	//overridden method from User class
	public void storingData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			String sql="INSERT INTO doctor(name,email,password,number,gender,birthdate,age,department)VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getPassword());
			ppt.setString(4,this.getNumber());
			ppt.setString(5,this.getGender());
			ppt.setString(6,this.getBirthdate());
			ppt.setInt(7,this.getAge());
			ppt.setString(8,this.getDepartment());

			ppt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void storingData_n() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			String sql="INSERT INTO doctor_n(name,email,password,number,gender,birthdate,age,department)VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getPassword());
			ppt.setString(4,this.getNumber());
			ppt.setString(5,this.getGender());
			ppt.setString(6,this.getBirthdate());
			ppt.setInt(7,this.getAge());
			ppt.setString(8,this.getDepartment());

			ppt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void deleteData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			PreparedStatement ppt=con.prepareStatement("DELETE FROM doctor WHERE email=? and password=?");
			ppt.setString(1, this.getEmail());
			ppt.setString(2, this.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean checkPassword() {
		boolean valid = false;
		String em=new String();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from doctor";
			ResultSet result=ppt.executeQuery(sql);
			while(result.next()){
				if(this.getPassword().equals(result.getString("password"))){
					valid=true;
				}
			}
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("value is "+valid+" "+em);
			e.printStackTrace();
		}
		return valid;
	}
	public Doctor finddata()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from doctor where email='"+getEmail()+"'";
			ResultSet result=ppt.executeQuery(sql);
			if(result.next())
			{
				String pass=result.getString("password");
				String name=result.getString("name");
				String email=result.getString("email");
				String number=result.getString("number");
				String birthdate=result.getString("birthdate");
				String gender=result.getString("gender");
				String dept=result.getString("department");
			    Doctor a=new Doctor(name,email,pass,number,gender,birthdate,dept);
			    Doctor b=new Doctor();
			    b=a;
			    b.deleteData();
			    //a.display();
			    return a;
			}
			con.close();
			
			
		}catch(Exception e1)
		{
			System.out.println("Showin Profile: "+e1);
		}
		return null;
		
	}
}

