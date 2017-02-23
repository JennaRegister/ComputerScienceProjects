
public class TestRugbyPlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create RugbyPlayer objects
		RugbyPlayer player1 = new RugbyPlayer("Fullback",17);
		RugbyPlayer player2 = new RugbyPlayer("Flyhalf",22);
		
		//displaying info
		System.out.printf("This rugby player's position is the %s, and they have %d bruises.\n",player1.getposition(), player1.getbruises());
		System.out.printf("This rugby player's position is the %s, and they have %d bruises.\n",player2.getposition(), player2.getbruises());
		
		//mutating via set methods
		player1.setposition("Flanker");
		player2.setbruises(3);
		
		//showing what has changed and what has stayed the same
		System.out.printf("This rugby player's position is the %s, and they have %d bruises.\n",player1.getposition(), player1.getbruises());
		System.out.printf("This rugby player's position is the %s, and they have %d bruises.\n",player2.getposition(), player2.getbruises());

	}

}
