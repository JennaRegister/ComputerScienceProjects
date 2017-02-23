
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*How does Mastermind work?
*Basically, it uses the concepts of possible Counting Assignments. 
*The user creates a "code" of colors in a determined number positions. 
*This is Counting Assignments. Each "slot" can have a certain number of choices, and since we do have repetition, the next slot has n possibilities.
*The computer makes a guess (random at first).
*The user gives a response: How many correct colors? How many correct positions?
*The computer then runs all of the possible counting assignments on its guess, and determines which possibilities would give the response that the user gave.
*The computer can then eliminate the Counting Assignments that would NOT give the response that the user gave.
*Next, it will guess one of the codes that could have given that response, then run itself again with updated info.
*It continues to narrow down, based on this concept.
*
*MAIN PROBLEM: The recursive structure to actually generate the Counting Assignments (not just know the NUMBER of them).
*Be able to "cross out" unusable guesses after comparing to the user's "black pegs" and "white pegs", and continue guessing appropriate codes.
*

*/
public class Game {
	//global variables to be accessed by all functions and the Game constructor
	String [] colors = {"RED","GREEN","BLUE","ORANGE","PURPLE","PINK","BLACK"};
	static String [][] combinations=null;
	
	
	public Game(){
	Scanner scan = new Scanner(System.in);
	int i;
	//introduce the game
	System.out.printf("Welcome to the game of Mastermind, a codebreaking game that will astound you with it's genuis. \nYou will create a code of colors in a determined number of positions (duplicates are allowed). \nAnd I will crack the code!\nI will give you a guess, and you will tell me how many CORRECT COLOR CORRECT POSITIONs I have, and CORRECT COLOR INCORRECT POSITIONs I have for that guess. \n");
	//Receive input for how many colors and positions
	System.out.println("How many colors would you like to play with? Maximum is 7.");
	int colornum = scan.nextInt();
	String[] currentcolors=new String [colornum];
	
	//JUST SO THE USER KNOWS THE COLORS THEY ARE USING THIS TIME
	System.out.println("The colors you will be using are the following:");
	for(i=0;i<colornum;i++){	
		currentcolors[i]=colors[i];
		System.out.print(colors[i]+" ");
	}
	System.out.println();
	//Unfortunately, the max is 4 positions. I guess my recursion is just too slow!
	System.out.println("How many positions would you like to play with? Maximum is 4.");
	int posinum=scan.nextInt();//number of positions
	int size=currentcolors.length;//number of colors
	combinations = new String [(int) Math.pow(size, posinum)][posinum];
	
	//ALL OF THE POSSIBLE CODES ARE CONSTRUCTED HERE
	buildCodes(currentcolors,posinum);
	print2Darray(combinations);
	
	System.out.println("Please make your code. Write it down so you don't forget!");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//print2Darray(combinations);
	System.out.println("My first guess is: ");
	
	
	//THIS COUNTER CONTROLS EACH OF THE SUCCESSIVE GUESSES. Non-workable guesses are changed to "NOOO", and the counter iterates until it finds a code that does not begin with the "NOOO" string.
	int counter=0;
	for(int rows=0;rows<combinations.length;rows++){
		if(combinations[rows][0].equals("NOOO")){
			counter+=1;
			if (combinations[rows][0]!=("NOOO")){
				rows=combinations.length;
			}
		}
		
		
	}
	//for the first guess, counter = 0, and we are guessing the first row.
	String [] theguess=combinations[counter];
	printarray(theguess);
	
	System.out.println("How many CORRECT COLOR CORRECT POSITIONs do I have?");
	//correct colors correct positions (c.c.c.p)
	int cccp=scan.nextInt();
	System.out.println("How many CORRECT COLOR INCORRECT POSITIONs do I have?");
	//correct colors incorrect positions (c.c.i.p)
	int ccip=scan.nextInt();
	narrowDown(combinations,theguess, counter,cccp,ccip);
	//print2Darray(combinations);
	
	//The user must input the final code as all positions holding correct colors. AKA (cccp = posinum)
	//Until then, the big list continues to be narrowed down, and new guesses are made.
	while(cccp!=posinum){
		System.out.println("My next guess is: ");
		//print2Darray(combinations);
		counter=0;
		
		for(int rows=0;rows<combinations.length;rows++){
			if(combinations[rows][0].equals("NOOO")){
				counter+=1;	
			}
			else
			{
				rows=combinations.length;
			}
			
		}
		//System.out.println(counter);
		theguess=combinations[counter];
		printarray(theguess);
		
		System.out.println("How many CORRECT COLOR CORRECT POSITIONs do I have?");
		cccp=scan.nextInt();
		System.out.println("How many CORRECT COLOR INCORRECT POSITIONs do I have?");
		ccip=scan.nextInt();
		narrowDown(combinations,theguess, counter,cccp,ccip);
		
	}
	//THE SOLUTION HOORAY!
	System.out.println("Your code is:");
		printarray(combinations[counter]);
		
	//prompt to play again, with default "exit"
	System.out.println("Would you like to play again? Y/N");
	String answer = scan.next();
	if(answer.toLowerCase().equals("y")){
		newGame();
	}
	else{
		System.out.println("Thank you for playing! Feel free to boast to friends and family about my astounding genius and talent!");
	}
	
	}
	//GENERATES POSSIBLE RESPONSES
	public static void buildCodes(String [] currentcolorlist,int positions){
		int index = 0;
		int size=currentcolorlist.length;
		//String[][] combinations = null;
		int arrsize=combinations[0].length;
		//System.out.println(positions);
		/* HERE IS AN EXAMPLE GRID OF POSSIBLE COMBINATIONS FOR A 3*3 "RGB" SAMPLE
		 * NOTICE, THERE ARE 9 REDS IN A COLUMN, 9 GREENS, THEN 9 BLUES.
		 * WITHIN EACH OF THOSE, THERE ARE 3 REDS, 3 GREENS, 3 BLUES.
		 * AND FOR THE FINAL BLOCK, THERE IS 1 RED, 1 GREEN, 1 BLUE.
		 * 
		 * RRR	GRR	BRR
		 * RRG	GRG	BRG
		 * RRB	GRB	BRB
		 * RGR	GGR	BGR
		 * RGG	GGG	BGG
		 * RGB	GGB	BGB
		 * RBR	GBR	BBR
		 * RBG	GBG	BBG
		 * RBB	GBB	BBB
		 */
		//THIS RECURSION WORKS "BACKWARDS", DECREASING IN POSITION EACH TIME. INSTEAD OF WHAT YOU SEE ABOVE (9 REDS, 9 GREENS, 9 BLUES), IT WILL ACTUALLY WORK BY DOING 9 "RED GREEN BLUE"s FIRST. DON'T WORRY ABOUT IT, JUST HOLD ON TO YOUR HAT.
		//The outermost loop controls the "blocks". In this example, it controls a 9...3...1 pattern of "populating" the array. *How many times, going through each of the colors, will you duplicate the pattern?*
		for(int z=0;z<Math.pow(size, positions-1);z++){
			//going through each of the colors
			for(int i=0;i<size;i++){
				//unlike the outermost loop, this actually controls what I call "duplicates". For the block, and for the specific color, how many of them are being duplicated? In the VERY FIRST runthrough of the RGB example, "red, green, blue" will populate the 27 rows, with ONE of each color, NINE times.
				for(int j=0;j<Math.pow(size,arrsize-(positions));j++){
					System.out.println(index);
					System.out.println(arrsize-positions);					
					combinations[index++][(arrsize-positions)]=currentcolorlist[i];
					
					
					//System.out.print(currentcolorlist[i]);
					}
				//System.out.println(index);
				//System.out.println();
			}
		
		
		//System.out.println();
			if(positions!=1){
				buildCodes(currentcolorlist,positions-1);
			}
		
	}

}
	//mostly for my purposes, but feel free to print out arrays
	public static void print2Darray(String [][] a){
	for ( int row = 0; row < a.length; row++ ){
		for ( int column = 0; column < a[ row ].length; column++ ){
			System.out.printf( "%3s  ", a[ row ][ column ] );
		}
		System.out.println();
		}
	}
	
	public void printarray(String[] a){
		for(int i =0; i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	//"RESPONSE" FUNCTION
	//IN ORDER TO NARROW DOWN POSSIBILITIES, I WILL COMPARE EACH OF THE COMBINATIONS TO THE GUESS THAT I MADE. IF THEY GIVE THE SAME NUMBER OF CCCP AND CCIPs, THEN I KEEP THEM, AND START AT THE TOP OF THE LIST AGAIN.
	public void narrowDown(String [][] bigarray, String [] theguess,int count, int cccp, int ccip){
		
		for(int rows=count+1; rows<bigarray.length;rows++){
			int mycccp=0;//"cccp"=correct color correct position
			int myccip=0;//"ccip"=correct color incorrect position
			ArrayList<String> incorrects = new ArrayList<String>();
			//use your current guess as the base for comparison against all the other values.
			for(int cols=0;cols<bigarray[0].length;cols++){
				if(bigarray[rows][cols].equals(theguess[cols])){
					mycccp+=1;
						
				}
				//THIS GOT FUNKY UP IN HERE.
				//In order to properly find the "Correct Color INCORRECT Position", it must be able to differentiate from the "Correct Color CORRECT Position" values.
				else{
					incorrects.add(bigarray[rows][cols]);
				}
							
			}
			for(int cols=0;cols<bigarray[0].length;cols++){
				if(incorrects.contains(theguess[cols])){
					myccip+=1;
					incorrects.remove(theguess[cols]);
						
				}
			}
			
			//System.out.println("Information: "+ mycccp + " "+ myccip);
			
			//IF IT IS NOT A CODE WITH MATCHING VALUES TO THE CURRENT GUESS, REPLACE IT WITH A DIFFERENT WORD... PERHAPS SOMETHING LIKE "NOOO" :)
			if((mycccp!=cccp)||(myccip!=ccip)){
				for(int cols=0;cols<bigarray[0].length;cols++){
					bigarray[rows][cols]="NOOO";					
				}
			}
				
		}
		//replace the current guess with NOOO at the end.
		if(cccp!=bigarray[0].length){
		for(int cols=0;cols<bigarray[count].length;cols++){
			bigarray[count][cols]="NOOO";
		}
		}
		
		
	}
	//NEW GAME FUNCTION *so simple, sorry!*
	public void newGame(){
		Game newgame=new Game();
	}
	
	
	
}

