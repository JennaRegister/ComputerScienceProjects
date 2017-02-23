import java.awt.*;
public class SuperBlock {
	Color color;
	int orient;
	Location l;
	Location[][] blocks;
	public SuperBlock(Color color, int orient,Location l, Location[][] blocks){
		this.color=color;
		this.orient=orient;
		this.l=l;
		this.blocks=blocks;
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getOrient() {
		return orient;
	}

	public void setOrient(int orient) {
		this.orient = orient;
	}

	public Location getL() {
		return l;
	}

	public void setL(Location l) {
		this.l = l;
	}

	public Location[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Location[][] blocks) {
		this.blocks = blocks;
	}
	

}
