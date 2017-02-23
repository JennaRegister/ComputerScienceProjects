import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HashTable {
	String [] values;
	public HashTable(int capacity){
		values=new String [capacity];
	}
	public HashTable(){
		values=new String [20];
	}
	public HashTable(String [] array, boolean duplicates){
		String [] thearray = null;
		if(duplicates){
			ArrayList thea=new ArrayList<String>();
			
			for(int j=0;j<array.length;j++){
				if(!thea.contains(array[j].toLowerCase())){
					
					thea.add(array[j]);
				}
			}
			int size=thea.size();
			thearray=new String [size];
			for(int k=0;k<size;k++){
				thearray[k]=(String) thea.get(k);
			}
			//values=new String [thearray.length*3];
			values=new String [13];
			for(int i=0;i<thearray.length;i++){
				insert(thearray[i]);
			}
			System.out.println("Number of words read in = " +array.length);
			System.out.println("Number of unique words = "+ size);
		}
		
		else if(duplicates==false){
			values=new String [array.length*3];
			for(int i=0;i<array.length;i++){
				insert(array[i]);
			}
		}
		
		
	}
	//IGNORE ME
	public HashTable(ArrayList<String> list){
		//System.out.println("I got here!");
		String [] temp = new String[list.size()];
		for(int i=0; i<list.size();i++){
			temp[i]=list.get(i);
		}
		values=new String [10000000];
		for(int i=0;i<temp.length;i++){
			//System.out.println(i);
			insert(temp[i]);
		}
		
	}
	
	public static int hash(String key, int size){
		int value=0;
		
		for(int i=0; i<key.length();i++){
			value+=key.charAt(i);
		}
		System.out.println(value);
		return value%size;
	}
	
	
	public void insert(String key){
		
		int index=hash(key,values.length);
		//if there's room, put it there.
		
		if(values[index]==null){
			if(values[index]==key){
				return;
			}
			else{
			values[index]=key;
			}
		}
		
		else{
			//if it's already there, don't insert anything.
			if(values[index]==key){
				return;
			}
			//if there's no room, keep looking for an "empty chair" until you find one.
			else {
			while(values[(index+1)%values.length]!=null){
				//if the next one is me, exit.
				if(values[(index+1)%values.length]==key){
					return;
				}
				//keep moving until you have an empty space
				index++;
			}
			//go to that empty space.
			index++;
			//takes care of wrap-around
			values[index%values.length]=key;
			}
		}
		
		
		
		if(getLoad()>values.length/2){
			String [] temp=values;
			values=new String [temp.length*2];
			
			for(int i=0; i<temp.length;i++){
				if(temp[i]!=null){
					int newindex=hash(temp[i],values.length);
					values[newindex]=temp[i];
				}
				
			}
		}
			
		
	}
	
	public void print(){
		for(int i=0;i<values.length;i++){
			if(values[i]!=null){
				System.out.println(values[i]);
			}
		}
	}
	public int getCapacity(){
		return values.length;
	}
	
	public int getLoad(){
		int load=0;
		for(int i=0;i<values.length;i++){
			if(values[i]!=null){
				load++;
			}
		}
		return load;	
	}
	
	
}
