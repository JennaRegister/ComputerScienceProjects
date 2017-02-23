import java.util.ArrayList;

import java.util.Scanner;




public class Gameplay {
	Scanner scan;
	Board board;
	State state;
	Player X=new Player("X");
	Player O=new Player("O");
	Board testboard;
	
	
	public Gameplay(){
		scan=new Scanner(System.in);
		board=new Board();
		state=new State(board,X);
		
		Move lastmove = null;
		
		/*testboard=new Board();
		State teststate=new State (testboard,X);
		Move test=new Move(X,1);
		Move test2=new Move(X,3);
		Move test3=new Move(O,5);
		Move test4=new Move(O,9);
		Move test5=new Move(O,7);
		Move test6=new Move(X,4);
		
		teststate.board.apply(test);
		teststate.board.apply(test2);
		teststate.board.apply(test3);
		teststate.board.apply(test4);
		teststate.board.apply(test5);
		teststate.board.apply(test6);
		teststate.printstate();
		System.out.println("Heuristic: " + teststate.board.heuristic());*/
		
		
		
		System.out.println("We are going to play Tic Tac Toe! This is a text game, so each of the spaces are labeled with a number, like this:");
		instructboard();
		
		System.out.println("I'll let you go first (X). Where do you put your X?");
		boolean playing=true;
		//make a do while loop to play until solution is found
		while(playing){
			
				if(state.next==X){
				lastmove=humansayswhat();
				}
				else if(state.next==O){
					lastmove=getNextMove();
					state.board.apply(lastmove);
					
					switchPlay(state);
				}
				
				
				state.printstate();
				
				
				//printing out the end of the game
				if(state.board.isXwin(lastmove)||state.board.isOwin(lastmove)||state.board.isDraw(lastmove)){
					if(state.board.isXwin(lastmove)){
						System.out.println("X wins.");
					}
					if(state.board.isOwin(lastmove)){
						System.out.println("O wins.");
					}
					else if(state.board.isDraw(lastmove)){
						System.out.println("Draw.");
					}
					
					playing=false;
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






public void switchPlay(State s){
	if(s.next==X){
		s.next=O;
	}
	else if(s.next==O){
		s.next=X;
	}
}


public int [] maxMove(State s){
	//System.out.println("MAX");
	int best = -13000000;
	int bestMove = -2;
	State newstate;
	int [] value = new int[2];
	
	
	
	ArrayList<Move> actions=new ArrayList<Move>();
	for(int i1=1;i1<10;i1++){
		if(s.board.isApplicable(new Move(s.next,i1))){
			actions.add(new Move(s.next,i1));
			
		
		}
	}
	for(int i=0;i<actions.size();i++){
			newstate=result(s,actions.get(i));
			//newstate.printstate();
			if(newstate.isGoalState(actions.get(i))){
				//System.out.println("ASTA LA VISTA BABY. get it, it's a terminator?");
				//newstate.printstate();
				value[0]=utility(newstate,actions.get(i));
				//value[0]=newstate.board.heuristic();
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
				
				value=minMove(newstate);
				if(value[0] > best){
					best=value[0];
					bestMove=actions.get(i).position;	
				}
	
			}	
	}
	
	int [] twos = new int [2];
	twos[0]=best;
	twos[1]=bestMove;
	//System.out.println("HEY IM PRINTING THINGS LOOK AT ME: " + best + " " + bestMove);
	//s.printstate();
	return twos;
	
	
}

public int[] minMove(State s){
	//System.out.println("MIN");
	int best = 13000000;
	int bestMove = -2;
	State newstate;
	int [] value = new int[2];
	value[0]=13;
	value[1]=0;
	ArrayList<Move> actions=new ArrayList<Move>();
	for(int i1=1;i1<10;i1++){
		if(s.board.isApplicable(new Move(s.next,i1))){
			actions.add(new Move(s.next,i1));
			
		}
	}
	for(int i=0;i<actions.size();i++){
			newstate=result(s,actions.get(i));
			if(newstate.isGoalState(actions.get(i))){
				//System.out.println("ASTA LA VISTA BABY. get it, it's a terminator?");
				//newstate.printstate();
				value[0]=utility(newstate,actions.get(i));
				//once we reach a "win" we need to be able to STOP! and give this move!
				
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
				value=maxMove(newstate);
				
				if(value[0] < best){
					best=value[0];
					bestMove=actions.get(i).position;
				}

			}
	}
	
	int [] twos = new int [2];
	twos[0]=best;
	twos[1]=bestMove;
	return twos;
	
	
}



public int utility(State s,Move action){
	
	
	if(s.board.isXwin(action)){
		
		return -1;
	}
	if(s.board.isOwin(action)){
		
		return 1;
	}
	else if(s.board.isDraw(action)){
		
		return 0;
	}
	
	return 0;
	
	
}


public State result(State s, Move m){
	//need to actually make COPY
	Board newboard=new Board();
	
	for(int i=0;i<s.board.length();i++){
		for(int j=0;j<s.board.length();j++){
			newboard.grid[i][j]=s.board.grid[i][j];
		}
	}
	State newstate=new State(newboard,s.next);
	
	newstate.board.apply(m);
	switchPlay(newstate);
	return newstate;
	
	
}
public Move getNextMove(){
	
	
	Board newboard=new Board();
	for(int i=0;i<state.board.length();i++){
		for(int j=0;j<state.board.length();j++){
			newboard.grid[i][j]=state.board.grid[i][j];
		}
	}
	State newstate=new State(newboard,state.next);
	int [] back = maxMove(newstate);
	int position = back[1];
	Move themove=new Move(O,position);
	themove.toString();
	
	return themove;
	
}
public Move humansayswhat(){
	System.out.println("What is your next move?");
	Move m=new Move(X,scan.nextInt());
	if(state.board.isApplicable(m)){
		state.board.apply(m);
	}
	switchPlay(state);
	return m;
	
}


}