import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class MainLab20 {
	public static void main(String [] args) throws NumberFormatException, IOException{
		String g1 = "/Users/jennaregister/Desktop/Graph1.txt";
		Graph graph1=createFromFile(g1);
		System.out.println("Printing the Graph1 from the file: ");
		graph1.show();
		System.out.println();
		graph1.shortestPath(0,6 );
		System.out.println();
		
		String g2 = "/Users/jennaregister/Desktop/Graph2.txt";
		Graph graph2=createFromFile(g2);
		System.out.println("Printing the Graph2 from the file: ");
		graph2.show();
		System.out.println();
		graph2.shortestPath(6,0);
		System.out.println();
		
		String g3 = "/Users/jennaregister/Desktop/Graph3.txt";
		Graph graph3=createFromFile(g3);
		System.out.println("Printing the Graph3 from the file: ");
		graph3.show();
		System.out.println();
		graph3.shortestPath(0,2 );
		System.out.println();
		
		String g4 = "/Users/jennaregister/Desktop/Graph4.txt";
		Graph graph4=createFromFile(g4);
		System.out.println("Printing the Graph4 from the file: ");
		graph4.show();
		System.out.println();
		graph4.shortestPath(0,3 );
		System.out.println();
		
		String g5 = "/Users/jennaregister/Desktop/Graph5.txt";
		Graph graph5=createFromFile(g5);
		System.out.println("Printing the Graph5 from the file: ");
		graph5.show();
		System.out.println();
		graph5.shortestPath(0,7);
		System.out.println();
	
		String g6 = "/Users/jennaregister/Desktop/Graph6.txt";
		Graph graph6=createFromFile(g6);
		System.out.println("Printing the Graph6 from the file: ");
		graph6.show();
		System.out.println();
		graph6.shortestPath(1,3);
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
}