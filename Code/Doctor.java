import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Doctor {
  public Doctor(String name,String id) {
	  JFrame f=new JFrame("Doctor Page");
		f.getContentPane().setBackground( Color.PINK );
		JLabel title=new JLabel("XYZ Hospital");
		JLabel l1=new JLabel("Username: ");
		JLabel l2 = new JLabel("UserId: ");
		JLabel l3 = new JLabel("Patient Details");
		JLabel l4=new JLabel(name);
		JLabel l5=new JLabel(id);
		String data[][]={};  
String column[]={"Patient ID","Patient NAME","HEALTH PROBLEM"};         
JTable jt=new JTable(data,column);  
		title.setBounds(100, 10, 150, 30);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title.setForeground(Color.RED);
		l1.setBounds(40,50,100,30);
		l1.setForeground(Color.blue);
		l4.setBounds(150,50,100,30);
		l5.setBounds(150,90,100,30);
		l2.setBounds(40,90,100,30);
		l2.setForeground(Color.blue);
		l3.setBounds(100,130,100,30);
		jt.setBounds(40,170,320,300);
		f.add(title);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(jt);
		f.setLayout(null);
		f.setBounds(500,350,500,250);
	  	f.setLocationRelativeTo(null);
		f.setVisible(true);
		Connect();
  }
  Connection cnct;
  PreparedStatement pst;
  	public void Connect() {
  	try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  		cnct=DriverManager.getConnection("jdbc:mysql://localhost/Hospital","root","");
  	} catch (ClassNotFoundException e) {
  		e.printStackTrace();
  	} catch (SQLException e) {
  		e.printStackTrace();
  	}
  }
}
