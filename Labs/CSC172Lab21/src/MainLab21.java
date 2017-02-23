import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MainLab21 {
	public static void main(String [] args) throws NumberFormatException, IOException{
		String g1 = "/Users/jennaregister/Desktop/Graph1Weighted.txt";
		Graph graph1=createFromFileW(g1);
		System.out.println("Printing the Graph1 from the file: ");
		graph1.show();
		System.out.println();
		graph1.shortestPathW(1);
		System.out.println();
		
		//some of these distances will be infinity because you can NEVER get to vertex 5!!!
		String g2 = "/Users/jennaregister/Desktop/Graph2W.txt";
		Graph graph2=createFromFileW(g2);
		System.out.println("Printing the Graph2 from the file: ");
		graph2.show();
		System.out.println();
		graph2.shortestPathW(5);
		System.out.println();
		
		
		String g3 = "/Users/jennaregister/Desktop/Graph5W.txt";
		Graph graph3=createFromFileW(g3);
		System.out.println("Printing the Graph3 from the file: ");
		graph3.show();
		System.out.println();
		graph3.shortestPathW(0);
		System.out.println();
	}
	public static Graph createFromFile(String filename) throws NumberFormatException, IOException{
		Graph graph;
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		boolean isDirected = false;
		int numVertices=Integer.parseInt(br.readLine());
		String evaluate = br.readLine();
		
		if((evaluate.compareTo("U")==0)){
			
			isDirected=false;
		}
		
		else{
			
			isDirected=true;
		}
		
		//System.out.println("Printing isDirected: " + isDirected);
		graph = new Graph (numVertices,isDirected);
		
		String l;
		while((l=br.readLine()) !=null){
			String [] vstring =l.split(",");
			int [] vertices = new int[vstring.length];
			for(int i=0;i<vstring.length;i++){
				vertices[i]=Integer.parseInt(vstring[i]);
			}
			//System.out.println("Inserting vertex: "+vertices [0] + " and vertex: " + vertices[1]);
			graph.insert(new Edge(vertices[0],vertices[1]));
	}
	return graph;
}
	public static Graph createFromFileW(String filename) throws NumberFormatException, IOException{
		Graph graph;
		File file = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(file));
		boolean isDirected = false;
		int numVertices=Integer.parseInt(br.readLine());
		String evaluate = br.readLine();
		
		if((evaluate.compareTo("U")==0)){
			
			isDirected=false;
		}
		
		else{
			
			isDirected=true;
		}
		
		//System.out.println("Printing isDirected: " + isDirected);
		graph = new Graph (numVertices,isDirected);
		
		String l;
		while((l=br.readLine()) !=null){
			String [] vstring =l.split(",");
			int [] vertices = new int[vstring.length];
			for(int i=0;i<vstring.length;i++){
				vertices[i]=Integer.parseInt(vstring[i]);
			}
			//System.out.println("Inserting vertex: "+vertices [0] + " and vertex: " + vertices[1]);
			graph.insert(new Edge(vertices[0],vertices[1],vertices[2]));
	}
	return graph;
}
}
