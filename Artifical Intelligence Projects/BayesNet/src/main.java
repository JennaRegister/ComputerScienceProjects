import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


public class main {

	public static void main(String[] args) {
		
		//construct Random Variables with the appropriate vectors
		String [] burgs={"b","~b"};
		RandomVar burglary=new RandomVar("Burglary",burgs);
		
		String [] alarms={"a","~a"};
		RandomVar alarm=new RandomVar("Alarm",alarms);

		String [] earthquakes={"e","~e"};
		RandomVar earthquake=new RandomVar("Earthquake",earthquakes);
		
		RandomVar john=new RandomVar("JohnCalls",new String [] {"j","~j"});
		
		RandomVar mary=new RandomVar("MaryCalls",new String [] {"m","~m"});
	
		
	
		
		//construct the CPTs and create Nodes for the Net
		//I AM THE ABSOLUTE WORST WOW. THIS WAS SUCH A PAIN BECAUSE IM NOT PARSING. THIS IS GARBAGE, LIKE THE REST OF THIS PROGRAM.
		
		String [] b={"b"};
		String [] noB={"~b"};
		String [][] Bu={b,noB};
		ArrayList<String> b1=makeList(b);
		ArrayList<String> nob1=makeList(noB);
		ArrayList<ArrayList<String>> Blisty=new ArrayList<ArrayList<String>>();
		Blisty.add(b1);
		Blisty.add(nob1);
		Double [] bprob={.001,.999};
		CPT Bcpt=new CPT(Blisty,bprob);
		Node B=new Node(null,null,burglary,Bcpt);
		
		String [] e={"e"};
		String [] noE={"~e"};
		ArrayList<String> e1=makeList(e);
		ArrayList<String> noe1=makeList(noE);
		ArrayList<ArrayList<String>> Elisty=new ArrayList<ArrayList<String>>();
		Elisty.add(e1);
		Elisty.add(noe1);
		Double [] eprob={.002,.998};
		CPT Ecpt=new CPT(Elisty,eprob);
		Node E=new Node(null,null,earthquake,Ecpt);
	
		
		String [] a1={"a","b","e"};
		String [] a2={"a","b","~e"};
		String [] a3={"a","~b","e"};
		String [] a4={"a","~b","~e"};
		String [] a5={"~a","b","e"};
		String [] a6={"~a","b","~e"};
		String [] a7={"~a","~b","e"};
		String [] a8={"~a","~b","~e"};
		ArrayList<String> aa1=makeList(a1);
		ArrayList<String> aa2=makeList(a2);
		ArrayList<String> aa3=makeList(a3);
		ArrayList<String> aa4=makeList(a4);
		ArrayList<String> aa5=makeList(a5);
		ArrayList<String> aa6=makeList(a6);
		ArrayList<String> aa7=makeList(a7);
		ArrayList<String> aa8=makeList(a8);
		ArrayList<ArrayList<String>> bigABE=new ArrayList<ArrayList<String>>();
		bigABE.add(aa1);
		bigABE.add(aa2);
		bigABE.add(aa3);
		bigABE.add(aa4);
		bigABE.add(aa5);
		bigABE.add(aa6);
		bigABE.add(aa7);
		bigABE.add(aa8);
		Double [] probz={.95,.94,.29,.001,.05,.06,.71,.999};
		CPT AgivenBEcpt=new CPT(bigABE,probz);
		HashMap<String,Node> aparents=new HashMap<String,Node>();
		aparents.put("Burglary", B);
		aparents.put("Earthquake", E);
		Node AgivenBE=new Node(null,aparents,alarm,AgivenBEcpt);
	
		
		String [] j1={"j","a"};
		String [] j2={"j","~a"};
		String [] j3={"~j","a"};
		String [] j4={"~j","~a"};
		ArrayList<String> jj1=makeList(j1);
		ArrayList<String> jj2=makeList(j2);
		ArrayList<String> jj3=makeList(j3);
		ArrayList<String> jj4=makeList(j4);
		ArrayList<ArrayList<String>> JJ=new ArrayList<ArrayList<String>>();
		JJ.add(jj1);
		JJ.add(jj2);
		JJ.add(jj3);
		JJ.add(jj4);
		Double [] jprob={.90,.05,.10,.95};
		CPT JgivenAcpt=new CPT(JJ,jprob);
		HashMap<String,Node> jparents=new HashMap<String,Node>();
		jparents.put("Alarm", AgivenBE);
		Node JgivenA=new Node(null,jparents,john,JgivenAcpt);
	
		
		
		String [] m1={"m","a"};
		String [] m2={"m","~a"};
		String [] m3={"~m","a"};
		String [] m4={"~m","~a"};
		ArrayList<String> mm1=makeList(m1);
		ArrayList<String> mm2=makeList(m2);
		ArrayList<String> mm3=makeList(m3);
		ArrayList<String> mm4=makeList(m4);
		ArrayList<ArrayList<String>> MM=new ArrayList<ArrayList<String>>();
		MM.add(mm1);
		MM.add(mm2);
		MM.add(mm3);
		MM.add(mm4);
		Double [] mprob={.70,.01,.30,.99};
		CPT MgivenAcpt=new CPT(MM,mprob);
		
		HashMap<String,Node> mparents=new HashMap<String,Node>();
		mparents.put("Alarm", AgivenBE);
		Node MgivenA=new Node(null,mparents,mary,MgivenAcpt);
		
		
		
		
		//FINALLY WE ARE DONE WITH THAT FAKE PARSING GARBAGE. 
		
		
		
		//add in the children and parents once the right nodes are created
		E.addChild("Alarm", AgivenBE);
		B.addChild("Alarm", AgivenBE);
		
		AgivenBE.addChild("MaryCalls", MgivenA);
		AgivenBE.addChild("JohnCalls", JgivenA);
		
		//PRINTING OUT MY NODES
		
	
		
		HashMap<String,Node> nodes=new HashMap<String,Node>();
		
		
		nodes.put("Burglary",B);
		nodes.put("Earthquake",E);
		nodes.put("Alarm",AgivenBE);
		nodes.put("JohnCalls",JgivenA);
		nodes.put("MaryCalls",MgivenA);
		ArrayList<Node> sorted=new ArrayList<Node>();
		
		sorted.add(B);
		sorted.add(E);
		sorted.add(AgivenBE);
		sorted.add(JgivenA);
		sorted.add(MgivenA);
		
		
		Net alarmNet= new Net(nodes,sorted);
		alarmNet.printNet();
		
		//WET GRASS EXAMPLE. IM SORRY THIS IS SO BAD.
		RandomVar cloudy=new RandomVar("Cloudy", new String [] {"c","~c"});
		String [] c1=new String [] {"c"};
		String [] c2=new String [] {"~c"};
		ArrayList<String> cc1=makeList(c1);
		ArrayList<String> cc2=makeList(c2);
		ArrayList<ArrayList<String>> Clist=new ArrayList<ArrayList<String>>();
		Clist.add(cc1);
		Clist.add(cc2);
		Double [] cprob=new Double [] {.5,.5};
		CPT cloudcpt=new CPT(Clist, cprob);
		Node C=new Node(null,null,cloudy,cloudcpt);
		
		
		
		RandomVar sprinkler=new RandomVar("Sprinkler", new String [] {"s","~s"});
		String [] s1=new String [] {"s","c"};
		String [] s2=new String [] {"s","~c"};
		String [] s3=new String [] {"~s","c"};
		String [] s4=new String [] {"~s","~c"};
		ArrayList<String> ss1=makeList(s1);
		ArrayList<String> ss2=makeList(s2);
		ArrayList<String> ss3=makeList(s3);
		ArrayList<String> ss4=makeList(s4);
		ArrayList<ArrayList<String>> Slist=new ArrayList<ArrayList<String>>();
		Slist.add(ss1);
		Slist.add(ss2);
		Slist.add(ss3);
		Slist.add(ss4);
		Double [] sprob=new Double [] {.1,.5,.9,.5};
		CPT sprinklecpt=new CPT(Slist, sprob);
		HashMap<String,Node> sparents=new HashMap<String,Node>();
		sparents.put("Cloudy", C);
		Node S=new Node(null,sparents,sprinkler,sprinklecpt);
		
		
		RandomVar rain=new RandomVar("Rain",new String[] {"r","~r"});
		String [] r1=new String [] {"r","c"};
		String [] r2=new String [] {"r","~c"};
		String [] r3=new String [] {"~r","c"};
		String [] r4=new String [] {"~r","~c"};
		ArrayList<String> rr1=makeList(r1);
		ArrayList<String> rr2=makeList(r2);
		ArrayList<String> rr3=makeList(r3);
		ArrayList<String> rr4=makeList(r4);
		ArrayList<ArrayList<String>> Rlist=new ArrayList<ArrayList<String>>();
		Rlist.add(rr1);
		Rlist.add(rr2);
		Rlist.add(rr3);
		Rlist.add(rr4);
		Double [] rprob=new Double [] {.8,.2,.2,.8};
		CPT raincpt=new CPT(Rlist, rprob);
		HashMap<String,Node> rparents=new HashMap<String,Node>();
		rparents.put("Cloudy", C);
		Node R=new Node(null,rparents,rain,raincpt);
		
		RandomVar wetgrass=new RandomVar("WetGrass",new String [] {"w","~w"});
		String [] w1=new String [] {"w","s","r"};
		String [] w2=new String [] {"w","s","~r"};
		String [] w3=new String [] {"w","~s","r"};
		String [] w4=new String [] {"w","~s","~r"};
		String [] w5=new String [] {"~w","s","r"};
		String [] w6=new String [] {"~w","s","~r"};
		String [] w7=new String [] {"~w","~s","r"};
		String [] w8=new String [] {"~w","~s","~r"};
		ArrayList<String> ww1=makeList(w1);
		ArrayList<String> ww2=makeList(w2);
		ArrayList<String> ww3=makeList(w3);
		ArrayList<String> ww4=makeList(w4);
		ArrayList<String> ww5=makeList(w5);
		ArrayList<String> ww6=makeList(w6);
		ArrayList<String> ww7=makeList(w7);
		ArrayList<String> ww8=makeList(w8);
		ArrayList<ArrayList<String>> Wlist=new ArrayList<ArrayList<String>>();
		Wlist.add(ww1);
		Wlist.add(ww2);
		Wlist.add(ww3);
		Wlist.add(ww4);
		Wlist.add(ww5);
		Wlist.add(ww6);
		Wlist.add(ww7);
		Wlist.add(ww8);
		Double [] wprob=new Double [] {.99,.90,.90,0.0,.01,.1,.1,1.0};
		CPT wetcpt=new CPT(Wlist, wprob);
		HashMap<String,Node> wparents=new HashMap<String,Node>();
		wparents.put("Sprinkler", S);
		wparents.put("Rain",R);
		
		Node W=new Node(null,wparents,wetgrass,wetcpt);
		
		S.addChild("WetGrass", W);
		R.addChild("WetGrass", W);
		C.addChild("Rain",R);
		C.addChild("Sprinkler", S);
		
	HashMap<String,Node> nodes2=new HashMap<String,Node>();
		
		
		nodes2.put("Cloudy",C);
		nodes2.put("Sprinkler",S);
		nodes2.put("Rain",R);
		nodes2.put("WetGrass",W);
		
		ArrayList<Node> sorted2=new ArrayList<Node>();
		
		sorted2.add(C);
		sorted2.add(S);
		sorted2.add(R);
		sorted2.add(W);
		
		Net wetGrassNet= new Net(nodes2,sorted2);
		
		wetGrassNet.printNet();
		System.out.println();
		
		/* I built this really crappy version of the Bayes Net for the Alarm Problem.
		 * So now let's look at the example problem.
		 * P(B|j,m) --> alpha* <0.00059224, 0.0014919> = <0.284, 0.716>
		 * 
		 * Query variable: burglary
		 * Evidence: j, m
		 * Bayes Net: alarmNet
		 */
		
		System.out.println("Let's look at the Alarm Example.");
		System.out.print("Query Variable ");
		//QUERY VARIABLE
		burglary.printpossible();
		
		//EVIDENCE VARIABLE
		
		ArrayList<String> evi=new ArrayList<String>();
		evi.add("j");
		evi.add("m");
		Evidence evidence=new Evidence(evi);
		evidence.print();
		System.out.println();
	
		System.out.println("The results of exact inference: ");
		CPT answer=enumerationASK(burglary,evidence,alarmNet);
		answer.printCPT();
		System.out.println("The results of approximate inference: ");
		double [] rSalarm=rejectionSampling(burglary,evidence,alarmNet,100000);
		for(int i=0;i<rSalarm.length-1;i++){
			System.out.println(rSalarm[i]);
		}
		//HashMap<double [],Double> rejectionResultsa=MetaReject(burglary,evidence,alarmNet,100000,100);
		//printMap2(rejectionResultsa);
		System.out.println();
		System.out.println("Let's look at the Wet Grass Example.");
		System.out.print("Query Variable ");
		rain.printpossible();
		Evidence evidence2=new Evidence(makeList(new String [] {"s"}));
		evidence2.print();
		System.out.println();
		System.out.println("The results of exact inference: ");
		CPT answer2=enumerationASK(rain,evidence2,wetGrassNet);
		answer2.printCPT();
		System.out.println("The results of approximate inference: ");
		System.out.println();
		double [] rSgrass=rejectionSampling(rain,evidence2,wetGrassNet,100000);
		for(int i=0;i<rSgrass.length-1;i++){
			System.out.println(rSgrass[i]);
		}
		System.out.println();
		//HashMap<double [],Double> rejectionResults=MetaReject(rain,evidence2,wetGrassNet,100000,100);
		//printMap(rejectionResults);
		
	}
	
	public static ArrayList<String> makeList(String []array){
		ArrayList<String> newlist=new ArrayList<String>();
		for(int i=0;i<array.length;i++){
			
				newlist.add(array[i]);
			
		}
		return newlist;
	}
	
	public static HashMap<double [],Double> MetaReject(RandomVar x,Evidence e,Net net,int n,int s){
		HashMap<double[],Double> results=new HashMap<double [],Double>();
		double[] answer;
		for(int i=0;i<s;i++){
			answer=rejectionSampling(x,e,net,n);
			results.put(answer, answer[answer.length-1]);
		}
		return results;
	}

	
	//found online to print HashMaps
	public static void printMap(HashMap<double [],Double> m) {
		double sum=0;
		for (Map.Entry<double [], Double> entry : m.entrySet()) {
			
			System.out.println(entry.getKey()[0]+","+"Rain");
			System.out.println(entry.getKey()[1]+","+"NoRain");
			System.out.println(entry.getValue()+",Rejection,WetGrass");
			sum+=entry.getValue();
	        
	    }
		sum=sum/m.size();
		//System.out.println("Average rejection: " + sum);
	}
	
	public static void printMap2(HashMap<double [],Double> m) {
		double sum=0;
		for (Map.Entry<double [], Double> entry : m.entrySet()) {
			
			System.out.println(entry.getKey()[0]+","+"Burglary");
			System.out.println(entry.getKey()[1]+","+"NoBurglary");
			System.out.println(entry.getValue()+",Rejection,Alarm");
			sum+=entry.getValue();
	        
	    }
		sum=sum/m.size();
		System.out.println("Average rejection: " + sum);
	}
	
	

	//performs the exact inference with the enumeration algorithm
	public static CPT enumerationASK(RandomVar x,Evidence e,Net net){
		
		//distribution over X, inititally empty
		
		CPT Q=new CPT(null,null);
		ArrayList<Node> vars=net.sorted;
		//for each value of xi of X
		for(int i=0;i<x.vector.length;i++){
			String current=x.vector[i];
			//add one of the values from the domain to the evidence
			e.extend(current);
			//now the evidence contains one of the query possibilities
			
			ArrayList<String> whatamidoing=new ArrayList<String>();
			//hold on to it
			whatamidoing.add(current);
			//the exact probability for this value will be added to the (at first) empty CPT
			//enumerate all of the variables in the net
			Q.add(whatamidoing, enumerateALL(vars,e));
			e.removelast();
		}
		Q.normalize();
		return Q;
		
	}
	
	public static float enumerateALL(ArrayList<Node> vars,Evidence e){
		
		//once you are done (base case) return 1
		if(vars.size()==0){
			return (float) 1.0;
		}
		//separate out the first variable
		Node first=vars.get(0);
		
		//check if contains
		//example: variable "john" contains evidence assignment "j"
		String [] contains=first.randvar.contains(e);
		if(contains[0]=="true"){
		
			//then return P(y|Pa(Y)) * enumerateALL(Rest(vars),e)
			
			//get rid of first (now you have rest)
			vars.remove(0);
			
			float fuckanswer=(float) (first.pgiven(e)*enumerateALL(vars,e));
			
			//add back in at the front of the list
			vars.add(0,first);
			return fuckanswer;
		}
		else{
			//if the variable does not contain the evidence
			float answer=0;
			vars.remove(0);
			for(int i=0;i<first.randvar.vector.length;i++){
				e.extend(first.randvar.vector[i]);
				float wtf=(float) (first.pgiven(e)*enumerateALL(vars,e));
				
				
				answer+=wtf;
				
				e.removelast();
				
				
			}
			vars.add(0,first);
			
			return answer;
			
			
		}	
		}
		
	public static double [] rejectionSampling(RandomVar x,Evidence e,Net net,int n){
		//a vector of counts for each value of X, initially 0;
		double [] counts=new double [x.vector.length+1];
		double counter=0;
		//sample a bunch of times
		x.printpossible();
		for(int i=0;i<n;i++){
			//create a possible world of assignments
			Evidence possible=priorSample(net);
			//possible.print();
			//if possible is consistent with e
			if(possible.isConsistent(e)){
				//which one is in there?
				for(int j=0;j<x.vector.length;j++){
					if(possible.evidence.contains(x.vector[j])){
						
						//add the count for the value that was in the possible
						counts[j]+=1;
						
					}
					
				}
				
			}
			else{
				//System.out.println("Not consistent evidence. REJECT.");
				counter++;
			}
			
			
			
		}
		
		//normalize so you can get proportions
		normalize(counts);
		
		//get a percentage of rejected
		double prop=(counter/n)*100;
		System.out.println("Proportion of Rejections: " +prop+ "%");
		counts[x.vector.length]=prop;
		return counts;
		
		
	}
	
	public static Evidence priorSample(Net net){
		//create random Evidence based on probabilities
		//go through sorted (topological order)
		ArrayList<String> currentE=new ArrayList<String>();
		Evidence possible=new Evidence(currentE);
		ArrayList<Entry> viable=new ArrayList<Entry>();
		
		//loop through all of the variables in the net
		for(int i=0;i<net.sorted.size();i++){
			//add to evidence stochastically
			//generate a random number between 1 and 0.
			
			
			//loop through the CPT and see where the random value is closest to
			for(int j=0;j<net.sorted.get(i).randvar.vector.length;j++){
				//given the current evidence (if have parents)
				
				if(net.sorted.get(i).parents!=null){
					//only need to compare to the value of parents that is already set
					Evidence cutdown=possible.cutdown(net.sorted.get(i).parents);
					viable=net.sorted.get(i).cpt.CPTcontains(cutdown);
				}
				else{
					//dont need to compare to evidence already there (standalone)
					viable=net.sorted.get(i).cpt.getViable();
				}
				
				
				
			}
			//out of the possible entry values, choose one based on its value compared to the randint
			
			//for all the possible entries
			findAddClosest(viable,possible);
			
			
			
			
			
			
		}
		//create your evidence and return it
		
		return possible;
	
	}
	
	public static void findAddClosest(ArrayList<Entry> entries,Evidence possible){
	
		double sum=0;
		double [] keepvalues=new double [entries.size()];
		double best=100;
		Entry bestentry = null;
		//loop through the possible entries
		for(int k=0;k<entries.size();k++){
			Double current=(Double) entries.get(k).getValue();
			//get the sum of the probabilities in the cpt
			sum+=current;
			keepvalues[k]=sum;
			//System.out.println(entries.get(k).getKey().toString()+ keepvalues[k]);
			
		}
		//pick a random number between 0 and the sum
		double randint=new Random().nextDouble()*sum;
		
		for(int j=0;j<keepvalues.length;j++){
			//System.out.println("Sum: " + sum + " Random: " + randint + " Index: " + keepvalues[j]);
			
			//once it is larger
			if(randint<keepvalues[j]){
				bestentry=entries.get(j);
				//System.out.println("Best entry: " + bestentry.getKey());
				break;
				
			}
		}
		
		
		
	
		//now you have the chosen entry. we need to modify the evidence now
		//loop through the key array in best entry
		for(int i=0;i<((ArrayList<String>) bestentry.getKey()).size();i++){
			if(!possible.evidence.contains(((ArrayList<String>) bestentry.getKey()).get(i))){
				possible.evidence.add((String) ((ArrayList<String>) bestentry.getKey()).get(i));
				//System.out.println("Selected to add: " + (String) ((ArrayList<String>) bestentry.getKey()).get(i));
			}
		}
		
		
		
	}
	
	public static void normalize(double [] a){
		//XA+XB=1
		//sum up all of the values then divide each value by that sum (make it add up to 1)
		float sum=0;
		
		for(int i=0;i<a.length-1;i++){
			sum+=a[i];
		}
		
		for(int j=0;j<a.length-1;j++){	
			a[j]= (a[j]/sum);
		}
		
		
	}
	
	
	

}
