import java.util.ArrayList;


public class Lab11 {
	public static void main(String[] args){
	Address1();	
	Address1();
	Address1();
	Address2();
	Address2();
	System.out.println(Address2());//just to prove that the return statement is working!
	System.out.println(Factorial(3));
	System.out.println(Prime(13));
	System.out.println(Prime(12));
	Prime100();
	GCD(6,12);
	GCD(6.2,12.3);
	System.out.println(Max(2,3,4,5,1,2,3,7,17));
	}
	//PART1
	public static void Address1(){
		String name = ("Pythagoras");
		String address = ("314 Pi Circle.");
		System.out.println(name + " lives at " + address);
	}
	//PART2
	public static String Address2(){
		String name2 = ("Alice");
		String address2 = ("Infinity Wonderland Heights");
		return (name2 + " lives at " +  address2);	
	}
	//PART3
	public static int GCD(int x, int y){
		if (y>x){
			int z=x;
			x=y;
			y=z;
		}
		while(x%y !=0){
			int z=x;
			x=y;
			y=z%y;
		}
		System.out.println("The GCD is: "+ y);
		return y;
	}
	//PART4
	public static double GCD(double x, double y){
		if (y>x){
			double z=x;
			x=y;
			y=z;
		}
		while(x%y !=0){
			double z=x;
			x=y;
			y=z%y;
		}
		System.out.println("The GCD is: "+ y);
		return y;
	}
	
	//PART5
	public static int Factorial(int n){
		int product=1;
		while(n>0){
			product = product*n ;
			n=n-1;
		}
		return product;
	}
	//PART6
	public static long Factorial(long n){
		long product=1;
		while(n>0){
			product = product*n ;
			n=n-1;
		}
		return product;
		
	}
	//PART7
	public static int Max(int...args){
		int max = args[0];
		for(int arg:args){
			if(arg>max){
				max = arg;
			}
		}
		return max;
	}
	
	//PART8
	public static boolean Prime(int k){
		boolean prime = true;//default true
		for(int i=2; i< k; i++){//between 2 and itself minus 1
			if(k%i==0){//if it can divide by anything over 1, it isn't prime!
				prime = false;
			}
		}
		return prime;//returns boolean
	}
	
	//PART9
	public static void Prime100(){
		int count = 0;
		int num =2;
		ArrayList<Integer> primes = new ArrayList<>();
		while(count < 100){
			if (Prime(num) == true){
				primes.add(num);
				count += 1;
				num += 1;	
			}
			else{
				num+=1;
			}
			
		}
		System.out.println(primes);
	}
}
