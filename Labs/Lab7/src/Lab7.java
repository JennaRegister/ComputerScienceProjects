import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//Part 2
		double num; //initialization
		double square;
		int counter = 0;
		System.out.println("Enter a number and I will square it! Enter 0 to quit the program.");//gather input
		num = scan.nextDouble();
		
		//while loop, ends with sentinel value 0
		while (num != 0){
			square = (num * num);
			System.out.println("The square of that is " + square +".");
			counter = counter + 1;
			System.out.println("Enter a number and I will square it! Enter 0 to quit the program.");
			num = scan.nextDouble();
			
			
		}
		System.out.println("See ya later, alligator!");
		
		//Part 3
		System.out.println("Enter the name of a rugby position so I can assess your rugby know-how! If you don't know an answer, type Q to quit!");
		String entered = scan.next();
		if ((entered.equalsIgnoreCase("Flyhalf")) || (entered.equalsIgnoreCase("Fullback")) || (entered.equalsIgnoreCase("Scrumhalf")) || (entered.equalsIgnoreCase("Flanker")) || (entered.equalsIgnoreCase("Prop")) || (entered.equalsIgnoreCase("Wing")) || (entered.equalsIgnoreCase("Hooker")) || (entered.equalsIgnoreCase("Lock"))){
			System.out.println("You got it! Rugby " + entered + " it is!");
		}
		else{
		if (entered.equalsIgnoreCase("Q")){
			System.out.println("Wasn't even worth a try? You need to brush up on your rugby knowledge!");
		}
		else {
			System.out.println("You need to brush up on your rugby knowledge!");
		}
		}
		//Part4
		double pi = 0;
		int running=1000000000;
		double sign = 1.0;
		double precision = .0000001;
		double term;
			for (int i=0; i<= running; i++){
				term= sign*(4.0/(2.0*i+1));
				if ((Math.abs(term)) < precision){
					System.out.println("Estimated pi is: " + pi);
					System.out.println("The number of terms for this precision is: " + i);
					i = running;
				}
				pi = pi + term;
				sign = -(sign);
			}
		
		//Part5: IT IS NOT TIME FOR CHRISTMAS SONGS YET!!! On the first day of HALLOWEEN...?
		System.out.println("\n");
		String verseString = null;
		int theverse = 12;
		for(int verse=1; verse <=theverse; verse++) {
		System.out.print("On the ");
		switch (verse) {
		case 1: verseString = "first";
				break;
		case 2: verseString = "second";
				break;
		case 3: verseString = "third";
				break;
		case 4: verseString = "fourth";
				break;
		case 5: verseString = "fifth";
				break;
		case 6: verseString = "sixth";
				break;
		case 7: verseString = "seventh";
				break;
		case 8: verseString = "eighth";
				break;
		case 9: verseString = "ninth";
				break;
		case 10: verseString = "tenth";
				break;
		case 11: verseString = "eleventh";
				break;
		case 12: verseString = "twelth";
				break;
		}
		verseString += (" day of Christmas, my true love gave to me: ");
		
		
		switch (verse) {
		case 12: verseString += "twelve drummers drumming, ";
		case 11: verseString += "eleven pipers piping, ";
		case 10: verseString += "ten lords-a-leaping, ";
		case 9: verseString += "nine ladies dancing, ";
		case 8: verseString += "eight maids-a-milking,  ";
		case 7: verseString += "seven swans-a-swimming, ";
		case 6: verseString += "six geese-a-laying, ";
		case 5: verseString += "FIVE GOLDEN RIIIIINGS, ";
		case 4: verseString += "four calling birds, ";
		case 3: verseString += "three french hens, ";
		case 2: verseString += "two turtle doves, and ";
		case 1: verseString += "a partridge in a pear tree.";
		}
		System.out.println(verseString);
		System.out.println("\n");
		}
	}

}
