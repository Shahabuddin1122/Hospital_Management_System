package backend;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Patients extends User {
	private String address;
	//protected Object textField;
	public Patients(){ };
	public Patients(String name, String email, String password ,String number ,String gender,String birthdate,String address){
		super(name,email,password,number,gender,birthdate);
		this.address=address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return this.address;
	}
	public void display()
	{
		System.out.println(this.getName()+"  "+this.getEmail()+"  "+this.getNumber());
	}
//    Patients p=new Patients();


	//checks whether an account is already created or not
	
	
	
	
	
	
	
	
	public boolean checkData() {
		boolean valid = true;
		String em=new String();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from patients";
			ResultSet result=ppt.executeQuery(sql);
			while(result.next()){
				if(this.getEmail().equals(result.getString("email"))){
					valid=false; //false means account exists
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
			String sql="INSERT INTO patients(name,email,password,number,gender,birthdate,age,address)VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getPassword());
			ppt.setString(4,this.getNumber());
			ppt.setString(5,this.getGender());
			ppt.setString(6,this.getBirthdate());
			ppt.setInt(7,this.getAge());
			ppt.setString(8,this.getAddress());

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
			PreparedStatement ppt=con.prepareStatement("DELETE FROM patients WHERE email=? and password=?");
			ppt.setString(2, this.getEmail());
			ppt.setString(3, this.getPassword());
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
			String sql="select * from patients where email='"+this.getEmail()+"'";
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
	public Patients finddata()
	{
		System.out.println(this.getEmail());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from patients where email='"+this.getEmail()+"'";
			ResultSet result=ppt.executeQuery(sql);
			if(result.next())
			{
				String pass=result.getString("password");
				String name=result.getString("name");
				String number=result.getString("number");
				String birthdate=result.getString("birthdate");
				String gender=result.getString("gender");
				String address=result.getString("address");
			    Patients a=new Patients(name,this.getEmail(),pass,number,gender,birthdate,address);
			    
			    return a;
			}
			con.close();
			
			
		}catch(Exception e1)
		{
			System.out.println("Showin Profile: "+e1);
		}
		return null;
		
	}
	
	
	//***************
	public class Appointment{
		private int serial;
		private Doctor doctor;
		private String date;
		private String time;
		public void appointmentDataBase(String patientName,String patientEmail,String DateOfAppointment,String doctorName,String dept,String timeOfAppointment,int serial) {
			try {
//				LocalDate date=LocalDate.parse(DateOfAppointment);
//				String day=date.getDayOfWeek().toString();
//				day=day.toLowerCase();
//				day=day.substring(0, 3);
				String day=new String();
				if(DateOfAppointment.equals("2022-12-16")) day="fri";
				else day="sat";
				int id=0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
				String sql="select id from hospital.patient where name=? and email=?";
				PreparedStatement ppt=con.prepareStatement(sql);
				//ppt.setString(8, dept);
				ppt.setString(1,patientName);
				ppt.setString(2, patientEmail);
				ResultSet result=ppt.executeQuery();
				while(result.next()) {
					id=result.getInt("id");
				}
				ppt=con.prepareStatement("INSERT INTO `hospital`.`appointment` (`patient_id`, `doctor_name`, `doctor_dept`, `date`, `day`, `serial`, `time`) VALUES (?, ?, ?, ?, ?, ?, ?);");
				ppt.setInt(1, id);
				ppt.setString(2, doctorName);
				ppt.setString(3,dept);
				ppt.setString(4, DateOfAppointment);
				ppt.setString(5, day);
				ppt.setInt(6, serial);
				ppt.setString(7, timeOfAppointment);
				ppt.executeUpdate();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public int appointmentDataStore(String DateOfAppointment,String doctorName,String dept,String timeOfAppointment) {
//			ArrayList<String>time = new ArrayList<>();
//			LocalDate date=LocalDate.parse(DateOfAppointment);
//			String day=date.getDayOfWeek().toString();
//			day=day.toLowerCase();
//			day=day.substring(0, 3);
			String day=new String();
			if(DateOfAppointment.equals("2022-12-16")) day="fri";
			else day="sat";
			
			String shift = new String(); int doctor_id = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
				PreparedStatement ppt=con.prepareStatement("select id,shift from doctor where name=? and department=?");
				ppt.setString(1, doctorName);
				ppt.setString(2, dept);
				ResultSet result=ppt.executeQuery();
				while(result.next()) {
					shift=result.getString("shift");
					
					doctor_id=result.getInt("id");
				}
				String b =new String();
				timeOfAppointment="t"+timeOfAppointment.substring(0, 2)+timeOfAppointment.substring(3, 5);
				if(timeOfAppointment.charAt(3)=='3') {
					int i=Integer.parseInt(timeOfAppointment.substring(1, 3));
					i=(i+1)%12;
					String c;
					if(i>=1 && i<=9) c="0"+Integer.toString(i);
					else c=Integer.toString(i);
					b=timeOfAppointment.substring(0,1)+c+"0"+timeOfAppointment.substring(4);
					 
				}
				else if(timeOfAppointment.charAt(3)=='0') {
					b=timeOfAppointment.substring(0, 3)+"3"+timeOfAppointment.substring(4);
				}
				timeOfAppointment=timeOfAppointment+"_"+b;
				if(shift.equals("1")) {
					PreparedStatement stmt=con.prepareStatement("update `hospital`.`schedule1` set "+timeOfAppointment+" = '1'"
							+ "WHERE doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					stmt.executeUpdate();
					
					stmt=con.prepareStatement("select serial from `hospital`.`schedule1` where doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					ResultSet res=stmt.executeQuery();
					while(res.next()) {
						serial=res.getInt("serial");
					}
				}
				else if(shift.equals("2")){
					PreparedStatement stmt=con.prepareStatement("update `hospital`.`schedule2` set "+timeOfAppointment+" = '1'"
							+ "WHERE doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					stmt.executeUpdate();
					
					stmt=con.prepareStatement("select serial from `hospital`.`schedule2` where doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					ResultSet res=stmt.executeQuery();
					while(res.next()) {
						serial=res.getInt("serial");
					}
				}
				else if(shift.equals("3")) {
					PreparedStatement stmt=con.prepareStatement("update `hospital`.`schedule3` set "+timeOfAppointment+" = '1'"
							+ "WHERE doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					stmt.executeUpdate();
					stmt=con.prepareStatement("select serial from `hospital`.`schedule3` where doctor_id=? and day=?");
					stmt.setInt(1, doctor_id);
					stmt.setString(2, day);
					ResultSet res=stmt.executeQuery();
					while(res.next()) {
						serial=res.getInt("serial");
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (serial+1)%14;
		}
		
		
		public ArrayList<String> getDoctorByDept(String dept){
			ArrayList<String> doctors=new ArrayList<>();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
				String sql="select name from hospital.doctor where department=?";
				PreparedStatement ppt=con.prepareStatement(sql);
				//ppt.setString(8, dept);
				ppt.setString(1,dept);
				ResultSet result=ppt.executeQuery();
				while(result.next()) {
					doctors.add(result.getString("name"));
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return doctors;
			
		}
		public ArrayList<String> getTime(String DateOfAppointment,String doctorName,String dept){
			ArrayList<String>time = new ArrayList<>();
//			LocalDate date=LocalDate.parse(DateOfAppointment);
//			String day=date.getDayOfWeek().toString();
//			day=day.toLowerCase();
//			day=day.substring(0, 3);
			String day=new String();
			if(DateOfAppointment.equals("2022-12-16")) day="fri";
			else day="sat";
			//JOptionPane.showMessageDialog(null, day);
			String shift = null; int doctor_id = 0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
				PreparedStatement ppt=con.prepareStatement("select id,shift from hospital.doctor\r\n"
						+ "where name=? and department=?");
				ppt.setString(1, doctorName);
				ppt.setString(2, dept);
				ResultSet result=ppt.executeQuery();
				while(result.next()) {
					shift=result.getString("shift");
					JOptionPane.showMessageDialog(null, shift);
					doctor_id=result.getInt("id");
				}
				if(shift.equals("1")) {
					ppt=con.prepareStatement("SELECT t0900_t0930 ,\r\n"
							+ "t0930_t1000 ,\r\n"
							+ "t1000_t1030 ,\r\n"
							+ "t1030_t1100 ,\r\n"
							+ "t1100_t1130 ,\r\n"
							+ "t1130_t1200 ,\r\n"
							+ "t1200_t0100 ,\r\n"
							+ "t0100_t0130 ,\r\n"
							+ "t0130_t0200 ,\r\n"
							+ "t0200_t0230 ,\r\n"
							+ "t0230_t0300 ,\r\n"
							+ "t0300_t0330 ,\r\n"
							+ "t0330_t0400 ,\r\n"
							+ "t0400_t0430 ,\r\n"
							+ "t0430_t0500  FROM hospital.schedule1\r\n"
							+ "where day=? and doctor_id=?");
					ppt.setString(1,day);
					//JOptionPane.showMessageDialog(null, day+" "+Integer.toString(doctor_id));
					ppt.setInt(2, doctor_id);
					result=ppt.executeQuery();
					while(result.next()) {
						if(result.getInt("t0900_t0930")==0) time.add("09:00 AM");
						if(result.getInt("t0930_t1000")==0) time.add("09:30 AM");
						if(result.getInt("t1000_t1030")==0) time.add("10:00 AM");
						if(result.getInt("t1030_t1100")==0) time.add("10:30 AM");
						if(result.getInt("t1100_t1130")==0) time.add("11:00 AM");
						if(result.getInt("t1130_t1200")==0) time.add("11:30 AM");
						if(result.getInt("t0100_t0130")==0) time.add("01:00 PM");
						if(result.getInt("t0130_t0200")==0) time.add("01:30 PM");
						if(result.getInt("t0200_t0230")==0) time.add("02:00 PM");
						if(result.getInt("t0230_t0300")==0) time.add("02:30 PM");
						if(result.getInt("t0300_t0330")==0) time.add("03:00 PM");
						if(result.getInt("t0330_t0400")==0) time.add("03:30 PM");
						if(result.getInt("t0400_t0430")==0) time.add("04:00 PM");
						if(result.getInt("t0430_t0500")==0) time.add("04:30 PM");
						
					}
				}
				else if(shift.equals("2")){
					
					PreparedStatement ppt1=con.prepareStatement("SELECT t0500_t0530 ,\r\n"
							+ "t0530_t0600 ,\r\n"
							+ "t0600_t0630 ,\r\n"
							+ "t0630_t0700 ,\r\n"
							+ "t0700_t0730 ,\r\n"
							+ "t0730_t0800 ,\r\n"
							+ "t0800_t0900 ,\r\n"
							+ "t0900_t0930 ,\r\n"
							+ "t0930_t1000 ,\r\n"
							+ "t1000_t1030 ,\r\n"
							+ "t1030_t1100 ,\r\n"
							+ "t1100_t1130 ,\r\n"
							+ "t1130_t1200 ,\r\n"
							+ "t1200_t1230 ,\r\n"
							+ "t1230_t0100  FROM hospital.schedule2\r\n"
							+ "where day=? and doctor_id=?");
					ppt1.setString(1,day);
					//JOptionPane.showMessageDialog(null, day+" "+Integer.toString(doctor_id));
					ppt1.setInt(2, doctor_id);
					ResultSet result1=ppt1.executeQuery();
					while(result1.next()) {
						if(result1.getInt("t0500_t0530")==0) time.add("05:00 PM");
						if(result1.getInt("t0530_t0600")==0) time.add("05:30 PM");
						if(result1.getInt("t0600_t0630")==0) time.add("06:00 PM");
						if(result1.getInt("t0630_t0700")==0) time.add("06:30 PM");
						if(result1.getInt("t0700_t0730")==0) time.add("07:00 PM");
						if(result1.getInt("t0730_t0800")==0) time.add("07:30 PM");
						if(result1.getInt("t0900_t0930")==0) time.add("09:00 PM");
						if(result1.getInt("t0930_t1000")==0) time.add("09:30 PM");
						if(result1.getInt("t1000_t1030")==0) time.add("10:00 PM");
						if(result1.getInt("t1030_t1100")==0) time.add("10:30 PM");
						if(result1.getInt("t1100_t1130")==0) time.add("11:00 PM");
						if(result1.getInt("t1130_t1200")==0) time.add("11:30 PM");
						if(result1.getInt("t1200_t1230")==0) time.add("12:00 AM");
						if(result1.getInt("t1230_t0100")==0) time.add("12:30 AM");
					}
				}
				else if(shift.equals("3")) {
					PreparedStatement ppt2=con.prepareStatement("SELECT t0100_t0130 ,\r\n"
							+ "t0130_t0200 ,\r\n"
							+ "t0200_t0230 ,\r\n"
							+ "t0230_t0300 ,\r\n"
							+ "t0300_t0330 ,\r\n"
							+ "t0330_t0400 ,\r\n"
							+ "t0400_t0500 ,\r\n"
							+ "t0500_t0530 ,\r\n"
							+ "t0530_t0600 ,\r\n"
							+ "t0600_t0630 ,\r\n"
							+ "t0630_t0700 ,\r\n"
							+ "t0700_t0730 ,\r\n"
							+ "t0730_t0800 ,\r\n"
							+ "t0800_t0830 ,\r\n"
							+ "t0830_t0900  FROM hospital.schedule3\r\n"
							+ "where day=? and doctor_id=?");
					ppt2.setString(1,day);
					//JOptionPane.showMessageDialog(null, day+" "+Integer.toString(doctor_id));
					ppt2.setInt(2, doctor_id);
					 ResultSet result2=ppt2.executeQuery();
					while(result2.next()) {
						if(result2.getInt("t0100_t0130")==0) time.add("01:00 AM");
						if(result2.getInt("t0130_t0200")==0) time.add("01:30 AM");
						if(result2.getInt("t0200_t0230")==0) time.add("02:00 AM");
						if(result2.getInt("t0230_t0300")==0) time.add("02:30 AM");
						if(result2.getInt("t0300_t0330")==0) time.add("03:00 AM");
						if(result2.getInt("t0330_t0400")==0) time.add("03:30 AM");
						if(result2.getInt("t0500_t0530")==0) time.add("05:00 AM");
						if(result2.getInt("t0530_t0600")==0) time.add("05:30 AM");
						if(result2.getInt("t0600_t0630")==0) time.add("06:00 AM");
						if(result2.getInt("t0630_t0700")==0) time.add("06:30 AM");
						if(result2.getInt("t0700_t0730")==0) time.add("07:00 AM");
						if(result2.getInt("t0730_t0800")==0) time.add("07:30 AM");
						if(result2.getInt("t0800_t0830")==0) time.add("08:00 AM");
						if(result2.getInt("t0830_t0900")==0) time.add("08:30 AM");
						
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return time;
		}
		
	}


	
}

