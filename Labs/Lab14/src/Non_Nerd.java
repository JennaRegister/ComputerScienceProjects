
public class Non_Nerd extends Student_in_CS_Class{
	private int num_of_friends;
	public Non_Nerd(int num_of_friends, String name){
		super(name);
		this.num_of_friends= num_of_friends;
	}
	public int getNum_of_friends() {
		return num_of_friends;
	}
	public void setNum_of_friends(int num_of_friends) {
		this.num_of_friends = num_of_friends;
	}
	public String toString(){
		return("This student is not a Nerd and they have social skills, resulting in "+ num_of_friends + " friends!");
	}

}
