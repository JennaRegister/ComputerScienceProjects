

public class Lab02 {
	public static void main(String[] args){
		MyLinkedList<Character> l= new MyLinkedList<Character>();//creating a Linked List of Characters
		
		l.insert('c');
		l.insert('a');
		l.insert('t');
		l.insert('t');
		l.insert('t');
		System.out.println("The list is empty: " + l.isEmpty()); // it isn't empty, as I have inserted many things
		l.printList();
		System.out.println("In this list? " + l.lookup('b'));
		System.out.println("In this list? " + l.lookup('c'));
		l.delete('a');
		l.printList();
		
				
		}
}
	