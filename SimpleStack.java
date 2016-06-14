public class SimpleStack<E> implements ISimpleStack<E> {
	// Composition. It ¡°Has-A¡± list.
	private SinglyLinkedList a = new SinglyLinkedList();
	
	@Override
	public boolean isEmpty() {
		if (a.size()==0){
			return true;
		}
		else 
			return false;
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		a.add(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		
		E b = (E) a.get(a.size()-1);		
		a.remove(a.size()-1);
		return b;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		
		return (E) a.get(a.size()-1);
	}

}
