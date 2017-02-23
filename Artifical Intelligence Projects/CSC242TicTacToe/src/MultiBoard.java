
public class MultiBoard {
	Board [] metaboard=new Board [9];
	
	public MultiBoard(){
		for(int i=0;i<metaboard.length;i++){
			metaboard[i]=new Board();
		}
	}
	
	public void printmulti(){
		for(int i=0;i<metaboard.length;i++){
			int printme=i+1;
			System.out.println("BOARD "+ printme);
			metaboard[i].print();
		}
	}

	public boolean isApplicable(Move m,int lastplace) {
		return metaboard[lastplace].grid[m.x][m.y]==null;
		
	}

	public void apply(Move m,int lastplace) {
		if (isApplicable(m,lastplace)){
			metaboard[lastplace-1].grid[m.x][m.y]=m.player;
		}
		
	}

	public int length() {
		
		return metaboard.length;
	}
	
	
}
