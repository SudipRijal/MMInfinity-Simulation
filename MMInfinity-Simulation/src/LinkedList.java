

public class LinkedList {

	
	Node head;
	
	//inserting 
	public void insert (float rArrays) {
		Node node = new Node();
		node.data = rArrays;
		node.next = null;
		
		
		if (head == null) {
			head = node;
		}
		else {
		
			
			Node n = head; 
			while(n.next != null) { 
				n= n.next; 
			}
			
			n.next = node;
		}	
	}
	//length of a linked list
	public  int getCount()
	{
		
		Node temp = head;
		int count = 0;
		while(temp!= null) {
			
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	
	//inssert At first
	public void insertAtfirst(float data) {
		
		Node node = new Node();
		node.data = data;
		node.next = null;	
		
		node.next = head;
		head = node;	
	}
	
	//insert at position
	public void insertAtposition(int position, float data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
			if(position == 0) {
				insertAtfirst(data);
			}else {
			
			Node n = head;
			for(int i=0; i<(position-1); i++) {
				
				n= n.next;
					}
			node.next = n.next;
			n.next = node;
			
			}
		}
	

		// get value from nth term
	public  float GetNth(int index) 
    { 
		
		float nums = 0;
        Node current = head; 
        int count = 0;
       
        while (current != null) 
        { 
            if (count == index) 
            	nums =   current.data; 
            count++; 
            current = current.next; 
        }
        
        return nums ; 
    } 
	//deleting a node
	public void deleteFirst() {
		
		if(head == null) {
			return;
		}
		else {
				head = head.next;
			}
		}
	
  
	//print the elements in the Linked list
	public void show() {
		
		try {
			Node node = head;
			while(node.next != null) {
				System.out.println(node.data+" ");
				node = node.next;
			}
			System.out.println(node.data);
			}
			catch(Exception e) {
			 System.out.println("The list is empty");
			}
		
		
	}
	
	
	 public boolean isEmpty( )
     {
         return head == null;
     	
     }
					
	
	
	

}
