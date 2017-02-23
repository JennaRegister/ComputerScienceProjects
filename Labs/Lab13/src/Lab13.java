
public class Lab13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = RowsnCols(2,3);
		Prt2Darr(array);
		Fillit(array, 3);
		Prt2Darr(array);
		int [][] a1=RowsnCols(2,3);
		int [][] a2=RowsnCols(2,3);
		Prt2Darr(a1);
		Prt2Darr(a2);
		int[][] summed=Sumit(a1,a2);
		//This is just to deal with the "null" not being a valid parameter for my print 2D array function... there's a better way to do this but I just wanted to show that it returns null if different dimensions!
		if(summed != null){
			Prt2Darr(summed);
		}
		if(summed == null){
			System.out.println("The arrays must have the same dimensions!");
		}
		int[][] subbed=Subit(a1,a2);
		if(subbed != null){
			Prt2Darr(subbed);
		}
		if(summed == null){
			System.out.println("The arrays must have the same dimensions!");
		}
		//assuming the triangle arrays have the same integer parameter... otherwise I would just put in more if statements as above
		int [][] t=Triangle(5);
		int [][] j = Triangle(5);
		Prt2Darr(t);
		Prt2Darr(j);
		Prt2Darr(Sumit(t,j));
		Prt2Darr(Subit(t,j));
		Fillit(t,13);//my favorite number
		Prt2Darr(t);
		

	}
	//PART1
	public static void Fillit(int[][] a, int n){
		for(int rows = 0; rows < a.length; rows++){
			for(int cols = 0; cols < a[rows].length; cols++){
				a[rows][cols]=n;
			}
			
		}
		
	}
	//PART2
	public static int[][] Sumit(int[][] a, int [][] b){
		int n = a.length-1;
		int m = b.length-1;
		if((a.length != b.length)||(a[n].length != b[m].length)){
			return null;
		}
		
		int[][] sum = new int[a.length][a[n].length];
		for(int rows = 0; rows < a.length; rows++){
			for(int cols = 0; cols < a[rows].length; cols++){
				sum[rows][cols]=a[rows][cols]+b[rows][cols];
			}
		}
		return sum;
	}
		
	//PART3
	public static int[][] Subit(int[][] a, int [][] b){
		int n = a.length-1;
		int m = b.length-1;
		if((a.length != b.length)||(a[n].length != b[m].length)){
			return null;
		}
		int[][] sub = new int[a.length][a[n].length];
		for(int rows = 0; rows < a.length; rows++){
			for(int cols = 0; cols < a[rows].length; cols++){
				sub[rows][cols]=a[rows][cols]-b[rows][cols];
			}
		}
		return sub;
		
	}
	public static void Prt2Darr( int[][] a ) {
		for ( int row = 0; row < a.length; row++ ){
			for ( int column = 0; column < a[ row ].length; column++ ){
				System.out.printf( "%3s  ", a[ row ][ column ] );
			}
			System.out.println();
			} 
		System.out.println();
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
	//PART4
	public static int [][] Triangle(int k){
		int [][] trarry = new int [k][];
		int counter =1;
		for(int rows = 0; rows < k; rows++){
			trarry[rows]= new int [rows +1];
			for(int cols = 0; cols <= rows; cols++){
				trarry[rows][cols]=counter;
				counter+=1;
			}
			System.out.println();
		}
		return trarry;
	}
}

