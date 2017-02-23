
public class MyTreeNode<T extends Comparable<T>> {
	public T data;
	public MyTreeNode<T> leftChild;
	public MyTreeNode<T> rightChild;
	public MyTreeNode<T> parent;
	
	public MyTreeNode(T data){
		this.data=data;
		leftChild=null;
		rightChild=null;
		parent=null;
		
	}
	
	public void insert(T x){
		MyTreeNode newnode=new MyTreeNode(x);
		if(x.compareTo(data)>0){
			if(rightChild==null){
				rightChild=newnode;
				newnode.parent=this;	
			}
			if(rightChild!=null){
				rightChild.insert(x);
			}
			
			
		}
		if(x.compareTo(data)<0){
			if(leftChild==null){
				leftChild=newnode;
				newnode.parent=this;
			}
			if(leftChild!=null){
				leftChild.insert(x);
			}
			
		}
	}
	public boolean lookup(T x){
		if(data.compareTo(x)==0){
			return true;
		}
		else if((x.compareTo(data)>0)&&(rightChild!=null)){
			return rightChild.lookup(x);
		}
		else if((x.compareTo(data)<0)&&(leftChild!=null)){
			return leftChild.lookup(x);
		}
		else{
			
		return false;
		}
		
	}
	public void delete(T x){
		//System.out.println("I am called!");
		if(!lookup(x)){
			//System.out.println("The item you want to delete is not in the tree.");
			return;
			
		}
		//System.out.println("In between");
		if(lookup(x)){
			if(data.compareTo(x)==0){
				if(parent==null){
					if((leftChild==null)&&(rightChild==null)){
					this.data=null;
					}
					if(((leftChild==null)&&(rightChild!=null))){
					rightChild.parent=null;
					}
					if(((leftChild!=null)&&(rightChild==null))){
					leftChild.parent=null;
					}
					if(((leftChild!=null)&&(rightChild!=null))){	
						MyTreeNode tempnode=rightChild;
						if(rightChild.leftChild!=null){
							tempnode=rightChild.leftChild;
							while(tempnode.leftChild!=null){
							tempnode=tempnode.leftChild;
							}	
						}
						Comparable theswitch=tempnode.data;
						delete((T) theswitch);
						this.data=(T) theswitch;
					}
					
				}
				//if i have no children
				else if((leftChild==null)&&(rightChild==null)){
					if(data.compareTo(parent.data)<0){
					parent.leftChild=null;
					//System.out.println("parent of left child to null!");
					}
					
					
					if(data.compareTo(parent.data)>0){
						parent.rightChild=null;
						//System.out.println("parent of right child to null!");
						
					}
				}
				
				//if I am the left baby
				else if(parent.leftChild.data.compareTo(x)==0){
					if((leftChild!=null)&&(rightChild==null)){
						parent.leftChild=leftChild;
						
					}
					if((leftChild==null)&&(rightChild!=null)){
						parent.leftChild=rightChild;
						
					}
					if((leftChild!=null)&&(rightChild!=null)){
						MyTreeNode tempnode=rightChild;
						if(rightChild.leftChild!=null){
							tempnode=rightChild.leftChild;
							while(tempnode.leftChild!=null){
							tempnode=tempnode.leftChild;
							}	
						}
						Comparable theswitch=tempnode.data;
						delete((T) theswitch);
						this.data=(T) theswitch;
						
					}
					
					
					
				}
				//i am the right baby
				else if(parent.rightChild.data.compareTo(x)==0){
					if(((leftChild==null)&&(rightChild!=null))){
					parent.rightChild=rightChild;	
					
				}
					if((leftChild!=null)&&(rightChild==null)){
						parent.rightChild=leftChild;
						
					}
					if((leftChild!=null)&&(rightChild!=null)){
						MyTreeNode tempnode=rightChild;
						if(rightChild.leftChild!=null){
							tempnode=rightChild.leftChild;
							while(tempnode.leftChild!=null){
							tempnode=tempnode.leftChild;
							}	
						}
						Comparable theswitch=tempnode.data;
						delete((T) theswitch);
						this.data=(T) theswitch;
						
					}
				}
			}
			if(data.compareTo(x)<0){
				//System.out.println("Right deleting");
				rightChild.delete(x);
			}
			if(data.compareTo(x)>0){
				//System.out.println("Left deleting");
				leftChild.delete(x);
			}
				
			}
			
			
			
		}
		
		
		
		
	
	
	
	
	
	
	
	
	public void printInOrder(){
		if(leftChild !=null){
			leftChild.printInOrder();
		}
		System.out.println(data);
		if(rightChild!=null){
			rightChild.printInOrder();	
		}
	
	}
	public void printPreOrder(){
		System.out.println(data);
		if(leftChild !=null){
			leftChild.printPreOrder();
		}
		
		if(rightChild!=null){
			rightChild.printPreOrder();	
		}
	
	}
	public void printPostOrder(){
		
		if(leftChild !=null){
			leftChild.printPostOrder();
		}
		
		if(rightChild!=null){
			rightChild.printPostOrder();	
		}
		System.out.println(data);
	
	}
	

}
