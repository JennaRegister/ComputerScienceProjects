
public class MyLinkedList<AnyType>implements SimpleLinkedList<AnyType> {
	
	MyNode<AnyType> head= null;
	//This is the placeholder for the beginning of the Linked List!
	
	//if there is no beginning to the list, there is no list at all!
	public boolean isEmpty(){
		if (head==null){
			return true;	
		}
		else{
		return false;
		}
	}
	
	//This works by inserting after the first node and "sliding" down
	public void insert(AnyType x){
		//if(!lookup(x)){
		MyNode<AnyType> newlink= new MyNode<AnyType>();
		newlink.data=x;
		newlink.next=head;
		head=newlink;
		//}
	}
	//Here you must set a temp Node, because you can't actually change head every time.
	public void printList(){
		MyNode<AnyType> temp = head;
		while(temp!=null){
			System.out.println((temp.data).toString());
			temp=temp.next;//traverse
		}
	}
	//this will compare data and report if the item is already in the current list
	public boolean lookup(AnyType x){
		//System.out.println("Got here!!!");
		MyNode<AnyType> tmp= new MyNode<AnyType>();
		tmp=head;
		
		while(tmp != null){
			int found =tmp.data.toString().compareTo((x.toString()));
			if(found==0){
				//System.out.println("LL");
				return true;
			}
			tmp=tmp.next;
		}
		return false;
	}
	
	//delete must first lookup the object, then reroute the references to "ignore" the deleted item!
	//must use a temporary Node!!
	public void delete(AnyType x){
		if(!isEmpty()){
		MyNode<AnyType> tmp = new MyNode<AnyType>();
		MyNode<AnyType> before = new MyNode<AnyType>();
		before=head;
		tmp=head;
		while(tmp != null){
			if((boolean) (tmp.data==x)){
				if(tmp==before){
				before=tmp.next;	
				}
				else{
					before.next=tmp.next;
				}
			}
			before=tmp;
			tmp=tmp.next;
		
		}
	}
	}
	public AnyType popit(){
		AnyType value = null;
		if(!isEmpty()){
			value= head.data;
			head=head.next;	
			
		}
		return value;	
	}
	public AnyType peekit(){
		AnyType value = null;
		if(!isEmpty()){
			value= head.data;
		}
		return value;
	}
	public int size() {
		   int size = 0;
		for(MyNode n = head; n.next != null; n = n.next)
		       size++;     
		   return size;
		}



}
	



		
			

