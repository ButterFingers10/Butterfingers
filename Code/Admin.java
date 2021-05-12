import javax.swing.*;

import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Admin {
	static Connection cnct;
	static PreparedStatement pst;
	static ResultSet rs;
public Admin(String name,String id) {
	connect();
	JFrame f=new JFrame("Admin Page");
	f.getContentPane().setBackground( Color.PINK );
	JLabel title=new JLabel("XYZ Hospital");
	JLabel l1=new JLabel("Username: ");
	JLabel l2 = new JLabel("UserId: ");
	JLabel l3 =new JLabel(id);
	JLabel l4 = new JLabel(name);
	JButton b1=new JButton("Create User");
	JButton b2=new JButton("Logout");
	title.setBounds(100, 10, 150, 30);
	title.setFont(new Font("Verdana", Font.BOLD, 18));
	title.setForeground(Color.RED);
	l1.setBounds(40,50,100,30);
	l1.setForeground(Color.blue);
	l4.setBounds(150,50,100,30);
	l2.setBounds(40,90,100,30);
	l2.setForeground(Color.blue);
	l3.setBounds(150,90,100,30);
	b1.setBounds(40,130,100,30);
	b2.setBounds(150,130,100,30);
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
	            rs =s.executeQuery("select MAX(id) from users");
				rs.next();
	            String userid="U00001";
	            if(rs.getString("MAX(id)")==null){
	            	new UserRegistration(userid,1);
	            }
	            else {
	                int len = rs.getString("MAX(id)").length();
	                int id =Integer.parseInt( rs.getString("MAX(id)"));
	                id++;
	                len=String.valueOf(id).length();
	                String str="0000";
                	String str1="U"+str.substring(0,5-len)+String.valueOf(id);
                	new UserRegistration(str1,len);
	            }
				
			}
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
