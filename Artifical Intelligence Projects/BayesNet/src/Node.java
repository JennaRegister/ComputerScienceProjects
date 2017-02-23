import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Node {
	//the node of a BN contains the distributions for our variables, stored as CPTs
	
	//conditional probability of distribution of its random variable given it's parents
	
	// has a set of child nodes (hashmap)
	// has a set of parent nodes (hashmap)
	//has a random variable
	//if no parents, has a prior distribution (still a CPT, but a lame one)
	
	HashMap<String,Node> children;
	HashMap<String,Node> parents;
	RandomVar randvar;
	CPT cpt;
	
	public Node(HashMap<String,Node> children,HashMap<String,Node> parents,RandomVar randvar,CPT cpt){
		this.children=children;
		this.parents=parents;
		this.randvar=randvar;
		this.cpt=cpt;
		
	}
	
	/*public double pgiven(String val){
		double prob=0;
		ArrayList<Map.Entry<ArrayList<String>,Double>> storeme=new ArrayList<Map.Entry<ArrayList<String>,Double>>();
		if(parents!=null){
		//for each parent
		for (Map.Entry<String, Node> entry : parents.entrySet()) {
			//any of the keys in the CPT matching any of the vector for any of the parents
		    for(int i=0;i<entry.getValue().randvar.vector.length;i++){
		    	System.out.println(entry.getValue().randvar.vector[i]);
		    	for(Entry<ArrayList<String>, Double> cptentry : cpt.cpt.entrySet()){
		    		if(cptentry.getKey().contains(entry.getValue().randvar.vector[i])&&(cptentry.getKey().contains(val))){
		    			if(!storeme.contains(cptentry)){
		    			storeme.add(cptentry);
		    			}
		    		}
		    	}
		    }
		    //entry.getValue().randvar.printpossible();
		    
		}
		}
		
		prob=sum(storeme);
		System.out.println(prob);
		return prob;
	}*/
	
	public double pgiven(Evidence e){
		//match to your CPT
		for(Entry<ArrayList<String>, Double> cptentry : cpt.cpt.entrySet()){
			boolean matched=true;
			for(int i=0;i<cptentry.getKey().size();i++){
				if(!(e.evidence.contains(cptentry.getKey().get(i)))){
					matched=false;
				}
			}
			if(matched){
				return cptentry.getValue();
			}
			
		}
		return -1;
	    	
	}
	public static float sum(ArrayList<Entry<ArrayList<String>, Double>> storeme){
		float p=0;
		for(int i=0;i<storeme.size();i++){
			p+=storeme.get(i).getValue();
			System.out.println("Summing: " + storeme.get(i).getValue());
		}
		return p;
	}
	
	public void printNode(){
		randvar.printpossible();
		System.out.println(" --> --> --> ");
		cpt.printCPT();
		
		if(parents!=null&&children!=null){
			//if I am in the middle (have both parents and children)
			System.out.println("Parents: ");
			for (Map.Entry<String, Node> entry : parents.entrySet()) {
			    System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			System.out.println();
			System.out.println("Children: ");
			for (Map.Entry<String, Node> entry : children.entrySet()) {
			    System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			System.out.println("--------------------------------");
			System.out.println();
		}
		if(parents!=null&&children==null){
			//if I have no children (lowest)
			System.out.println("Parents: ");
			for (Map.Entry<String, Node> entry : parents.entrySet()) {
			    System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			System.out.println("--------------------------------");
			System.out.println();
		}
		if(parents==null&&children!=null){
			//if I have no parents (highest)
			System.out.println("Children: ");
			for (Map.Entry<String, Node> entry : children.entrySet()) {
			    System.out.println(entry.getKey()+" : "+entry.getValue());
			}
			System.out.println("--------------------------------");
			System.out.println();
			
		}
		
		
	}
	
	public void addChild(String s,Node n){
		if(children!=null){
			children.put(s,n);
		}
		else{
			children=new HashMap<String,Node>();
			children.put(s, n);
		}
	}
	
	public void addParent(String s, Node n){
		if(parents!=null){
			parents.put(s,n);
		}
		else{
			parents=new HashMap<String,Node>();
			parents.put(s, n);
		}
	}
	
	public String toString(){
		return(randvar.name);
	}
	
	
	

}
