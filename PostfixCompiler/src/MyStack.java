
public class MyStack<AnyType> implements Stack<AnyType> {
	MyLinkedList<AnyType> stack = new MyLinkedList<AnyType>();
	
	//checks to see if the stack is empty
	public boolean isEmpty() {
		
		return stack.isEmpty();
	}

	//inserts to the top of the stack (pushes everything else down)
	public void push(AnyType x) {
		stack.insert(x);
		
	}

	//pops off from the top, similar to deleting, but from the top only.
	public AnyType pop() {
		return stack.popit();
	}

	//Can look at the data contained in the head
	public AnyType peek() {
		
		return stack.peekit();
		
	}
	//SIZE OF STACK?
	public int size(){
		return stack.size();
	}
	
	

}
