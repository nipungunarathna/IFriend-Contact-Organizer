import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class RemoveCustomer extends JFrame{
	private JLabel titleLabel;
    private JLabel searchLbl;
	private JLabel customerID;
	private JLabel nameLbl;
	private JLabel companyLbl;
	private JLabel phoneNumberLbl;
	private JLabel salaryLbl;
	private JLabel birthdayLbl;
	
	private JButton searchBtn;
	private JButton removeBtn;
	
	private JTextField searchTxt;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField phoneNumberTxt;
	private JTextField salaryTxt;
	private JTextField birthdayTxt;
	
	CustomerNotExist cNotExist;
	
	RemoveCustomer(){
		setSize(400,300);
		setTitle("Remove Customer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("Remove Customer");
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
		removeBtn=new JButton("Remove");
		btnPanel.add(removeBtn);
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
				
				removeBtn.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						list.remove(c);
						System.out.println("Customer removed successfully");
				}
			});
				
			}
				}
			});
		}
}
