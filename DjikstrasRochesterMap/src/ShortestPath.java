import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.HashMap;

public class ShortestPath extends JPanel {
	//I have a lot of stupid ArrayLists to hold things while I read in. This negatively affects my runtime.
	public static ArrayList<String> lines = new ArrayList<String>();
	public static ArrayList<String []>roads = new ArrayList<String []>();
	public static ArrayList<String []>intersections = new ArrayList<String []>();
	public static ArrayList<Intersection> intersections2=new ArrayList<Intersection>();
	public static ArrayList<Road> roads2=new ArrayList<Road>();
	public static HashMap<String,Intersection> intersectionsmap=new HashMap<String,Intersection>();
	public static HashMap<String,Road> roadsmap=new HashMap<String,Road>();
	public static Image img;
	public static ProjectGraph graph=new ProjectGraph(false);
	
	//a constructor that sets up graphics things
	public ShortestPath(){
		super();
		Color forest=new Color(117,148,106);
		setBackground(forest);
		final ImageIcon icon=new ImageIcon("sorry.jpg");
		//JOptionPane.showMessageDialog(null, "My Goodness, this Project is totally incomplete!","Message",JOptionPane.INFORMATION_MESSAGE,icon);
		//JOptionPane.showMessageDialog(null, "Please have mercy.");
	}
	
	public static void main(String [] args) throws IOException{
		
		//Graphics Setup
		ShortestPath panel = new ShortestPath();
		JFrame win = new JFrame("Monroe County");
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		win.add(panel);
		win.setSize(660,660);
		img=ImageIO.read(new File("parchment.jpg"));
		//End Graphics Setup
		
		Scanner scan= new Scanner(System.in);
		/*System.out.println("It's just a spare bit of parchment.");
		while(scan.hasNext() && !scan.nextLine().equals("I solemnly swear I am up to no good.")){
			System.out.println("It's just a spare bit of parchment.");
		}
		System.out.println("Welcome, Maurauder.");*/
		
		
		String filename="monroe.txt";
		File file = new File(filename);
		//This Readit function does most of the work
		Readit(file);
		
		for(int j=0;j<roads.size();j++){
			String [] line=roads.get(j);
			//Now I actually create Road objects
			Road road=createRoad(line[1],line[2],line[3]);
			
			//adds to the list to draw!
			roads2.add(road);
			
		}
		System.out.println(roads2.get(0).i1);
		System.out.println(roads2.get(0).i2);
		//graph.shortestPath(roads2.get(0).i1);
		
		//Prints the graph
		graph.show();
		
		//Show the graphics
		win.setVisible(true);
		
	}

	
	public static Road createRoad(String ID,String i1, String i2){
		//creates roads from intersections
		
		//accesses the intersection IDs and takes their x
		int x1=(int) intersectionsmap.get(i1).x;
		int y1=(int) intersectionsmap.get(i1).y;
		int x2=(int) intersectionsmap.get(i2).x;
		int y2=(int) intersectionsmap.get(i2).y;
		
		//calculates the distance, AKA weight
		int weight= (int) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
		//creates the new road object
		Road road= new Road(ID,intersectionsmap.get(i1),intersectionsmap.get(i2),weight);
		
		//inserts the road into the adjacency list graph
		graph.insertRoad(road);
		
		return road;
		
	}
	
	
	public static void Readit(File file) throws IOException{
		//sets up Reader
		BufferedReader br = new BufferedReader(new FileReader(file));
		String l;
		
		//until the end of the file
		while((l=br.readLine()) !=null){
			
			String [] split=l.split(",");
			if(split[0].equals("i")){
				//insert into HashMap by ID. Creates new Intersection object using ID, x, and y
				intersectionsmap.put(split[1],new Intersection(split[1],Double.parseDouble(split[2]),Double.parseDouble(split[3])));
				
				//inserts into adjacency List graph
				graph.insertIntersection(intersectionsmap.get(split[1]));
				graph.insertIntersection(intersectionsmap.get(split[1]));
			}
			
			
			//put the r tags into a roads list to work with later
			if(split[0].equals("r")){
				roads.add(split);
			}
			
		}	
		
	}
	
	//setting up graphics
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		int i=roads2.size();
		//draws background
		g.drawImage(img, 0,0,null);
		
		//draws the Road lines
		for(int k=0;k<i;k++){
			g.drawLine((int)Math.floor(roads2.get(k).i1.x),(int)Math.floor(roads2.get(k).i1.y),(int)Math.floor(roads2.get(k).i2.x),(int)Math.floor(roads2.get(k).i2.y));
			
		}
		
		
		
	}

}
