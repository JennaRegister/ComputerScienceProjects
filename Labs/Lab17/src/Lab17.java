import java.util.*;
import java.io.*;

public class Lab17 {
	//PART1
	public static void main(String [] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String name =scan.next();
		File file = new File(name);
		StringsnDoubles(file);
		Readit(file);
		File temp = new File("/Users/jennaregister/Documents/workspace/temp.txt");
		SquareitBaby(temp,file);
		System.out.println();
		Readit(file);
			
	}
	
	//PART2
	public static void StringsnDoubles(File f) throws IOException{
		Scanner scan = new Scanner(System.in);
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(fw);
		}
		catch(NullPointerException ex){
			System.out.println("Error.");
		}
		
		System.out.println("Enter a number between 10 and 20: ");
		int n=scan.nextInt();
		if(n<10 || n >20){
			System.out.println("Listen to directions, you fool.");
		}
		else{
		try{
			for(int i=0; i<=n;i++){
				bw.write(rands() + " " + randd() + "\n");
			}
		}
		catch(IOException ex){
			System.out.print("Error");
		}
		try{
			bw.close();
		}
		catch(IOException ex){
			System.out.println("Error");
		}
		}
			
	}
		
	public static String rands(){
		StringBuilder s = new StringBuilder();
		char[] charray="abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random r = new Random();
		for(int i=0; i<3;i++){
			char c = charray[r.nextInt(charray.length)];
			s.append(c);	
		}
		String s2=s.toString();
		return s2;
	}
	
	public static double randd(){
		double d = 1+(double)(Math.random()*((9-1)+1));
		return d;
		
	}
	//PART3
	public static void Readit(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String l;
		while((l=br.readLine()) !=null){
			System.out.println(l);
		}
		
		
	}
	//PART4
	public static void SquareitBaby(File t, File f) throws IOException{
		double d = 0.0;
		FileWriter fw = null;
		try {
			fw = new FileWriter(t);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(fw);
		}
		catch(NullPointerException ex){
			System.out.println("Error.");
		}
		Scanner scan = new Scanner(new BufferedReader(new FileReader(f)));
		try{
			while(scan.hasNext()){
				String s =scan.next();
					d = scan.nextDouble();
					
					d= d*d;
					//System.out.println(d + "\n");
					bw.write(s+" " + Double.toString(d)+"\n");

			}
			t.renameTo(f);
		}
		catch(IOException ex){
			System.out.print("Error");
		}
		try{
			bw.close();
		}
		catch(IOException ex){
			System.out.println("Error");
		}
		}
		
}
	


