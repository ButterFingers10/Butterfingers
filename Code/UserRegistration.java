import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class UserRegistration {
	 Connection cnct;
	 ResultSet rs;
	 JLabel l5;
public UserRegistration(String id,int len) {
	connect();
	JFrame f=new JFrame("UserRegistration");
	f.getContentPane().setBackground( Color.PINK );
	JDialog d= new JDialog(f , "Registered", true); 
	d.getContentPane().setBackground(Color.green);
	JLabel d1 = new JLabel("User Successfully Registered");
	d.getContentPane().setBackground(Color.green);
	d1.setBounds(20,10,100,30);
	d.add(d1);
	d.setBounds(530,390,250,250);
	JLabel title=new JLabel("XYZ Hospital");
	JLabel title1=new JLabel("User Registration Page");
	JLabel l1=new JLabel("UserId: ");
	 l5=new JLabel(id);
	JLabel l2=new JLabel("UserName: ");
	JTextField tf=new JTextField();
	JLabel l3=new JLabel("Password: ");
	JPasswordField pf=new JPasswordField();
	JLabel l4=new JLabel("Role: ");
	String []roles = {"Doctor","Receptionist"};
	JComboBox jb=new JComboBox(roles);
	JButton b=new JButton("Register");
	JButton b1=new JButton("Exit");
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
	b1.setBounds(200,260,100,30);
	b1.setBackground(Color.red);
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
	f.add(b1);
	f.setBounds(500,350,500,400);
	f.setVisible(true);
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String username =tf.getText();
			String password = pf.getText();
			String role = (String) jb.getSelectedItem();
			String id1=id.substring(6-len);
			int id2=Integer.parseInt(id1);
			PreparedStatement s;
			try {
				s = cnct.prepareStatement("insert into Users(id,username,password,utype) values(?,?,?,?)");
				s.setString(1,id1);
				s.setString(2,username);
				s.setString(3,password);
				s.setString(4,role);
				s.executeUpdate();
				d.setVisible(true);
				tf.setText("");
				pf.setText("");
				tf.requestFocus();
				ID();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}
		});	
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
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
public void ID() {
	try {
		Statement s=cnct.createStatement();
        rs =s.executeQuery("select MAX(id) from users");
		rs.next();
        String userid="U00001";
        if(rs.getString("MAX(id)")==null){
        	l5.setText("");
        }
        else {
            int len = rs.getString("MAX(id)").length();
            int id =Integer.parseInt( rs.getString("MAX(id)"));
            id++;
            len=String.valueOf(id).length();
            String str="0000";
        	String str1="U"+str.substring(0,5-len)+String.valueOf(id);
        	l5.setText(str1);
        }
		
	}
	catch (SQLException e1) {
    	e1.printStackTrace();
    }
}
}
