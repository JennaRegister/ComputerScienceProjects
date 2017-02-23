import java.awt.*;
public class JPiece extends SuperBlock {
	Location [][] jblocks={{new Location(0,-1),new Location(0,0),new Location(0,1),new Location(-1,1)},{new Location(-1,0),new Location(0,0),new Location(1,0),new Location(1,1)},{new Location(0,1),new Location(0,0),new Location(0,-1),new Location(1,-1)},{new Location(1,1),new Location(0,1),new Location(-1,1),new Location(-1,0)}};
public JPiece(Color color, int orient, Location l, Location [][] blocks){
	super(color, orient, l, blocks);
	setBlocks(jblocks);
}
}


