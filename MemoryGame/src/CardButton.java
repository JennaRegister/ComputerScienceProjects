import javax.swing.ImageIcon;
import javax.swing.JButton;


public class CardButton extends JButton {
	private ImageIcon front, back;
	private boolean isFlipped;
	private int rank;
	public CardButton(ImageIcon f, ImageIcon b,int r){
		front=f;
		back=b;
		isFlipped=true;
		rank=r;
		flip();
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void flip() {
		isFlipped = !isFlipped;
		if(isFlipped){
			this.setIcon(front);
		}
		else{
			this.setIcon(back);
			
		}
	}
	public ImageIcon getFront() {
		return front;
	}
	public void setFront(ImageIcon front) {
		this.front = front;
	}
	public ImageIcon getBack() {
		return back;
	}
	public void setBack(ImageIcon back) {
		this.back = back;
	}
	public boolean isFlipped() {
		return isFlipped;
	}
	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}
	
	
	
	

}
