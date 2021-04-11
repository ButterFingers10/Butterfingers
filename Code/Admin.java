import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Admin {
public Admin() {
	JFrame f=new JFrame("Admin Page");
	JLabel title=new JLabel("XYZ Hospital");
	JLabel l1=new JLabel("Username: ");
	JLabel l2 = new JLabel("UserId: ");
	JButton b1=new JButton("Create User");
	JButton b2=new JButton("Logout");
	
	title.setBounds(100, 10, 150, 30);
	title.setFont(new Font("Verdana", Font.BOLD, 18));
	title.setForeground(Color.RED);
	l1.setBounds(40,50,100,30);
	l1.setForeground(Color.blue);
	l2.setBounds(40,90,100,30);
	l2.setForeground(Color.blue);
	b1.setBounds(40,130,100,30);
	b2.setBounds(150,130,100,30);
	f.add(title);
	f.add(l1);
	f.add(l2);
	f.add(b1);
	f.add(b2);
	f.setLayout(null);
	f.setBounds(500,350,500,250);
	f.setVisible(true);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new UserRegistration();
		}
	});
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			new Login();
		}
	});
}
}