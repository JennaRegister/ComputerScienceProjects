
public class MyHeap<T extends Comparable<T>> implements Heap {
	T [] theheap;
	int currentsize=0;
	
	public MyHeap(){
	theheap=(T[]) new Comparable [10];
	}

	public MyHeap(int capacity){
		theheap=(T[]) new Comparable [capacity];
		
	}
	
	public MyHeap(T[] array){
		theheap=array;
		heapify(theheap);
		
	}
	
	public T[] heapify(T[] array){
		currentsize= array.length-1;
		//System.out.println(currentsize);
		for(int i=(currentsize/2)+1; i>=1;i--){
				bubbledown2(i);
			
		}
		return array;		
	}
	
	public void swap(Comparable i, Comparable j, T[] a){
		Comparable temp=a[(int) i];
		a[(int) i]=a[(int) j];
		a[(int) j]=(T) temp;
	}
	
	public int size(Comparable [] h){
		return h.length;
	}
	
	public boolean isEmpty(Comparable [] h){
		if(h==null){
			return true;
		}
		else{
			return false;
		}
	}
	public void expand(){
		int size=(theheap.length)*2;
		T [] bigger=(T[]) new Comparable [size];
		for(int i=1;i<theheap.length;i++){
			bigger[i]=theheap[i];
				
		}
		theheap=bigger;
	}
	public void insert(Comparable item) {
		if(++currentsize==theheap.length){
			expand();
		}
		
		//add it in the first available spot...which will usually make this a NOT OK HEAP.
		theheap[currentsize]=(T) item;
		if(currentsize==1){
			return;
		}
		else{
		bubbleUp(currentsize);
		//System.out.println("Current size: " + currentsize);
		}
		
	}
	public void bubbleUp(int index){
		//parent=wherever you are currently
		int parent=index/2;
		while((((Comparable) theheap[index]).compareTo(theheap[parent])<0)&&parent>=1){
			
			Comparable temp=(Comparable) theheap[index];
			temp=theheap[parent];
			theheap[parent]=theheap[index];
			theheap[index]=(T) temp;
			
			if(parent>1){
			index=parent;
			parent=index/2;
			
			}
			else{
				//parent=parent;
				return;
			}
			
			
		}
		
		
		}

	public void printHeap(){
		for(int i=1;i<=currentsize;i++){
			System.out.println(theheap[i]);
		}
	}
	public Comparable deleteMin() {
		Comparable tmp=theheap[currentsize];
		theheap[1]=(T) tmp;
		theheap[currentsize]=null;
		currentsize--;
		bubbledown2(1);
	
		return tmp;
		
		
	}
	public void bubbledown2(int index){
		//set family relations
		int leftkid=2*index;
		int rightkid=leftkid+1;
		//WHILE YOU HAVE A LEFT KID, UNTIL YOU'RE DONE
		while(leftkid<=currentsize){
		//while((theheap[index].compareTo(theheap[leftkid])>0)|(theheap[index].compareTo(theheap[rightkid])>0))
			//IF YOU HAVE 2 CHILDREN
			if(rightkid<=currentsize){
				//IF THE LEFT IS THE MINIMUM
				if((theheap[leftkid].compareTo(theheap[rightkid])<0)){
					//IF YOU NEED TO SWAP
					if(theheap[index].compareTo(theheap[leftkid])>0){
						//THEN DO IT.
						Comparable temp=(Comparable) theheap[index];
						temp=theheap[leftkid];
						theheap[leftkid]=theheap[index];
						theheap[index]=(T) temp;
						//RESET FAMILY
						index=leftkid;
						leftkid=index*2;
						rightkid=leftkid+1;
					}
					//IF YOU DON'T NEED TO SWAP, CHILL.
					else{
						return;
					}
				}
				//IF THE RIGHT IS THE MINIMUM
				else if((theheap[leftkid].compareTo(theheap[rightkid])>0)){
					//AND YOU NEED TO SWAP.
					if(theheap[index].compareTo(theheap[rightkid])>0){
						//THEN SWAP.
						Comparable temp=(Comparable) theheap[index];
						temp=theheap[rightkid];
						theheap[rightkid]=theheap[index];
						theheap[index]=(T) temp;
						index=rightkid;
						leftkid=index*2;
						rightkid=leftkid+1;
					}
					//OTHERWISE, CHILL.
					else{
						return;
					}
				}
				
				
				
				
			}
			//IF YOU ONLY HAVE A LEFT CHILD...
			else{
				//IF YOU ARE BIGGER THAN LEFT, SHIFT DOWN BY SWAPPING WITH LEFT.
				if(theheap[index].compareTo(theheap[leftkid])>0){
					Comparable temp=(Comparable) theheap[index];
					temp=theheap[leftkid];
					theheap[leftkid]=theheap[index];
					theheap[index]=(T) temp;
					//RESET FAMILY RELATIONS
					index=leftkid;
					leftkid=index*2;
					rightkid=leftkid+1;
				}
				else{
					return;
				}
			}
		}
				
		}
	
	/*public void bubbledown(int i){
		if(i<currentsize){
			int index=i;
			int leftkid=2*index;
			int rightkid=(2*index)+1;
			int size=currentsize;
			//System.out.println("Current size is: " + currentsize); 
			//IF YOU HAVE A RIGHT CHILD AND IT IS BIGGER THAN YOU AND THE RIGHT IS THE MINIMUM:
			if(rightkid<=size && (theheap[rightkid].compareTo(theheap[index])<0)&& theheap[rightkid].compareTo(theheap[leftkid])<0){
				Comparable tmp=theheap[rightkid];
				theheap[rightkid]=theheap[index];
				theheap[index]=(T) tmp;
				bubbledown(rightkid);
				//SWAP WITH THE RIGHT, AND THEN USE THAT AS THE NEW INDEX.
			}
			else if(leftkid<size && theheap[leftkid].compareTo(theheap[index])<0){
				Comparable tmp=theheap[leftkid];
				theheap[leftkid]=theheap[index];
				theheap[index]=(T) tmp;
				bubbledown(leftkid);
			}
			}
	}*/
	
	}

	


	
	


