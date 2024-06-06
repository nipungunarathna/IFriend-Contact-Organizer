import java.util.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
class CustomerNotExist extends JFrame{
	JLabel lblTitle;
	JButton btnYES;
	JButton btnNO;
	CustomerNotExist(){
		setSize(400,300);
		setTitle("Customer Not Exist");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		lblTitle=new JLabel("Customer not exist... Do you want to add again.");
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
