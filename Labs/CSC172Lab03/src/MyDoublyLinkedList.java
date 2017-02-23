
public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	//We can think of "head" and "tail" as bookends on a shelf. 
	//Right now, there are no books between the bookends. So if "head" is directly referencing "tail",then there are no books on the shelf!
	MyDoubleNode<AnyType> head;
	MyDoubleNode<AnyType> tail;
public MyDoublyLinkedList(){
	//here we route all the pointers to properly reference the right places.
	head= new MyDoubleNode<AnyType>();
	tail =new MyDoubleNode<AnyType>();
	head.next=tail;
	head.prev=null;
	tail.prev=head;
	tail.next=null;
}
//this boolean will traverse through the list until it finds a matching data point. If there is a match, it has "looked it up" and found it. If there is not a match, return false.
	public boolean lookup(AnyType x) {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> current=head;
		while(current!=tail){
			if(x.equals(current.data)){
				return true;
			}
			current=current.next;
		}
		return false;
	}
//Insert works by "rerouting" references. You "detach" references, insert new ones, and reroute the references so that you have inserted a link into a chain.
	public void insert(AnyType x) {
		
		// TODO Auto-generated method stub
		if(!lookup(x)){
		MyDoubleNode<AnyType> newlink=new MyDoubleNode(head.next,head);//the new link with unique data! It is now pointing AHEAD to head.next and BEHIND to head
		newlink.data=x;//assigning the data into its container (Node)
		(head.next).prev=newlink;//reroute the "broken" pointers
		head.next=newlink;
		}
		else{
			System.out.println("You are trying to insert an item that is already in the list!");
		}
	}
//Delete actually works in a similar way to Insert. First you lookup the item. Second, you must reroute references to "ignore" the deleted item. It doesn't actually go anywhere (until it is swept up later), but it will no longer be reported or printed.
	
	public void delete(AnyType x) {
		// TODO Auto-generated method stub
		MyDoubleNode current = head;
		if(lookup(x)){
		while(current!=tail){
			if(x.equals(current.data)){
				//System.out.println("Found it!");
				(current.next).prev=current.prev;
				(current.prev).next=current.next;
				return;
				
			}
			current=current.next;
		}
		}
		else{
			System.out.println("You are trying to delete an item that is not in the list!");
		}
	}
	//This is the idea of "bookends". If head is directly referencing tail, nothing has been inserted in between!	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head.next==tail);
	}
	
	public void printList() {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> current = head.next;
		while(current!=tail){
			System.out.println(current.data);
			current=current.next;
		}
		
	}
	public void printListRev() {
		// TODO Auto-generated method stub
		MyDoubleNode<AnyType> current=tail.prev;
		while(current!=head){
			System.out.println(current.data);
			current=current.prev;
		}
		
	}


}
