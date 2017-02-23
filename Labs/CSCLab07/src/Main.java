
public class Main {
	public static void main(String [] args){
	MyQueue<String> thequeue = new MyQueue<String>();
	System.out.println(thequeue.isEmpty());
	thequeue.enqueue("Achilles");//get in line
	thequeue.enqueue("and");//get in line
	thequeue.enqueue("the");//get in line
	thequeue.enqueue("Tortoise");//get in line
	
	
	thequeue.dequeue();//leaves the queue
	System.out.println(thequeue.peek());//check the front of the line
	thequeue.dequeue();//leaves the queue
	System.out.println(thequeue.peek());//check the front of the line
	thequeue.dequeue();//leaves the queue
	System.out.println(thequeue.peek());//check the front of the line
	thequeue.dequeue();//leaves the queue
	System.out.println(thequeue.peek());//check the front of the line
	//notice, this works in the opposite direction from a Stack. This time, the sentence reads FORWARDS, because it is a FIFO structure.
	
	}
}
