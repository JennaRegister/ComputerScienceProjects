import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Evidence {
// set of random variables and a value for each of them (assignment)
	//not necessarily just "true" or "false" -> an assignment is simply a state of the world (the value of the variable) 
	//e.g. [Weather = sunny] is just like [Alarm = true]
	ArrayList<String> evidence;
	public Evidence(ArrayList<String> evidence){
		this.evidence=evidence;
		
	}
	
	public void print(){
		System.out.print("Evidence: ");
		for(int i=0;i<evidence.size();i++){
			
			System.out.print(evidence.get(i)+ " ");
		}
		System.out.println();
	}
	
	public void extend(String n00b){
		
		ArrayList<String> newevidence=new ArrayList<String>();
		for(int i=0;i<evidence.size();i++){
			newevidence.add(this.evidence.get(i));
		}
		newevidence.add(n00b);
		this.evidence=newevidence;
	}
	
	public void removelast(){
		evidence.remove(evidence.size()-1);
	}
	
	public boolean isConsistent(Evidence e2){
		//checks to see if evidence is consistent with each other
		boolean consistent=true;
		for(int i=0;i<e2.evidence.size();i++){
			if(!this.evidence.contains(e2.evidence.get(i))){
				consistent=false;
			}
		}
		
		return consistent;
		
	}
	public Evidence cutdown(HashMap<String,Node> parents){
		//cutdown some evidence only to include values that could be the parents
		//e.g. I have a list b e a j but I am evaluating on john and only want to include anything that could be Alarm
		ArrayList<String> newlist=new ArrayList<String>();
		Evidence newevidence;
		boolean match=false;
		//for each of the parents
		for (Map.Entry<String, Node> entry : parents.entrySet()) {
			//for each of the values in the vector
			for(int i=0;i<entry.getValue().randvar.vector.length;i++){
				if(this.evidence.contains(entry.getValue().randvar.vector[i])){
					newlist.add(entry.getValue().randvar.vector[i]);
				}
			}
			
			
		}
		newevidence=new Evidence(newlist);
		return newevidence;
	}
}
