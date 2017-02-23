
public class RugbyPlayer {
	private String position ;
	private int bruises ;
	
	//constructor
	RugbyPlayer( String playingposition, int numbruises )
	{
		position = playingposition;
		bruises = numbruises;
	}
	//set methods
	public void setposition(String playingposition)
	{
		position = playingposition;
	}
	public void setbruises(int numbruises)
	{
		bruises = numbruises;
	}
	
	//get methods
	public String getposition()
	{
		return position;
	}
	public int getbruises()
	{
		return bruises;
	}
}
