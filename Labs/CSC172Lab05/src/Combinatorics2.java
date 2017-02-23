import java.math.BigInteger;


public class Combinatorics2 {
	public static void main(String [] args){
		//for the word "error"
		int [] errorgroups = {1,1,3};
		//for the word "street"
		int [] streetgroups = {1,1,2,2};
		//for the word "allele"
		int [] allelegroups = {1,3,2};
		//for mississippi
		int [] missgroups = {1,4,4,2};
		System.out.println("The number of anagrams for 'error': "+order_identical(5,errorgroups));
		System.out.println("The number of anagrams for 'street': "+order_identical(6,streetgroups));
		System.out.println("The number of anagrams for 'allele': "+order_identical(6,allelegroups));
		System.out.println("The number of anagrams for 'Mississippi': "+order_identical(11,missgroups));
		System.out.println("The ways to distribute 6 apples to 4 kids: " +distbins(6,4));
		System.out.println("The ways to distribute 4 apples to 6 kids: " +distbins(4,6));
		//groups for the fruits
		int [] classes = {6,3};
		int [] classes2 = {2,5,6};
		System.out.println("Ways to distribute 6 apples and 3 pears to 5 children: "+doubledist(9,5,classes));
		System.out.println("Ways to distribute 2 apples,5 pears, and 6 bananas to 3 children: "+doubledist(13,3,classes2));
				
	}
	//1. Here we cycle through the different groups/classes to account for the duplication. Technically, order matters for the ENTIRE word, but not for the duplicates. "tt" is the same as "tt", so we have to "take out" the fact that order matters. It's almost as if we "take out" the permutation.
	public static BigInteger order_identical(int n, int [] a){
		int i;
		BigInteger d=BigInteger.ONE;
		for(i=0;i<a.length;i++){
			d=d.multiply(fact(a[i]));		
		}
		BigInteger value=fact(n).divide(d);
		return value;
		
		
	}
	// recursive factorial function
	public static BigInteger fact(int n){
		if(n==1){
			return BigInteger.valueOf(1);
		}
		return fact(n-1).multiply(BigInteger.valueOf(n));
	}
	//2. Distributing into bins, can use the recursive choose function and this special relationship
	public static BigInteger distbins(int n, int r){
		return choose(n+r-1,n);
	}
	
	//technically this is the Unordered Select function from the last lab. It is a recursive version of "choose" (vocabulary in combinatorics)
	public static BigInteger choose(int n, int r){
		if(n==r)
			return BigInteger.ONE;
		
		if(r==1)
			return BigInteger.valueOf(n);
		
		return choose(n-1,r).add(choose(n-1,r-1));
	}
	//3. We can use the function written in Part 1 to write Distributing Distinguishable Objects into Bins
	public static BigInteger doubledist(int n, int r, int [] a){
		int i;
		BigInteger d=BigInteger.ONE;
		BigInteger finald;
		for(i=0;i<a.length;i++){
			d=d.multiply(fact(a[i]));		
		}
		finald=fact(r-1).multiply(d);
		BigInteger value=fact(n+r-1).divide(finald);
		return value;
		
		
	}
	
	
}
