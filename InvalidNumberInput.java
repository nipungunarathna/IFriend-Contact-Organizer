import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class InvalidNumberInput extends JFrame{
	JLabel lblTitle;
	JButton btnYES;
	JButton btnNO;
	InvalidNumberInput(){
		setSize(400,300);
		setTitle("Invalid Number Input");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		lblTitle=new JLabel("Invalid Phone Number.... Do you want to add again.");
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
