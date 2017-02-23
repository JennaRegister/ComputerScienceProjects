
public class Lab8Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(stars(3));
	System.out.println(stars(5));
	System.out.println(stars(9));

	}

	public static String stars(int n) {
		// TODO Auto-generated method stub
		String starry="";
		for(int i=0; i<n; i++){
			starry+="*";
			}
		return starry;

}
}
