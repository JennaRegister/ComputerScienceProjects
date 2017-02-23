import java.util.ArrayList;
import java.util.Iterator;

//a sentence in propositional logic. This can be an atomic sentence (one symbol, true or false), or a complex sentence which is defined in terms of a model.

public class Sentence {
	Connective connect;
	Sentence p,q;
	Symbol symbol;
	boolean binarycomplex;
	boolean simple;
	boolean unarycomplex;
	
	
	//binary complex sentence
	public Sentence(Sentence p, Sentence q, Connective connect){
		
		this.connect=connect;
		this.p=p;
		this.q=q;
		binarycomplex=true;
		
	}
	
	//simple sentence (single symbol/proposition)
	public Sentence(Symbol symbol){
		this.symbol=symbol;
		simple=true;
		
	}
	
	//unary complex sentence (in my case, only "NOT" is implemented...poorly)
	public Sentence(Sentence p, Connective connect){
		//System.out.println("holla at me");
		this.p=p;
		this.connect=connect;
		unarycomplex=true;
		
		
	}
	
	
	
	
	public boolean evaluate(){
		
		//here is where the connectives are evaluated for truth of the sentence
		if(connect!=null){
			//recursively evaluate each piece of the sentence (particularly because sentences contain other sentences)
			switch(connect.connective){
			case("->"):
				//CNF version evaluation
				return((!(p.evaluate())||q.evaluate()));
			
			case("^"):

				return((p.evaluate()&&q.evaluate()));
				
			
			case("v"):
				
		
			return((p.evaluate()||q.evaluate()));
			
			case("<-->"):
				return((!(p.evaluate())||q.evaluate())&&!(q.evaluate())||p.evaluate());
			
			case("!"):
				//this is a unary complex sentence, no matter what (because we are in the case of NOT)
				
				//double negation??
				
				
				
				if(p.binarycomplex==true){
					
					//we need to flip the "and" into an "or"
					if(p.connect.connective=="^"){
						
						//evaluate "not" on the pieces
						boolean pnot=new Sentence(p.p,new Connective("!")).evaluate();
						boolean qnot=new Sentence(p.q,new Connective("!")).evaluate();
						return(pnot||qnot);
						
					}
					//we need to flip the "or" into an "and"
					if(p.connect.connective=="v"){
					
						
						//evaluate "not" on the pieces
						boolean pnot=new Sentence(p.p,new Connective("!")).evaluate();
						boolean qnot=new Sentence(p.q,new Connective("!")).evaluate();
						return(pnot&&qnot);
						
					}
					
					//we need to convert to CNF in order to apply the NOT
					if(p.connect.connective=="->"){
						
						Sentence cnf=new Sentence(p.CNFconvert(p),new Connective("!"));
						
						
						return(!(cnf.evaluate()));
						
					}
					
				}
				
				//recurse down the pieces
				if(p.unarycomplex==true){
					//if it is just a "not" on a sentence, evaluate that recursively
					
					return(!(p.evaluate()));
				}
				
				//recurse down the pieces

				else{
					
		
					//if it is simple, just negate the symbol
					return(!(p.symbol.truth));
				}
			
				
			
			}
		}
		
		if(unarycomplex==true){
			//System.out.println("Returning");
			return(!(this.p.symbol.truth));
		}
		
		//THE ULTIMATE BASE CASE
		return(this.symbol.truth);
		
		
	}
	
	//override toString for various sentences
	public String toString(){
		if(connect==null){
			return(symbol + " ");
			
		}
		if(connect.connective=="!"){
			return("! ("+p.toString()+")");
		}
		else{
		return(p.toString() + " " + connect.connective + "  " + q.toString());
		}
	}

	//here we convert a sentence into CNF
	public Sentence CNFconvert(Sentence old){
		
		Sentence newsentence = null;
		if(old.connect.connective=="->"){
			newsentence=new Sentence(new Sentence(old.p,old.q,new Connective("v")),new Connective("!"));
		}
		
		
		return newsentence;
	}
	
	//here we "extract" the relevant symbols from a sentence (collects them out of the entire sentence). 
	//This will be helpful so we can reassign the values
	public ArrayList<Symbol> extractSyms(Sentence s, ArrayList<Symbol> current){
		
		if(s.simple==true){
			if(!(current.contains(s.symbol)))
			current.add(s.symbol);
		}
		else{
			if(s.binarycomplex==true){
				//recursively extract
				s.extractSyms(s.p,current);
				s.extractSyms(s.q,current);
			}
			if(s.unarycomplex==true){
				
				s.extractSyms(s.p,current);
			}
		}
		
		return current;
		
		
	}
}
