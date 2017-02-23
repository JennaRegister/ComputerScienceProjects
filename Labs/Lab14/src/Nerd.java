
public class Nerd extends Student_in_CS_Class{
	private String fave_CS_joke;
	public Nerd(String fave_CS_joke,String name){
		super(name);
		this.fave_CS_joke = fave_CS_joke;
	}
	public String getFave_CS_joke() {
		return fave_CS_joke;
	}
	public void setFave_CS_joke(String fave_CS_joke) {
		this.fave_CS_joke = fave_CS_joke;
	}
	public String toString(){
		
		return ("This student is a Nerd and their favorite nerdy CS joke is "+fave_CS_joke+".");
	}
	
}


