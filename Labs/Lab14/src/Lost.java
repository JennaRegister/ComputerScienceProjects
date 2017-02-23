
public class Lost extends Non_Nerd{
	private boolean thinks_this_is_Humanities_class;
	public Lost(String name, int num_of_friends, boolean thinks_this_is_Humanities_class){
		super(num_of_friends, name);
		this.thinks_this_is_Humanities_class=thinks_this_is_Humanities_class;
	}
	public boolean isThinks_this_is_Humanities_class() {
		return thinks_this_is_Humanities_class;
	}
	public void setThinks_this_is_Humanities_class(
			boolean thinks_this_is_Humanities_class) {
		this.thinks_this_is_Humanities_class = thinks_this_is_Humanities_class;
	}
	public String toString(){
		return("It is "+ thinks_this_is_Humanities_class +" that this student is lost and believes this is a Humanities class.");
	}

}
