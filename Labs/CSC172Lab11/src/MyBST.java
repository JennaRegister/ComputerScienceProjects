
public class MyBST implements BST{
	MyTreeNode root;
	public MyBST(){
		root=null;
	}
	

	public void insert(Comparable x) {
		if(root!=null){
			root.insert(x);
		}
		else{
			root=new MyTreeNode(x);
		}
		
		
	}

	
	

	public void printPreOrder() {
		root.printPreOrder();
			
	}

	public void printInOrder() {
		root.printInOrder();
				
	}

	public void printPostOrder() {
		root.printPostOrder();
		
	}


	@Override
	public boolean lookup(Comparable x) {
		if(root==null){
			return false;
		}
		return root.lookup(x);
	}


	@Override
	public void delete(Comparable x) {
		if(root==null){
			return;
		}
		
		root.delete(x);
	}

	

	
	

	
}
