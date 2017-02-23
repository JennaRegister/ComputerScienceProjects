import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*THIS WAS ENTIRELY FOR MY OWN PURPOSES. IT IS SIMPLY A ROUGH DRAFT ON THE REVERSE GAME (THE GAME YOU PLAY ON THE COMPUTER).
 * THE COMPUTER HAS A CODE (WHICH I PRINT OUT, FOR MY OWN PURPOSES)
 * IT ASKS FOR YOUR GUESS
 * AND REPORTS CORRECT COLOR CORRECT POSITION (BLACK PEG) AND CORRECT COLOR INCORRECT POSITION (WHITE PEG)
 */

public class ReverseGame {
	public ReverseGame(){
		/*
		 * The game in reverse is the original game. A computer generates a random code, and the user guesses. 
		 * The computer then indicates to the user how many correct colors, and correct color/position combos they have guessed.
		 */
		String [] colors = {"ORANGE","PINK","RED","BLUE","GREEN","YELLOW","PURPLE","BLACK"};
		Scanner scan = new Scanner(System.in);
		int i;
		//introduce the game
		System.out.println("Welcome to the game of Mastermind, a codebreaking game that will astound you with it's genuis. *HOW TO PLAY:blah blah blah* ");
		//Receive input for how many colors and positions
		System.out.println("How many colors would you like to play with? Maximum is 8.");
		int colornum = scan.nextInt();
		String [] currentcolors =new String [colornum];
		for(i=0;i<colornum;i++){	
			currentcolors[i]=colors[i];
		}
		System.out.println("The colors you will be using are the following:");
		for(i=0;i<colornum;i++){	
			System.out.print(currentcolors[i]+" ");
		}
		System.out.println();
		System.out.println("How many positions would you like to play with? Maximum is 8.");
		int posinum=scan.nextInt();
		System.out.println("You have chosen to play with "+ posinum + " positions.");
		String [] mycode=randomCode(currentcolors,posinum);
		//Printing just so I can see my code!
		for(int j=0;j<mycode.length;j++){
			System.out.println(mycode[j]);
		}
		System.out.println("I have generated my code. Get ready to play! Give me a guess.");
		
		//creates an array to take in the user guess
		String [] g=getGuess(posinum,mycode,scan);
		
		//my own testing
		System.out.println("Printing out the guess: ");
		for(int b=0;b<g.length;b++){
			System.out.print(g[b]+" ");
		}
		System.out.println();
		compareIt(g,mycode);
		
		
		
		
	}
	
	public String [] randomCode(String [] currentcolors, int pos){
		//array with the index possibilities to choose from {1,2,3,4...}
		int [] indexes = new int [pos];
		String [] code = new String [pos];
		int randind;
		
		for(int i=0;i<pos;i++){
			randind=(int) (Math.random()*currentcolors.length);
			
			code[i]=currentcolors[randind];
			
		}
		return code;
		
		
	}
	public void compareIt(String [] theguess, String [] thecode){
		int colorcounter =0;
		int counter=0;
		
		for(int i=0;i<theguess.length;i++){
			if(theguess[i].equals(thecode[i])){
				colorcounter+=1;
			}
			else if((new ArrayList<String>(Arrays.asList(thecode))).contains(theguess[i])){
				counter+=1;
				
				
			}
		}
		System.out.println("Colors correct and correct position: " +colorcounter);
		System.out.println("Colors correct and incorrect position: " +counter);
		
		
	}
	
	
	public String [] getGuess(int p, String [] c, Scanner s){
		//creates an array to take in the user guess
				String [] guess = new String[p];
				for(int a=0;a<c.length;a++){
					System.out.println("Enter a color guess: ");
					guess[a]=s.next();
				}
				return guess;
	}
	
	

}


