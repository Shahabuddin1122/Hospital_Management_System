package Frontend;

import backend.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField_1;
	private JTextField textField_7;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JPasswordField passwordField_2;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 128, 255));
		panel_6.setBounds(320, 0, 1266, 100);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_4_2 = new JLabel("United Hospital");
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4_2.setBounds(458, 11, 214, 43);
		panel_6.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_2_1 = new JLabel("Hotline  : 02-12335");
		lblNewLabel_4_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4_2_1.setBounds(986, 46, 270, 43);
		panel_6.add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_2_1_1 = new JLabel("Emergency:02-466555");
		lblNewLabel_4_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_4_2_1_1.setBounds(10, 46, 313, 43);
		panel_6.add(lblNewLabel_4_2_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 320, 863);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registration as.....");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(36, 202, 210, 54);
		panel.add(lblNewLabel);

		final JComboBox comboBox = new JComboBox();


		comboBox.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Patients", "Doctor"}));
		comboBox.setBounds(31, 267, 215, 54);
		panel.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/icons8-write-64.png")));
		lblNewLabel_1.setBounds(31, 398, 231, 389);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/resized.png")));
		lblNewLabel_2.setBounds(36, 36, 176, 155);
		panel.add(lblNewLabel_2);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(318, 79, 1268, 784);
		contentPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBounds(292, 42, 188, 185);
		panel_1.add(lblNewLabel_3_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 255, 255));
		panel_4.setBounds(700, 11, 525, 734);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 505, 712);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Sign Up");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(170, 28, 214, 43);
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Name        :");
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1.setBounds(10, 111, 129, 43);
		panel_5.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_1_1 = new JLabel("E-mail       :");
		lblNewLabel_4_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1.setBounds(10, 189, 129, 43);
		panel_5.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("Address    :");
		lblNewLabel_4_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1.setBounds(10, 267, 129, 43);
		panel_5.add(lblNewLabel_4_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("BirthDate  :");
		lblNewLabel_4_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1.setBounds(10, 343, 140, 43);
		panel_5.add(lblNewLabel_4_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Number     :");
		lblNewLabel_4_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1.setBounds(10, 420, 129, 43);
		panel_5.add(lblNewLabel_4_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Password  :");
		lblNewLabel_4_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(10, 562, 140, 43);
		panel_5.add(lblNewLabel_4_1_1_1_1_1_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1_1 = new JLabel("Gender      :");
		lblNewLabel_4_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1_1.setBounds(10, 494, 140, 43);
		panel_5.add(lblNewLabel_4_1_1_1_1_1_1_1);

		textField = new JTextField();
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField.setText("");
		textField.setBounds(144, 111, 295, 43);
		panel_5.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_1.setBounds(144, 189, 295, 43);
		panel_5.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_2.setBounds(144, 267, 295, 43);
		panel_5.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_3.setBounds(144, 343, 295, 43);
		panel_5.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_4.setBounds(144, 420, 295, 43);
		panel_5.add(textField_4);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnNewRadioButton.setBounds(148, 509, 86, 23);
		panel_5.add(rdbtnNewRadioButton);

		final JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnFemale.setBounds(236, 509, 111, 23);
		panel_5.add(rdbtnFemale);

		final JRadioButton rdbtnOther = new JRadioButton("Others");
		buttonGroup.add(rdbtnOther);
		rdbtnOther.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnOther.setBounds(364, 509, 111, 23);
		panel_5.add(rdbtnOther);

		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		passwordField.setBounds(160, 562, 295, 43);
		panel_5.add(passwordField);

//		JLabel lblNewLabel_5 = new JLabel("");
//		lblNewLabel_5.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/button (4).png")));
//		lblNewLabel_5.setBounds(156, 638, 214, 51);
//		panel_5.add(lblNewLabel_5);




		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/26835-removebg-preview.png")));
		lblNewLabel_7.setBounds(0, 0, 690, 745);
		panel_1.add(lblNewLabel_7);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.CYAN);
		panel_4_1.setBounds(728, 11, 525, 734);
		panel_2.add(panel_4_1);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBounds(10, 11, 505, 712);
		panel_4_1.add(panel_5_1);

		JLabel lblNewLabel_4_3 = new JLabel("Sign Up");
		lblNewLabel_4_3.setForeground(Color.BLACK);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_3.setBounds(170, 28, 214, 43);
		panel_5_1.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_1_2 = new JLabel("Name        :");
		lblNewLabel_4_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_2.setBounds(10, 111, 129, 43);
		panel_5_1.add(lblNewLabel_4_1_2);

		JLabel lblNewLabel_4_1_1_2 = new JLabel("E-mail       :");
		lblNewLabel_4_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_2.setBounds(10, 189, 129, 43);
		panel_5_1.add(lblNewLabel_4_1_1_2);

		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Dept         :");
		lblNewLabel_4_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_2.setBounds(10, 267, 129, 43);
		panel_5_1.add(lblNewLabel_4_1_1_1_2);

		JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("BirthDate  :");
		lblNewLabel_4_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_2.setBounds(10, 343, 140, 43);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_2);

		JLabel lblNewLabel_4_1_1_1_1_1_2 = new JLabel("Number     :");
		lblNewLabel_4_1_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_2.setBounds(10, 420, 129, 43);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_1_2);

		JLabel lblNewLabel_4_1_1_1_1_1_1_2 = new JLabel("Password  :");
		lblNewLabel_4_1_1_1_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1_2.setBounds(10, 562, 140, 43);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_1_1_2);

		JLabel lblNewLabel_4_1_1_1_1_1_1_1_1 = new JLabel("Gender      :");
		lblNewLabel_4_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1_1_1.setBounds(10, 494, 140, 43);
		panel_5_1.add(lblNewLabel_4_1_1_1_1_1_1_1_1);

		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_5.setBounds(144, 111, 295, 43);
		panel_5_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_6.setBounds(144, 189, 295, 43);
		panel_5_1.add(textField_6);

		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_8.setBounds(144, 343, 295, 43);
		panel_5_1.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setText("");
		textField_9.setColumns(10);
		textField_9.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_9.setBounds(144, 420, 295, 43);
		panel_5_1.add(textField_9);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Male");
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnNewRadioButton_1.setBounds(148, 509, 86, 23);
		panel_5_1.add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnFemale_1 = new JRadioButton("Female");
		buttonGroup_1.add(rdbtnFemale_1);
		rdbtnFemale_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnFemale_1.setBounds(236, 509, 111, 23);
		panel_5_1.add(rdbtnFemale_1);

		final JRadioButton rdbtnOther_1 = new JRadioButton("Others");
		buttonGroup_1.add(rdbtnOther_1);
		rdbtnOther_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnOther_1.setBounds(364, 509, 111, 23);
		panel_5_1.add(rdbtnOther_1);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		passwordField_1.setBounds(160, 562, 295, 43);
		panel_5_1.add(passwordField_1);

		JLabel lblNewLabel_5_1 = new JLabel("");
		
		lblNewLabel_5_1.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/button (4).png")));
		lblNewLabel_5_1.setBounds(156, 638, 214, 51);
		panel_5_1.add(lblNewLabel_5_1);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Medicine", "Neurology", "Surgeon", "Psychiatrist", "Pediatrics", "Radiologist", "Cardiologist", "Urologist", "Dermatology", "Gynaecology", "Dentist"}));
		comboBox_1.setBounds(144, 262, 235, 48);
		panel_5_1.add(comboBox_1);
		
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNewRadioButton_1.setActionCommand("Male");
				rdbtnFemale_1.setActionCommand("Female");
				rdbtnOther_1.setActionCommand("Others");
				String gender=buttonGroup_1.getSelection().getActionCommand();
				//String dept=comboBox_1.getSelectedItem();
				Doctor p1=new Doctor(textField_5.getText(),textField_6.getText(),new String(passwordField_1.getPassword()),textField_9.getText(),gender,textField_8.getText(),(String)comboBox_1.getSelectedItem());
				if(p1.checkData()) {
					p1.storingData();
					JOptionPane.showMessageDialog(null, "Registration is done!");
					Login login=new Login();
					login.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Account already exist!");
					dispose();
				}
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(317, 49, 188, 185);
		panel_2.add(lblNewLabel_3_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/26835-removebg-preview.png")));
		lblNewLabel_6.setBounds(0, 0, 718, 745);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		lblNewLabel_3_2_1.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/image/output-onlinegiftools.gif")));
		lblNewLabel_3_2_1.setBounds(249, 49, 188, 185);
		panel_2.add(lblNewLabel_3_2_1);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBackground(Color.CYAN);
		panel_4_1_1.setBounds(716, 11, 525, 734);
		panel_3.add(panel_4_1_1);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBounds(10, 11, 505, 712);
		panel_4_1_1.add(panel_5_1_1);

		JLabel lblNewLabel_4_3_1 = new JLabel("Sign Up");
		lblNewLabel_4_3_1.setForeground(Color.BLACK);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_3_1.setBounds(170, 28, 214, 43);
		panel_5_1_1.add(lblNewLabel_4_3_1);

		JLabel lblNewLabel_4_1_2_1 = new JLabel("Name        :");
		lblNewLabel_4_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_2_1.setBounds(10, 111, 129, 43);
		panel_5_1_1.add(lblNewLabel_4_1_2_1);

		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("E-mail       :");
		lblNewLabel_4_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_2_1.setBounds(10, 189, 129, 43);
		panel_5_1_1.add(lblNewLabel_4_1_1_2_1);

		JLabel lblNewLabel_4_1_1_1_1_2_1 = new JLabel("BirthDate  :");
		lblNewLabel_4_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_2_1.setBounds(10, 263, 140, 43);
		panel_5_1_1.add(lblNewLabel_4_1_1_1_1_2_1);

		JLabel lblNewLabel_4_1_1_1_1_1_2_1 = new JLabel("Number     :");
		lblNewLabel_4_1_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_2_1.setBounds(10, 340, 129, 43);
		panel_5_1_1.add(lblNewLabel_4_1_1_1_1_1_2_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1_2_1 = new JLabel("Password  :");
		lblNewLabel_4_1_1_1_1_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1_2_1.setBounds(10, 482, 140, 43);
		panel_5_1_1.add(lblNewLabel_4_1_1_1_1_1_1_2_1);

		JLabel lblNewLabel_4_1_1_1_1_1_1_1_1_1 = new JLabel("Gender      :");
		lblNewLabel_4_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_4_1_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_1_1_1_1_1_1_1_1_1.setBounds(10, 414, 140, 43);
		panel_5_1_1.add(lblNewLabel_4_1_1_1_1_1_1_1_1_1);

		textField_7 = new JTextField();
		textField_7.setText("");
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_7.setBounds(144, 111, 295, 43);
		panel_5_1_1.add(textField_7);

		textField_10 = new JTextField();
		textField_10.setText("");
		textField_10.setColumns(10);
		textField_10.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_10.setBounds(144, 189, 295, 43);
		panel_5_1_1.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setText("");
		textField_11.setColumns(10);
		textField_11.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_11.setBounds(144, 263, 295, 43);
		panel_5_1_1.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setText("");
		textField_12.setColumns(10);
		textField_12.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_12.setBounds(144, 340, 295, 43);
		panel_5_1_1.add(textField_12);

		final JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Male");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnNewRadioButton_1_1.setBounds(148, 429, 86, 23);
		panel_5_1_1.add(rdbtnNewRadioButton_1_1);

		final JRadioButton rdbtnFemale_1_1 = new JRadioButton("Female");
		rdbtnFemale_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnFemale_1_1.setBounds(236, 429, 111, 23);
		panel_5_1_1.add(rdbtnFemale_1_1);

		final JRadioButton rdbtnOther_1_1 = new JRadioButton("Others");
		rdbtnOther_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnOther_1_1.setBounds(364, 429, 111, 23);
		panel_5_1_1.add(rdbtnOther_1_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		passwordField_2.setBounds(160, 482, 295, 43);
		panel_5_1_1.add(passwordField_2);

		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/image/button (9).png")));
		lblNewLabel_5_1_1.setBounds(175, 638, 140, 51);
		panel_5_1_1.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/output-onlinegiftools.gif")));
		lblNewLabel_3.setBounds(224, 11, 188, 185);
		panel_3.add(lblNewLabel_3);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s =comboBox.getSelectedItem().toString();
				if(s=="Doctor") {
					tabbedPane.setSelectedIndex(1);
				}
				else if(s=="Admin") {
					tabbedPane.setSelectedIndex(2);				}
				else {
					tabbedPane.setSelectedIndex(0);
				}
			}
		});
		JButton regButton=new JButton();
		regButton.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/Image/button (4).png")));
		regButton.setBounds(156, 638, 214, 51);
		regButton.setFocusable(false);
		regButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//if(comboBox.getSelectedItem().equals("Patients")){
					rdbtnNewRadioButton.setActionCommand("Male");
					rdbtnFemale.setActionCommand("Female");
					rdbtnOther.setActionCommand("Others");
					String gender=buttonGroup.getSelection().getActionCommand();
					Patients p1=new Patients(textField.getText(),textField_1.getText(),new String(passwordField.getPassword()),textField_4.getText(),gender,textField_3.getText(),textField_2.getText());
					if(p1.checkData()) {
						p1.storingData();
						JOptionPane.showMessageDialog(null, "Registration is done!");
						Login login=new Login();
						login.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Account already exist!");
						
						dispose();
					}
				//}
//				else if(comboBox.getSelectedItem().equals("Doctor")){
////					rdbtnNewRadioButton_1.setActionCommand("Male");
////					rdbtnFemale_1.setActionCommand("Female");
////					rdbtnOther_1.setActionCommand("Others");
////					String gender=buttonGroup.getSelection().getActionCommand();
////					//String dept=comboBox_1.getSelectedItem();
////					Doctor p1=new Doctor(textField_5.getText(),textField_6.getText(),new String(passwordField_1.getPassword()),textField_9.getText(),gender,textField_8.getText(),(String)comboBox_1.getSelectedItem());
////					if(p1.checkData()) {
////						p1.storingData();
////						JOptionPane.showMessageDialog(null, "Registration is done!");
////						Login login=new Login();
////						login.setVisible(true);
////						dispose();
////					}
////					else{
////						JOptionPane.showMessageDialog(null,"Account already exist!");
////						dispose();
////					}
//				}
//				else if(comboBox.getSelectedItem().equals("Admin")){
//					rdbtnNewRadioButton_1_1.setActionCommand("Male");
//					rdbtnFemale_1_1.setActionCommand("Female");
//					rdbtnOther_1_1.setActionCommand("Others");
//					String gender=buttonGroup.getSelection().getActionCommand();
//					Admin p1=new Admin(textField_7.getText(),textField_8.getText(),new String(passwordField_2.getPassword()),textField_12.getText(),gender,textField_11.getText());
//					if(p1.checkData()) {
//						p1.storingData();
//						JOptionPane.showMessageDialog(null, "Registration is done!");
//						Login login=new Login();
//						login.setVisible(true);
//						dispose();
//					}
//					else{
//						JOptionPane.showMessageDialog(null,"Account already exist!");
//						dispose();
//					}
//				}
			}
		});
		panel_5.add(regButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Registration.class.getResource("/Frontend/image/output-onlinegiftools.gif")));
		lblNewLabel_5.setBounds(184, 42, 216, 200);
		panel_1.add(lblNewLabel_5);

	}
}
