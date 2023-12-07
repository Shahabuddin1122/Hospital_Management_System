package backend;

import java.awt.TextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Admin extends User{
	
	public Admin(){ };
	public Admin(String name, String email, String password ,String number ,String gender,String birthdate){
		super(name,email,password,number,gender,birthdate);
	}
	
	//checks whether an account is already created or not
		public boolean checkData() {
			boolean valid = true;
			String em=new String();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
				Statement ppt= con.createStatement();
				String sql="select * from admin";
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
			String sql="INSERT INTO admin(name,email,password,number,gender,birthdate,age)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ppt=con.prepareStatement(sql);
			ppt.setString(1,this.getName());
			ppt.setString(2,this.getEmail());
			ppt.setString(3,this.getPassword());
			ppt.setString(4,this.getNumber());
			ppt.setString(5,this.getGender());
			ppt.setString(6,this.getBirthdate());
			ppt.setInt(7,this.getAge());
			

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
			PreparedStatement ppt=con.prepareStatement("DELETE FROM admin WHERE email=? and password=?");
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
			String sql="select * from admin";
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
	public Admin finddata()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			Statement ppt= con.createStatement();
			String sql="select * from admin where email='"+getEmail()+"'";
			ResultSet result=ppt.executeQuery(sql);
			if(result.next())
			{
				String pass=result.getString("password");
				String name=result.getString("name");
				String number=result.getString("number");
				String birthdate=result.getString("birthdate");
				String gender=result.getString("gender");
			    Admin a=new Admin(name,getEmail(),pass,number,gender,birthdate);
			    return a;
			}
			con.close();
			
			
		}catch(Exception e1)
		{
			System.out.println("Showin Profile: "+e1);
		}
		return null;
		
	}
	public class Schedule{
		private int id;
		
		public Schedule() {
			this.id = 0;
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
		
		
		public void setOffDays(String day,String shift,int id) {
			if(shift.equals("1")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("UPDATE `hospital`.`schedule1` SET `t0900_t0930` = '-1', `t0930_t1000` = '-1', `t1000_t1030` = '-1', `t1030_t1100` = '-1', `t1100_t1130` = '-1', `t1130_t1200` = '-1', `t0100_t0130` = '-1', `t0130_t0200` = '-1', `t0200_t0230` = '-1', `t0230_t0300` = '-1', `t0300_t0330` = '-1', `t0330_t0400` = '-1', `t0400_t0430` = '-1', `t0430_t0500` = '-1' WHERE (`day` = ?) AND (`doctor_id` = ?)");
					ppt.setString(1, day);
					ppt.setInt(2, id);
					ppt.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shift.equals("2")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("UPDATE `hospital`.`schedule2` SET `t0500_t0530` = '-1', `t0530_t0600` = '-1', `t0600_t0630` = '-1', `t0630_t0700` = '-1', `t0700_t0730` = '-1', `t0730_t0800` = '-1', `t0800_t0900` = '-1', `t0900_t0930` = '-1', `t0930_t1000` = '-1', `t1000_t1030` = '-1', `t1030_t1100` = '-1', `t1100_t1130` = '-1', `t1130_t1200` = '-1', `t1200_t1230` = '-1', `t1230_t0100` = '-1' WHERE (`day` = ?) AND (`doctor_id` = ?)");
					ppt.setString(1, day);
					ppt.setInt(2, id);
					ppt.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shift.equals("3")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("UPDATE `hospital`.`schedule3` SET `t0100_t0130` = '-1', `t0130_t0200` = '-1', `t0200_t0230` = '-1', `t0230_t0300` = '-1', `t0300_t0330` = '-1', `t0330_t0400` = '-1', `t0400_t0500` = '-1', `t0500_t0530` = '-1', `t0530_t0600` = '-1', `t0600_t0630` = '-1', `t0630_t0700` = '-1', `t0700_t0730` = '-1', `t0730_t0800` = '-1', `t0800_t0830` = '-1', `t0830_t0900` = '-1' WHERE (`day` = ?) AND (`doctor_id` = ?)");
					ppt.setString(1, day);
					ppt.setInt(2, id);
					ppt.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		public void setSchedule(String shift,String doctorName,String doctorDept,ArrayList<String> notSelectedDay) {
			
			if(shift.equals("1")) {
				id=0;
				boolean valid=false;
				Connection con;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					
					ppt=con.prepareStatement("select doctor_id from hospital.schedule1");
					result=ppt.executeQuery();
					while(result.next()) {
						if(id==result.getInt("doctor_id")) valid=true;
					}
					if(!valid) {
					ppt=con.prepareStatement("INSERT INTO `hospital`.`schedule1` (`doctor_id`, `day`, `t0900_t0930`, `t0930_t1000`, `t1000_t1030`, `t1030_t1100`, `t1100_t1130`, `t1130_t1200`, `t1200_t0100`, `t0100_t0130`, `t0130_t0200`, `t0200_t0230`, `t0230_t0300`, `t0300_t0330`, `t0330_t0400`, `t0400_t0430`, `t0430_t0500`)"
							+ "VALUES (?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0')");
					for(int i=1;i<=13;i+=2) {
						ppt.setInt(i, id);
					}
					//ppt.setInt(1, id);
					ppt.setString(2, "sat");
					ppt.setString(4, "sun");
					ppt.setString(6, "mon");
					ppt.setString(8, "tues");
					ppt.setString(10, "wed");
					ppt.setString(12, "thurs");
					ppt.setString(14, "fri");
					ppt.executeUpdate();
					
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					ppt=con.prepareStatement("UPDATE `hospital`.`doctor` SET `shift` = ? WHERE (`id` = ?)");
					ppt.setString(1, shift);
					ppt.setInt(2, id);
					ppt.executeUpdate();
					
					ppt=con.prepareStatement("UPDATE `hospital`.`schedule1` SET `serial` = '0' WHERE (`doctor_id` = ?)");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					}
					else updateSchedule(shift,doctorName,doctorDept,notSelectedDay);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			else if(shift.equals("2")) {
				id=0;
				boolean valid=false;
				Connection con;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					
					ppt=con.prepareStatement("select doctor_id from hospital.schedule2");
					result=ppt.executeQuery();
					while(result.next()) {
						if(id==result.getInt("doctor_id")) valid=true;
					}
					if(!valid) {
					ppt=con.prepareStatement("INSERT INTO `hospital`.`schedule2` (`doctor_id`, `day`, `t0500_t0530`, `t0530_t0600`, `t0600_t0630`, `t0630_t0700`, `t0700_t0730`, `t0730_t0800`, `t0800_t0900`, `t0900_t0930`, `t0930_t1000`, `t1000_t1030`, `t1030_t1100`, `t1100_t1130`, `t1130_t1200`, `t1200_t1230`, `t1230_t0100`) "
							+ "VALUES (?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0')");
					for(int i=1;i<=13;i+=2) {
						ppt.setInt(i, id);
					}
					//ppt.setInt(1, id);
					ppt.setString(2, "sat");
					ppt.setString(4, "sun");
					ppt.setString(6, "mon");
					ppt.setString(8, "tues");
					ppt.setString(10, "wed");
					ppt.setString(12, "thurs");
					ppt.setString(14, "fri");
					ppt.executeUpdate();
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					ppt=con.prepareStatement("UPDATE `hospital`.`doctor` SET `shift` = ? WHERE (`id` = ?);");
					ppt.setString(1, shift);
					ppt.setInt(2, id);
					ppt.executeUpdate();
					
					ppt=con.prepareStatement("UPDATE `hospital`.`schedule2` SET `serial` = '0' WHERE (`doctor_id` = ?)");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					}
					
					
					else updateSchedule(shift,doctorName,doctorDept,notSelectedDay);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shift.equals("3")) {
				id=0;
				boolean valid=false;
				Connection con;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					ppt=con.prepareStatement("select doctor_id from hospital.schedule3");
					result=ppt.executeQuery();
					while(result.next()) {
						if(id==result.getInt("doctor_id")) valid=true;
					}
					if(!valid) {
					ppt=con.prepareStatement("INSERT INTO `hospital`.`schedule3` (`doctor_id`, `day`, `t0100_t0130`, `t0130_t0200`, `t0200_t0230`, `t0230_t0300`, `t0300_t0330`, `t0330_t0400`, `t0400_t0500`, `t0500_t0530`, `t0530_t0600`, `t0600_t0630`, `t0630_t0700`, `t0700_t0730`, `t0730_t0800`, `t0800_t0830`, `t0830_t0900`)"
							+ "VALUES (?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0'),"
							+"(?, ?, '0', '0', '0', '0', '0', '0', '-1', '0', '0', '0', '0', '0', '0', '0', '0')");
					for(int i=1;i<=13;i+=2) {
						ppt.setInt(i, id);
					}
					//ppt.setInt(1, id);
					ppt.setString(2, "sat");
					ppt.setString(4, "sun");
					ppt.setString(6, "mon");
					ppt.setString(8, "tues");
					ppt.setString(10, "wed");
					ppt.setString(12, "thurs");
					ppt.setString(14, "fri");
					ppt.executeUpdate();
					
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					ppt=con.prepareStatement("UPDATE `hospital`.`doctor` SET `shift` = ? WHERE (`id` = ?);");
					ppt.setString(1, shift);
					ppt.setInt(2, id);
					ppt.executeUpdate();
					
					ppt=con.prepareStatement("UPDATE `hospital`.`schedule3` SET `serial` = '0' WHERE (`doctor_id` = ?)");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					}
					else updateSchedule(shift,doctorName,doctorDept,notSelectedDay);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		public void updateSchedule(String shift,String doctorName,String doctorDept,ArrayList<String> notSelectedDay) {
			if(shift.equals("1")) {
				id=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					ppt=con.prepareStatement("update `hospital`.`schedule1`"
							+ "set `t0900_t0930` ='0',"
							+ "`t0930_t1000` ='0',"
							+ "`t1000_t1030` ='0',"
							+ "`t1030_t1100` ='0',"
							+ "`t1100_t1130` ='0',"
							+ "`t1130_t1200` ='0',"
							+ "`t1200_t0100` ='-1',"
							+ "`t0100_t0130` ='0',"
							+ "`t0130_t0200` ='0',"
							+ "`t0200_t0230` ='0',"
							+ "`t0230_t0300` ='0',"
							+ "`t0300_t0330` ='0',"
							+ "`t0330_t0400` ='0',"
							+ "`t0400_t0430` ='0',"
							+ "`t0430_t0500` ='0'"
							+ "where (`doctor_id`=?) ");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shift.equals("2")) {
				id=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					ppt=con.prepareStatement("update `hospital`.`schedule2`"
							+ "set `t0500_t0530` ='0',"
							+ "`t0530_t0600` ='0',"
							+ "`t0600_t0630` ='0',"
							+ "`t0630_t0700` ='0',"
							+ "`t0700_t0730` ='0',"
							+ "`t0730_t0800` ='0',"
							+ "`t0800_t0900` ='-1',"
							+ "`t0900_t0930` ='0',"
							+ "`t0930_t1000` ='0',"
							+ "`t1000_t1030` ='0',"
							+ "`t1030_t1100` ='0',"
							+ "`t1100_t1130` ='0',"
							+ "`t1130_t1200` ='0',"
							+ "`t1200_t1230` ='0',"
							+ "`t1230_t0100` ='0'"
							+ "where (`doctor_id`=?) ");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shift.equals("3")) {
				id=0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					PreparedStatement ppt=con.prepareStatement("select id from hospital.doctor where name=? and department=?");
					ppt.setString(1, doctorName);
					ppt.setString(2, doctorDept);
					ResultSet result=ppt.executeQuery();
					while(result.next()) {
						//System.out.println(result.getString("id"));
						id=Integer.parseInt(result.getString("id"));
					}
					ppt=con.prepareStatement("UPDATE `hospital`.`schedule3` SET `t0100_t0130` = '0', `t0130_t0200` = '0', `t0200_t0230` = '0', `t0230_t0300` = '0', `t0300_t0330` = '0', `t0330_t0400` = '0', `t0400_t0500` = '-1', `t0500_t0530` = '0', `t0530_t0600` = '0', `t0600_t0630` = '0', `t0630_t0700` = '0', `t0700_t0730` = '0', `t0730_t0800` = '0', `t0800_t0830` = '0', `t0830_t0900` = '0'"
							+ "where (`doctor_id`=?) ");
					ppt.setInt(1, id);
					ppt.executeUpdate();
					if(!notSelectedDay.isEmpty()) {
//						notSelectedDay.forEach(e->{
//							setOffDays(e,shift,id);
//						});
						for(String i: notSelectedDay) {
							setOffDays(i,shift,id);
						}
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	

}


