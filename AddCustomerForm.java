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
	JButton idGenerateButton;
	
	InvalidNumberInput invalidNumber;
	InvalidSalaryInput invalidSalary;
	InvalidBirthdayInput invalidBirthday;
	
	//============================GENERATE ID=======================
	private String generateId(){
		if(CustomerManagementApp.list.size()==0){
			return "C0001";
		}
		String lastId=CustomerManagementApp.list.get(CustomerManagementApp.list.size()-1).getId();
		int lastNo=Integer.parseInt(lastId.substring(1));
		return String.format("C%04d",lastNo+1);
		}	
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
	
		
	
		addButton=new JButton("Add");
		backButton=new JButton("Back");
		idGenerateButton=new JButton("Generate ID");
		JPanel btnPanel=new JPanel();
		btnPanel.add(idGenerateButton);
		btnPanel.add(addButton);
		btnPanel.add(backButton);
		add("North",formName);
		
		add("South",btnPanel);
		ValidateInput validate=new ValidateInput();
		
		idGenerateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					id.setText(generateId());	
					id.setEnabled(false);
				}
			});
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
	
			//==================validate phone number===================
			if(!validate.isValidPhoneNumber(phone.getText())){
				if(invalidNumber==null){
					invalidNumber=new InvalidNumberInput();
					}
					invalidNumber.setVisible(true);
				}
			//=================validate salary===============
			else if(!validate.isValidSalary(Double.parseDouble(salary.getText()))){
				if(invalidSalary==null){
					invalidSalary=new InvalidSalaryInput();
					}
					invalidSalary.setVisible(true);
				}
			//=================validate birthday==============
			else if(!validate.isValidBirthday(birthday.getText())){
				if(invalidBirthday==null){
					invalidBirthday=new InvalidBirthdayInput();
					}
					invalidBirthday.setVisible(true);
				}
			else{
					
				
					String custId=id.getText();
					String custName=name.getText();
					String custPhone=phone.getText();
					String custCompany=company.getText();
					double custSalary=Double.parseDouble(salary.getText());
					String custBirthday=birthday.getText();
					
			
					Customer c =new Customer(custId,custName,custPhone,custCompany,custSalary,custBirthday);
					CustomerManagementApp.list.add(c);
					System.out.println("Customer added successfully");
					
				}
				}
			
			
		});
		
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddCustomerForm.this.dispose();
				}
			});
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
		
		add("Center",formPanel);
		}
	}
