
import java.awt.*;
public class Square extends SuperBlock{
	Location [][] sblocks={{new Location(-1,0),new Location(-1,1),new Location(0,1),new Location(0,0)},{new Location(-1,1),new Location(0,1),new Location(0,0),new Location(-1,0)},{new Location(0,1),new Location(0,0),new Location(-1,0),new Location(-1,1)},{new Location(0,0),new Location(-1,0),new Location(-1,1),new Location(0,1)}};
	public Square(Color color, int orient, Location l, Location [][] blocks){
		super(color, orient, l, blocks);
		setBlocks(sblocks);
		
	}
}


