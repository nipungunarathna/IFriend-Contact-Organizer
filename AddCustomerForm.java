import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddCustomerForm extends JFrame{
	JLabel formName;
	JLabel customerID;
	JLabel customerName;
	JLabel customerPhone;
	JLabel customerCompany;
	JLabel customerSalary;
	JLabel customerBirthday;
	
	JTextField id;
	JTextField name;
	JTextField phone;
	JTextField company;
	JTextField salary;
	JTextField birthday;
	
	JButton addButton;
	JButton backButton;
	AddCustomerForm(){
		setSize(400,300);
		setTitle("Add Customer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel formPanel= new JPanel(new GridLayout(6,2));
		formName=new JLabel("Add Customer Form");
		formName.setFont(new Font("",1,25));
		customerID=new JLabel("ID");
		customerName=new JLabel("Name");
		customerPhone=new JLabel("Mobile/Tel");
		customerCompany=new JLabel("Company");
		customerSalary=new JLabel("Salary");
		customerBirthday=new JLabel("Birthday");
		
		id=new JTextField(4);
		name=new JTextField(10);
		phone=new JTextField(10);
		company=new JTextField(10);
		salary=new JTextField(10);
		birthday=new JTextField(15);
		
		formPanel.add(customerID);
		formPanel.add(id);
		formPanel.add(customerName);
		formPanel.add(name);
		formPanel.add(customerPhone);
		formPanel.add(phone);
		formPanel.add(customerCompany);
		formPanel.add(company);
		formPanel.add(customerSalary);
		formPanel.add(salary);
		formPanel.add(customerBirthday);
		formPanel.add(birthday);
		
		addButton=new JButton("Add");
		backButton=new JButton("Back");
		JPanel btnPanel=new JPanel();
		btnPanel.add(addButton);
		btnPanel.add(backButton);
		add("North",formName);
		add("Center",formPanel);
		add("South",btnPanel);
		
		ValidateInput validate=new ValidateInput();
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
			String custId=id.getText();
			String custName=name.getText();
			//==================validate phone number===================
			while(!validate.isValidPhoneNumber(phone.getText())){
				
			}
			String custPhone=phone.getText();
			String custCompany=company.getText();
			double custSalary=Double.parseDouble(salary.getText());
			String custBirthday=birthday.getText();
			
			
			Customer c =new Customer(custId,custName,custPhone,custCompany,custSalary,custBirthday);
			CustomerManagementApp.list.add(c);
				}
			});
		
		
		}
	}
