package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Booking{
	private String name;
	private String email;
	private String number;
	private String date;
	private String bedtype;
	private int day;
	private int number_of_room;	

	/**
	 * 
	 */
	public Booking() {
		
	}
	public Booking(String name,String email,String number,String date,String bedtype,int day)
	{
		this.name=name;
		this.email=email;
		this.number=number;
		this.date=date;
		this.bedtype=bedtype;
		this.day=day;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBedtype() {
		return bedtype;
	}
	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getNumber_of_room() {
		return number_of_room;
	}
	public void setNumber_of_room(int number_of_room) {
		this.number_of_room = number_of_room;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void appointementHistory() {
		
	}
	public void BookingDataStore_reg() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			String sql="INSERT INTO booking_reg(name,email,number,bedtype,number_of_days,date_of_booking)VALUES(?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getNumber());
			
			ppt.setString(4,this.getBedtype());
			ppt.setInt(5,this.getDay());
			ppt.setString(6,this.getDate());

			ppt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Booking Store :"+e);
		}
		
	}
	public void BookingDataStore() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			String sql="INSERT INTO booking(name,email,number,bedtype,number_of_days,date_of_booking)VALUES(?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getNumber());
			
			ppt.setString(4,this.getBedtype());
			ppt.setInt(5,this.getDay());
			ppt.setString(6,this.getDate());

			ppt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Booking Store :"+e);
		}
		
	}
	public Booking finddata()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from booking_reg where email='"+getName()+"'";
			ResultSet result=ppt.executeQuery(sql);
			if(result.next())
			{
				String email=result.getString("email");
				String name=result.getString("name");
				String number=result.getString("number");
				String bedtype=result.getString("bedtype");
				int number_of_days=result.getInt(6);
				String date_of_booking=result.getString("date_of_booking");
			    Booking a=new Booking(name,email,number,date,bedtype,number_of_days);
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
