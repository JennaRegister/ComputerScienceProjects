import java.util.Scanner;


public class main {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);

		System.out.println("Hello human! Let's have a friendly round of TTT. Would you like to play basic (1) or NineBoard (2)?");
		int input=scan.nextInt();
		if(input==1){
			Gameplay game=new Gameplay();
		}
		if(input==2){
			NinePlay ninegame=new NinePlay();
		}
		
		
		
		
		
	}

}
