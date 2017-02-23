import javax.swing.ImageIcon;


public class Card {
	private int rank;
	private String face;
	private int suit;
	public Card(int n,String f,int s){
		rank=n;
		face=f;
		suit=s;
	}

	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public int getRank(){
		return rank;
	}
	public String getFace(){
		return face;
	}
	

}
