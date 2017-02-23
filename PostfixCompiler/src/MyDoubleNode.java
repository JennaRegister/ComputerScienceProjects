
public class MyDoubleNode<AnyType> {
	public AnyType data;//The addresses, or Nodes, contain data (e.g.  int 17, 'a', 'wonderland', etc).
	public MyDoubleNode<AnyType> next;
	public MyDoubleNode<AnyType> prev;
	//The cool thing about Doubly Linked Lists is that you can move backwards! Here we include another "address" of a Node, with "prev".
	public MyDoubleNode(){//a constructor that sets item to null
		
	}
	public MyDoubleNode(MyDoubleNode<AnyType> n, MyDoubleNode<AnyType> p){//a constructor that will be useful when creating new Nodes
		next=n;
		prev=p;
	}

}
