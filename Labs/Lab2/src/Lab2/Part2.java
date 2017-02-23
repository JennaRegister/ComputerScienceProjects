package Lab2;
import java.util.Scanner;
public class Part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is a nifty converter that can convert Fahrenheit to Celsius. Because you never know when you'll need that...");
		Scanner input = new Scanner (System.in);
		int temp;
		System.out.println("What is the current temperature in Fahrenheit? Please give it to me to the nearest degree, I'm a simple man.");
		temp = input.nextInt();
		int convert = (temp - 32)*5/9;
		System.out.println("The temperature in Celsius is: " + convert + " degrees!");
		System.out.println("Congratulations, you're not in America anymore!");

	}

}
