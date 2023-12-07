package Frontend;


import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.sql.RowSetMetaData;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.*;
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

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import backend.Admin;
import backend.Admin.Schedule;
import backend.Booking;
import backend.Doctor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Home_Admin extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	private JTable table;
	private JTable table_1;
	
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_2;
	int icu,ccu,nicu,cabin;
	int icu_counter=0,nicu_counter=0,ccu_counter=0,cabin_counter=0;
	private JTextField textField_10;
	
	
	ArrayList<String> doctorName=new ArrayList<>();
	//Schedule sc=new Admin().new Schedule();
	Admin admin=new Admin();
	Schedule sc=admin.new Schedule();
	String dept;
	//String notSelectedDay;
	ArrayList<String>notSelectedDay;
	String docName;
	String holl;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Admin frame = new Home_Admin();
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
	public Home_Admin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		Toolkit toolkit=getToolkit();
		Dimension size = toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(381, 0, 1205, 157);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(0, 128, 128));
		
		JLabel lblNewLabel_2_3 = new JLabel("United");
		lblNewLabel_2_3.setFont(new Font("Dutch801 XBd BT", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_3.setBounds(290, 27, 301, 47);
		panel_1_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hospital Ltd.");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(274, 59, 317, 47);
		panel_1_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Anytime at Your Service ");
		lblNewLabel_4_1.setFont(new Font("Brush Script MT", Font.BOLD, 22));
		lblNewLabel_4_1.setBounds(255, 102, 249, 51);
		panel_1_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Hotline :");
		lblNewLabel_5_1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(1076, 75, 71, 20);
		panel_1_2.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("11606");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(1140, 70, 55, 20);
		panel_1_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Emergency :");
		lblNewLabel_7_1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblNewLabel_7_1.setBounds(1005, 102, 86, 20);
		panel_1_2.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("01912345678");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(1093, 90, 102, 34);
		panel_1_2.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("uhospital08@gmail.com");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9_2.setBounds(1027, 126, 168, 20);
		panel_1_2.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_10_2 = new JLabel("");
		lblNewLabel_10_2.setBounds(657, 106, 39, 24);
		panel_1_2.add(lblNewLabel_10_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 383, 863);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(0, 219, 383, 88);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/icons8-hospital-64.png")));
		lblNewLabel_1.setBounds(10, 11, 77, 66);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setBounds(97, 11, 244, 66);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/resized.png")));
		lblNewLabel.setBounds(75, 11, 181, 184);
		panel.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1.setBounds(0, 334, 383, 79);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/1564534_customer_man_user_account_profile_icon.png")));
		lblNewLabel_1_1.setBounds(0, 11, 77, 66);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Profile");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1.setBounds(97, 11, 244, 66);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1.setBounds(0, 434, 383, 79);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/icons8-add-new-100.png")));
		lblNewLabel_1_1_1.setBounds(0, 11, 102, 66);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Add");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1.setBounds(97, 11, 244, 66);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1.setBounds(0, 726, 383, 72);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/rsz_bill.png")));
		lblNewLabel_1_1_1_1.setBounds(10, 11, 77, 66);
		panel_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Bill Genarator");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1_1.setBounds(97, 11, 244, 66);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("@ right reserved");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_3.setBounds(25, 821, 240, 31);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(new Color(128, 255, 255));
		panel_1_1_1_2.setBounds(0, 535, 383, 72);
		panel.add(panel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/icons8-view-schedule-50.png")));
		lblNewLabel_1_1_1_2.setBounds(10, 11, 77, 66);
		panel_1_1_1_2.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Set Schedules");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1_2.setBounds(97, 11, 276, 66);
		panel_1_1_1_2.add(lblNewLabel_2_1_1_2);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1_1.setBounds(0, 631, 383, 72);
		panel.add(panel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/image/icons8-fund-flow-64.png")));
		lblNewLabel_1_1_1_1_1.setBounds(10, 11, 77, 66);
		panel_1_1_1_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Resources");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1_1_1.setBounds(97, 11, 244, 66);
		panel_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(381, 134, 1205, 729);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 128, 128));
		panel_3_1.setBounds(1021, 0, 179, 702);
		panel_3.add(panel_3_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("Why US?");
		lblNewLabel_11_1.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblNewLabel_11_1.setBounds(44, 328, 98, 40);
		panel_3_1.add(lblNewLabel_11_1);
		
		JLabel lblNewLabel_12 = new JLabel("*24 hour service");
		lblNewLabel_12.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_12.setBackground(new Color(210, 210, 210));
		lblNewLabel_12.setBounds(20, 378, 159, 40);
		panel_3_1.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13_1 = new JLabel("*Online Appointment");
		lblNewLabel_13_1.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_13_1.setBounds(20, 428, 159, 41);
		panel_3_1.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_14 = new JLabel("*Qualified Doctor\r\n\r\n");
		lblNewLabel_14.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_14.setBounds(20, 479, 159, 40);
		panel_3_1.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("*Emergency Service");
		lblNewLabel_15.setFont(new Font("Segoe Print", Font.BOLD, 14));
		lblNewLabel_15.setBounds(20, 529, 159, 40);
		panel_3_1.add(lblNewLabel_15);
		
		JButton btnNewButton_2_1 = new JButton("About Us");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(32, 637, 123, 31);
		panel_3_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_5 = new JButton("Log Out");
		btnNewButton_5.setBounds(44, 36, 113, 34);
		panel_3_1.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login n=new Login();
				n.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/image/vivid-blurred-colorful-wallpaper-background (1).jpg")));
		lblNewLabel_4.setBounds(0, 0, 1200, 702);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 255, 255, 128));
		panel_8.setBounds(314, 11, 576, 687);
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Profile");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel_7.setBounds(187, 11, 190, 66);
		panel_8.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/icons8-male-user-96.png")));
		lblNewLabel_8.setBounds(216, 70, 101, 109);
		panel_8.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Name       :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9.setBounds(20, 197, 126, 52);
		panel_8.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 22));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 255)));
		textField.setBounds(152, 197, 372, 52);
		panel_8.add(textField);
		
		JLabel lblNewLabel_9_1 = new JLabel("Email       :");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1.setBounds(20, 264, 126, 52);
		panel_8.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Number    :");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1_1.setBounds(20, 344, 126, 52);
		panel_8.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Gender    :");
		lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_9_1_1_1.setBounds(20, 429, 126, 52);
		panel_8.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Birthdate :");
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
		
		//showinProfile();

		
		
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/button (7).png")));
		lblNewLabel_11.setBounds(263, 600, 130, 52);
		panel_8.add(lblNewLabel_11);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/Image/3150060.jpg")));
		lblNewLabel_6.setBounds(0, 0, 1200, 709);
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(124, 185, 214));
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(1.0f,1.0f,1.0f,0.2f));
		panel_9.setBounds(135, 0, 837, 702);
		panel_5.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add Doctor");
		
		
		btnNewButton_1.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/image/icons8-add-male-user-group-50.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(186, 38, 220, 168);
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Admin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Admin frame = new Add_Admin();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/image/icons8-add-48.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(445, 38, 220, 168);
		panel_9.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 226, 817, 380);
		panel_9.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		

		lblNewLabel_5.setIcon(new ImageIcon(Home_Admin.class.getResource("/Frontend/image/button (10).png")));
		lblNewLabel_5.setBounds(464, 635, 135, 56);
		panel_9.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(144, 635, 282, 56);
		panel_9.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 128, 0));
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField_5.getText();
				Doctor pp=new Doctor();
				pp.setName(name);
				Doctor a=pp.finddata();
				a.storingData_n();
//				a.deleteData();
			}
		});
		//*******************************
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(106, 42, 932, 639);
		panel_6.add(panel_10);
		
		JLabel lblNewLabel_51 = new JLabel("Department: ");
		lblNewLabel_51.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_51.setBounds(125, 47, 240, 46);
		panel_10.add(lblNewLabel_51);
		
		final JComboBox deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"General", "Cardiology", "Radiologist", "Pediatrician", "Medicine", "Neurology", "Dermatology", "Surgeon", "Urologist", "Gynacologist"}));
		deptComboBox.setFont(new Font("Tahoma", Font.BOLD, 20));
		deptComboBox.setBounds(450, 49, 278, 46);
		panel_10.add(deptComboBox);
		
		final DefaultListModel<String> model=new DefaultListModel<>();
		
		
		deptComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!model.isEmpty()) {
					model.clear();
				}
				dept=deptComboBox.getSelectedItem().toString();
				doctorName=sc.getDoctorByDept(dept);
//				doctorName.forEach(n->{
//					model.addElement(n);
//				});
				for(String n:doctorName) {
					model.addElement(n);
				}
			}
		});
		
		JLabel lblDoctorList = new JLabel("Doctor List:");
		lblDoctorList.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoctorList.setBounds(125, 145, 240, 46);
		panel_10.add(lblDoctorList);
		
		final JList<String> doctorList = new JList<String>();
		
		doctorList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					docName=doctorList.getSelectedValue();
					//JOptionPane.showMessageDialog(null, docName);
				}
			}
		});
		
		doctorList.setFont(new Font("Tahoma", Font.BOLD, 16));
		doctorList.setBackground(SystemColor.menu);
		doctorList.setBounds(450, 135, 270, 188);
		doctorList.setModel(model);
		panel_10.add(doctorList);
		
		JLabel lblShift = new JLabel("Shift:");
		lblShift.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblShift.setBounds(125, 325, 240, 46);
		panel_10.add(lblShift);
		
		final JRadioButton shift1 = new JRadioButton("1");
		buttonGroup.add(shift1);
		shift1.setFont(new Font("Tahoma", Font.BOLD, 20));
		shift1.setBounds(458, 341, 52, 21);
		panel_10.add(shift1);
		
		final JRadioButton shift2 = new JRadioButton("2");
		buttonGroup.add(shift2);
		shift2.setFont(new Font("Tahoma", Font.BOLD, 20));
		shift2.setBounds(555, 341, 52, 21);
		panel_10.add(shift2);
		
		final JRadioButton shift3 = new JRadioButton("3");
		buttonGroup.add(shift3);
		shift3.setFont(new Font("Tahoma", Font.BOLD, 20));
		shift3.setBounds(654, 341, 52, 21);
		panel_10.add(shift3);
		
		JLabel lblDaysToWork = new JLabel("Days to work:");
		lblDaysToWork.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDaysToWork.setBounds(124, 379, 240, 46);
		panel_10.add(lblDaysToWork);
		
		JButton btnSet = new JButton("Set");
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSet.setBounds(390, 583, 166, 46);
		panel_10.add(btnSet);
		
		final JToggleButton satToggle = new JToggleButton("Sat");
		satToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		satToggle.setBackground(new Color(64, 128, 128));
		satToggle.setBounds(444, 399, 91, 68);
		panel_10.add(satToggle);
		
		final JToggleButton sunToggle = new JToggleButton("Sun");
		sunToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sunToggle.setBackground(new Color(64, 128, 128));
		sunToggle.setBounds(545, 399, 91, 68);
		panel_10.add(sunToggle);
		
		final JToggleButton monToggle = new JToggleButton("Mon");
		monToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monToggle.setBackground(new Color(64, 128, 128));
		monToggle.setBounds(644, 399, 91, 68);
		panel_10.add(monToggle);
		
		final JToggleButton tuesToggle = new JToggleButton("Tues");
		tuesToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tuesToggle.setBackground(new Color(64, 128, 128));
		tuesToggle.setBounds(745, 399, 91, 68);
		panel_10.add(tuesToggle);
		
		final JToggleButton wedToggle = new JToggleButton("Wed");
		wedToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		wedToggle.setBackground(new Color(64, 128, 128));
		wedToggle.setBounds(444, 477, 91, 68);
		panel_10.add(wedToggle);
		
		final JToggleButton thursToggle = new JToggleButton("Thurs");
		thursToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		thursToggle.setBackground(new Color(64, 128, 128));
		thursToggle.setBounds(545, 477, 91, 68);
		panel_10.add(thursToggle);
		
		final JToggleButton friToggle = new JToggleButton("Fri");
		friToggle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		friToggle.setBackground(new Color(64, 128, 128));
		friToggle.setBounds(644, 477, 91, 68);
		panel_10.add(friToggle);
		
		notSelectedDay=new ArrayList<>();
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!satToggle.isSelected()) {
					if(!notSelectedDay.contains(satToggle.getText())) {
						notSelectedDay.add(satToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(satToggle.getText());
				}
				if(!sunToggle.isSelected()) {
					if(!notSelectedDay.contains(sunToggle.getText())) {
						notSelectedDay.add(sunToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(sunToggle.getText());
				}
				if(!monToggle.isSelected()) {
					if(!notSelectedDay.contains(monToggle.getText())) {
						notSelectedDay.add(monToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(monToggle.getText());
				}
				if(!tuesToggle.isSelected()) {
					if(!notSelectedDay.contains(tuesToggle.getText())) {
						notSelectedDay.add(tuesToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(tuesToggle.getText());
				}
				if(!wedToggle.isSelected()) {
					if(!notSelectedDay.contains(wedToggle.getText())) {
						notSelectedDay.add(wedToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(wedToggle.getText());
				}
				if(!thursToggle.isSelected()) {
					if(!notSelectedDay.contains(thursToggle.getText())) {
						notSelectedDay.add(thursToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(thursToggle.getText());
				}
				if(!friToggle.isSelected()) {
					if(!notSelectedDay.contains(friToggle.getText())) {
						notSelectedDay.add(friToggle.getText());
					}
				}
				else {
					notSelectedDay.remove(friToggle.getText());
				}
				
				shift1.setActionCommand("1");
				shift2.setActionCommand("2");
				shift3.setActionCommand("3");
				
				String shift=buttonGroup.getSelection().getActionCommand();
				sc.setSchedule(shift, docName, dept, notSelectedDay);
				
			}
		});
		
		JLabel lblNewLabel_1_2 = new JLabel("(Double click to select)");
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(450, 105, 270, 21);
		panel_10.add(lblNewLabel_1_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(114, 181, 190));
		tabbedPane.addTab("New tab", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_101 = new JPanel();
		panel_101.setBackground(new Color(0, 128, 128));
		panel_101.setBounds(58, 51, 220, 608);
		panel_7.add(panel_101);
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setBackground(new Color(0, 128, 128));
		panel_10_1.setBounds(944, 38, 220, 608);
		panel_7.add(panel_10_1);
		
		final JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(316, 27, 603, 632);
		panel_7.add(tabbedPane_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(192, 192, 192));
		tabbedPane_1.addTab("Set Number of Bed", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("ICU Beds     :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_10.setBounds(30, 52, 171, 44);
		panel_11.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("CCU Beds     :");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_10_1.setBounds(30, 143, 148, 44);
		panel_11.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("NICU Beds     :");
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_10_1_1.setBounds(30, 235, 148, 44);
		panel_11.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("Cebin          :");
		lblNewLabel_10_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_10_1_1_1.setBounds(30, 339, 148, 44);
		panel_11.add(lblNewLabel_10_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(232, 52, 278, 44);
		panel_11.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(232, 143, 278, 44);
		panel_11.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(232, 251, 278, 44);
		panel_11.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(232, 355, 278, 44);
		panel_11.add(textField_9);
		
		JButton btnNewButton_3 = new JButton("Set");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				icu=Integer.parseInt(textField_6.getText());
				ccu=Integer.parseInt(textField_7.getText());
				nicu=Integer.parseInt(textField_8.getText());
				cabin=Integer.parseInt(textField_9.getText());
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(160, 451, 181, 51);
		panel_11.add(btnNewButton_3);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(192, 192, 192));
		tabbedPane_1.addTab("Resource allocation", null, panel_13, null);
		panel_13.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 85, 578, 372);
		panel_13.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton_4 = new JButton("Check");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_2.setModel(new DefaultTableModel());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					Statement ppt= con.createStatement();
					String sql="select * from booking_reg";
					ResultSet result=ppt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd= result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table_2.getModel();
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					for(int i=0;i<cols;i++)
					{
						colName[i]=rsmd.getColumnName(i+1);

					}
					model.setColumnIdentifiers(colName);
					
					String a,b,c,d,l,f,g,h,i;
					while(result.next())
					{
						a=result.getString(1);
						b=result.getString(2);
						c=result.getString(3);
						d=result.getString(4);
						l=result.getString(5);
						f=result.getString(6);
						g=result.getString(7);
						
						String row[]= {a,b,c,l,f,g};
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
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(157, 11, 206, 48);
		panel_13.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Add");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int a=Integer.parseInt(textField_10.getText().toString());
				String a=textField_10.getText().toString();
				Booking b= new Booking();
				b.setName(a);
				Booking c=b.finddata();
				if(c.getBedtype()=="icu")
				{
					if(icu_counter<icu) {
						icu_counter++;
	
					}
				}
				else if(c.getBedtype()=="ccu") {
					if(ccu_counter <ccu) {
						ccu_counter++;
					}
				}
				else if(c.getBedtype()=="nicu") {
					if(nicu_counter <nicu) {
						nicu_counter++;
					}
				}
				else if(c.getBedtype()=="cabin") {
					if(cabin_counter <cabin) {
						cabin_counter++;
					}
				}


				
			}
		});
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4_1.setBounds(365, 468, 177, 48);
		panel_13.add(btnNewButton_4_1);
		
		textField_10 = new JTextField();
		textField_10.setBounds(51, 468, 286, 55);
		panel_13.add(textField_10);
		textField_10.setColumns(10);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 128, 255));
		panel_12.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		tabbedPane.addTab("New tab", null, panel_12, null);
		panel_12.setLayout(null);
		
		final JComboBox comboBox_1 = new JComboBox();

		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Choose", "For Patients", "For Doctors"}));
		comboBox_1.setBounds(404, 28, 322, 62);
		panel_12.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 140, 1075, 439);
		panel_12.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		final JButton btnNewButton = new JButton("Download");

		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(457, 616, 269, 56);
		panel_12.add(btnNewButton);
		
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		panel_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
///show in table
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s =comboBox_1.getSelectedItem().toString();
				
				if(s=="For Patients")
				{
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
				else if(s=="For Doctors") {
					table.setModel(new DefaultTableModel());
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
						Statement ppt= con.createStatement();
						String sql="select * from doctor";
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
				else
				{
					table.setModel(new DefaultTableModel());
				}


				
			}
		});
///make pdf
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String path="";
					JFileChooser j=new JFileChooser();
					j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int x=j.showSaveDialog(btnNewButton);
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
                    doc.add(new Paragraph("                               Patient Name   : "+textField.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.LIGHT_GRAY)));
                    doc.add(new Paragraph("                               Birthdate         : "+textField_4.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.LIGHT_GRAY)));
                    doc.add(new Paragraph("                               Number           : "+textField_2.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.LIGHT_GRAY)));
                    doc.add(new Paragraph(" "));
                    PdfPTable tb3=new PdfPTable(8);
                    PdfPCell cell=new PdfPCell(new Paragraph("Invoice"));
                    cell.setColspan(8);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.GREEN);
                    tb3.addCell(cell);
                    doc.add(tb3);
                    
                    
                  int col=table.getColumnCount();
                  
                  PdfPTable tb6=new PdfPTable(col);
                  int row=table.getRowCount();
                  tb6.addCell("ID");
                  tb6.addCell("Name");
                  tb6.addCell("E-mail");
                  //tbl.addCell("Password");
                  tb6.addCell("Number");
                  tb6.addCell("Gender");
                  tb6.addCell("Birthday");
                  tb6.addCell("Age");
                  tb6.addCell("Address");
                  //System.out.println(col+"  "+row);//8 2
                  for(int i=0;i<row;i++)
                  {
                  	for(int k=0;k<col;k++)
                  	{
                  		String A=table.getValueAt(i,k).toString();
                  		System.out.println(A);
                  		tb6.addCell(A);
                  	}
                  	doc.add(tb6);
                  }
                  
                  
                  
					doc.add(tb6);

                    JOptionPane.showMessageDialog(null, "Pdf gnerated");
					doc.close();
					
					
					
				}catch(Exception e1) {
					System.out.println("Bill print"+e1);
				}
				
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table_1.setModel(new DefaultTableModel());
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
					Statement ppt= con.createStatement();
					String sql="select * from doctor";
					ResultSet result=ppt.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd= result.getMetaData();
					DefaultTableModel model =(DefaultTableModel) table_1.getModel();
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
		
		lblNewLabel_51.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField_5.getText();
				Doctor d=new Doctor();
				d.setName(name);
				//d.insertDatabase();
				d.deleteData();
				
			}
		});


	}

	
	//System.out.println(b.getName());
	public void showinProfile(Admin b)
	{
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
//			Statement ppt= con.createStatement();
//			String sql="select * from admin where email='"+b.getEmail()+"'";
//			ResultSet result=ppt.executeQuery(sql);
//			if(result.next())
//			{
//				
//			}
			textField.setText(b.getName());
			textField_1.setText(b.getEmail());
			textField_2.setText(b.getNumber());
			textField_3.setText(b.getGender());
			textField_4.setText(b.getBirthdate());
			
			
		}catch(Exception e1)
		{
			System.out.println("Showin Profile: "+e1);
		}
	}
}


