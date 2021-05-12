import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Doctor {
	JTable jTable1;
	JScrollPane panel1;
	PreparedStatement pst;
	ResultSet rs;
	ResultSetMetaData rsm;
  public Doctor(String name,String id,int len) {
	  connect();
	  JFrame f=new JFrame("Doctor Page");
		f.getContentPane().setBackground( Color.PINK );
		JLabel title=new JLabel("XYZ Hospital");
		JLabel l1=new JLabel("Username: ");
		JLabel l2 = new JLabel("UserId: ");
		JLabel l3 = new JLabel("Patient Details");
		JLabel l4=new JLabel(name);
		JLabel l5=new JLabel(id);
		JButton b=new JButton("Exit");
		String [][]data= {};
        String []columns= {"patientname","healthproblem","phonenumber"};
        DefaultTableModel df = new DefaultTableModel(data,columns);
		
		 try {
			 String id1=id.substring(6-len);
			 Statement stmt=cnct.createStatement();  
			 rs=stmt.executeQuery("select * from patient where doctorid="+id1);
			 
	         ResultSetMetaData rsm = rs.getMetaData();
	          while(rs.next()){
	              Vector v = new Vector();
	               v.add(rs.getString("patientname"));
	               v.add(rs.getString("healthproblem"));
	               v.add(rs.getString("patientphonenumber"));
	              
	              df.addRow(v);
	             
	          }
	          
	      } 
			catch(Exception e) {
				e.printStackTrace();
			}
		 jTable1=new JTable(df);
		
		panel1=new JScrollPane(jTable1);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});
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
		panel1.setBounds(40,170,400,300);
		b.setBounds(40,500,100,30);
		f.add(title);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(panel1);
		f.add(b);
		f.setLayout(null);
		f.setBounds(500,290,500,600);
		
		f.setVisible(true);
		
		
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
}
