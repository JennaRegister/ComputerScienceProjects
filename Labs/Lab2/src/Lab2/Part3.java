package Lab2;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to America, where we are different from the rest of the world. I can convert Celsius to Fahrenheit to make it easier for you.");
		String temp = JOptionPane.showInputDialog("What is the temperature in Celsius? Nearest degree please.");
		int tempnum = Integer.parseInt(temp);//I wanted temperature in simple degrees, not a double
		int convert = (tempnum * 9/5)+32;
		JOptionPane.showMessageDialog(null, "The temperature in Fahrenheit is: " + convert + " degrees.");
		if (convert <= 32)
			JOptionPane.showMessageDialog(null, "Brrr baby that's cold! You must be in Rochester.");
		if (convert >= 100)
			JOptionPane.showMessageDialog(null, "Ow ow baby, that's hot! Better get out of there!");
			
			
		
		

	}

}
