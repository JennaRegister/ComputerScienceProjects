import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class Main {
	public static void main(String [] args){
		MyHeap heap=new MyHeap(1);
		heap.insert(3);
		System.out.println("Printing the heap:");
		heap.printHeap();
		heap.insert(4);
		System.out.println("Printing the heap:");
		heap.printHeap();
		heap.insert(5);
		System.out.println("Printing the heap:");
		heap.printHeap();
		heap.insert(2);
		System.out.println("Printing the heap:");
		heap.printHeap();
		heap.insert(1);
		System.out.println("Printing the heap:");
		heap.printHeap();
		
		heap.deleteMin();
		System.out.println("Printing after deleteMin");
		heap.printHeap();
		heap.deleteMin();
		System.out.println("Printing after deleteMin");
		heap.printHeap();
		heap.deleteMin();
		System.out.println("Printing after deleteMin");
		heap.printHeap();
		
		
		System.out.println("Now I am going to create an array of random numbers, with null at the 0th element.");
		System.out.println("Print the array:");
		Integer [] a = new Integer [10];
		for(int i=0; i<a.length; i++){
				a[i]=i+1;	
		}
		Collections.shuffle(Arrays.asList(a));
		a[0]=null;
		
		System.out.println(Arrays.toString(a));
		MyHeap thenewheap=new MyHeap(a);
		System.out.println("Now Heapify it!");
		thenewheap.printHeap();
		System.out.println("Testing the deleteMin one more time!");
		thenewheap.deleteMin();
		thenewheap.printHeap();
		
	}

}
