import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login  {
	static Connection cnct;
	static PreparedStatement pst;
	static ResultSet rs;
		public Login() {
			connect();
			JFrame f=new JFrame("Login");
			f.getContentPane().setBackground( Color.PINK );
			JLabel title=new JLabel("XYZ Hospital");
			JLabel l1=new JLabel("Username :");
			JLabel l2=new JLabel("Password :");
			JLabel l3=new JLabel("Role :");
			JTextField tf1=new JTextField();
			JPasswordField pf=new JPasswordField();
			String []roles = {"Doctor","ADMIN","Receptionist"};
			JComboBox jb=new JComboBox(roles);
			JButton b1=new JButton("Login");
			JButton b2 = new JButton("Exit");
			title.setBounds(100,10,200,40);
	        title.setFont(new Font("Verdana", Font.BOLD, 18));
			title.setForeground(Color.RED);
			l1.setBounds(40,50,150,50);
			l1.setForeground(Color.blue);
			l1.setFont(new Font("Verdana", Font.PLAIN, 16));
			l2.setBounds(40,110,150,50);
			l2.setForeground(Color.blue);
			l2.setFont(new Font("Verdana", Font.PLAIN, 16));
			l3.setBounds(40,170,150,50);
			l3.setForeground(Color.blue);
			l3.setFont(new Font("Verdana", Font.PLAIN, 16));
			tf1.setBounds(200,50,150,50);
			pf.setBounds(200,110,150,50);
			jb.setBounds(200,170,150,50);
			b1.setBounds(40,230,150,50);
			b2.setBounds(200,230,150,50);
			f.setBounds(500,350,500,400);
			f.setLayout(null);
			f.setVisible(true);
			f.add(title);
			f.add(l1);
			f.add(l2);
			f.add(l3);
			f.add(tf1);
			f.add(pf);
			f.add(jb);
			f.add(b1);
			f.add(b2);
			b1.setBackground(Color.green);
			b2.setBackground(Color.red);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					f.setVisible(false);
					String username = tf1.getText();
					String password = pf.getText();
			        String utype = jb.getSelectedItem().toString();
					try {
				    pst = cnct.prepareStatement("select * from Users where username =? and Password =? and utype = ?");
		            pst.setString(1, username);
		            pst.setString(2, password);
		            pst.setString(3, utype);      
		            rs= pst.executeQuery();
		            if(rs.next())
		            {   String name=rs.getString("username");
		                int userid = rs.getInt("id");
		                f.setVisible(false);
		                if(utype.equals("Doctor"))
		                {  
		                	int len = String.valueOf(userid).length();
		                	String st="D";
		                	String str="0000";
		                	String str1=st+str.substring(0,5-len)+String.valueOf(userid);
		                   new Doctor(name,str1);
		                }
		                else if(utype.equals("Receptionist"))
		                {
		                	int len = String.valueOf(userid).length();
		                	String st="R";
		                	String str="0000";
		                	String str1=st+str.substring(0,5-len)+String.valueOf(userid);
		                   new Receptionist(name,str1);
		                }
		                else if(rs.getString("utype").equals("Admin"))
		                {
		                	int len = String.valueOf(userid).length();
		                	String st="AD";
		                	String str="0000";
		                	String str1=st+str.substring(0,5-len)+String.valueOf(userid);
		                  new Admin(name,str1);

		                }
		               
		              }
		            else{
	                	JDialog d= new JDialog(f , "Error", true);
	                	JLabel d1 = new JLabel("Username and password does not match");
	            		d1.setBounds(20,10,100,30);
	            		d.add(d1);
	            		d.setBounds(530,390,250,250);
	                	d.setVisible(true);
	                	f.setVisible(true);
		                tf1.setText("");
		                pf.setText("");
		                jb.requestFocus();
	                };}
		            catch (SQLException e1) {
			        	e1.printStackTrace();
			        }
		            
		            }  
			
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});}
		/* connecting to the database */
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
		public static void main(String[] args){
			new Login();
		}
	
}
