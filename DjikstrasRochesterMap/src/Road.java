
public class Road implements Comparable {

	//A Road has an ID, 2 Intersections, and a Weight.
	public final String rID;
	public final Intersection i1, i2;
	public final int weight;
	public Road(String rID, Intersection i1, Intersection i2, int weight){
		this.rID=rID;
		this.i1=i1;
		this.i2=i2;
		this.weight=weight;
	}
	//I have overwritten this method so that when I print a Road object, I am printing the ID (instead of a weird address)
	public String toString(){
		
		return rID;
	}

	//I have also overwritten the compareTo method. I don't want to compare IDs or Intersections. I want a Road to be compared by WEIGHT.
	public int compareTo(Object o) {
		Road r= (Road) o;
		if(weight < r.weight)
			return -1;
		if(weight==r.weight)
			return 0;
		else 
			return 1;
	}
	
	

}
