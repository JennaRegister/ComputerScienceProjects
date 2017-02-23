	public class Graph {
		 private int vertexCount, edgeCount;
		 boolean directed;
		 private boolean [][] admatrix;
		 
		 public Graph(int numVerticies, boolean isDirected) { 
			 vertexCount=numVerticies;
			 directed=isDirected;
			 //System.out.println("Constructing: " + directed);
			 admatrix = new boolean [vertexCount][vertexCount];
			 
			 
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

