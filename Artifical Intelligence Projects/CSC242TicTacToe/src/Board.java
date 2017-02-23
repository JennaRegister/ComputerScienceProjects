
public class Board {
	//We need a Board class. The board can be represented with a 2D array of Players (which Player is occupying that spot) in the array.
	Player [][] grid;
	public Board(int n){
		grid=new Player[n][n];
	}
	
	//default constructor 3 x 3
	public Board(){
		grid=new Player[3][3];
	}
	
	public int length(){
		return grid.length;
	}
	
	public boolean isFull(){
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				if(grid[row][col]==null){
					return false;
				}
			}
		}
		return true;
	}
	

	
	//check for a win by taking the last move played, and seeing if it completes a row
	public boolean isXwin(Move m){
		int x=m.x;
		int y=m.y;
		boolean rows=true;
		boolean cols=true;
		boolean dl=true;
		boolean dr=true;
		
		
		//check rows for a win
		for(int r=0;r<grid.length;r++){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[x][r]==null||!grid[x][r].value.equals("X")){
				rows=false;
				//System.out.println("Rows False!");
			}
		}
		//check cols
		for(int c=0;c<grid.length;c++){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[c][y]==null||!grid[c][y].value.equals("X")){
				cols=false;
				//System.out.println("Cols False!");
			}
		}
		//check  diagonal left
		for(int d=0,dll=grid.length-1;d<grid.length&&dll>=0;d++,dll--){
			
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
				if(grid[dll][d]==null||!grid[dll][d].value.equals("X")){
					
					dl=false;
					//System.out.println("Diagonal Left False! " + dll + " " +d);
				}
			
		}
		//check diagonal right
		for(int di=grid.length-1;di>=0;di--){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[di][di]==null||!grid[di][di].value.equals("X")){
				dr=false;
				//System.out.println("Diagonal Right False!");
			}
		}

		if(cols||rows||dl||dr==true){
			
			return true;
		}
		else{
		return false;
		}
		
	}
	public boolean isOwin(Move m){
		int x=m.x;
		int y=m.y;
		boolean rows=true;
		boolean cols=true;
		boolean dl=true;
		boolean dr=true;
		
		
		//check rows for a win
		for(int r=0;r<grid.length;r++){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[x][r]==null||!grid[x][r].value.equals("O")){
				rows=false;
				//System.out.println("Rows False!");
			}
		}
		for(int c=0;c<grid.length;c++){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[c][y]==null||!grid[c][y].value.equals("O")){
				cols=false;
				//System.out.println("Cols False!");
			}
		}
		//check  diagonal left
		for(int d=0,dll=grid.length-1;d<grid.length&&dll>=0;d++,dll--){
			
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
				if(grid[dll][d]==null||!grid[dll][d].value.equals("O")){
					
					dl=false;
					//System.out.println("Diagonal Left False! " + dll + " " +d);
				}
			
		}
		//check diagonal right
		for(int di=grid.length-1;di>=0;di--){
			//think state machines: if we come across a position that is NOT X, we can't have 3 in a row!
			if(grid[di][di]==null||grid[di][di].value.equals("O")){
				dr=false;
				//System.out.println("Diagonal Right False!");
			}
		}

		if(cols||rows||dl||dr==true){
			//System.out.println("yep!"); 
			return true;
		}
		else{
		return false;
		}
		
	}
	
	public boolean isDraw(Move m){
		//if the board is full but X hasn't won and O hasn't won, it must be a Draw.
		if((this.isFull()) && !(this.isOwin(m)) && !(this.isXwin(m))){
			return true;
		}
		return false;
	}
	//insert the Player into the position
	public void apply(Move m){
		if (isApplicable(m)){
		grid[m.x][m.y]=m.player;
		}
		
	}
	
	public void remove(Move m){
		grid[m.x][m.y]=null;
	}
	
	
	
	//must have a space to actually go to!
	public boolean isApplicable(Move m){
		return grid[m.x][m.y]==null;
	}
	
	public void print(){
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				//System.out.println("Row: " + row + " Col: " + col);
				if(col!=0){
					System.out.print("|");
				}
				if(grid[row][col]==null){
					System.out.print("   ");
				}
				
				
				else if(grid[row][col]!=null){
					System.out.print(" "+grid[row][col]+" ");
				}
				
				if((((col==2))&&(row!=2))){
					System.out.println();
					System.out.println("-----------");
				}
			}
		}
		System.out.println();
		
	}
	//call heuristic on the rows, columns, and diagonals
	public int heuristic(){
		int score=0;
		//score the rows
		//row 1
		Player [] row1={grid[0][0],grid[0][1],grid[0][2]};
		score+=scoreit(row1);
		//row 2
		Player [] row2={grid[1][0],grid[1][1],grid[1][2]};
		score+=scoreit(row2);
		//row 3
		Player [] row3={grid[2][0],grid[2][1],grid[2][2]};
		score+=scoreit(row3);
		//score the cols
		//col 1
		Player [] col1={grid[0][0],grid[1][0],grid[2][0]};
		score+=scoreit(col1);
		//col 2
		Player [] col2={grid[0][1],grid[1][1],grid[2][1]};
		score+=scoreit(col2);
		//col 3
		Player [] col3={grid[0][2],grid[1][2],grid[2][2]};
		score+=scoreit(col3);
		//score the diagonals
		//right
		Player [] diagright={grid[0][0],grid[1][1],grid[2][2]};
		score+=scoreit(diagright);
		//left
		Player [] diagleft={grid[0][2],grid[1][1],grid[2][0]};
		score+=scoreit(diagleft);
		
		return score;
	}
	
	//score your board
	public int scoreit(Player [] line){
		
		int xcount=0;
		int ocount=0;
		
		
		//check the given line
		
		for(int i=0;i<line.length;i++){
			if(line[i]!=null){
				if(line[i].value.equals("X")){
					xcount+=1;
				}
				if(line[i].value.equals("O")){
					ocount+=1;
				}
				
			}
		}
		if(xcount==3){
			return -13;
		}
		if(ocount==3){
			return 13;
		}
		
			
				if(ocount>0){
					if(xcount==0){
						return ocount;
					}
					else{
						return 0;
					}
				}
				else{
					return -xcount;
				}

	}
}
