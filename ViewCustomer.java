import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
class ViewCustomer extends JFrame{
	JButton reload;
	JTable customerDetails;
	JLabel tableName;
	DefaultTableModel tableModel;
	ViewCustomer(){
		setSize(400,300);
		setTitle("View Customer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel titlePanel=new JPanel();
		tableName=new JLabel("Customer Details");
		tableName.setFont(new Font("",1,25));
		titlePanel.add(tableName);
		add("North",titlePanel);
		
		String column[]={"ID","Name","Phone","Company","Salary","Birthday"};
		tableModel=new DefaultTableModel(column,0);
	
		CustomerList list=CustomerManagementApp.list;
		reload=new JButton("Reload");
		reload.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt){
					for(int i=0;i<list.size();i++){
						Customer c=list.get(i);
						Object []customerData=new Object[]{c.getId(),c.getName(),c.getPhoneNumber(),c.getCompany(),c.getSalary(),c.getBirthday()};
						tableModel.addRow(customerData);
					}
				}
			});
		
		
		add("South",reload);
		customerDetails=new JTable(tableModel);
		JScrollPane sp= new JScrollPane(customerDetails);
		add("Center",sp);
		
		
		
		}
	
	}
