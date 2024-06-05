class CustomerList{
	Node start;
	public void add(Customer customer){
		Node n=new Node(customer);
		if(start==null){
			start=n;
			}
		else{
			Node temp=start;
			while(temp.next!=null){
				temp=temp.next;
				}
				temp.next=n;
			}
		}
	private Node searchNode(int index){
		int count=0;
		Node temp=start;
		while(count!=index){
			count++;
			temp=temp.next;
			}
			return temp;
		}
	public  Customer get(int index){
		if(index>=0&&index<size()){
			Node node=searchNode(index);
			return node.customer;
			}
			else
			return null;
		}
	public void remove(int index){
		Node temp=start;
		int count=0;
		if(index>0&&index<size()){
		while(count<index-1){
			count++;
			temp=temp.next;
			}
			temp.next=temp.next.next;
		}
		else if(index==0){
			start=start.next;
			}
	}
	public void remove(Customer c){
		Node temp=start;
		int count=0;
		while(temp.customer!=c){
			temp=temp.next;
			count++;
			}
			remove(count);
			
		}
	
	
	public int size(){
		int count=0;
		Node temp=start;
		while(temp!=null){
			temp=temp.next;
			count++;
			}
			return count;
		}
	 //=========================CONVERT TO ARRAY==========================
	 public Customer[] toArray(){
		 Customer dataArray[]=new Customer[size()];
		 Node temp=start;
		 for(int i=0;i<dataArray.length;i++){
			 dataArray[i]=temp.customer;
			 temp=temp.next;
			 }
			 return dataArray;
		 }
    //---------------------------SEARCH METHOD--------------------------
     public Customer searchByNameOrPhoneNumber(String nameOrPhone){
		 Node temp=start;
		 while(temp!=null){
			 if(temp.customer.getName().equals(nameOrPhone)||temp.customer.getPhoneNumber().equals(nameOrPhone)){
				 return temp.customer;
				 }
				 temp=temp.next;
			 }
		 return null;
		 }
    

	//==============================INNER CLASS=================================
	class Node{
		private Customer customer;
		private Node next;
		Node(Customer customer){
			this.customer=customer;
			}
		
		}
	}
