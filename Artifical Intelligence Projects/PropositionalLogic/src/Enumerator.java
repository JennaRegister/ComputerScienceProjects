import java.util.ArrayList;


public class Enumerator<T> {
	//Originally this was my attempt at Part 1. 
	KnowledgeBase kb=new KnowledgeBase();
	ArrayList<Sentence>sentences=new ArrayList<Sentence>();
	Sentence kbsentence;
	
	public Enumerator(){
		System.out.println("Let's create some sentences out of simple symbols. Let's start with the sentence p. Let's start by setting it to true.");
		Sentence p=new Sentence(new Symbol("p",true));
		System.out.println(p.toString());
		System.out.println("Now we can add q. That can be true too.");
		Sentence q=new Sentence(new Symbol("q",true));
		System.out.println(q.toString());
		System.out.println("Let's create a brand new sentence! A conjunction of p and q.");
		Sentence and=new Sentence(p,q,new Connective("^"));
		System.out.println(and.toString());
		System.out.println("We know that p is true and that q is true, so how about the conjunction of the two?");
		System.out.println("Evaluating: [" + and.toString()+ "] == " + and.evaluate());
		System.out.println("If we change the p symbol in this conjunction to false, we can reevaluate the new sentence.");
		and.p.symbol.setTruth(false);
		System.out.println("Evaluating: [" + and.toString()+ "] == " + and.evaluate());
		System.out.println("So that is really nifty. We can also create some more sentences and test the following:");
		System.out.println();
		System.out.println("Like a disjunction.");
		Sentence or=new Sentence(p,q,new Connective("v"));
		System.out.println("Evaluating: [" + or.toString()+ "] == " + or.evaluate());
		System.out.println();
		System.out.println("Some negations...");
		Sentence not=new Sentence(p,new Connective("!"));
		System.out.println("Evaluating: [" + not.toString()+ "] == " + not.evaluate());
		p.symbol.setTruth(true);
		System.out.println("Evaluating: [" + not.toString()+ "] == " + not.evaluate());
		System.out.println();
		System.out.println("Some implications...");
		Sentence implies=new Sentence(p,q,new Connective("->"));
		System.out.println("Evaluating: [" + implies.toString()+ "] == " + implies.evaluate());
		q.symbol.setTruth(false);
		System.out.println("Evaluating: [" + implies.toString()+ "] == " + implies.evaluate());
		p.symbol.setTruth(false);
		System.out.println("Evaluating: [" + implies.toString()+ "] == " + implies.evaluate());
		q.symbol.setTruth(true);
		System.out.println("Evaluating: [" + implies.toString()+ "] == " + implies.evaluate());
		Sentence noimply=new Sentence(implies,new Connective("!"));
		System.out.println("Evaluating: [" + noimply.toString()+ "] == " + noimply.evaluate());
		
		System.out.println();
		System.out.println("We can even work with a very long sentence.");
		

		Sentence r=new Sentence(new Symbol("r",false));
		Sentence s=new Sentence(new Symbol("s",false));
		Sentence or2=new Sentence(r,s,new Connective("v"));
		Sentence oror=new Sentence(p,or2,new Connective("v"));
		Sentence implies2=new Sentence(oror,and,new Connective("->"));
		System.out.println("Evaluating: [" + implies2.toString()+ "] == " + implies2.evaluate());
		System.out.println();
		System.out.println("It would become useful to be able to extract the various symbols out of a sentence like this, with their appropriate boolean values.");
		ArrayList<Symbol> relevants=new ArrayList<Symbol>();
		ArrayList<Symbol> extract=implies2.extractSyms(implies2,relevants);
		printarray((ArrayList<T>) extract);
		System.out.println();
		System.out.println("In fact, we can now run these through an 'extend' function to change them as part of a model.");

		System.out.println();
		ArrayList<Symbol> model=new ArrayList<Symbol>();
		ArrayList<Symbol> newmodel=extend(extract.get(0),true,model);
		ArrayList<Symbol> othermodel=extend(extract.get(1),true,model);
		System.out.println("Testing the extension of the first extracted symbol.");
		printarray((ArrayList<T>)newmodel);
		System.out.println("Testing the extension of the second extracted symbol.");
		printarray((ArrayList<T>)othermodel);
		System.out.println();
		
		
	
		System.out.println("Let's build a knowledge base of some of the sentences. And then we will transform this into one big conjunction of the sentences!");
		sentences.add(p);
		sentences.add(q);
		r.symbol.setTruth(true);
		sentences.add(r);
		sentences.add(implies);
		sentences.add(implies2);
		sentences.add(oror);
		//Sentence nowayjose=new Sentence(implies,new Connective("!"));
		//sentences.add(nowayjose);
		printarray((ArrayList<T>) sentences);
		kbsentence=kb.toConjunct(sentences);
		
		System.out.println("Evaluating the knowledge base conjunct: ["+ kbsentence.toString()+ "] == "+kbsentence.evaluate());
		
	
		
		
		
		
		
		
		
		//TESTING EXTEND
		/*
		System.out.println("Testing extend");
		ArrayList<Symbol> testmodel=extend(p.symbol,false,model);
		printarray((ArrayList<T>) testmodel);
		ArrayList<Symbol> newtestmodel=extend(p.symbol,true,testmodel);
		System.out.println("second test");
		printarray((ArrayList<T>) newtestmodel);
		System.out.println("third test");
		ArrayList<Symbol> thirdmodel=extend(implies.p.symbol,false,newtestmodel);
		printarray((ArrayList<T>) thirdmodel);*/
		
		
		
	}
	
	//printing arraylists is annoying so I made a function
	public void printarray(ArrayList<T> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

	
	public boolean entails(Sentence kb, Sentence alpha){
		//entails calls the checkall method
		
		ArrayList<Symbol> current=new ArrayList<Symbol>();
		
		//extract the relevant symbols
		ArrayList<Symbol> symbols=alpha.extractSyms(alpha, current);
		
		
		//a model is the assignment of truth values, starts off empty
		ArrayList<Symbol> model=new ArrayList<Symbol>();
		
		return checkall(kb, alpha, symbols,model);
			
		
	}
	public boolean checkall(Sentence kb, Sentence alpha, ArrayList<Symbol>s,ArrayList<Symbol> model){
		//when you run out of symbols
		if(s.size()==0){
			//if it holds within the knowledge base....
			if(holdstrue(kb,model)){
				//does the sentence also fit the model?
				return holdstrue(alpha, model);
			}
			else{
				//if its not true compared to this knowledge base, doesn't mean it couldn't possibly be true! Anything could be true!
				return true;
			}	
			
		}
		else{
			//get the first symbol
			Symbol firstsymbol=s.get(0);
			ArrayList<Symbol> rest=new ArrayList<Symbol>();
			//add the rest of the symbols into a new arraylist rest
			for(int i=1;i<s.size();i++){
				rest.add(s.get(i));
			}
			
			//return the evaluation of "and" on the recursive checkall of trues and falses
			return checkall(kb,alpha,rest,(extend(firstsymbol,true,model)))&&checkall(kb,alpha,rest,(extend(firstsymbol,false,model)));
			
		}
		
	}
	//extend applies the possible truth values to a symbol, and returns the partial model
	public ArrayList<Symbol> extend(Symbol symbol, boolean value,ArrayList<Symbol> model){
		ArrayList<Symbol> partialmodel=new ArrayList<Symbol>();
		Symbol copysym=new Symbol(symbol.value,value);
		
		//copy in everything from before
		for(int i=0;i<model.size();i++){
			partialmodel.add(model.get(i));
		}
		
		//add in the new stuff
		partialmodel.add(copysym);
		//returns the partial model with new values assigned
		return partialmodel;
	}

	public boolean holdstrue(Sentence sentence, ArrayList<Symbol> model) {
		//evaluate if the sentence holds within the model
		
		return false;
	}
	
	
	
	
}

