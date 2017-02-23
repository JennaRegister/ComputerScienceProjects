
public class Main {
	public static void main(String [] args){
	MyStack<String> thestack = new MyStack<String>();
	System.out.println(thestack.isEmpty());
	thestack.push("Achilles");
	thestack.push("and");
	thestack.push("the");
	thestack.push("Tortoise");
	System.out.println(thestack.size());
	System.out.println(thestack.peek());
	thestack.pop();
	System.out.println(thestack.peek());
	thestack.pop();
	System.out.println(thestack.peek());
	thestack.pop();
	System.out.println(thestack.peek());
	
	}
}
