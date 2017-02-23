import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	public static void main(String [] args) throws IOException{
		HashTable ht=new HashTable(13);
		ht.insert("jenna");
		ht.insert("bumblebee");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("brian");
		ht.insert("jenna");
		ht.insert("jenna");
		ht.insert("chihiro");
		ht.print();
		
		
		String name="/Users/jennaregister/Desktop/Pastaipsum.txt";
		File file = new File(name);
		String[] array=getit(file);
		HashTable hashtable=new HashTable(array,true);
		//System.out.println("I made it!");
		hashtable.print();
		
	}
	
	public static void printarray(String[] a){
		for(int i =0; i<a.length;i++){
			System.out.print(a[i]+" ");
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void Readit(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String l;
		while((l=br.readLine()) !=null){
			System.out.println(l);
		}	
	}
	
	public static String [] getit(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str;
		String[] values = null;
		
		while((str = br.readLine())!=null){
			values = str.split(" ");
		}
		return values;
	}
	public static ArrayList<String> getAL(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str;
		ArrayList<String> list = new ArrayList<String>();
		while((str = br.readLine())!=null){
			list.add(str);
		}
		return list;
	}
	 
}
