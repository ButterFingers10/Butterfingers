import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Receptionist {
	static Connection cnct;
	static PreparedStatement pst;
	static ResultSet rs;
public Receptionist(String name,String id){
	JFrame f=new JFrame("Receptionist Page");
	connect();
	f.getContentPane().setBackground( Color.PINK );
	JLabel title=new JLabel("XYZ Hospital");
	JLabel l1=new JLabel("Username: ");
	JLabel l2 = new JLabel("UserId: ");
	JLabel l3=new JLabel(name);
	JLabel l4=new JLabel(id);
	JButton b1=new JButton("Register Patient");
	JButton b2=new JButton("Logout");
	title.setBounds(100, 10, 150, 30);
	title.setFont(new Font("Verdana", Font.BOLD, 18));
	title.setForeground(Color.RED);
	l1.setBounds(40,50,100,30);
	l1.setForeground(Color.blue);
	l3.setBounds(150,50,100,30);
	l2.setBounds(40,90,100,30);
	l2.setForeground(Color.blue);
	l4.setBounds(150,90,100,30);
	b1.setBounds(40,130,140,30);
	b2.setBounds(190,130,100,30);
	f.add(title);
	f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(l4);
	f.add(b1);
	f.add(b2);
	f.setLayout(null);
	f.setBounds(500,350,500,250);
	f.setVisible(true);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			Statement s=cnct.createStatement();
            rs =s.executeQuery("select MAX(patientid) from patient");
			rs.next();
            String id="P00001";
            if(rs.getString("MAX(patientid)")==null){
            	new PatientRegistration(id);
            }
            else {
                int len = rs.getString("MAX(patientid)").length();
                int id1 =Integer.parseInt( rs.getString("MAX(patientid)"));
                id1++;
                String str="0000";
            	String str1="P"+str.substring(0,5-len)+String.valueOf(id);
            	new PatientRegistration(str1);
            } }
			catch (SQLException e1) {
		    	e1.printStackTrace();
		    }
			
		
		}
	});
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			new Login();
		}
	});
}
public void connect() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
    cnct = DriverManager.getConnection("jdbc:mysql://localhost/xyzhosiptal","root","");
    }
	catch (SQLException e1) {
    	e1.printStackTrace();
    }
	catch (ClassNotFoundException e1) {
    	e1.printStackTrace();
    } 
	
}
}
