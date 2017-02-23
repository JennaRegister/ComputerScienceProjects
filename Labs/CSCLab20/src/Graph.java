import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

	public class Graph {
		 private int vertexCount, edgeCount;
		 boolean directed;
		 private boolean [][] admatrix;
		 boolean [] known;
		 int [] distances;
		 int [] previous;
		 public Graph(int numVerticies, boolean isDirected) { 
			 vertexCount=numVerticies;
			 directed=isDirected;
			 //System.out.println("Constructing: " + directed);
			 admatrix = new boolean [vertexCount][vertexCount];
			 known=new boolean [vertexCount];
			 distances=new int [vertexCount];
			 previous=new int [vertexCount];
			 for(int i=0;i<vertexCount;i++){
				 distances[i]=1000;
				 
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
							 if(distances[t]==1000){
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
				 
				 admatrix[e.v][e.w]=true;
				 admatrix[e.w][e.v]=true;
				 edgeCount++;
				 
			 }
			 else{
				 admatrix[e.v][e.w]=true;
				 edgeCount++;
			 }
		 }
		 public void delete(Edge e) {
			 if(!directed){
				 admatrix[e.v][e.w]=false;
				 admatrix[e.w][e.v]=false;
				 edgeCount--;
			 }
			 else{
				 admatrix[e.v][e.w]=false;
				 edgeCount--;
			 }
		 }
		 public boolean connected(int node1, int node2) { 
			 return admatrix[node1][node2];
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

