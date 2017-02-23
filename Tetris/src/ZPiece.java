import java.awt.Color;
public class ZPiece extends SuperBlock {
	Location [][] zblocks={{new Location(1,0),new Location(0,0),new Location(0,1),new Location(-1,1)},{new Location(0,-1),new Location(0,0),new Location(1,0),new Location(1,1)},{new Location(1,0),new Location(0,0),new Location(0,1),new Location(-1,1)},{new Location(0,-1),new Location(0,0),new Location(1,0),new Location(1,1)}};
	public ZPiece(Color color, int orient, Location l, Location [][] blocks){
		super(color, orient, l, blocks);
		setBlocks(zblocks);
	}
}
