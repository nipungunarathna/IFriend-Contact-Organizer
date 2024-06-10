import java.util.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
class InvalidBirthdayInput extends JFrame{
	JLabel lblTitle;
	JButton btnYES;
	JButton btnNO;
	InvalidBirthdayInput(){
		setSize(400,300);
		setTitle("Invalid Birthday Input");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		lblTitle=new JLabel("Invalid birthday.. Do you want to add again.");
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
