import java.util.Scanner;
public class Lab8Part4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number and be dazzled by stars!");
		int lines = scan.nextInt();
		for(int i=0; i<= lines; i++){
		System.out.println(stars(i));
		}
		System.out.println("Enter a number and be dazzled by... nothing.");
		int lines2= scan.nextInt();
		for(int k=0; k<=lines2; k++){
		System.out.println(spaces(k));
		}
		//AND PART 6
		System.out.println("Enter a number and be dazzled by...stars and nothing, making something...");
		int lines3 = scan.nextInt();
		for(int m=0; m<= lines3; m++){
			System.out.print(spaces(lines3-m)+stars(m)+"\n");
		}
		//AND PART 7 WOW I MISNAMED THIS, DEFINITELY NOT JUST PART 4
		System.out.println("Enter a number and be dazzled by DIAMONDS! ");
		int lin = scan.nextInt();
		int x;
		if(lin % 2 == 0){
			for(x=1; x <= (lin/2); x++){
				System.out.print(spaces((lin/2)-x)+ stars(2*x-1)+ spaces((lin/2)-x)+"\n");
			}
			for(x=(lin/2); x>=1; x--){
				System.out.print(spaces((lin/2)-x)+ stars(2*x-1)+ spaces((lin/2)-x)+"\n");
			}
		}
		else{
			for(x=0; x<(Math.floor(lin/2)); x++){
				System.out.print(spaces((int) ((Math.floor(lin/2))-x))+ stars(2*x+1)+spaces((int) ((Math.floor(lin/2))-x)) +"\n");
			}
			for(x=(int)((Math.floor(lin/2))); x>=0; x--){
				System.out.print(spaces((int) ((Math.floor(lin/2))-x))+ stars(2*x+1)+spaces((int) ((Math.floor(lin/2))-x)) +"\n");
			}
			}
		
		
		
	}
	public static String stars(int n) {
		// TODO Auto-generated method stub
		String starry="";
		for(int i=0; i<n; i++){
			starry+="*";
			}
		return starry;
	
}
	//and Part5!!!
	public static String spaces(int n) {
		String spacey="";
		for(int i=0; i<n; i++){
			spacey+=" ";
		}
		return spacey;
	}

}
