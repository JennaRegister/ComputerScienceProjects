
public interface Heap<T extends Comparable<T>> {
	public void insert(T item);
	public boolean isEmpty(T[] h);
	public int size(T[] h);
	public T deleteMin();

}
