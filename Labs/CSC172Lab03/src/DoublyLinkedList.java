
public interface DoublyLinkedList<AnyType> {
	public void insert(AnyType x);
	public void delete(AnyType x);
	public boolean lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
	public void printListRev();

}
//this interface is mostly used for organization! Sets up what methods we will have.
