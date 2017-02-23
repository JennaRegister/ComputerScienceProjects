import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

	public class Graph {
		 private int vertexCount, edgeCount;
		 boolean directed;
		 private Integer [][] admatrix;
		 boolean [] known;
		 int [] distances;
		 int [] previous;
		 public Graph(int numVerticies, boolean isDirected) { 
			 vertexCount=numVerticies;
			 directed=isDirected;
			 //System.out.println("Constructing: " + directed);
			 admatrix = new Integer [vertexCount][vertexCount];
			 known=new boolean [vertexCount];
			 distances=new int [vertexCount];
			 previous=new int [vertexCount];
			 
			 for(int i=0;i<vertexCount;i++){
				 distances[i]=(int) Double.POSITIVE_INFINITY;
				 
			 }
			 for(int i=0;i<admatrix.length;i++){
				 for(int j=0;j<admatrix[0].length;j++){
					 admatrix[i][j]=-1;
				 }
			 }
			
			 
		 }
		 
		
		 
		 public void shortestPath(int from, int to){
			 previous[from]=-1;
			 distances[from]=0;
			 for(int currentdist=0;currentdist<vertexCount;currentdist++){
				 for(int v=0;v<vertexCount;v++){
					 if((known[v]==false) && (distances[v]==currentdist)){
						 known[v]=true;
						 AdjArray A=new AdjArray(v);
						 for(int t= A.begin(); !A.end(); t=A.next()){
							 if(distances[t]==Double.POSITIVE_INFINITY){
								 distances[t]=currentdist+1;
								 previous[t]=v;
							 }
						 }
					 }
				 }
			 }
			 
			 
			 int indexvalue=previous[to];
			 //System.out.println(previous[to]);
			 ArrayList<Integer> thepath=new ArrayList<Integer>();
			 thepath.add(to);
			 thepath.add(previous[to]);
			 
			 while(previous[indexvalue]!=-1){
				 thepath.add(previous[indexvalue]);
				 indexvalue=previous[indexvalue];
				 
			 }
			 
			 System.out.println("To go from "+ from + " to " + to + ":");
			 for(int j=thepath.size()-1;j>=0;j--){
				 
				 
				 System.out.print(thepath.get(j));
				 if(j>0){
				 System.out.print(" --> ");
				 }
				 
			 }
			 System.out.println();
			 
			 
		 }
			 
		
		//weighted shortest path	 
		public void shortestPathW(int s){
			
			for(int i=0;i<vertexCount;i++){
				 distances[i]=(int) Double.POSITIVE_INFINITY;
				 known[i]=false;
				 previous[i]=-1;
			 }
			distances[s]=0;
			
			
			int i=0;
			while(i<distances.length){
				int shortest = mindistance();
				AdjArray A=new AdjArray(shortest);
				 for(int t= A.begin(); !A.end(); t=A.next()){
					 if(!known[t]){
						int cost=admatrix[shortest][t];
						//System.out.println("cost" + cost);
						if(distances[shortest]+cost<distances[t]){
							distances[t]=distances[shortest]+cost;
							previous[t]=shortest;
							//System.out.println(previous[t]);
						
						}
					 }
					 
					 
				
				
				}
				 
				 
				 
				 
					i++;
					
			}
			for(int d=0;d<distances.length;d++){
				System.out.println("To get to vertex " + d + " from " + s + ":");
				if(distances[d]!=2147483647){
				System.out.println("The distance is: " + distances[d]);
				}
				else if(distances[d]==2147483647){
					System.out.println("This vertex is unreachable from " + s);
				}
				 int indexvalue=previous[d];
				 //System.out.println(previous[to]);
				 ArrayList<Integer> thepath=new ArrayList<Integer>();
				 thepath.add(d);
				 thepath.add(previous[d]);
				 if(indexvalue!=-1){
				 while(previous[indexvalue]!=-1){
					 thepath.add(previous[indexvalue]);
					 indexvalue=previous[indexvalue];
					 
				 }
				 
				 System.out.println("To go from "+ s + " to " + d + ":");
				 for(int j=thepath.size()-1;j>=0;j--){
					 
					 
					 System.out.print(thepath.get(j));
					 if(j>0){
					 System.out.print(" --> ");
					 }
					 
				 }
				 System.out.println();
				
			}
				 System.out.println();
			}
			
			
			
			
		}
		//finds the vertex with minimum distance every time!!!
		public int mindistance(){
			
			int shortest = (int) Double.POSITIVE_INFINITY;
			int index=0;
			for(int j=0;j<distances.length;j++){
				if(!known[j]){
					if(distances[j]<shortest){
						shortest=distances[j];
						index=j;
						
					}
					
					
				}
			}
			known[index]=true;
			return index;
		}
			 
		public static void printme(int [] a){
			for(int i=0; i<a.length;i++){
				System.out.print(a[i] + "  ");
				
			}
			System.out.println();
		}
		 public boolean isDirected() { 
			 return directed;
		 }
		 public int vertices() { 
			 return vertexCount;
		 }
		 public int edges() { 
			 return edgeCount;
		 }
		 public void insert(Edge e) { 
			 if(!directed){
				 
				 admatrix[e.v][e.w]=e.weight;
				 admatrix[e.w][e.v]=e.weight;
				 edgeCount++;
				 
			 }
			 else{
				 admatrix[e.v][e.w]=e.weight;
				 edgeCount++;
			 }
		 }
		 public void delete(Edge e) {
			 if(!directed){
				 admatrix[e.v][e.w]= -1;
				 admatrix[e.w][e.v]=-1;
				 edgeCount--;
			 }
			 else{
				 admatrix[e.v][e.w]=-1;
				 edgeCount--;
			 }
		 }
		 public boolean connected(int node1, int node2) { 
			 return admatrix[node1][node2]!=-1;
		 }
		 public AdjArray getAdjArray(int vertex) { 
			return new AdjArray(vertex);
		}
		 public void show(){
			 for(int s=0; s<vertices();s++){
				 System.out.print(s +": ");
				 AdjArray A = getAdjArray(s);
				 for(int t= A.begin(); !A.end(); t=A.next()){
					 System.out.print(t + " ");
				 }
				 System.out.println();
			 }
		 }


	private class AdjArray implements AdjList {
		private int v;
		private int i;
		
		public AdjArray(int v){
			this.v=v;
			i=-1;
		}
		
		public int begin() {
			i=-1;
			return next();
		}

		
		public int next() {
			for(++i;i<vertices();i++){
				if(connected(v,i)==true)
					return i;
			}
			return -1;
			
		}
		

		
		public boolean end() {
			if(i<vertices()){
				return false;	
			}
			return true;
			
		}
		
		
	}
}

