package Frontend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import backend.Admin;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Add_Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Admin frame = new Add_Admin();
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
	public Add_Admin() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBackground(Color.CYAN);
		panel_4_1_1.setBounds(736, 86, 525, 734);
		contentPane.add(panel_4_1_1);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBounds(10, 11, 505, 712);
		panel_4_1_1.add(panel_5_1_1);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Sign Up");
		lblNewLabel_4_3_1.setForeground(Color.BLACK);
		lblNewLabel_4_3_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4_3_1.setBounds(197, 30, 123, 43);
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
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField.setBounds(144, 111, 295, 43);
		panel_5_1_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_1.setBounds(144, 189, 295, 43);
		panel_5_1_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_2.setBounds(144, 263, 295, 43);
		panel_5_1_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		textField_3.setBounds(144, 340, 295, 43);
		panel_5_1_1.add(textField_3);
		
		final JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnNewRadioButton_1_1.setBounds(148, 429, 86, 23);
		panel_5_1_1.add(rdbtnNewRadioButton_1_1);
		
		final JRadioButton rdbtnFemale_1_1 = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale_1_1);
		rdbtnFemale_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnFemale_1_1.setBounds(236, 429, 111, 23);
		panel_5_1_1.add(rdbtnFemale_1_1);
		
		final JRadioButton rdbtnOther_1_1 = new JRadioButton("Others");
		buttonGroup.add(rdbtnOther_1_1);
		rdbtnOther_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		rdbtnOther_1_1.setBounds(364, 429, 111, 23);
		panel_5_1_1.add(rdbtnOther_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 255)));
		passwordField.setBounds(160, 482, 295, 43);
		panel_5_1_1.add(passwordField);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				rdbtnNewRadioButton_1_1.setActionCommand("Male");
				rdbtnFemale_1_1.setActionCommand("Female");
				rdbtnOther_1_1.setActionCommand("Others");
				String gender=buttonGroup.getSelection().getActionCommand();
				Admin p1=new Admin(textField.getText(),textField_1.getText(),new String(passwordField.getPassword()),textField_3.getText(),gender,textField_2.getText());
				if(p1.checkData()) {
					p1.storingData();
					JOptionPane.showMessageDialog(null, "Registration is done!");
					Home_Admin frame = new Home_Admin();
					frame.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Account already exist!");
					dispose();
				}
			}
		});
		lblNewLabel_5_1_1.setIcon(new ImageIcon(Add_Admin.class.getResource("/Frontend/image/button (9).png")));
		lblNewLabel_5_1_1.setBounds(175, 638, 140, 51);
		panel_5_1_1.add(lblNewLabel_5_1_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(3, 3, 320, 863);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Registration as.....");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(36, 202, 210, 54);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 22));
		comboBox.setBounds(31, 267, 215, 54);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Add_Admin.class.getResource("/Frontend/image/icons8-write-64.png")));
		lblNewLabel_1.setBounds(31, 398, 231, 389);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Add_Admin.class.getResource("/Frontend/image/resized.png")));
		lblNewLabel_2.setBounds(36, 36, 176, 155);
		panel.add(lblNewLabel_2);
	}

}
