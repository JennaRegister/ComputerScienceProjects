package Lab2;
import java.util.Scanner;
public class Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This program shows basic arithmentic operations! I need two decimal numbers to work with.");
		Scanner input = new Scanner (System.in);
		double number1;
		double number2;
		System.out.println("Give me the first number!");//prompting for number1
		number1 = input.nextDouble(); //reads from user, saves as number1
		System.out.println("Alright, now the second!");
		number2 = input.nextDouble(); //reads from user, saves as number2
		System.out.println("Alright now I'm going to do some nifty math!");
		double add = number1 + number2;
		double sub = number1 - number2;
		double div = number1 / number2;
		double mul= number1 * number2;
		System.out.println("Adding " + number1 + " and " + number2 + " gives us: " + add);
		System.out.println("Subtracting " + number2 + " from " + number1 + " gives us: " + sub);
		System.out.println("Dividing " + number1 + " by " + number2 + " gives us: " + div);
		System.out.println("Multiplying " + number1 + " by " + number2 + " gives us: " + mul);
		System.out.println("Well done, you are officially satisfactory and rudimentary in my eyes. Have a nice day.");
	}

}
