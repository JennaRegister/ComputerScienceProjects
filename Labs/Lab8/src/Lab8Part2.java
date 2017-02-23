import java.util.Scanner;


public class Lab8Part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Part2
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter two integer temperatures in Fahrenheit! Once again, we will be converting to Celsius. ");
		int deg1= scan.nextInt();
		int deg2 = scan.nextInt();
		for(int i=deg1; i <= deg2 ;){
			double cels = (i-32.0)*5/9;
			System.out.printf("%2d F\t", (i));
			System.out.printf("%8f C\n",(cels));
			i++;
		}

	}

}
