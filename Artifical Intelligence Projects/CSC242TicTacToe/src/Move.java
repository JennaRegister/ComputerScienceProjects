
public class Move {
	//an Action, or Move, is quite simple. It is a location on the board by a Player.
	Player player;
	
	//may convert this into numbers
	int position;
	int x,y;
	int myboard;
	
	public Move(Player player, int position){
		this.player=player;
		this.position=position;
		
		
		switch(this.position){
			case 1: x=0;y=0;
			break;
			case 2: x=0;y=1;
			break;
			case 3: x=0;y=2;
			break;
			case 4: x=1;y=0;
			break;
			case 5: x=1;y=1;
			break;
			case 6: x=1;y=2;
			break;
			case 7: x=2;y=0;
			break;
			case 8: x=2;y=1;
			break;
			case 9: x=2;y=2;
			break;	
		}
	}
	
	public Move() {
		
	}
	public Move(Player player, int position,int myboard){
		this.player=player;
		this.position=position;
		this.myboard=myboard;
		
		
		switch(this.position){
			case 1: x=0;y=0;
			break;
			case 2: x=0;y=1;
			break;
			case 3: x=0;y=2;
			break;
			case 4: x=1;y=0;
			break;
			case 5: x=1;y=1;
			break;
			case 6: x=1;y=2;
			break;
			case 7: x=2;y=0;
			break;
			case 8: x=2;y=1;
			break;
			case 9: x=2;y=2;
			break;	
		}
	}
	
	public String toString(){
		if(myboard>=0){
			int printme=myboard+1;
			return("Your move is: " +player.toString() + " in position "+ position + " on Board " + printme);
			
		}
		else{
			return("Your move is: " +player.toString() + " in position "+ position );
		}
	}
	
}
//where do I generate the applicable actions?