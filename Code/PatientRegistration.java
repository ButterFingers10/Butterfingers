import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class PatientRegistration {
	JLabel l8;
	ResultSet rs;
  public PatientRegistration(String id,int len) {
	  connect();
	  JFrame f=new JFrame("PatientRegistration");
		f.getContentPane().setBackground( Color.PINK );
		JDialog d= new JDialog(f , "Registered", true); 
		d.getContentPane().setBackground(Color.green);
		JLabel d1 = new JLabel("Patient Successfully Registered");
		d1.setBounds(20,10,100,30);
		d.add(d1);
		d.setBounds(530,390,250,250);
		JLabel title=new JLabel("XYZ Hospital");
		JLabel title1=new JLabel("PatientRegistrationPage");
		 JLabel l1=new JLabel("Patient Id: ");
		JLabel l2=new JLabel("Patient Name: ");
		JTextField tf=new JTextField();
		JLabel l3=new JLabel("PhoneNumber: ");
		JTextField tf1=new JTextField();
		JLabel l4=new JLabel("Address: ");
	    JTextArea area=new JTextArea();
	    JLabel l5 =new JLabel("Health Problem: ");
	    JTextArea area1=new JTextArea();
	    JLabel l6=new JLabel("DoctorId: ");
	    JTextField tf2=new JTextField();
	    JLabel l7=new JLabel("DoctorName: ");
	    l8=new JLabel(id);
	    JTextField tf3=new JTextField();
		JButton b=new JButton("Register");
		JButton b1=new JButton("Exit");
		title.setBounds(100, 10, 150, 30);
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title1.setBounds(90, 50, 250, 30);
		title1.setForeground(Color.CYAN);
		title1.setFont(new Font("Verdana", Font.BOLD, 17));
		l1.setBounds(40,90,100,30);
		l8.setBounds(150,90,100,30);
		l2.setBounds(40,130,100,30);
		tf.setBounds(150,130,100,30);
		l3.setBounds(40,180,100,30);
		tf1.setBounds(150,180,100,30);
		l4.setBounds(40,220,100,30);
		area.setBounds(150,220,100,70);
		l5.setBounds(40,300,100,30);
		area1.setBounds(150,300,100,70);
		l6.setBounds(40,380,100,30);
		tf2.setBounds(150,380,100,30);
		l7.setBounds(40,420,100,30);
		tf3.setBounds(150,420,100,30);
		b.setBounds(90,460,100,30);
		b1.setBounds(200,460,100,30);
		b1.setBackground(Color.red);
		b.setBackground(Color.green);
		f.setLayout(null);
		f.add(title);
		f.add(title1);
		f.add(l1);
		f.add(l2);
		f.add(tf);
		f.add(l3);
		f.add(tf1);
		f.add(l4);
		f.add(area);
		f.add(l5);
		f.add(area1);
		f.add(l6);
		f.add(tf2);
		f.add(tf3);
		f.add(l7);
		f.add(l8);
		f.add(b);
		f.add(b1);
		f.setBounds(500,250,500,550);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			d.setVisible(true);
			String patientname =tf.getText();
			String phonenumber = tf1.getText();
			String id1=id.substring(6-len);
			String address=area.getText();
			String healthproblem=area1.getText();
			String doctorid=tf2.getText();
			int id2=Integer.parseInt(id1);
			PreparedStatement s;
			try {
				s = cnct.prepareStatement("insert into patient(patientid,patientname,patientphonenumber,address,healthproblem,Doctorid) values(?,?,?,?,?,?)");
				s.setString(1,id1);
				s.setString(2,patientname);
				s.setString(3,phonenumber);
				s.setString(4,address);
				s.setString(5,healthproblem);
				s.setString(6,doctorid);
				s.executeUpdate();
				d.setVisible(true);
				tf.setText("");
				tf1.setText("");
				area.setText("");
				area1.setText("");
				tf2.setText("");
				tf3.setText("");
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
  Connection cnct;
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
          rs =s.executeQuery("select MAX(patientid) from patient");
			rs.next();
          String id="P00001";
          if(rs.getString("MAX(patientid)")==null){
          	l8.setText("id");
          }
          else {
              int len = rs.getString("MAX(patientid)").length();
              int id1 =Integer.parseInt( rs.getString("MAX(patientid)"));
              id1++;
              len=String.valueOf(id1).length();
              String str="0000";
          	String str1="P"+str.substring(0,5-len)+String.valueOf(id1);
          	l8.setText(str1);
          } }
			catch (SQLException e1) {
		    	e1.printStackTrace();
		    }
  }
  
}

