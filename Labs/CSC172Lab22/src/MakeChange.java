import java.util.Arrays;


public class MakeChange {
	public static int calls=0;
	
	//for dynamic programming
	public static int [][] table;
	public static void main (String [] args){
		//"coins"
		int [] denominations = { 10000,5000,2000,1000,500, 100, 25, 10, 5, 1};
		int amount = 43;
		//takes in command line argument for amount
		if(args.length==1){
			amount = Integer.parseInt(args[0]);
		}
		int [] change= makeChange2(amount, denominations);
		
		System.out.print("Change for " + amount + " is { ");
		for (int i=0; i < change.length;i++){
			System.out.print(change[i] + ", ");
			
		}
		System.out.println("}");
		//counts the number of calls it takes
		System.out.println("This took " + calls + " calls.");
	}
	
	//makeChange makes the recursive call
	public static int [] makeChange(int amount, int [] denominations){
		int [] counts= new int [denominations.length+1];
		
		recMakeChange(amount,denominations,counts);
		//printme(counts);
		int [] toreturn = convert(denominations,counts);
		return toreturn;
	}
	//the second, dynamic version of makeChange
	public static int [] makeChange2(int amount, int [] denominations){
		table=new int[amount+1][];
		int [] counts= new int [denominations.length+1];
		recMakeChange(amount,denominations,counts);
		//printme(counts);
		int [] toreturn = convert(denominations,counts);
		return toreturn;
	}
	
	//the recursive method
	public static boolean recMakeChange(int amount, int [] denominations, int [] counts){
		calls++;
		boolean solution=false;
		//base cases
		if(amount==0)
			return true;
		else if(amount<0)
			return false;
		//SO MUCH FASTER!!!
		if(table[amount] != null){
			for(int k=0; k<table[amount].length;k++)
				counts[k]=table[amount][k];
			return true;
		}
		
		
		int [] temp = new int [counts.length];
		int [] best=new int [counts.length];
		best[counts.length-1]=amount+1;
		
		for(int d=0;d<denominations.length;d++){
			for(int t=0;t<temp.length;t++){
				temp[t]=0;
			}
			if((recMakeChange(amount-denominations[d],denominations,temp))){
				if(temp[temp.length-1] < best[best.length-1]){
					temp[d]++;
					temp[temp.length-1]++;
					for(int z=0; z<best.length;z++)
						best[z]=temp[z];
				}
				solution=true;
			}
		}
		//WAY SLOWER WITH THIS IMPLEMENTATION
		/*if(solution){
			for(int b=0;b<best.length;b++){
				counts[b]=best[b];
				//System.out.println(Arrays.toString(best));
			}
			return true;
		}*/
		if(solution){
			
			table[amount]=new int[counts.length];
			for(int z=0; z<best.length;z++)
				table[amount][z]=counts[z]=best[z];
			//System.out.println(Arrays.toString(best));
			return true;
		}
		
		else{
		return false;
		}
		
	}
		
		
	
	//converts the counts into an array that displays which coins you need
	public static int [] convert(int [] denoms,int [] counts){
		int [] returns=new int [counts[counts.length-1]];
		for(int i=0;i<returns.length;i++){
			returns[i]=0;
		}
		
		int counter=0;
		for(int a=0;a<counts.length-1;a++){
			
			
			if((counts[a]!=0)){
				for(int b=0;b<counts[a];b++){
					
					returns[counter]=denoms[a];
					
					counter++;
				}
			}
			
		}
		return returns;
	}
	
	//prints an array
	public static void printme(int [] a){
		for(int i=0; i<a.length;i++){
			System.out.print(a[i] + "  ");
		}
	}
	
	
}
