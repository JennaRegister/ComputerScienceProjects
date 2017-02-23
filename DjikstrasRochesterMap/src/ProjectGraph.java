
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class ProjectGraph {
	//I am using the Adjacency List implementation. This is a hashmap of Intersections, which each have a LinkedList of their connected Roads
	HashMap<Intersection, LinkedList<Road>> adjList=new HashMap<Intersection, LinkedList<Road>>();
	int vertexCount=0;
	int edgeCount=0;
	boolean directed;
	//I started off by using arrays, but then I realized that I can only index by Intersection or Intersection ID. I can't use an index like I did in the labs.
	HashMap<Intersection, Intersection> previous = new HashMap<Intersection, Intersection>();
	HashMap<Intersection, Boolean> known = new HashMap<Intersection, Boolean>();
	HashMap<Intersection, Double> distances = new HashMap<Intersection, Double>();
	
	public ProjectGraph(boolean isDirected){
		directed=isDirected;
	}
	//Inserting is easy :) All we have to do is make a place for the Intersection and create a new LinkedList of Roads.
	public void insertIntersection(Intersection i){
		adjList.put(i, new LinkedList<Road>());
		vertexCount++;
	}
	//Inserting Roads uses the Intersections as keys, then adds to the LinkedList at that key!
	public void insertRoad(Road r){
		adjList.get(r.i1).add(r);
		edgeCount++;
		if(!isDirected()){
			adjList.get(r.i2).add(r);
		}
	}
	
	//A bunch of simple getters below
	public boolean isDirected() { 
		 return directed;
	 }
	
	public int vertices() { 
		 return vertexCount;
	 }
	 public int edges() { 
		 return edgeCount;
	 }
	 
	 
	//This is how I print my graph. Mostly for testing. It prints out the Intersection ID and the LinkedList for each Intersection. I have overwritten the Road toString method to print the Road ID only.
	 public void show(){
		 for(Entry<Intersection, LinkedList<Road>> entry: adjList.entrySet()){
			 String key=entry.getKey().id;
			 System.out.println("Intersection: " + key );
			 
			 Object [] valarray=entry.getValue().toArray();
			 
			 for(int i=0; i<entry.getValue().size();i++){
				 System.out.println("Road "+ (i+1) +": " +valarray[i]);
			 }
			 System.out.println();
			 
		       
	 
		 }
		 
	 }
	 //The shortest path algorithm takes advantage of the hashmaps indexed by Intersection, and the compareTo method of Roads.
	 public void shortestPath(Intersection source){
		 for(Intersection i :adjList.keySet()){
			 distances.put(i,Double.POSITIVE_INFINITY);
			 previous.put(i,null);
			 known.put(i, false);
		 }
		 
		 distances.put(source,0.0);
		 PriorityQueue<Road> pq=new PriorityQueue<Road>();
		 pq.add(new Road("",source,source,0));
		 while(!pq.isEmpty()){
			 Road shortest=pq.poll();
			 Intersection i =shortest.i1;
			 
			 if(!known.get(i)){
				 known.put(i, true);
				 for(Road r : adjList.get(i)){
					 int cost=r.weight;
					 Intersection i2=r.i2;
					 if((distances.get(i)+cost)<distances.get(i2)){
					
						 distances.put(i2,distances.get(i)+cost);
						 previous.put(i2,i);
						 pq.add(new Road("",i2,i2, ((distances.get(i2).intValue()))));
					 }
					 
				 }
			 }
		 }
		 for(Entry<Intersection, Intersection> entry: previous.entrySet()){
			 
			 String key=entry.getKey().id;
			 String value=entry.getValue().id;
			 System.out.println("From " + key + " to " + value);
		 
		 
		 }
		 
		 
	 }
	 
	 
	 
	 
	 
					 				
			
}
