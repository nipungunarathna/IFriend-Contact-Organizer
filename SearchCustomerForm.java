import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
class SearchCustomerForm extends JFrame{
	JLabel titleLabel;
	JLabel searchLbl;
	JLabel customerID;
	JLabel nameLbl;
	JLabel companyLbl;
	JLabel phoneNumberLbl;
	JLabel salaryLbl;
	JLabel birthdayLbl;
	
	JButton searchBtn;
	JTextField searchTxt;
	JTextField idTxt;
	JTextField nameTxt;
	JTextField companyTxt;
	JTextField phoneNumberTxt;
	JTextField salaryTxt;
	JTextField birthdayTxt;
	
	CustomerNotExist cNotExist;
	SearchCustomerForm(){
		setSize(400,300);
		setTitle("Search customer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("Search Customer");
		titleLabel.setFont(new Font("",1,25));
		JPanel titlePanel=new JPanel();
		titlePanel.add(titleLabel);
		add("North",titlePanel);
		
		JPanel searchPanel=new JPanel(new GridLayout(7,2));
		searchLbl=new JLabel("Search");
		searchPanel.add(searchLbl);
		searchTxt=new JTextField(10);
		searchPanel.add(searchTxt);
		
		customerID=new JLabel("customer ID");
		searchPanel.add(customerID);
		idTxt=new JTextField(10);
		searchPanel.add(idTxt);
		
		nameLbl=new JLabel("Name");
		searchPanel.add(nameLbl);
		nameTxt=new JTextField(10);
		searchPanel.add(nameTxt);
		
		companyLbl=new JLabel("Company");
		searchPanel.add(companyLbl);
		companyTxt=new JTextField(10);
		searchPanel.add(companyTxt);
		
		phoneNumberLbl=new JLabel("Phone Number");
		searchPanel.add(phoneNumberLbl);
		phoneNumberTxt=new JTextField(10);
		searchPanel.add(phoneNumberTxt);
		
		salaryLbl=new JLabel("Salary");
		searchPanel.add(salaryLbl);
		salaryTxt=new JTextField(10);
		searchPanel.add(salaryTxt);
		
		birthdayLbl=new JLabel("Birthday");
		searchPanel.add(birthdayLbl);
		birthdayTxt=new JTextField(10);
		searchPanel.add(birthdayTxt);
		
		searchBtn=new JButton("Search");
		add("South",searchBtn);
		add("Center",searchPanel); 
		
		CustomerList list=CustomerManagementApp.list;
		searchBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Customer c=list.searchByNameOrPhoneNumber(searchTxt.getText());
				if(c==null){
					if(cNotExist==null){
						cNotExist=new CustomerNotExist();
						}
						cNotExist.setVisible(true);
					}
				else{
				idTxt.setText(c.getId());
				nameTxt.setText(c.getName());
				companyTxt.setText(c.getCompany());
				phoneNumberTxt.setText(c.getPhoneNumber());
				salaryTxt.setText(Double.toString(c.getSalary()));
				birthdayTxt.setText(c.getBirthday());
			}
				}
			});
		
		}
}
