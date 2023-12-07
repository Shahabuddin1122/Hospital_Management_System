package Frontend;

import backend.Admin;
import backend.Doctor;
import backend.Patients;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1513, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(587, 0, 10, 863);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Frontend/image/eHospital.gif")));
		lblNewLabel_2.setBounds(0, 0, 577, 863);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Forget Password?");
		lblNewLabel_4.setBounds(950, 753, 249, 43);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("E-mail        :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(736, 278, 140, 43);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		textField_1.setBounds(933, 269, 414, 52);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		passwordField_1.setBounds(933, 367, 414, 52);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password  :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(736, 367, 140, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type           :");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(736, 466, 140, 45);
		contentPane.add(lblNewLabel_1_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 21));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Patients", "Admin", "Doctor"}));
		comboBox.setBounds(933, 466, 266, 43);
		contentPane.add(comboBox);
		
		JLabel regButton = new JLabel("");
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration reg=new Registration();
				reg.setVisible(true);
			}
		});
		regButton.setIcon(new ImageIcon(Login.class.getResource("/Frontend/image/button (4).png")));
		regButton.setBounds(800, 599, 203, 52);
		contentPane.add(regButton);

//		JButton regButton=new JButton();
//		regButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				new Registration();
//			}
//		});
//		regButton.setIcon(new ImageIcon(Login_page.class.getResource("/Frontend/Image/button (4).png")));
//		regButton.setBounds(516, 599, 234, 52);
//		contentPane.add(regButton);
		
		JLabel loginButton = new JLabel("");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String email=textField_1.getText();
				String pass=new String(passwordField_1.getPassword());
				if(comboBox.getSelectedItem().equals("Patients")){
					Patients p=new Patients();
					p.setEmail(email);
					p.setPassword(pass);
					if(!p.checkData() && p.checkPassword()){
						

		
						JOptionPane.showMessageDialog(null,"Logged in successfully!");
						//goes to next menu
						Patients c=p.finddata();
						//c.display();
						Home_patients frame=new Home_patients();
						frame.textField.setText(c.getName());
						frame.textField_1.setText(c.getEmail());
						frame.textField_2.setText(c.getNumber());
						frame.textField_3.setText(c.getGender());
						frame.textField_4.setText(c.getBirthdate());
						frame.setVisible(true);;
						dispose();
						
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Log in failed!");
					}
				}
				else if(comboBox.getSelectedItem().equals("Doctor")){
					Doctor d=new Doctor();
					d.setEmail(email);
					d.setPassword(pass);
					if(!d.checkData() && d.checkPassword()){
						JOptionPane.showMessageDialog(null,"Logged in successfully!");
						//goes to next menu
						//goes to next menu
//						new Home_Admin().setVisible(true);
						Doctor c=d.finddata();
						Home_Doctor frame = new Home_Doctor();
						frame.textField.setText(c.getName());
						frame.textField_1.setText(c.getEmail());
						frame.textField_2.setText(c.getNumber());
						frame.textField_3.setText(c.getGender());
						frame.textField_4.setText(c.getBirthdate());
						frame.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Log in failed!");
					}
				}
				else if(comboBox.getSelectedItem().equals("Admin")){
					Admin a=new Admin();
					a.setEmail(email);
					a.setPassword(pass);
					if(!a.checkData() && a.checkPassword()){
						JOptionPane.showMessageDialog(null,"Logged in successfully!");
						
						Admin c=a.finddata();
						//goes to next menu
//						new Home_Admin().setVisible(true);
						
						Home_Admin frame = new Home_Admin();
						frame.textField.setText(c.getName());
						frame.textField_1.setText(c.getEmail());
						frame.textField_2.setText(c.getNumber());
						frame.textField_3.setText(c.getGender());
						frame.textField_4.setText(c.getBirthdate());
						frame.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Log in failed!");
					}
				}
			}
		});
		loginButton.setIcon(new ImageIcon(Login.class.getResource("/Frontend/Image/button (1).png")));
		loginButton.setBounds(1137, 599, 199, 52);
		contentPane.add(loginButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Frontend/Image/vivid-blurred-colorful-wallpaper-background (1).jpg")));
		lblNewLabel_3.setBounds(0, 0, 1500, 863);
		contentPane.add(lblNewLabel_3);
		

}
}