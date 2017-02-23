import java.awt.*;

public class Long extends SuperBlock{
	Location [][] lblocks={{new Location(0,-1), new Location(0,0),new Location(0,1),new Location(0,2)},{new Location(-1,1),new Location(0,1),new Location(1,1),new Location(2,1)},{new Location(0,1),new Location(0,0),new Location(0,-1),new Location(0,-2)},{new Location(1,1),new Location(0,1),new Location(-1,1),new Location(-2,1)}};
	public Long(Color color, int orient, Location l, Location [][] blocks){
		super(color, orient, l, blocks);
		setBlocks(lblocks);
		
	}
}
