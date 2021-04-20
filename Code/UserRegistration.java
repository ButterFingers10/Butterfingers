import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UserRegistration {
	 
public UserRegistration(String id) {
	JFrame f=new JFrame("UserRegistration");
	connect();
	f.getContentPane().setBackground( Color.PINK );
	JDialog d= new JDialog(f , "Registered", true); 
	JLabel d1 = new JLabel("User Successfully Registered");
	d1.setBounds(20,10,100,30);
	d.add(d1);
	d.setBounds(530,390,250,250);
	JLabel title=new JLabel("XYZ Hospital");
	JLabel title1=new JLabel("User Registration Page");
	JLabel l1=new JLabel("UserId: ");
	JLabel l5=new JLabel(id);
	JLabel l2=new JLabel("UserName: ");
	JTextField tf=new JTextField();
	JLabel l3=new JLabel("Password: ");
	JPasswordField pf=new JPasswordField();
	JLabel l4=new JLabel("Role: ");
	String []roles = {"Doctor","Receptionist"};
	JComboBox jb=new JComboBox(roles);
	JButton b=new JButton("Register");
	title.setBounds(100, 10, 150, 30);
	title.setForeground(Color.RED);
	title.setFont(new Font("Verdana", Font.BOLD, 18));
	title1.setBounds(90, 50, 200, 30);
	title1.setForeground(Color.CYAN);
	title1.setFont(new Font("Verdana", Font.BOLD, 15));
	l1.setBounds(40,90,100,30);
	l5.setBounds(150,90,100,30);
	l2.setBounds(40,130,100,30);
	tf.setBounds(150,130,100,30);
	l3.setBounds(40,180,100,30);
	pf.setBounds(150,180,100,30);
	l4.setBounds(40,220,100,30);
	jb.setBounds(150,220,100,30);
	b.setBounds(90,260,100,30);
	b.setBackground(Color.green);
	f.setLayout(null);
	f.add(title);
	f.add(title1);
	f.add(l1);
	f.add(l2);
	f.add(tf);
	f.add(l3);
	f.add(pf);
	f.add(l4);
	f.add(l5);
	f.add(jb);
	f.add(b);
	f.setBounds(500,351,500,400);
	f.setVisible(true);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		d.setVisible(true);
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
