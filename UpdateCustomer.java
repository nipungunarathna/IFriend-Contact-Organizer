import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class UpdateCustomer extends JFrame{
	private JLabel titleLabel;
    private JLabel searchLbl;
	private JLabel customerID;
	private JLabel nameLbl;
	private JLabel companyLbl;
	private JLabel phoneNumberLbl;
	private JLabel salaryLbl;
	private JLabel birthdayLbl;
	
	private JButton searchBtn;
	private JButton updateBtn;
	
	private JTextField searchTxt;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField phoneNumberTxt;
	private JTextField salaryTxt;
	private JTextField birthdayTxt;
	
	CustomerNotExist cNotExist;
	
	UpdateCustomer(){
		
		setSize(400,300);
		setTitle("Update Customer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("Update Customer");
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
		
		add("Center",searchPanel);
		JPanel btnPanel=new JPanel();
		searchBtn=new JButton("Search");
		updateBtn=new JButton("Update");
		btnPanel.add(updateBtn);
		btnPanel.add(searchBtn);
		add("South",btnPanel);
		
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
				
				updateBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						String name=nameTxt.getText();
						c.setName(name);
						String phoneNumber=phoneNumberTxt.getText();
						c.setPhoneNumber(phoneNumber);
						String company=companyTxt.getText();
						c.setCompany(company);
						String birthday=birthdayTxt.getText();
						c.setBirthday(birthday);
						Double salary=Double.parseDouble(salaryTxt.getText());
						c.setSalary(salary);
						System.out.println("Customer updated successfully");
					}
				});
			}
		}
	});
	}
}
