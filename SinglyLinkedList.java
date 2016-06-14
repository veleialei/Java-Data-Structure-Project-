public class SinglyLinkedList<E> implements ISimpleList<E> {
	
	
	private class Node {
		E val;
		Node next;
	}
	private Node front;
	private Node back;
	private int size=0;
	/**
	 * 
 	* @return the list size
 	*/
	public SinglyLinkedList(){
		this.front = new Node();
		back = front;
	}

	@Override
	public int size(){
		return size;
	};

	/**
 	* Add item e to the end of the list
 	* @param e
 	*/
	@Override
	public void add(E e){
		Node current = new Node();
		current.val=e;
		current.next=null;
		back.next=current;
		back = current;			
		size++;
	};

	/**
 	* Get the element at position index
 	* 
 	* @param index
 	* @return
 	*/
	@Override
	public E get(int index){
		if(index<0||index>=this.size()){
			System.out.println("index out of boundary");
		}
		Node temp = new Node();
		temp=front;
		for(int i =0;i<=index;i++){
			temp=temp.next;
		}
		return temp.val;
};

	/**
 	* Add item e at position index
 	* 
 	* @param index
 	* @param element
 	*/
	@Override
	public void add(int index, E e){
		Node temp1 = new Node();
		Node temp2 = new Node();
		Node add = new Node();
		add.val = e;
		temp1=front;
		temp2=temp1.next;
		for(int i =0;i<index;i++){
			temp1=temp1.next;
			temp2=temp1.next;
		}
		temp1.next=add;
		add.next=temp2;
		size++;		
	};

	/**
 	* Remove the item at position index
 	* 
 	* @param index
 	*/
	@Override
	public void remove(int index){
		if(this.size()==0||index>=this.size()){
			System.out.println("It is impossible");
		}
		else if (index==this.size()-1){
			
		}
		Node temp1 = new Node();
		Node temp2 = new Node();
		temp1=front;
		temp2=temp1.next;
		for(int i =0;i<index;i++){
			temp1=temp1.next;
			temp2=temp1.next;
			if(index==this.size()-1){
				
			}
		}
		temp1.next=temp2.next;
		size--;
	};

	/**
 	* Remove any occurrences of element e from the list and return how many were removed
 	* 
 	* @param e the element to remove
 	* @return how many occurrences of e were removed
 	*/
	@Override
	public int remove(E e){
		int count=0;
		Node temp1 = new Node();
		Node temp2 = new Node();
		temp1=front;
		temp2=temp1.next;
		for(int i =0;i<size;i++){
			temp1=temp1.next;
			temp2=temp1.next;
			if(temp2.val==e){				
				temp1=temp2;
				size--;
				count++;
			}	
		}
		return count;
	};

}