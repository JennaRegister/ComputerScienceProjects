
public class MultiState {
	MultiBoard board=new MultiBoard();
	Player next;
	
	public MultiState(MultiBoard multiboard,Player next){
		this.board=multiboard;
		this.next=next;
	}
	public boolean isGoalState(Move lastmove){
		for(int i=0;i<board.metaboard.length;i++){
			//Here is the goal checking code. 3 in a row or all full. X wins, O wins, Draw
			//if any of the boards are a win!
			if(board.metaboard[i].isOwin(lastmove)||board.metaboard[i].isXwin(lastmove)||board.metaboard[i].isDraw(lastmove)){
				return true;
			}
			
		}
		return false;
	}
	public void printstate() {
		// TODO Auto-generated method stub
		
	}
	
}


