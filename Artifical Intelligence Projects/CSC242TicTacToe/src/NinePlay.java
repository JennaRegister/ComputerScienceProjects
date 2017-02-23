import java.util.ArrayList;
import java.util.Scanner;


public class NinePlay {
	Scanner scan;
	MultiBoard board=new MultiBoard();
	MultiState state;
	Player X=new Player("X");
	Player O=new Player("O");
	
	
	public NinePlay(){
		scan=new Scanner(System.in);
		state=new MultiState(board,X);
		Move lastmove = null;
		Move firstmove=null;
		int firstposition=0;
		Move firstcountermove=null;
		int firstcountposition=0;
		
		
		
		System.out.println("We are going to play NineBoard Tic Tac Toe! This is a text game, so each of the spaces are labeled with a number, like this:");
		instructboard();
		
		System.out.println("But instead of just 1 board, we have 9. A meta-board, if you will. You will give me 2 numbers. Which board you want to play on, and in which position. Whichever position you choose, I MUST play on that corresponding board, and so on. I'll let you go first (X). Where do you put your X?");
		firstmove=firstmove();
		firstposition=firstmove.position;
		//firstcountermove=getnextMove();
		
		boolean playing=true;
		//make a do while loop to play until solution is found
		while(playing){
			
			if(state.next==X){
					
				lastmove=humansayswhat(firstposition);
				
				//TEST: How I would iterate through applicable actions
				ArrayList<Move> actions=new ArrayList<Move>();
				//iterate through boards as well
				//if board is free to play on (not a draw, and certainly not a win)
				for(int k=0;k<state.board.metaboard.length;k++){
					for(int i1=0;i1<9;i1++){
						
						if(state.board.isApplicable(new Move(state.next,i1+1), k)){
							
							actions.add(new Move(state.next,i1,k));
						
						}
					}
				}
				for(int i=0;i<actions.size();i++){
					System.out.println(actions.get(i));
				}
				
				
				}
				else if(state.next==O){
					lastmove=getNextMove(firstposition);
					state.board.metaboard[lastmove.position].apply(lastmove);
					
					switchPlay(state);
				}
				
				
				
				
				//printing out the end of the game
				//go through all the boards, if any of them are a win, the game is over!
			
				for(int i=0;i<board.length();i++){
					if(state.board.metaboard[i]!=null){
					if(state.board.metaboard[i].isXwin(lastmove)||state.board.metaboard[i].isOwin(lastmove)||state.board.metaboard[i].isDraw(lastmove)){
						if(state.board.metaboard[i].isXwin(lastmove)){
							System.out.println("X wins.");
							playing=false;
						}
						if(state.board.metaboard[i].isOwin(lastmove)){
							System.out.println("O wins.");
							playing=false;
						}
						else if(state.board.metaboard[i].isDraw(lastmove)){
							//System.out.println("Draw.");
							//Move to different board
							restart();
							playing=true;
						}
						
						
					}
				}
				}
			}
			
		}
		
			
		
	

public void instructboard(){
	System.out.println();
	System.out.println(" 1 | 2 | 3 ");
	System.out.println("------------");
	System.out.println(" 4 | 5 | 6 ");
	System.out.println("------------");
	System.out.println(" 7 | 8 | 9 ");
	System.out.println();
}






public void switchPlay(MultiState s){
	if(s.next==X){
		s.next=O;
	}
	else if(s.next==O){
		s.next=X;
	}
}


public int [] maxMove(MultiState s,int whichboard,int level){

	int best = -13000000;
	int bestMove = -2;
	MultiState newstate;
	int [] value = new int[2];
	
	
	
	ArrayList<Move> actions=new ArrayList<Move>();
	//iterate through boards as well
	//if board is free to play on (not a draw, and certainly not a win)
	for(int k=0;k<state.board.metaboard.length;k++){
		for(int i1=0;i1<9;i1++){
			
			if(state.board.isApplicable(new Move(state.next,i1+1), k)){
				
				actions.add(new Move(state.next,i1,k));
			
			}
		}
	}
	for(int i=0;i<actions.size();i++){
		System.out.println(actions.get(i));
	}
	for(int k=0; k<state.board.metaboard.length;k++){
		for(int i=0;i<actions.size();i++){
				newstate=result(s,actions.get(i),whichboard);
				//newstate.printstate();
				if(newstate.isGoalState(actions.get(i))||level==2){
					
					
					value[0]=newstate.board.metaboard[whichboard].heuristic();
					if(value[0]>best){
						best=value[0];
						bestMove=actions.get(i).position;
						
					}
					int [] twos = new int [2];
					twos[0]=best;
					twos[1]=bestMove;
					return twos;
					
				}
				else{
					
					value=minMove(newstate,whichboard,level);
					if(value[0] > best){
						best=value[0];
						bestMove=actions.get(i).position;	
					}
		
				}	
		}
	}
	level++;
	System.out.println(level);
	int [] twos = new int [2];
	twos[0]=best;
	twos[1]=bestMove;
	
	return twos;
	
	
}

public int[] minMove(MultiState s,int whichboard,int level){
	
	int best = 13000000;
	int bestMove = -2;
	MultiState newstate;
	int [] value = new int[2];
	value[0]=13;
	value[1]=0;
	
	ArrayList<Move> actions=new ArrayList<Move>();
	//iterate through boards as well
	//if board is free to play on (not a draw, and certainly not a win)
	for(int k=0;k<state.board.metaboard.length;k++){
		for(int i1=0;i1<9;i1++){
			
			if(state.board.isApplicable(new Move(state.next,i1+1), k)){
				
				actions.add(new Move(state.next,i1,k));
			
			}
		}
	}
	
	for(int i=0;i<actions.size();i++){
			newstate=result(s,actions.get(i),whichboard);
			if(newstate.isGoalState(actions.get(i))||level==2){
				
				
				value[0]=newstate.board.metaboard[whichboard].heuristic();
				
				
				if(value[0]<best){
					best=value[0];
					bestMove=actions.get(i).position;
				}
				int [] twos = new int [2];
				twos[0]=best;
				twos[1]=bestMove;
				return twos;
				
			}
			else{
				value=maxMove(newstate,whichboard,level);
				
				if(value[0] < best){
					best=value[0];
					bestMove=actions.get(i).position;
				}

			}
	}
	level++;
	System.out.println(level);
	int [] twos = new int [2];
	twos[0]=best;
	twos[1]=bestMove;
	return twos;
	
	
}



public int utility(MultiState s,Move action,int whichboard){
	
	
	if(s.board.metaboard[whichboard].isXwin(action)){
		
		return -1;
	}
	if(s.board.metaboard[whichboard].isOwin(action)){
		
		return 1;
	}
	else if(s.board.metaboard[whichboard].isDraw(action)){
		
		return 0;
	}
	
	return 0;
	
	
}


public MultiState result(MultiState s, Move m,int whichboard){
	//copies the multiboard
	MultiBoard newboard=new MultiBoard();
	for(int k=0;k<state.board.metaboard[k].length();k++){
		for(int i=0;i<state.board.metaboard[k].length();i++){
			for(int j=0;j<state.board.metaboard[k].length();j++){
				newboard.metaboard[k].grid[i][j]=state.board.metaboard[k].grid[i][j];
			}
		}
	}
	MultiState newstate=new MultiState(newboard,state.next);
	
	newstate.board.apply(m,whichboard);
	switchPlay(newstate);
	return newstate;
	
	
}
public Move getNextMove(int whichboard){
	
	//copies the multiboard
	MultiBoard newboard=new MultiBoard();
	for(int k=0;k<state.board.length();k++){
		for(int i=0;i<state.board.metaboard[k].length();i++){
			for(int j=0;j<state.board.metaboard[k].length();j++){
				newboard.metaboard[k].grid[i][j]=state.board.metaboard[k].grid[i][j];
				
			}
		}
	}
	
	MultiState newstate=new MultiState(newboard,state.next);
	int [] back = maxMove(newstate,whichboard,1);
	int position = back[1];
	Move themove=new Move(O,position);
	themove.toString();
	
	return themove;
	
}
public Move humansayswhat(int lastplace){
	System.out.println("What is your next move?");
	Move m=new Move(X,scan.nextInt());
	if(state.board.isApplicable(m,lastplace)){
		state.board.apply(m,lastplace);
	}
	switchPlay(state);
	return m;
	
}

public Move firstmove(){
	System.out.println("You get to start. So pick a board...");
	int placement=scan.nextInt();
	System.out.println("And pick a position on that board.");
	Move m=new Move(X,scan.nextInt());
	
	if(state.board.isApplicable(m,placement)){
		state.board.apply(m,placement);
	}
	//switchPlay(state);
	return m;
}

public Move restart(){
	//when a board is a Draw, you get to restart
	System.out.println("That board was full. So pick anywhere that is open to play! First your board...");
	int placement=scan.nextInt();
	System.out.println("And pick a position on that board.");
	Move m=new Move(X,scan.nextInt());
	
	if(state.board.isApplicable(m,placement)){
		state.board.apply(m,placement);
	}
	switchPlay(state);
	return m;
}

}


