
public class MyQueue<AnyType> implements Queue<AnyType> {
	MyDoublyLinkedList<AnyType> queue = new MyDoublyLinkedList<AnyType>();

	public boolean isEmpty() {

		return queue.isEmpty();
	}

	public void enqueue(AnyType x) {
		queue.enqueue(x);		
	}


	public AnyType dequeue() {
		return queue.dequeue();
		
	}

	public AnyType peek() {
		return queue.peek();
	}
	public void printQ(){
		queue.printList();
	}
	

}
