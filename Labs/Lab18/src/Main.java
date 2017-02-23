import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	public static void main(String [] args){
		String f = "/Users/jennaregister/Documents/students.txt";
		ArrayList<Student> list=lister(f);
		print(list);
		//PART3
		Collections.shuffle(list);
		print(list);
		Collections.sort(list, new Comp());	
		print(list);
		Collections.sort(list,new CompY());
		print(list);
		Collections.reverse(list);
		print(list);
		Collections.shuffle(list);
		System.out.println("The 'max' Student by name is: " + Collections.max(list,new Comp()));
		System.out.println("The 'max' Student by graduation year is: " + Collections.max(list,new CompY()));
		System.out.println("The 'min' Student by name is: " + Collections.min(list,new Comp()));
		System.out.println("The 'min' Student by graduation year is: " + Collections.min(list,new CompY()));
	}
	public static ArrayList<Student> lister(String filename){
		BufferedReader readit = null;
		File f = new File(filename);
		ArrayList<Student> s = new ArrayList<Student>();
		try{
			readit = new BufferedReader(new FileReader(f));
			String l;
			while((l=readit.readLine()) != null){
				String [] students=l.split(" ");
				String firstName = students[0];
				String lastName = students[1];
				int year = Integer.parseInt(students[2]);
				Student stud = new Student(firstName,lastName,year);
				s.add(stud);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				readit.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		return s;
		
	}
	public static void print(ArrayList<Student> a){
		for(int i=0; i< a.size(); i++){
			System.out.println(a.get(i));
			
		}
		System.out.println("");
	}
	

}


