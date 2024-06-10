import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CustomerManagementApp extends JFrame{
	public static CustomerList list=new CustomerList();
	private JButton addCustomerButton;
	private JButton removeCustomerButton;
	private JButton searchCustomerButton;
	private JButton updateCustomerButton;
	private JButton viewCustomerButton;
	private JButton exitButton;
	
	private JLabel appTitle;
	private JPanel buttonPanel;
	
	private AddCustomerForm addCustomerForm;
	private ViewCustomer viewCustomer;
	private SearchCustomerForm searchCustomer;
	private RemoveCustomer removeCustomer;
	private UpdateCustomer updateCustomer;
	
//=====================constructor==========================
	CustomerManagementApp(){
		setSize(400,300);
		setTitle("IFRIEND Contact Organizer");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		appTitle=new JLabel("IFRIEND Contact Organizer");
		appTitle.setFont(new Font("",1,25));
		setLayout(new FlowLayout());
		add("North",appTitle);
		
		buttonPanel=new JPanel(new GridLayout(2,3));
		addCustomerButton=new JButton("Add Customer");
		buttonPanel.add(addCustomerButton);
		removeCustomerButton=new JButton("Remove Customer");
		buttonPanel.add(removeCustomerButton);
		searchCustomerButton=new JButton("Search");
		buttonPanel.add(searchCustomerButton);
		updateCustomerButton=new JButton("Update Customer");
		buttonPanel.add(updateCustomerButton);
		viewCustomerButton=new JButton("View");
		buttonPanel.add(viewCustomerButton);
		exitButton=new JButton("Exit");
		buttonPanel.add(exitButton);
		add(buttonPanel);
		
		addCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addCustomerForm==null){
					addCustomerForm=new AddCustomerForm();
					}
					addCustomerForm.setVisible(true);
				}
			});
		searchCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchCustomer==null){
					searchCustomer=new SearchCustomerForm();
					}
					searchCustomer.setVisible(true);
				}
			});
		viewCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewCustomer==null){
					viewCustomer=new ViewCustomer();
					}
					viewCustomer.setVisible(true);
					viewCustomer=null;
				}
			});
			
		removeCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(removeCustomer==null){
					removeCustomer=new RemoveCustomer();
					}
					removeCustomer.setVisible(true);
				}
			});
		updateCustomerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateCustomer==null){
					updateCustomer=new UpdateCustomer();
					}
					updateCustomer.setVisible(true);
				}
			});
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
					System.exit(0);
				}
			});
		}
//========================main method==========================
	public static void main(String args[]){
		new CustomerManagementApp().setVisible(true);
		
		}
	}
