import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class CPT {
	//here we need to make a structure that can access conditional probabilities
	//must be topologically sorted
	
	/* e.g. 
	 * 			 a		 ~a			(vector)
	 *  b ^ e	 val	val
	 * ~b ^ e	 val	val
	 * b ^ ~e	 val	val
	 * ~b ^ ~e	 val	val	
	 * 
	 * (vector)
	 */
	
	
	HashMap<ArrayList<String> , Double> cpt=new HashMap<ArrayList<String>, Double>();
	
	public CPT( ArrayList<ArrayList<String>> list , Double[] probs){
		if(list!=null&&probs!=null){
			for(int i=0;i<list.size();i++){
				
				cpt.put(list.get(i), probs[i]);
			}
		}
	}
	public ArrayList<Entry> CPTcontains(Evidence e){
		ArrayList<Entry> entries=new ArrayList<Entry>();
		for (Map.Entry<ArrayList<String>, Double> entry : cpt.entrySet()) {
			boolean contains=true;
			for(int i=0;i<e.evidence.size();i++){
				if(!entry.getKey().contains(e.evidence.get(i))){
					contains=false;
				}
				
			}
			if(contains){
				if(!(entries.contains(entry))){
					entries.add(entry);
				}
			}
		}
		return entries;
		
	}
	
	public ArrayList<Entry> getViable(){
		ArrayList<Entry> entries=new ArrayList<Entry>();
		for (Map.Entry<ArrayList<String>, Double> entry : cpt.entrySet()) {
			entries.add(entry);
		}
		return entries;
	}
	public void add(ArrayList<String> s, double d){
		cpt.put(s, d);
	}
	
	public void printCPT(){
		for (Map.Entry<ArrayList<String>, Double> entry : cpt.entrySet()) {
			
		    System.out.print(entry.getKey()+" " );
			
			System.out.print(": "+entry.getValue());
			System.out.println();
		}
		System.out.println();
	}
	
	public void normalize(){
		//XA+XB=1
		//sum up all of the values then divide each value by that sum (make it add up to 1)
		float sum=0;
		
		for (Map.Entry<ArrayList<String>, Double> entry : cpt.entrySet()) {
			sum+=entry.getValue();
		}
		for (Map.Entry<ArrayList<String>, Double> entry : cpt.entrySet()) {
			
			cpt.put(entry.getKey(), entry.getValue()/sum);
		}
		
		
	}
	
	
}
