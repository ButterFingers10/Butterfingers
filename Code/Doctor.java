import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Doctor {
  public Doctor() {
	  JFrame f=new JFrame("Doctor Page");
		JLabel title=new JLabel("XYZ Hospital");
		JLabel l1=new JLabel("Username: ");
		JLabel l2 = new JLabel("UserId: ");
		JLabel l3 = new JLabel("Patient Details");
		String data[][]={{"Patient ID","Patient NAME","HEALTH PROBLEM"}, {"P101","Amit","Fever"},    
                {"P102","Jai","HEADACHE"},    
                };    
String column[]={"Patient ID","Patient NAME","HEALTH PROBLEM"};         
JTable jt=new JTable(data,column);  
		title.setBounds(100, 10, 150, 30);
		title.setFont(new Font("Verdana", Font.BOLD, 18));
		title.setForeground(Color.RED);
		l1.setBounds(40,50,100,30);
		l1.setForeground(Color.blue);
		l2.setBounds(40,90,100,30);
		l2.setForeground(Color.blue);
		l3.setBounds(100,130,100,30);
		jt.setBounds(40,170,320,300);
		f.add(title);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(jt);
		f.setLayout(null);
		f.setBounds(500,350,500,250);
		f.setVisible(true);
		
  }
}
