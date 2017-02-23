import java.awt.*;
public class Block extends SuperBlock {
	Location [][] bblocks={{new Location(-1,0),new Location(0,0),new Location(1,0),new Location(0,1)},{new Location(0,-1),new Location(0,0),new Location(1,0),new Location(0,1)},{new Location(-1,1),new Location(0,1),new Location(1,1),new Location(0,0)},{new Location(-1,0),new Location(0,0),new Location(0,1),new Location(0,-1)}};
	public Block(Color color, int orient, Location l, Location [][] blocks){
		super(color, orient, l, blocks);
		setBlocks(bblocks);
	}
}


