import java.util.ArrayList;


public class RandomVar {
// a random variable has a name and a domain (the set of its possible values)
	String name;
	String [] vector;
	public RandomVar(String name, String []vector){
		this.name=name;
		this.vector=vector;
	}
	
	public void printpossible(){
		System.out.print(name+ ": ");
		for(int i=0; i<vector.length-1;i++){
			System.out.print(vector[i]+ ", ");
		}
		System.out.print(vector[vector.length-1]);
		System.out.println();
	}
	
	public String [] contains(Evidence e){
		String [] returned=new String [2];
		for(String i:vector){
			for(String j:e.evidence){
				if(i==j||j!=null&&j.equals(i)){
					
					returned[0]="true";
					returned[1]=i;
					//System.out.println("mhmmm "+i+"   " +returned[1]);
					return returned;
				}
				else{
					returned[0]="false";
					returned[1]="crackerjacks";
					//System.out.println("False  "+returned[1]);
					
					
				}
			}
		}
		//System.out.println("FINAL: "+ returned[0] + "  " + returned[1]);
		return returned;
	}
}
