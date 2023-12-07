package Frontend;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class view_appointment extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_appointment frame = new view_appointment();
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
	public view_appointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(108, 54, 581, 614);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(24, 38, 526, 259);
		panel.add(table);
		table.setModel(new DefaultTableModel());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1","root","root123");
			PreparedStatement ppt=con.prepareStatement("select * from appointment where patient_id=?");
			ppt.setInt(1, 1);
			ResultSet res=ppt.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			DefaultTableModel model =(DefaultTableModel) table.getModel();
			int colNo=rsmd.getColumnCount();
			String[] colName=new String[colNo-1];
			for(int i=0;i<colNo-1;i++)
			{
				colName[i]=rsmd.getColumnName(i+1);

			}
			model.setColumnIdentifiers(colName);
			String a,b,c,d,e,f;
			while(res.next()) {
				a=res.getString("doctor_name");
				b=res.getString("doctor_dept");
				c=res.getString("date");
				d=res.getString("day");
				e=res.getString("time");
				f=res.getString("serial");
				String row[]= {a,b,c,d,e,f};
				model.addRow(row);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
