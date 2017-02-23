
public class Symbol {
	//this can probably be referred to as a "proposition" as well. I am using the term "symbol".
	
	//a symbol has a value. could be "is_raining" or "is_mortal" or "will_play_the_accordion" etc. Or simply, "p".
	String value;
	
	//a symbol has a truth value. No fuzzy logic here, just true or false.
	boolean truth;
	
	public Symbol(String value, boolean truth){
		this.value=value;
		this.truth=truth;
	}
	
	public void setTruth(boolean changeme){
		this.truth=changeme;
	}
	
	public String toString(){
		return(value+": "+ truth);
		
	}

}
