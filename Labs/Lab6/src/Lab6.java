import java.util.Scanner;
public class Lab6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter 3 different integers, separated by a space. These can be in any order, for I am going to sort them from lowest to highest!");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		if (a < b){
			if (a < c){//if a is first
				if (b < c)
				System.out.println(a + ", " + b + ", " + c );
				if (c < b)
				System.out.println(a + ", " + c + ", " + b );}
		}
		if (b < c){
			if(b < a){//if b is first
				if (a < c)
					System.out.println(b + ", " + a + ", " + c );
				if (c < a)
					System.out.println(b + ", " + c + ", " + a );}
		}
		if (c < a){
			if (c < b){
				if (a < b)
					System.out.println(c + ", " + a + ", " + b );
				if (b < a)
					System.out.println(c + ", " + b + ", " + a );}	
		}
		System.out.println("Okay now let's work with words! Give me three different words and I will put them in alphabetical order!");
		String word1 = scan.next();
		String word2 = scan.next();
		String word3 = scan.next();
		int compare1;
		int compare2;
		int compare3;
		
		compare1 = word1.compareToIgnoreCase(word2);
		compare2 = word1.compareToIgnoreCase(word3);
		compare3 = word2.compareToIgnoreCase(word3);
		if ((compare1 < 0) && (compare3 < 0)){
			System.out.println(word1 + " " + word2 + " " + word3);
		}
		if ((compare2 < 0) && (compare3 > 0)){
			System.out.println(word1 + " " + word3 + " " + word2);
		}
		if ((compare1 > 0) && (compare2 < 0)){
			System.out.println(word2 + " " + word1 + " " + word3);
		}
		if ((compare3 < 0) && (compare2 > 0)){
			System.out.println(word2 + " " + word3 + " " + word1);
		}
		if ((compare3 > 0) && (compare1 > 0)){
			System.out.println(word3 + " " + word2 + " " + word1);
		}
		if ((compare2 > 0) && (compare1 < 0)){
			System.out.println(word3 + " " + word1 + " " + word2);
	}

}
}
