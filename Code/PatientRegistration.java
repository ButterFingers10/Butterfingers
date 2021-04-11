import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PatientRegistration {
  public PatientRegistration() {
	  JFrame f=new JFrame("PatientRegistration");
		JDialog d= new JDialog(f , "Registered", true); 
		JLabel d1 = new JLabel("Patient Successfully Registered");
		d1.setBounds(20,10,100,30);
		d.add(d1);
		d.setBounds(530,390,250,250);
		JLabel title=new JLabel("XYZ Hospital");
		JLabel title1=new JLabel("Patient Registration Page");
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
	    JTextField tf3=new JTextField();
		JButton b=new JButton("Register");
		title.setBounds(100, 10, 150, 30);
		title.setForeground(Color.RED);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title1.setBounds(90, 50, 200, 30);
		title1.setForeground(Color.CYAN);
		title1.setFont(new Font("Verdana", Font.BOLD, 15));
		l1.setBounds(40,90,100,30);
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
		f.add(b);
		f.setBounds(500,250,500,550);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			d.setVisible(true);
			}
		});
  }
}
