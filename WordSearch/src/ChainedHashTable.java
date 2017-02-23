import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChainedHashTable<AnyType> {
	MyLinkedList [] values;
	
	public ChainedHashTable(int capacity){
		values=new MyLinkedList [capacity];
	}
	public ChainedHashTable(){
		values=new MyLinkedList [1000000];
	}
	
	public ChainedHashTable(ArrayList<String> list){
		//System.out.println("I got here!");
		String [] temp = new String[list.size()];
		for(int i=0; i<list.size();i++){
			temp[i]=list.get(i);
		}
		values=new MyLinkedList [10];
		for(int i=0;i<temp.length;i++){
			//System.out.println(i);
			insert(temp[i]);
			//System.out.println("I am inserting: " + temp[i]);
		}
		
	}
	
	public static int hash(String temp, int size){
		int value=0;
		for(int i=0; i<temp.length();i++){
			value=37*value+temp.charAt(i);
		}
		value%=size;
		if(value<0)
			value+=size;
		
		return value;
		//System.out.println(value);
		
	}
	

	public void insert (String key){
		int index=hash(key,values.length);
		if(values[index]==null){
			values[index]=new MyLinkedList();
		}
		values[index].insert(key);
		System.out.println("Inserting:" + values[index].head.data.toString());
		//System.out.println("PRINT THE STACK AT: "+ index+ " : ");
		//values[index].printList();
	
				
		
		/*if(getLoad()>values.length/2){
			MyLinkedList [] temp=values;
			values=new MyLinkedList [temp.length*2];
			
			for(int i=0; i<temp.length;i++){
				if(temp[i]!=null){
					
					/*int newindex=hash(temp[i].head.data.toString(),values.length);
					values[newindex]=temp[i];
					if(temp[i].head.next!=null){
					while(temp[i].head.next!=null){
						newindex=hash(temp[i].head.next.data.toString(),values.length);
						values[newindex]=temp[i];
						temp[i].head.next=temp[i].head.next.next;
					}
					}*/
					/*
						MyNode<AnyType> current = temp[i].head;
						while(current!=null){
							int newindex=hash(current.data.toString(),values.length);
							values[newindex].insert(temp[i].head.data.toString());
							current=current.next;
						}
					
				}
				
				
			}
		}*/
			
		
	}
	
	public boolean lookitup(String query){
		int size=values.length;
		int index=hash(query,size);
		//System.out.println("UNICORNS" + index);
		if(values[index]!=null){
			
			boolean found =values[index].lookup(query);
			if(found){
				//System.out.println("returning: true");
				return true;
			}
		}
		else{
			//System.out.println("else");
		return false;
		}
		//System.out.println("Empty");
		return false;
	}
	
	public void print(){
		for(int i=0;i<values.length;i++){
			if(values[i]!=null){
				//System.out.println(values[i]);
				//System.out.println("Index : " + i);
				//values[i].printList();
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
