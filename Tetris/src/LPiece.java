import java.awt.*;
public class LPiece extends SuperBlock {
	Location [][] lpblocks={{new Location(0,-1),new Location(0,0),new Location(0,1),new Location(1,1)},{new Location(-1,1),new Location(0,1),new Location(1,1),new Location(1,0)},{new Location(0,1),new Location(0,0),new Location(0,-1),new Location(-1,-1)},{new Location(1,0),new Location(0,0),new Location(-1,0),new Location(-1,1)}};
	public LPiece(Color color, int orient, Location l, Location [][] blocks){
		super(color, orient, l, blocks);
		setBlocks(lpblocks);
	}
}


