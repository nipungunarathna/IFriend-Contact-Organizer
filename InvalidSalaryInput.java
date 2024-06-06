import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class InvalidSalaryInput extends JFrame{
	JLabel lblTitle;
	JButton btnYES;
	JButton btnNO;
	InvalidSalaryInput(){
		setSize(400,300);
		setTitle("Invalid Salary Input");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		lblTitle=new JLabel("Invalid salary... Do you want to add again.");
		add("Center",lblTitle);
		btnYES=new JButton("Yes");
		btnNO=new JButton("No");
		JPanel btnPanel=new JPanel();
		btnPanel.add(btnYES);
		btnPanel.add(btnNO);
		add("South",btnPanel);
		
	
		btnYES.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
				}
			});
		btnNO.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
				}
			});
		pack();
	}

}
