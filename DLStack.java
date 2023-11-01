
public class DLStack<T> implements DLStackADT<T> {                      // this class represents an extended stack ADT implemented using a doubly linked list

	// instance variables
	private DoubleLinkedNode<T> top;                                    // reference to the node at the top of the stack
	private int numitem;                                                // number of data items stored in the stack

	public DLStack() {                                                  // creates an empty stack
		top = null;
		numitem = 0;
	}

	/**
	 * @dataitem data to be insterted in the list
	 */
	public void push(T dataitem) {                                      // adds the given dataItem to the top of the stack
		DoubleLinkedNode<T> node = new DoubleLinkedNode<T>(dataitem);
		
		if (top == null) {
			top = new DoubleLinkedNode<T>();
			// node.setElement(dataitem);
			node.setNext(null);
			node.setPrevious(null);
			top.setNext(node);
			++numitem;
			return;
		}

		node.setNext(null);
		node.setPrevious(top.getNext());
		top.getNext().setNext(node);
		top.setNext(node);
		++numitem;
	}

	/**
	 * This function will delete an element from the stack
	 * and throws and emptystackexception when empty
	 */
	public T pop() throws EmptyStackException {
		
		if (top == null)
			throw new EmptyStackException("Stack UnderFlow");
		T element = top.getNext().getElement();
		top.setNext(top.getNext().getPrevious());
		
		if (top.getNext() == null)
			top = null;
		// else
		// 	top.setNext(top.getNext().getPrevious());
		--numitem;
		return element;
	}

	/**
	 * This function will delete an element from the stack
	 * at specific position and throws and
	 * emptystackexception when empty and InvalidItemException
	 * when position doesn't exists.
	 */
	public T pop(int k) throws InvalidItemException {
		
		if (k > numitem)
			throw new InvalidItemException("Position Doesn't Exists");
		
		if (top == null)
			throw new EmptyStackException("Stack Underflow");
		
		if (k == 1)
			return pop();
		DoubleLinkedNode<T> ptr = top.getNext();
		DoubleLinkedNode<T> pptr = null;
		
		while (k-- > 1) {
			pptr = ptr;
			ptr = ptr.getPrevious();
		}
		
		T element = ptr.getElement();
		if (ptr.getPrevious() == null) {
			ptr.getNext().setPrevious(null);
			return element;
		}
		
		ptr.getPrevious().setNext(ptr.getNext());
		pptr.setPrevious(ptr.getPrevious());
		--numitem;
		return element;
	}

	/**
	 * Returns the top most element from the stack
	 */
	public T peek() throws EmptyStackException {
		
		if (top == null)
			throw new EmptyStackException("Stack UnderFlow");
		return top.getNext().getElement();
	}

	/**
	 * Get the emptyness of the list.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Return the size of the list.
	 */
	public int size() {
		return numitem;
	}

	/**
	 * Return the stack
	 */
	public DoubleLinkedNode<T> getTop() {
		return top.getNext();
	}

	/**
	 * Overrides the default toString method to get Correct output.
	 */
	@Override
	public String toString() {
		DoubleLinkedNode<T> ptr = top;
		String str = "[";
		
		while (ptr != null) {
			str += ptr.getElement();
			ptr = ptr.getNext();
		}
		str += "]";
		return str;
	}

}