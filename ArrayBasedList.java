/**
 * 
 * @author Shuangjiao Hu
 * @ID 1571979
 *
 */
public class ArrayBasedList implements ISimpleList{
	
	// initial length of array
	private int length =4;
	// the size of the array
	private int size =0;
	// the based string array 
	private String[] list = new String[length];
	
	
	// double the length if hit the boundary
	// O(n)
	public String[] ensureCapacity(){
		// new double length array
		String[] newList = new String[2*list.length];
		// put old array into new array
		for (int i =0; i<list.length; i++){
			newList[i] = list[i];
		}
		return newList;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub		
		return size;
	}

	@Override
	// O(1)
	public void add(String e) {
		// TODO Auto-generated method stub
		// check the boundary of array
		if (size>=this.size()){
		list=this.ensureCapacity();
		}
		// add the element
		list[size]=e;
		// size of the list add one
		size++;
	}

	@Override
	// O(1)
	public String get(int index) {
		// TODO Auto-generated method stub
		return list[index];
	}

	@Override
	// O(n)
	public void add(int index, String e) {
		// TODO Auto-generated method stub
		// check the boundary of array
		if (size>=this.size()){
			list=this.ensureCapacity();
			}
		// move each element back one by one
		for(int i=size;i>index;i--){
			list[i]=list[i-1];			
			}
		//insert the element at index
		list[index]=e;
		//size of list increase by one
		size++;
	}

	@Override
	// O(n)
	public void remove(int index) {
		// TODO Auto-generated method stub		
		// move each element ahead one by one
		for(int i=index;i<size;i++){
		list[i]=list[i+1];
		}
		// size decrease by 1
		size--;
		// delete the extra element
		list[size]=null;
	}
	
	
	@Override
	// O(n)
	public int remove(String e) {
		// TODO Auto-generated method stub
		// record how many time the removed element appear
		int time=0;
		for(int i=0;i<this.size();i++){
			// find out the element
			if(this.get(i)==e){
				// remove the element
				this.remove(i);
				time++;
			}
		}		
		return time;
	}
}
