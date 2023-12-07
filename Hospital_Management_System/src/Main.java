import java.util.ArrayList;

import backend.Admin;
import backend.Admin.Schedule;
import backend.Patients;
import backend.Patients.Appointment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Patients p=new Patients();
		Appointment b=p.new Appointment();
		b.appointmentDataStore("2022-12-16", "A", "General", "09:00 AM");
//		Admin a=new Admin();
//		Schedule sc=a.new Schedule();
//		ArrayList<String> l=new ArrayList<>();
//		l.add("tues");
//		sc.setSchedule("1", "A", "General", l);

	}

}
