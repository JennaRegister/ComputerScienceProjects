import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Lab17Pt3 {
//WRITES TO FILE USING STREAM
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="/Users/jennaregister/Documents/workspace/file2.txt";
		try{
			FileOutputStream out = new FileOutputStream(path);
			DataOutputStream dout=new DataOutputStream(new BufferedOutputStream(out));
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a number between 10 and 20: ");
			int n=scan.nextInt();
			for(int i=0; i<n;i++){
				String s=rands();
				double d1 = randd();
				String d2= Double.toString(d1);
				System.out.println(s + " " + d2);
				dout.writeUTF(s + " ");
				dout.writeUTF(d2 + "\n");
			}
			dout.close();
			scan.close();
		}
		catch(IOException e){
			System.out.println("Error.");
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

		

}
