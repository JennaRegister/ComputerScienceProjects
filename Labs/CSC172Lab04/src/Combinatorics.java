import java.math.BigInteger;


public class Combinatorics {
	public static void main(String [] args){
		System.out.println("How many ways can we paint three houses in any four colors? "+ countassign(3,4));
		System.out.println("How many computer passwords can be made 8-10 using digits and/or uppercase/lowercase letters? "+ countassign(8,62)+","+countassign(9,62)+","+countassign(10,62));
		System.out.println("How many batting orders can there be with 9 baseball players? "+countpermute(9));
		System.out.println("How many options for Student Council out of 200 students (4 positions) are there? " + orderselect(200,4));
		System.out.println("a. Forming a sequence of 3 letters, without repetition: "+ orderselect(26,3));
		System.out.println("b. Forming a sequence of 5 letters, without repetition: "+ orderselect(26,5));
		System.out.println("Poker hands of 5 cards out of a 52 card deck: "+ unorderselect(52,5));
		System.out.println("Poker hands of 5 cards out of a 52 card deck (recursively): "+ undorderselect2(52,5));
		
	}
	
	//1. Counting Assignments
	public static BigInteger countassign(int n,int k){
		BigInteger value = BigInteger.valueOf( (long) Math.pow(k, n));
		return value;
		
	}
	//2.Permutations: order matters!
	public static BigInteger countpermute(int n){
		BigInteger value = factorial(n);
		return value;
	}
	//3. Ordered Selections: think of this as "competing" for the top 3 spots!
	public static BigInteger orderselect(int n, int r){
		BigInteger value = (factorial(n)).divide(factorial(n-r));
		return value;
	}
	//4.Unordered Select: non-recursive test.
	public static BigInteger unorderselect(int n, int r){
		BigInteger value= (factorial(n)).divide((factorial(n-r)).multiply(factorial(r)));
		return value;
	}
	//4. Unordered Select: recursive version
	public static BigInteger undorderselect2(int n, int r){
		if(n==r)
			return BigInteger.ONE;
		
		if(r==1)
			return BigInteger.valueOf(n);
		
		return undorderselect2(n-1,r).add(undorderselect2(n-1,r-1));
	}
	
	//a NON-recursive version of the factorial function. See next lab for recursive version.
	public static BigInteger factorial(int n){
		int count;
		BigInteger f = BigInteger.ONE;
		for(count=1;count<=n;count++){
			f=f.multiply(BigInteger.valueOf(count));
		}
		return f;
	}
	
	
	
	

}
