
public class Lab12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PART1
		String [][] friends = new String [2][3];
		friends[0][0]="Cat";
		friends[0][1]="Myself";
		friends[0][2]="My Hamster";
		friends[1][0]="Syd";
		friends[1][1]="Brie (not the cheese)";
		friends[1][2]="Tessa";
		System.out.println("My best friends are: ");
		Prt2Darr(friends);
		System.out.println();
		//PART2
		String [][] cheeses = {{"Feta","Brie"},{"Goat Cheese","Mozzerella"},{"Pepperjack","Vegan Cheese"}};
		System.out.println("My favorite cheeses are: ");
		Prt2Darr(cheeses);
		int[][] array = RowsnCols(2,3);
		Prt2Darr(array);

	}

	public static void Prt2Darr( String[][] a ) {
		for ( int row = 0; row < a.length; row++ ){
			for ( int column = 0; column < a[ row ].length; column++ ){
				System.out.printf( "%3s  ", a[ row ][ column ] );
			}
			System.out.println();
			} 

}
	public static int[][] RowsnCols(int rows, int columns){
		int [][] array = new int[rows][columns];
		int value = rows*columns;
		for ( int row = 0; row < array.length; row++ ){
			for ( int column = 0; column < array[ row ].length; column++ ){
				array[row][column]= (int) (Math.random()*value);
			}	
	}
		return array;
	
}
	public static void Prt2Darr( int[][] a ) {
		for ( int row = 0; row < a.length; row++ ){
			for ( int column = 0; column < a[ row ].length; column++ ){
				System.out.printf( "%3s  ", a[ row ][ column ] );
			}
			System.out.println();
			} 
}
}