import java.util.Arrays;


public class SortTest {
	private static int count;
	public static void main(String args[]) {
		 long startTime, endTime, elapsedTime;
		 int size = Integer.parseInt(args[0]);
	
		 Integer [] a = new Integer[size];
		 Integer [] b = new Integer[size];
	
		 for (int i = 0; i < size; i++) {
			 a[i] = b[i] = (int)(Math.random() * 100);
		 }


	 System.out.println(Arrays.toString(a));
	 count = 0;
	 startTime = System.currentTimeMillis();
	 //bubblesort(a);
	 //insertionSort(a);
	 //shellsort(a);
	 //Arrays.sort(a);
	 endTime = System.currentTimeMillis();
	 elapsedTime = endTime - startTime;
	 System.out.println(Arrays.toString(a));
	 System.out.println("sorting took "+ count + " moves to sort "
	 + size + " items");
	 System.out.println("\t in : "+ elapsedTime + " millesec"); 

	 // Reset count and array
	 count = 0;
	 for (int i = 0; i < size; i++){
		 a[i] = b[i];
	 }
 }
	 public static <AnyType extends Comparable<? super AnyType>>
	 void bubblesort(AnyType[] a) {
		 for (int i = 0; i < a.length; i++) {
			 for (int j = 0; j < a.length - 1; j++) {
				 if (a[j].compareTo(a[j + 1]) > 0) {
					 AnyType tmp = a[j];
					 count++;
					 a[j] = a[j + 1];
					 count++;
					 a[j + 1] = tmp;
					 count++;
				 }
			 }
		 }
	}
	 
	 public static <AnyType extends Comparable<? super AnyType>>
	  void insertionSort( AnyType []a){
	  int j;
	  for( int p = 1; p < a.length; p++ ){
		  AnyType tmp = a[ p ];
		  count++;
		  for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- ){
			  	a[ j ] = a[ j - 1 ];
		  		count++;
		  }
		  a[ j ] = tmp;
		  count++;
		 }
	  }
	 
	 
	 public static <AnyType extends Comparable<? super AnyType>>
	  void shellsort( AnyType [ ] a )
	  {
	  int j;
	 
	  //for( int gap = a.length / 2; gap > 0; gap /= 2 )
	  //for( int gap = (int)Math.pow(2,a.length); gap > 0; gap /=2)
	  for(int gap=(int) Math.pow(2, (Math.log(a.length)/Math.log(2)-1)); gap>0; gap/=2)
		  for( int i = gap; i < a.length; i++ ){
			  AnyType tmp = a[ i ];
			  count++;
			  for( j = i; j >= gap &&
					  tmp.compareTo( a[ j - gap ] ) < 0; j -= gap ){
				  a[ j ] = a[ j - gap ];
				  count++;
			  }
			  a[ j ] = tmp;
			  count++;
		  }
	  }
	 
	 
	  }
	 



