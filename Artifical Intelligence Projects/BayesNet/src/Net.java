import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Net {
	//this is a network of nodes (hashmap, accessed by random variable name?)
	HashMap<String,Node> nodes;
	ArrayList<Node> sorted;
	public Net(HashMap<String,Node> nodes,ArrayList<Node> sorted){
		this.nodes=nodes;
		this.sorted=sorted;
	}
	
	public HashMap<String,Node> getParents(RandomVar x){
		return nodes.get(x.name).parents;
	}
	
	public void add(String s, Node n){
		nodes.put(s,n);
	}
	
	public void remove(String s){
		if(nodes.containsKey(s)){
			nodes.remove(s);
		}
		else{
			System.out.println("The object " + s + " does not exist.");
		}
	}

	public int sizeme(){
		return nodes.size();
	}
	
	public void printNet(){
		for (Map.Entry<String, Node> entry : nodes.entrySet()) {
		    
		    entry.getValue().printNode();
		}
		System.out.println();
	}
	
	
	
	
}
