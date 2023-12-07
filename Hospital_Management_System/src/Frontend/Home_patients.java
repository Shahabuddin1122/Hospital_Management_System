package Frontend;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import backend.Patients;
import backend.Patients.Appointment;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_patients extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	private JTextField textField_6;
	private JTable table;
	String dept;
	Appointment ap=new Patients().new Appointment();
	ArrayList<String>doctorName,timeSchedule;
	String year,month,date;
	String dateOfAppointment;
	DefaultComboBoxModel<String> model;
	JComboBox comboBoxDept,comboBoxDate,comboBoxMonth,comboBoxYear;
	JComboBox<String>comboBoxDoc,comboBoxTime;
	DefaultComboBoxModel<String> model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_patients frame = new Home_patients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home_patients() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 0, 290, 852);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/resized.png")));
		lblNewLabel.setBounds(38, 35, 165, 128);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();

		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(0, 220, 290, 63);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-hospital-64.png")));
		lblNewLabel_1.setBounds(10, 0, 60, 63);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(93, 0, 171, 63);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();

		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.CYAN);
		panel_2_1.setBounds(0, 332, 290, 63);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/1564534_customer_man_user_account_profile_icon.png")));
		lblNewLabel_1_1.setBounds(0, 0, 83, 63);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("profile");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(93, 0, 171, 63);
		panel_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_2_1_1 = new JPanel();

		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(Color.CYAN);
		panel_2_1_1.setBounds(0, 448, 290, 63);
		panel_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-appointment-64.png")));
		lblNewLabel_1_1_1.setBounds(10, 0, 74, 63);
		panel_2_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Appointment");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(93, 0, 171, 63);
		panel_2_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_2_1_2 = new JPanel();

		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(Color.CYAN);
		panel_2_1_2.setBounds(0, 557, 290, 63);
		panel_1.add(panel_2_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("");
		lblNewLabel_1_1_2.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/rsz_bill.png")));
		lblNewLabel_1_1_2.setBounds(19, 0, 64, 63);
		panel_2_1_2.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Bill History");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_2.setBounds(93, 0, 171, 63);
		panel_2_1_2.add(lblNewLabel_2_1_2);
		
		JPanel panel_2_1_3 = new JPanel();

		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBackground(Color.CYAN);
		panel_2_1_3.setBounds(0, 664, 290, 63);
		panel_1.add(panel_2_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("");
		lblNewLabel_1_1_3.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-booking-91.png")));
		lblNewLabel_1_1_3.setBounds(0, 0, 83, 63);
		panel_2_1_3.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Booking");
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_3.setBounds(93, 0, 171, 63);
		panel_2_1_3.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("@ right reserved");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_3.setBounds(10, 807, 221, 34);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 0, 1576, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("United Hospital");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4.setBounds(699, 11, 230, 38);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hotline:02-234343");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1.setBounds(1298, 65, 230, 38);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Emergency :02-123984");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1.setBounds(376, 91, 300, 38);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("United Hospital");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1_1.setBounds(810, 91, 230, 38);
		panel.add(lblNewLabel_4_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(1201, 106, 215, 34);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login n=new Login();
				n.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(1439, 105, 127, 35);
		panel.add(btnNewButton_1);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(299, 115, 1287, 737);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10_1 = new JLabel("");
		lblNewLabel_10_1.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-right-button-100.png")));
		lblNewLabel_10_1.setBounds(-15, 81, 71, 62);
		panel_3.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/image/vivid-blurred-colorful-wallpaper-background (1).jpg")));
		lblNewLabel_5.setBounds(-5, 0, 1287, 709);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-right-button-100.png")));
		lblNewLabel_10.setBounds(10, 198, 71, 62);
		panel_4.add(lblNewLabel_10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		panel_8.setBounds(314, 11, 576, 687);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Profile");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel_7.setBounds(187, 11, 190, 66);
		panel_8.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/icons8-male-user-96.png")));
		lblNewLabel_8.setBounds(216, 70, 101, 109);
		panel_8.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Name       :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setBounds(20, 197, 126, 52);
		panel_8.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setEditable(false);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField.setBounds(152, 197, 372, 52);
		panel_8.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("E-mail     :");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1.setBounds(20, 264, 126, 52);
		panel_8.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Address   :");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1_1.setBounds(20, 344, 126, 52);
		panel_8.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("age           :");
		lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1_1_1.setBounds(20, 429, 126, 52);
		panel_8.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Number   :");
		lblNewLabel_9_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1_1_1_1.setBounds(20, 503, 126, 52);
		panel_8.add(lblNewLabel_9_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField_1.setBounds(152, 269, 373, 52);
		panel_8.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField_2.setBounds(152, 344, 372, 52);
		panel_8.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField_3.setBounds(152, 429, 372, 52);
		panel_8.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField_4.setBounds(152, 503, 372, 52);
		panel_8.add(textField_4);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/button (5).png")));
		lblNewLabel_11.setBounds(175, 596, 243, 52);
		panel_8.add(lblNewLabel_11);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/3150060.jpg")));
		lblNewLabel_6.setBounds(0, 0, 1282, 709);
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(164, 191, 219));
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 11, 308, 687);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton_2_1 = new JButton("View Appointment");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new view_appointment().setVisible(true);
			}
		});
		
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1.setBackground(new Color(164, 191, 219));
		btnNewButton_2_1.setBounds(54, 250, 202, 103);
		panel_9.add(btnNewButton_2_1);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setBounds(964, 11, 308, 687);
		panel_5.add(panel_9_1);
		
		JLabel lblNewLabel_12 = new JLabel("Appointment");
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblNewLabel_12.setBounds(426, 35, 346, 51);
		panel_5.add(lblNewLabel_12);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Dept       :");
		lblNewLabel_4_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1_2.setBounds(340, 145, 147, 38);
		panel_5.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Doctor    :");
		lblNewLabel_4_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1_2_1.setBounds(340, 240, 147, 38);
		panel_5.add(lblNewLabel_4_1_1_2_1);
		
		JLabel lblNewLabel_4_1_1_2_1_1 = new JLabel("Date       :");
		lblNewLabel_4_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1_2_1_1.setBounds(340, 351, 147, 38);
		panel_5.add(lblNewLabel_4_1_1_2_1_1);
		
		model=new DefaultComboBoxModel<>();
		
		doctorName=new ArrayList<>();
		comboBoxDept = new JComboBox();
		comboBoxDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.getSize()!=0) {
					model.removeAllElements();
				}
				dept=comboBoxDept.getSelectedItem().toString();
				doctorName=ap.getDoctorByDept(dept);
//				doctorName.forEach(n->{
//					model.addElement(n);
//				});
				for(int i=0;i<doctorName.size();i++) {
					model.addElement(doctorName.get(i));
				}
			}
		});
		comboBoxDept.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBoxDept.setModel(new DefaultComboBoxModel(new String[] {"General", "Cardiology", "Radiologist", "Pediatrician", "Medicine", "Neurology", "Dermatology", "Surgeon", "Urologist", "Gynacologist"}));
		comboBoxDept.setBounds(475, 145, 154, 38);
		panel_5.add(comboBoxDept);
		
		comboBoxDoc = new JComboBox<>();
		comboBoxDoc.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBoxDoc.setBounds(475, 240, 254, 38);
		comboBoxDoc.setModel(model);
		panel_5.add(comboBoxDoc);
		
		comboBoxDate = new JComboBox();
		comboBoxDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date=comboBoxDate.getSelectedItem().toString();
			}
		});
		comboBoxDate.setModel(new DefaultComboBoxModel(new String[] {"Day", "16", "17"}));
		comboBoxDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxDate.setBounds(475, 351, 65, 38);
		panel_5.add(comboBoxDate);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				month=comboBoxMonth.getSelectedItem().toString();
			}
		});
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Month", "12"}));
		comboBoxMonth.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxMonth.setBounds(564, 351, 85, 38);
		panel_5.add(comboBoxMonth);
		
		timeSchedule=new ArrayList<>();
		model1=new DefaultComboBoxModel<>();
		
		comboBoxYear = new JComboBox();
		comboBoxYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year=comboBoxYear.getSelectedItem().toString();
				dateOfAppointment=year+"-"+month+"-"+date;
				timeSchedule=ap.getTime(dateOfAppointment, comboBoxDoc.getSelectedItem().toString(), dept);
				if(model1.getSize()!=0) model1.removeAllElements();
				else {
//					timeSchedule.forEach(n->{
//						model1.addElement(n);
//					});
					for(int i=0;i<timeSchedule.size();i++) {
						model1.addElement(timeSchedule.get(i));
					}
				}
			}
		});
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"Year", "2022"}));
		comboBoxYear.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBoxYear.setBounds(667, 352, 91, 38);
		panel_5.add(comboBoxYear);
		
		JLabel lblNewLabel_4_1_1_2_1_1_2 = new JLabel("Time       :");
		lblNewLabel_4_1_1_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_4_1_1_2_1_1_2.setBounds(340, 445, 147, 38);
		panel_5.add(lblNewLabel_4_1_1_2_1_1_2);
		
		comboBoxTime = new JComboBox<String>();
		comboBoxTime.setModel(model1);
		comboBoxTime.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBoxTime.setBounds(475, 445, 236, 38);
		panel_5.add(comboBoxTime);
		
		JButton cnfrmButton = new JButton("Confirm");
		cnfrmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int serial=ap.appointmentDataStore(dateOfAppointment, comboBoxDoc.getSelectedItem().toString(), dept, comboBoxTime.getSelectedItem().toString());
				//ap.appointmentDataBase(textField.getText(), textField_1.getText(),dateOfAppointment, comboBoxDoc.getSelectedItem().toString(), dept, comboBoxTime.getSelectedItem().toString(),serial);
				JOptionPane.showMessageDialog(null, "Your serial is "+ serial);
			}
		});
		cnfrmButton.setBackground(new Color(0, 128, 128));
		cnfrmButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		cnfrmButton.setBounds(564, 565, 147, 38);
		panel_5.add(cnfrmButton);		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(1.0f,1.0f,1.0f,0.1f));
		panel_10.setBounds(331, 52, 626, 615);
		panel_6.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton = new JButton("Previous History");
		btnNewButton.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 64)));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(38, 54, 213, 153);
		panel_10.add(btnNewButton);
		
		final JButton btnDueBill = new JButton("Due Bill");

		btnDueBill.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 128)));
		btnDueBill.setBackground(new Color(255, 255, 255));
		btnDueBill.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnDueBill.setBounds(302, 54, 213, 153);
		panel_10.add(btnDueBill);
		
		JButton btnDownloadMamo = new JButton("Download Mamo");
		btnDownloadMamo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 128)));
		btnDownloadMamo.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDownloadMamo.setBounds(189, 556, 241, 48);
		panel_10.add(btnDownloadMamo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 236, 581, 289);
		panel_10.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/pexels-gradienta-6985276.jpg")));
		lblNewLabel_13.setBounds(34, 36, 1208, 636);
		panel_6.add(lblNewLabel_13);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 128, 128));
		panel_11.setBounds(124, 61, 1038, 568);
		panel_7.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("Number of Days:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_14.setBounds(247, 272, 223, 36);
		panel_11.add(lblNewLabel_14);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Choose", "1", "2", "3", "4", "5", "6"}));
		comboBox_2.setBounds(480, 275, 100, 36);
		panel_11.add(comboBox_2);
		
		JLabel lblNewLabel_15 = new JLabel("Date                      :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_15.setBounds(247, 192, 235, 44);
		panel_11.add(lblNewLabel_15);
		
		final JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_2_1.setBounds(480, 200, 71, 36);
		panel_11.add(comboBox_2_1);
		
		final JComboBox comboBox_2_1_1 = new JComboBox();
		comboBox_2_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_2_1_1.setBounds(567, 200, 71, 36);
		panel_11.add(comboBox_2_1_1);
		
		final JComboBox comboBox_2_1_1_1 = new JComboBox();
		comboBox_2_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023"}));
		comboBox_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_2_1_1_1.setBounds(648, 199, 71, 36);
		panel_11.add(comboBox_2_1_1_1);
		
		JLabel lblNewLabel_16 = new JLabel("");

		lblNewLabel_16.setIcon(new ImageIcon(Home_patients.class.getResource("/Frontend/Image/button (6).png")));
		lblNewLabel_16.setBounds(411, 389, 155, 61);
		panel_11.add(lblNewLabel_16);
		
		JLabel lblNewLabel_14_1 = new JLabel("Type of bed       :");
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_14_1.setBounds(247, 97, 223, 36);
		panel_11.add(lblNewLabel_14_1);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Choose", "Normal Bed", "ICU", "CCU", "Cabin"}));
		comboBox_3.setBounds(480, 96, 114, 37);
		panel_11.add(comboBox_3);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel_2_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		///show in bill table
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					Statement ppt= con.createStatement();
					String sql="select * from patients";
					ResultSet result=ppt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd= result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols-1];
					for(int i=0;i<cols-1;i++)
					{
						if(i<3) {
							colName[i]=rsmd.getColumnName(i+1);
						}
						else {
							colName[i]=rsmd.getColumnName(i+2);
						}
					}
					model.setColumnIdentifiers(colName);
					
					String a,b,c,d,l,f,g,h,i;
					while(result.next())
					{
						a=result.getString(1);
						b=result.getString(2);
						c=result.getString(3);
						//d=result.getString(4);
						l=result.getString(5);
						f=result.getString(6);
						g=result.getString(7);
						h=result.getString(8);
						i=result.getString(9);
						String row[]= {a,b,c,l,f,g,h,i};
						model.addRow(row);
						
					}
					ppt.close();
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error:"+e1);
					e1.printStackTrace();
				}
			}
		});
		btnDueBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path="";
					JFileChooser j=new JFileChooser();
					j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int x=j.showSaveDialog(btnDueBill);
					if(x==JFileChooser.APPROVE_OPTION)
					{
						path=j.getSelectedFile().getPath();
					}
					Document doc=new Document();
                    PdfWriter.getInstance(doc, new FileOutputStream(path+"abc1.pdf"));
                    doc.open();
                    //PdfPTable tbl=new PdfPTable(3);
                    //tbl.addCell("First Name");
                    //tbl.addCell("Last Name");
                    //tbl.addCell("Mobile Number");
                    
                    
                    
//                    doc.add(new Paragraph("-------------------------------------Bill for patients----------------------------------",FontFactory.getFont(FontFactory.TIMES_BOLD,28,Font.BOLD,BaseColor.RED)));
//                    Image image= Image.getInstance("C:\\Users\\shahabuddin akhon hr\\Eclipse(new)_marketplace\\Hospital_Management_System\\resized.png");
//                    doc.add(new Paragraph("Image"));
//                    doc.add(image);
//                    doc.add(new Paragraph(" "));
//                    doc.add(new Paragraph(" "));
//                    doc.add(new Paragraph(" "));
//                    doc.add(new Paragraph(" "));
//                    
//                    doc.add(new Paragraph("----------------------------------------------------------------------------------------"));
//                    doc.add(new Paragraph("---------------"));
//                    int col=table.getColumnCount();
//                    
//                    
//                    PdfPTable tbl=new PdfPTable(col);
//                    int row=table.getRowCount();
//                    tbl.addCell("ID");
//                    tbl.addCell("Name");
//                    tbl.addCell("E-mail");
//                    //tbl.addCell("Password");
//                    tbl.addCell("Number");
//                    tbl.addCell("Gender");
//                    tbl.addCell("Birthday");
//                    tbl.addCell("Age");
//                    tbl.addCell("Address");
//                    System.out.println(col+"  "+row);//8 2
//                    for(int i=0;i<row;i++)
//                    {
//                    	for(int k=0;k<col;k++)
//                    	{
//                    		String A=table.getValueAt(i,k).toString();
//                    		System.out.println(A);
//                    		tbl.addCell(A);
//                    	}
//                    	doc.add(tbl);
//                    }
//                    
//                    
//                    
//					doc.add(tbl);
//					JOptionPane.showMessageDialog(null, "Pdf gnerated");
//					doc.close();
    
                    PdfPTable tbl=new PdfPTable(3);
                    //tbl.setWidths(new int[]{10,10});
                    
                    Image image= Image.getInstance("C:\\Users\\shahabuddin akhon hr\\Eclipse(new)_marketplace\\Hospital_Management_System\\resized.png");
                    PdfPCell cell1=new PdfPCell(image);
                    cell1.setColspan(0);
                    cell1.setBorder(0);
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tbl.addCell(cell1);
                    
                    
                    PdfPCell cell21=new PdfPCell(new Paragraph(""));
                    cell21.setColspan(0);
                    cell21.setBorder(0);
                    cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell21.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell21);
                    
                    PdfPCell cell22=new PdfPCell(new Paragraph("United Hospital\nJatrabari,Dhaka-1236\nTel:02-232424",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD,BaseColor.RED)));
                    cell22.setColspan(0);
                    cell22.setBorder(0);
                    cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
                    //cell22.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tbl.addCell(cell22);
                    
                    //tbl.addCell(new Paragraph("United Hospital\n#palashpur,Dhaka-1236\nMobile:0192711168",FontFactory.getFont(FontFactory.TIMES_BOLD,28,Font.BOLD,BaseColor.RED)));
                    doc.add(tbl);

                    doc.add(new Paragraph("*********************************************************************",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.ITALIC,BaseColor.GRAY)));
                    doc.add(new Paragraph(" "));                   
                    doc.add(new Paragraph("                               Patient Name   :         "+textField.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
                    doc.add(new Paragraph("                               Birthdate         :         "+textField_4.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
                    doc.add(new Paragraph("                               Number           :         "+textField_2.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
                    doc.add(new Paragraph(" "));
                    PdfPTable tb3=new PdfPTable(3);
                    PdfPCell cell=new PdfPCell(new Paragraph("Invoice"));
                    cell.setColspan(3);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GREEN);
                    tb3.addCell(cell);
                    
                    PdfPCell cell2=new PdfPCell(new Paragraph("Bill Type"));
                    cell2.setColspan(2);
                    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tb3.addCell(cell2);
                    
                    PdfPCell cell3=new PdfPCell(new Paragraph("Amount"));
                    cell3.setColspan(1);
                    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    tb3.addCell(cell3);
                    
                    List li=new List();
                    li.add("Appointment Bill -");
                    li.add("Booking Bill -");
                    
                    
                    PdfPCell cell4=new PdfPCell(new Paragraph("Appointment Bill - \n Booking Bill -\n"));
                    cell4.setColspan(2);
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tb3.addCell(cell4);
                    
                    PdfPCell cell5=new PdfPCell(new Paragraph("--\n--\n\n"));
                    cell5.setColspan(2);
                    cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                    tb3.addCell(cell5);
                    
                    PdfPCell cell6=new PdfPCell(new Paragraph("Total Bill: "));
                    cell6.setColspan(3);
                    cell6.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    tb3.addCell(cell6);
                    doc.add(tb3);
                    //footer
                    
                    PdfPTable tb4=new PdfPTable(3);
                    PdfPCell cel=new PdfPCell(new Paragraph("---------------"));
                    PdfPCell cel2=new PdfPCell(new Paragraph("---------------"));
                    cel.setColspan(2);
                    cel.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cel.setBorder(0);
                    cel2.setColspan(1);
                    cel2.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cel2.setBorder(0);
                    tb4.addCell(cel);
                    tb4.addCell(cel2);
                    PdfPCell cel3=new PdfPCell(new Paragraph("Patients Sign"));
                    PdfPCell cel4=new PdfPCell(new Paragraph("Manager's Sign"));
                    cel3.setColspan(2);
                    cel3.setHorizontalAlignment(Element.ALIGN_LEFT);
                    cel3.setBorder(0);
                    cel4.setColspan(1);
                    cel4.setHorizontalAlignment(Element.ALIGN_RIGHT);
                    cel4.setBorder(0);
                    tb4.addCell(cel3);
                    tb4.addCell(cel4);
                    
                    doc.add(tb4);
                    JOptionPane.showMessageDialog(null, "Pdf gnerated");
					doc.close();
					
					
					
				}catch(Exception e1) {
					System.out.println("Bill print"+e1);
				}
			}
		});
		lblNewLabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String type=comboBox_3.getSelectedItem().toString();
				String d=comboBox_2_1.getSelectedItem().toString();
				String m=comboBox_2_1_1.getSelectedItem().toString();
				String y=comboBox_2_1_1_1.getSelectedItem().toString();
				String date=d+"/"+m+"/"+"/"+y;
				int num=Integer.parseInt(comboBox_2.getSelectedItem().toString());
				String name=textField.getText();
				String email=textField_1.getText();
				String number=textField_4.getText();
				backend.Booking b=new backend.Booking(name,email,number,date,type,num);
				b.BookingDataStore_reg();
				JOptionPane.showMessageDialog(null,"Request sent");
				
			}
		});
		
		
	}
}
