import java.util.Scanner;
public class Lab8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Part1
		
		String verse = "";
		for(int bottles = 99; bottles >= 1; bottles--){
			verse = (bottles + " bottles of beer on the wall, " + bottles + " bottles of beer! You take one down, pass it around, " + (bottles - 1) + " bottles of beer on the wall!");
			System.out.println(verse);
			System.out.println("\n");
		}
		int bottles = 0;
		if(bottles == 0){
			System.out.println(bottles + " bottles of beer on the wall, " + bottles + " bottles of beer! Go to the store, buy some more! \n");
			bottles = 99;
			System.out.println(bottles + " BOTTLES OF BEER ON THE WALL!");
			System.exit(0);
		}
	
	}

}
