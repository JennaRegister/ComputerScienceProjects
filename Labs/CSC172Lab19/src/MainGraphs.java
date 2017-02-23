
public class MainGraphs {

	public static void main(String[] args) {
		Graph graph = new Graph(7,true);
		System.out.println("Graph 1");
		graph.insert(new Edge(0,1));
		graph.insert(new Edge(0,3));
		graph.insert(new Edge(1,3));
		graph.insert(new Edge(1,4));
		graph.insert(new Edge(2,5));
		graph.insert(new Edge(3,2));
		graph.insert(new Edge(3,4));
		graph.insert(new Edge(3,5));
		graph.insert(new Edge(3,6));
		graph.insert(new Edge(4,6));
		graph.insert(new Edge(6,5));
		graph.insert(new Edge(2,0));
		
		graph.show();
		
		Graph graph2= new Graph(5,false);
		graph2.insert(new Edge(0,1));
		graph2.insert(new Edge(0,4));
		graph2.insert(new Edge(0,3));
		graph2.insert(new Edge(1,3));
		graph2.insert(new Edge(1,2));
		graph2.insert(new Edge(2,4));
		graph2.insert(new Edge(2,3));
		System.out.println();
		System.out.println("Graph 2");
		graph2.show();
		
		
		
		

	}

}
