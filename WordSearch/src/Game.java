import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Game {
/*HOW DOES THE GAME WORK?
 * Start with a board of chars.
 * We check for words in 8 possible orientations. Each of these checks will be a function.
 * Each orientation is a special kind of iteration through the 2D array.
 * Straight up and down and straight across are one dimensional.
 * Diagonal is 2 dimensional and will be nested.
 * Iterate and add to a list of words to be checked against the hash table. 1 letter, 2 letters, 3 letters etc. 
 * A max length of word is determined by the dimensions of the board.
 * Once you have a list of words, iterate through that and check against hash table.
 * If its looked up in the hashtable (aka IS A WORD) add it to a final list of words found.
 * Lookup: run the key through the hash function, go to that index, then find it.
 * Hashtable must be implemented using Linked Lists at the indexes. Can call insert and lookup for Linked List implementation.
 * The entire board is checked when all 8 functions are run for all the chars in the 2D array (nested for loops for rows and columns)
 * 
 */
	ArrayList<String> foundwords=new ArrayList<String>();
	ArrayList<String>words2check=new ArrayList<String>();
	int dimension=0;
	
	public Game(String words,String puzzle, String dim, String output) throws IOException{
		
		//String name="/Users/jennaregister/Desktop/Project3/linux.words";
		String name=words;
		File file = new File(name);
		dimension=Integer.parseInt(dim);
		ArrayList<String> array=getit(file,dimension);
		ChainedHashTable hashtable=new ChainedHashTable(array);
		//hashtable.print();
		
		//String boardname="/Users/jennaregister/Desktop/Project3/input10x10.txt";
		//String boardname="/Users/jennaregister/Desktop/Project3/puzzle.txt";
		String boardname=puzzle;
		File boardfile= new File(boardname);
		char [][] board=CreateBoard(boardfile,dimension);
		printboard(board);
		
			for(int j=0; j<board[0].length;j++){
				across(board,dimension,j);	
				backwardsacross(board,dimension,j);
				straightdown(board,dimension,j);
				straightup(board,dimension,j);
			}
			diagonalDR(board,dimension);
			diagonalUL(board,dimension);
			diagonalUR(board,dimension);
			diagonalDL(board,dimension);
			//System.out.println("WORDS TO CHECK");
			
			/*for(int print=0;print<words2check.size();print++){
				System.out.println(words2check.get(print));
			}*/
			
			checkinHash(words2check,hashtable);
			
			
			
		
		Collections.sort(foundwords);
		System.out.println("Printing out the found words:");
		printlist(foundwords);
		
		FileWriter writer= new FileWriter(output);
		for(String str: foundwords){
			writer.write(str + 
					System.getProperty("line.separator"));
		}
		writer.close();
		
		
		
		
		
	}
	
	public static ArrayList<String> getit(File f,int dimension) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str;
		
		ArrayList<String> list = new ArrayList<String>();
		while((str = br.readLine())!=null){
			if(str.length()<=dimension){
			list.add(str);
			}
		}
		return list;
	}
	
	//functions for checking!
	public void across(char [][] array, int size, int index){
		
		
		String word="";
		for(int c=0;c<size;c++){
			for(int cols=c;cols<size;cols++){
				
				word+=array[index][cols];
				if(!words2check.contains(word)){
				words2check.add(word);
				}
				
				//System.out.println("Printing across!");
			}
			word="";
		}
		
		
		
		
	}
public void backwardsacross(char [][] array, int size, int index){
		
		String word="";
		for(int c=size;c>=0;c--){
		for(int cols=c-1;cols>=0;cols--){
			
			word+=array[index][cols];
			if(!words2check.contains(word)){
			words2check.add(word);
			}
			
		}
		word="";
		}
		
		
		
	}
public void straightdown(char [][] array, int size, int index){
	
	
	String word="";
	for(int r=0;r<size;r++){
	for(int rows=r;rows<size;rows++){
		
		word+=array[rows][index];
		if(!words2check.contains(word)){
		words2check.add(word);
		}
		
	}
	word="";
	}
	
	
	
	
}
public void straightup(char [][] array, int size, int index){
	
	
	String word="";
	for(int r=size;r>=0;r--){
		for(int rows=r-1;rows>=0;rows--){
			
			word+=array[rows][index];
			if(!words2check.contains(word)){
				words2check.add(word);
				}
				
		}
		word="";
	}
	
	
	
}

public void diagonalDR(char [][] array,int size){
	
	String word="";
	
	for(int boat=0;boat<size;boat++){
		for(int pillar=0;pillar<size;pillar++){
			for(int r=boat,c=pillar; c<size && r<size;r++,c++){
				
					//System.out.println("Rows = " + rows + " Cols= "+ cols);
					word+=array[r][c];
					if(!words2check.contains(word)){
					words2check.add(word);
					}	
			}
			word="";
		}
		word="";
	}
}

	

	
	

public void diagonalUL(char [][] array,int size){
	int counter=0;
	String word="";
	
	for(int boat=size-1;boat>=0;boat--){
		for(int pillar=size-1;pillar>=0;pillar--){
			for(int r=boat,c=pillar; c>=0 && r>=0;r--,c--){
				
					//System.out.println("Rows = " + rows + " Cols= "+ cols);
					word+=array[r][c];
					counter++;
					if(!words2check.contains(word)){
					words2check.add(word);
					}
					
			}
			word="";
		}
		word="";
	}
	//System.out.println("THE COUNTER IS: " + counter);
}

	
	


public void diagonalUR(char [][] array,int size){
	
	String word="";
	
	
	
	for(int boat=size-1;boat>=0;boat--){
		for(int pillar=0;pillar<size;pillar++){
			for(int r=boat,c=pillar; c<size && r>=0;r--,c++){
				
					//System.out.println("Rows = " + rows + " Cols= "+ cols);
					word+=array[r][c];
					
					if(!words2check.contains(word)){
					words2check.add(word);
					//System.out.println(word);
					}
					
			}
			word="";
		}
		word="";
	}
	
	
}

public void diagonalDL(char [][] array,int size){
	
	String word="";

	
	
	for(int boat=0;boat<size;boat++){
		for(int pillar=size-1;pillar>=0;pillar--){
			for(int r=boat,c=pillar; c>=0 && r<size;r++,c--){
				
					//System.out.println("Rows = " + rows + " Cols= "+ cols);
					word+=array[r][c];
					
					if(!words2check.contains(word)){
					words2check.add(word);
					}
					
			}
			word="";
		}
		word="";
	}
	
	
}


	
	public static void printarray(String[] a){
		for(int i =0; i<a.length;i++){
			System.out.print(a[i]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void printlist(ArrayList<String> a){
		for(int i =0; i<a.size();i++){
			System.out.print(a.get(i)+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void printboard(char [][] board){
		for ( int row = 0; row < board.length; row++ ){
			for ( int column = 0; column < board[ row ].length; column++ ){
				System.out.printf( "%3s  ", board[ row ][ column ] );
			}
			System.out.println();
			}
	}
	public static char [][] CreateBoard(File f,int dimension) throws IOException{
		char [][] boardy=new char [dimension][dimension];
		BufferedReader br = new BufferedReader(new FileReader(f));
		String l;
		int i=0;
		while((l=br.readLine()) !=null){
			//System.out.println(l);
			
			boardy[i++]=l.toCharArray();
			//System.out.println(i);
		}	
		return boardy;
	}
	
	
	public void checkinHash(ArrayList<String> words2check,ChainedHashTable ht){
		
		for(int i=0;i<words2check.size();i++){
			//System.out.println("Words to check and pass: "+ words2check.get(i));
			if(ht.lookitup(words2check.get(i))){
				//System.out.println("Words found : " + words2check.get(i));
				//if(words2check.get(i).length()>=3){
					if(!foundwords.contains(words2check.get(i))){
					foundwords.add(words2check.get(i));
					}
			//}
			}
			
		}
		
	}
	
}
