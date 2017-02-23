
public class Main {
	public static void main(String [] args){
	MyBST b=new MyBST();
	b.insert(5);
	b.insert(18);
	b.insert(0);
	b.insert(16);
	b.insert(29);
	b.insert(10);
	b.insert(17);
	b.insert(23);
	b.insert(28);
	b.insert(21);
	b.insert(22);
	b.insert(3);
	b.insert(2);
	b.insert(4);
	b.insert(1);
	b.insert(-4);
	b.insert(-3);
	System.out.println("Printing inOrder:");
	b.printInOrder();
	System.out.println("Printing preOrder:");
	b.printPreOrder();
	System.out.println("Printing postOrder:");
	b.printPostOrder();
	System.out.println(b.lookup(2));
	b.delete(5);
	b.delete(0);
	b.delete(-4);
	System.out.println("Printing inOrder:");
	b.printInOrder();
	
	
	}
	

}
