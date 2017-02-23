
public class Part1 {
	public static void main(String[] args) {
		//given to us from the Lab instructions:
		Integer [] intArry = {1, 2, 3, 4, 5 };
		Double [] doubArry = {1.1, 2.2, 3.3, 4.4};
		Character [] charArry = {'H','E','L', 'L', 'O' };
		String [] strArry = {"once", "upon","a","time"};
		//Part 01: Using printarray(Object[]a)
		/*printarray(intArry);
		printarray(doubArry);
		printarray(charArry);
		printarray(strArry);*/
		
		//Part 02: Using overloading... UGH.
		/*printintarray(intArry);
		printdoubarray(doubArry);
		printchararray(charArry);
		printstrarray(strArry);*/
		
		//Part 03: Generics
		printarray(intArry);
		printarray(doubArry);
		printarray(charArry);
		printarray(strArry);
		
		//Part 04: Non-generic Comparable
		//given to us from the lab instructions:
		/*System.out.println(getMax(intArry));
		System.out.println(getMax(doubArry));
		System.out.println(getMax(charArry));
		System.out.println(getMax(strArry));
		
		/*COMPILE TIME ERROR:
		*Type safety: The method compareTo(Object) belongs to the raw type Comparable. References to generic type Comparable<T> should be parameterized
		*/
		
		//Part 05: Generic Comparable
		System.out.println(getMax(intArry));
		System.out.println(getMax(doubArry));
		System.out.println(getMax(charArry));
		System.out.println(getMax(strArry));
		
		
		
		
	}
	//PART 01: This code is TOO general, and wouldn't catch the right type errors at compile time.
	/*public static void printarray(Object[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");	
	}*/
	//PART 02: Overloading. Rewriting code to basically accomplish the same thing, with slight differences (the types)
	public static void printintarray(Integer[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");	
	}
	public static void printdoubarray(Double[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");	
	}
	public static void printchararray(Character[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");	
	}
	public static void printstrarray(String[]a){
		for(int z=0;z<a.length;z++){
			System.out.print(a[z]+" ");	
		}
		System.out.println("\n");	
	}
	
	//PART 03: Generics 
	public static <T> void printarray(T[] a){
		for(T element:a){
			System.out.print(element+" ");
		}
		System.out.println("\n");
		
	}
	//PART 04: Non-generic Comparable getMax
	/*public static Comparable getMax(Comparable [] a){
		int max=0;
		for(int n=0;n<a.length;n++){
			if(a[n].compareTo(a[max])>0){
				max=n;
			}
		}
		return a[max];
		
	}*/
	//PART 05: Generic Comparable getMax
	public static <AnyType extends Comparable<? super AnyType>>
	AnyType getMax(AnyType [] a){
		int max=0;
		for(int n =1; n<a.length; n++){
			if(a[n].compareTo(a[max])>0){
				max=n;
			}
		}
		return a[max];
			
	}
	

	
}
