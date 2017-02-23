
public class Main {
	public static void main(String [] args){
		MyDoublyLinkedList<Character> dl = new MyDoublyLinkedList();
		System.out.println("The list is empty: " + dl.isEmpty());
		dl.insert('a');
		dl.insert('n');
		dl.insert('n');//won't insert, because it uses lookup for each insertion
		dl.insert('e');
		dl.insert('j');
		System.out.println("The list is empty: " + dl.isEmpty());//now things have been inserted! No longer empty!
		System.out.println("Here is the printed list forwards: ");
		dl.printList();
		System.out.println("Here is the printed list backwards: ");
		dl.printListRev();
		System.out.println("The item is in the list: "+ dl.lookup('j'));
		System.out.println("The item is in the list: " + dl.lookup('t'));
		dl.delete('j');
		dl.delete('p');//won't delete, because it uses lookup before each deletion
		System.out.println("Here is a printed list with an item removed:");
		dl.printList();

	}

}
