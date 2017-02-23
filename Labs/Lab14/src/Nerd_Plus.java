
public class Nerd_Plus extends Nerd {
	private boolean attends_ComicCon;
	public Nerd_Plus(String name, String fave_CS_joke, boolean attends_ComicCon){
		super(name, fave_CS_joke);
		this.attends_ComicCon= attends_ComicCon;
	}
	public boolean isAttends_ComicCon() {
		return attends_ComicCon;
	}
	public void setAttends_ComicCon(boolean attends_ComicCon) {
		this.attends_ComicCon = attends_ComicCon;
	}
	public String toString(){
		return("This student is nerdy for all sorts of things. It is "+ attends_ComicCon + " that they will be attending ComicCon this year.");
	}

}
