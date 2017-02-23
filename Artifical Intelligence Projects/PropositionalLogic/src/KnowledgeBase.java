import java.util.ArrayList;

//technically, a knowledge base is just a big sentence. 
//However, semantically, this allows me to have a KB object that I can turn into a conjunctive sentence
public class KnowledgeBase {
	
	Sentence kbsentence;
	
	public KnowledgeBase(){
		
	}
	
	
	

	
	//turn all of the sentences into one big conjunctive sentence
	//take in arraylist of sentences, and conjoin them systematically. Neat.
	public Sentence toConjunct(ArrayList<Sentence> sentences){
		
		
		if(sentences.size()==1){
			Sentence kbsentence=sentences.get(0);
			return kbsentence;
		}
		else{
			Sentence temp = null;
			Connective and=new Connective("^");
			temp=new Sentence(sentences.get(0),sentences.get(1),and);
			//"pop" off the first 2 from the arraylist (could be a stack), then conjoin those and "push" them back on
			sentences.remove(0);
			sentences.remove(0);
			sentences.add(temp);
			temp=toConjunct(sentences);
			return temp;
		}
		
		
		
		
		
	}

}
