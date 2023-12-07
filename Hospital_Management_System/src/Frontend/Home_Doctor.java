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

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Home_Doctor extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Doctor frame = new Home_Doctor();
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
	public Home_Doctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 383, 863);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();

		panel_1.setBackground(new Color(128, 255, 255));
		panel_1.setBounds(0, 206, 383, 88);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/icons8-hospital-64.png")));
		lblNewLabel_1.setBounds(10, 11, 77, 66);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setBounds(97, 11, 244, 66);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/resized.png")));
		lblNewLabel.setBounds(75, 11, 181, 184);
		panel.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();

		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1.setBounds(0, 340, 383, 88);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/1564534_customer_man_user_account_profile_icon.png")));
		lblNewLabel_1_1.setBounds(10, 11, 77, 66);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Profile");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1.setBounds(97, 11, 244, 66);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1.setBounds(0, 481, 383, 88);
		panel.add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/icons8-view-schedule-50.png")));
		lblNewLabel_1_1_1.setBounds(10, 11, 77, 66);
		panel_1_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Scedules");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1.setBounds(97, 11, 244, 66);
		panel_1_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(128, 255, 255));
		panel_1_1_1_1.setBounds(0, 628, 383, 88);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/icons8-card-payment-80.png")));
		lblNewLabel_1_1_1_1.setBounds(10, 11, 77, 66);
		panel_1_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Payment");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_1_1_1.setBounds(97, 11, 244, 66);
		panel_1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("@ right reserved");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_3.setBounds(25, 821, 240, 31);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setBounds(381, 0, 1205, 160);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("United Hospital");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2.setBounds(484, 11, 244, 66);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("United Hospital");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2_1.setBounds(77, 69, 244, 66);
		panel_2.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Emergency:02-212219");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2_1_1.setBounds(379, 69, 333, 66);
		panel_2.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Hot_line:02-128766");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2_2_1_1_1.setBounds(892, 69, 286, 66);
		panel_2.add(lblNewLabel_2_2_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(852, 129, 216, 31);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login p=new Login();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(1077, 133, 118, 27);
		panel_2.add(btnNewButton_1);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(381, 140, 1205, 723);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_5.setBounds(316, 93, 513, 178);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/image/pexels-gradienta-6985276.jpg")));
		lblNewLabel_4.setBounds(0, -12, 1200, 707);
		panel_3.add(lblNewLabel_4);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(255, 255, 255, 128));
		panel_8.setBounds(274, 0, 576, 695);
		panel_4.add(panel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Profile");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblNewLabel_7.setBounds(187, 11, 190, 66);
		panel_8.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/icons8-male-user-96.png")));
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
		lblNewLabel_11.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/button (5).png")));
		lblNewLabel_11.setBounds(175, 596, 243, 52);
		panel_8.add(lblNewLabel_11);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Home_Doctor.class.getResource("/Frontend/Image/3150060.jpg")));
		lblNewLabel_6.setBounds(0, 0, 1200, 695);
		panel_4.add(lblNewLabel_6);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(164, 191, 219));
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(1.0f,1.0f,1.0f,0.3f));
		panel_7.setBounds(364, 0, 463, 695);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Set Scedules", "Check Scedules"}));
		comboBox.setBounds(81, 60, 218, 56);
		panel_7.add(comboBox);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 152, 443, 532);
		panel_7.add(tabbedPane_1);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_1.addTab("New tab", null, panel_9, null);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Date    :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_10.setBounds(10, 74, 101, 41);
		panel_9.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Time    :");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_10_1.setBounds(10, 154, 101, 41);
		panel_9.add(lblNewLabel_10_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 255, 255)));
		comboBox_1.setBounds(125, 73, 178, 42);
		panel_9.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 255, 255)));
		comboBox_1_1.setBounds(125, 154, 178, 48);
		panel_9.add(comboBox_1_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 255, 255));
		tabbedPane_1.addTab("New tab", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 128));
		tabbedPane.addTab("New tab", null, panel_6, null);
		panel_6.setLayout(null);
		
		final JButton btnNewButton = new JButton("Download");

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(395, 592, 252, 63);
		panel_6.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("No. of patients :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_12.setBounds(90, 70, 193, 49);
		panel_6.add(lblNewLabel_12);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(305, 70, 119, 49);
		panel_6.add(textField_5);
		textField_5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 203, 971, 332);
		panel_6.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Previous Patients");
	
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(448, 127, 203, 50);
		panel_6.add(btnNewButton_2);
		
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
		panel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
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
                    Paragraph p=new Paragraph("United Hospital",FontFactory.getFont(FontFactory.TIMES_BOLD,25,Font.ITALIC,BaseColor.GRAY));
                    p.setAlignment(Element.ALIGN_CENTER);
                   
                    
                    doc.add(p);
                    PdfPTable tbl=new PdfPTable(6);
                    //tbl.setWidths(new int[]{10,10});
                    
                    Image image= Image.getInstance("C:\\Users\\shahabuddin akhon hr\\Eclipse(new)_marketplace\\Hospital_Management_System\\resized.png");
                    PdfPCell cell1=new PdfPCell(image);
                    cell1.setColspan(0);
                    cell1.setBorder(0);
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tbl.addCell(cell1);
                    
                    
                    PdfPCell cell21=new PdfPCell(new Paragraph(""));
                    cell21.setColspan(4);
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

                    doc.add(new Paragraph("****************************************************",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.ITALIC,BaseColor.GRAY)));
                    doc.add(new Paragraph(" "));                   
                    doc.add(new Paragraph("                               Doctor Name   : "+textField.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
                    doc.add(new Paragraph("                               Birthdate         : "+textField_4.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
                    doc.add(new Paragraph("                               Number           : "+textField_2.getText(),FontFactory.getFont(FontFactory.TIMES_BOLD,15,Font.ITALIC,BaseColor.DARK_GRAY)));
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
                    
                    
                    PdfPCell cell4=new PdfPCell(new Paragraph("Appointment Bill -\n"));
                    cell4.setColspan(2);
                    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tb3.addCell(cell4);
                    
                    PdfPCell cell5=new PdfPCell(new Paragraph("--\n\n"));
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
                    PdfPCell cel3=new PdfPCell(new Paragraph("Doctor's Sign"));
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});

	}
}

