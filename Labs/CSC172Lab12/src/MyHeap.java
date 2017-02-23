
public class MyHeap<T> implements Heap{
	public MyHeap(){
	T [] theheap=(T[]) new Comparable [10];
	int currentsize;
	}
	public MyHeap(int capacity){
		T [] theheap=(T[]) new Comparable [capacity];
		int currentsize=theheap.length;
	}
	public int size(T[] h){
		return h.length;
	}
	public boolean isEmpty(T[] h){
		if(h==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void insert(Comparable item) {
		
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comparable deleteMin() {
		// TODO Auto-generated method stub
		return null;
	}

}
