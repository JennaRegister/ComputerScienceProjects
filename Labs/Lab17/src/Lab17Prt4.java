import java.io.*;


public class Lab17Prt4 {
	//READS FILE USING STREAM
	public static void main(String[] args) {
		String path = "/Users/jennaregister/Documents/workspace/file2.txt";
		try{
			FileInputStream fin = new FileInputStream(path);
			DataInputStream din = new DataInputStream(new BufferedInputStream((fin)));
			
			
				String s = din.readUTF();
				System.out.println(s);
				double d = din.readDouble();
				System.out.println(d);
			
			
		}
		catch(IOException e){
			System.out.println("Error.");
		}
		finally{
			System.out.println("Done.");
		}
	}

}
