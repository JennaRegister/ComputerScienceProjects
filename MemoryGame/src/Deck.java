import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;


public class Deck {
	public ArrayList<Card> deck = new ArrayList<Card>(52);
	public Deck(){
		int cardcount=1;
		for(int rank = 13; rank > 0; rank--){
			for(int suit =1; suit < 5; suit++){
				deck.add(new Card(rank,("image/"+String.valueOf(cardcount)+".png"),suit));
				cardcount++;
			}
		}
	}
	public void printDeck(){
		for(int i=0; i< deck.size();i++){
			System.out.println("rank " + deck.get(i).getRank() + " face " + deck.get(i).getFace() + " suit " + deck.get(i).getSuit());
		}
	}
	public void Shuffle(){
		Collections.shuffle(deck);
		
	}
}
	
	


