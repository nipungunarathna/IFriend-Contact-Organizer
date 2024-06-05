class Customer{
	private String id;
	private String name;
	private String phoneNumber;
	private String company;
	private double salary;
	private String birthday;
	
	Customer(String id,String name,String phoneNumber,String company,double salary,String birthday){
		this.id=id;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.company=company;
		this.salary=salary;
		this.birthday=birthday;
		
		}
	public String getId(){
		return id;
		}
	public String getName(){
		return name;
		}
	public String getPhoneNumber(){
		return phoneNumber;
		}
	public String getCompany(){
		return company;
		}
	public double getSalary(){
		return salary;
		}
	public String getBirthday(){
		return birthday;
		}
	public void setId(String id){
		this.id=id;
		}
	public void setName(String name){
		this.name=name;
		}
	public void setPhoneNumber(String number){
		this.phoneNumber=number;
		}
	public void setCompany(String company){
		this.company=company;
		}
	public void setSalary(double salary){
		this.salary=salary;
		}
	public void setBirthday(String birthday){
		this.birthday=birthday;
		}
	}
