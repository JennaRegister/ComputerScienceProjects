




public class State {
	//The various States in the Tic Tac Toe world. At any given time, a State has a board (configured with its current Player arrangement) and a next Player.
	//Initial State: Empty board, X is next
	//Terminal States: X wins, O wins, Draw
	Board board;
	Player next;
	
	public State(Board board,Player next){
		this.board=board;
		this.next=next;
	}


	public boolean isGoalState(Move lastmove){
		//Here is the goal checking code. 3 in a row or all full. X wins, O wins, Draw
		//only want to start checking after first player (X) has gone 3 times
		if(board.isOwin(lastmove)||board.isXwin(lastmove)||board.isDraw(lastmove)){
			return true;
		}
		else{
			return false;
		}
		
	}
	public void printstate(){
		System.out.println("The current board state is: ");
		board.print();
		System.out.println("and the next Player is " + next.toString()+".");
		
	}
}
