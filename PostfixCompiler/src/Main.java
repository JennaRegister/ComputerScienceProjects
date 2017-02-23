import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*Jenna Register
 * CSC 172 Fall 2015
 * Lab TR 9:40-10:55
 * Brian Leonard/Yiheng Zhou
 * Project 2: Infix Calculator
 */

/*IDEA & MAJOR PROBLEMS TO SOLVE:
 * READING AND SPLITTING THE FILE:
 * Read in the file and split it into "tokens". Write a method to split properly. 
 * E.g. "55" can't be split into two separate tokens of "5" and "5". Also, a "(" must be a separate token. 
 * Can't just split by spaces. Also, a double must be properly acknowledged as a token.
 * Write a method that evaluates different pieces and splits appropriately. "If digit followed by digit, keep as a token", "split at spaces and parentheses", "don't split at periods"
 * Take in tokens into an array, which passes to the function in2Post
 * 
 * SETTING PRECENDENCE:
 * Switch statement of the different operators, setting their precedence? returnPrecedence(String)
 * Implement the "Stack machine" based on the various "if" cases
 * Parenthesis take the highest precedence, and require a special case. They are NOT included in a postfix expression
 * 
 * OPERATIONS:
 * Create a switch for the various operations. Pop whatever needs to be popped off of the stack.
 * Perform each of the operations accordingly, then return back to the stack.
 * Parentheses are a special case. They are evaluated first, until you find the other paren.
 * 
 * NOW YOU HAVE A CALCULATOR HOORAY!
 */

public class Main {
	public static void main(String [] args)throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		///Users/jennaregister/Desktop/infix_expr_short.txt
		String name =scan.next();
		File file = new File(name);
		Readit(file);
		String [] pieces=getit(file);
		printarray(pieces);
		System.out.println("I did not complete the File I/O, and used a 2D array instead for the test cases. Sorry for the hassle!");
		System.out.println();
		System.out.println("TEST CASES");
		System.out.println();
		
		//String [] [] mytests ={{"25","^","(","-1","^","2",")"},{"1","-","(","4","+","5",")"},{"4","*","3","^","2","-","8","^","6","*","16","+","11","*","4","*","5"},{"2","%","4"},{"1","+","1",">","1","+","2"}};
		String [] [] expressions={{"1","+","1"},{"5.2","+","1"},{"5.2","+","1.0"},{"1","-","1"},{"5.2","-","1"},{"1.0","-","5.2"},{"3.0","*","4"},{"4","/","0.25"},{"1","-","(","4","+","5",")"},{"1","-","(","1","-","(","4","+","5",")",")"},{"0","<","55"},{"3.2","<","2.3"},{"0",">","55"},{"3.2",">","2.3"},{"5","=","5.0"},{"1","=","1"},{"1","=","0"},{"1","&","1"},{"1","&","0"},{"1","|","0"},{"0","|","0"},{"!","0"},{"!","1"},{"!","(","3","*","(","1","+","6",")","=","63","/","3",")"},{"(","1","<","3",")","&","(","2",">","4",")","|","1"},{"2","+","3","*","4","-","1"}};
		
		//for all of the expressions, print out their postfix versions, and the answers for their evaluations!
		for(int i=0;i<expressions.length;i++){
			System.out.println("NUMBER " +i+ " PROBLEM");
			//convert to postfix
			MyQueue q=in2Post(expressions[i]);
			System.out.print("The postfix expression is: ");
			q.printQ();
			System.out.println();
			
			String theanswer=post2Infix(q);
			System.out.println("The evaluation result is: "+ theanswer);
			System.out.println();
			
		}
		//without additional print statements
		for(int i=0;i<expressions.length;i++){
			MyQueue q=in2Post(expressions[i]);
			String theanswer=post2Infix(q);
			System.out.println(theanswer);
		}
		
		
	}
	//reads in a file
	public static void Readit(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String l;
		while((l=br.readLine()) !=null){
			System.out.println(l);
		}	
	}
	/*my attempt to convert pieces of the file into a readable form. 
	* However, I needed to split at various places. Cases like "55" can't be separated, and "(" are right next to digits! 
	* Again, sorry you have to sift through this.
	* */
	public static String [] getit(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str;
		String[] values = null;
		ArrayList<String> list = new ArrayList<String>();
		while((str = br.readLine())!=null){
			
			values = str.split(" ");	
		}
		
		//String [] arr=list.toArray(new String[0]);
		return values;
		
		
	}
	//prints out a 2D array
	public void print2Darray(String [][] a){
	for ( int row = 0; row < a.length; row++ ){
		for ( int column = 0; column < a[ row ].length; column++ ){
			System.out.printf( "%3s  ", a[ row ][ column ] );
		}
		System.out.println();
		}
	}
	//prints an array
	public static void printarray(String[] a){
		for(int i =0; i<a.length;i++){
			System.out.print(a[i]+" ");
			System.out.println();
		}
		System.out.println();
	}



	/*Shunting-Yard algorithm
	 * This converts oridnary expressions to postfix versions, which can then be processed by an evaluation Stack machine!
	 */
	

	public static MyQueue in2Post(String[] array){
		
		//create my Stack
		MyStack thestack=new MyStack<>();
		//create my Queue
		MyQueue thequeue=new MyQueue<>();
		
		//the one we are on
		String value;
		//operators
		String [] operator = {"+","-","*","/","^","(","<",">","=","&","|","!","%"};
		//go through each "token"
		for(int i=0;i<array.length;i++){
			value = array[i];
	
			//if the token is an operand
			if(isNumber(array[i])){
				//System.out.println(value+ " It's a number!");
				
				//enqueue it!
				thequeue.enqueue(value);
				
				//System.out.println("Queueing a number "+ value);
			}
			//if we have a closed paren, we have to find all the things between the open and closed paren and put them in the queue first!
			if(value==")"){
				while(thestack.peek()!="("){
					thequeue.enqueue(thestack.pop());
				}
				thestack.pop();
				
			}

			//if token is an operator
			if(Arrays.asList(operator).contains(value)){
					//System.out.println(value+ " It's an operator!");
					int p=returnPrecedence(value);
					//System.out.println("The precedence of " + value +" is:"+ p);
					
					while(p>=returnPrecedence((String) thestack.peek())){
						
						
						if(thestack.peek()!="("){
						thequeue.enqueue(thestack.pop());
						
						}
						if(thestack.peek()=="("){
							p=0;
						}
						//break out
						p=0;
						
					}
					
					
					thestack.push(value);
					//System.out.println("Pushing: " + value );
					
			
					
			}
			
			}
		
			while(!thestack.isEmpty()){
				 
			thequeue.enqueue(thestack.pop());	
			//System.out.println("Queueing it!" + thequeue.peek());
			
			}
		return thequeue;

		
		
	
	}
	public static boolean isNumber(String str){
	  return str.matches("-?\\d+(\\.\\d+)?");
	}
	/*Citation here! Not my own! "Peter O" showed me how to use regular expressions to determine if something is numeric or not!*/
	
	
	//sets the precedence for given values
	public static int returnPrecedence(String val){
		int precedence = 0;
		if(val==null){
			return 1000;
			//break out
		}
		switch(val){
		case "(":
			precedence=1;
			break;
		case "^":
			precedence=3;
			break;
		case "*":
			precedence=4;
			break;
		case "/":
			precedence=4;
			break;
		case "+":
			precedence=5;
			break;
		case "-":
			precedence=5;
			break;
		case "<":
			precedence=6;
			break;
		case ">":
			precedence=6;
			break;
		case "=":
			precedence=7;
			break;
		case "&":
			precedence=8;
			break;
		case "|":
			precedence=9;
			break;
		case "!":
			precedence=2;
			break;
		case "%":
			precedence=4;
			break;
		
			
		
		}
		return precedence;
	}

	//performs the operations for given operators; this function controls the stack
	public static String operation(String val,MyStack stack){
		
		double answer=0;
		switch(val){
		case "+":
			double first=Double.parseDouble((String) stack.pop());
			double second=Double.parseDouble((String) stack.pop());
			
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=second+first;
			break;
		case "-":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=second-first;
			break;
		case "*":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=second*first;
			break;
		case "^":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=(double) Math.pow(second,first);
			//System.out.println("Exponent answer=" + answer);
			break;
		case "/":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=second/first;
			//System.out.println("Division answer=" + answer);
			break;
		case "<":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			if(Double.compare(second, first)<0){
				answer=1;
			}
			else{
				answer=0;
			}
			break;
		case ">":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			if(Double.compare(second, first)>0){
				answer=1;
			}
			else{
				answer=0;
			}
			break;
		case "=":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			if(Double.compare(second, first)==0){
				answer=1;
			}
			else{
				answer=0;
			}
			break;
		case "&":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			if((second==1)&&(first==1)){
				answer=1;
			}
			else{
				answer=0;
			}
			break;
		case "|":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			if((second==0)&&(first==0)){
				answer=0;
			}
			else{
				answer=1;
			}
			break;
		case "!":
			first=Double.parseDouble((String) stack.pop());
			if(first==0){
				answer=1;
			}
			else{
				answer=0;
			}
			break;	
		case "%":
			first=Double.parseDouble((String) stack.pop());
			second=Double.parseDouble((String) stack.pop());
			//System.out.println("First num: "+first+" Second num: "+ second);
			answer=second%first;
			break;
		
		}
		String finanswer=String.valueOf(answer);
		return finanswer;
		
	}
	//evaluation of a postfix expression
	public static String post2Infix(MyQueue q){
		String [] operator = {"+","-","*","/","^","<",">","=","&","|","!","%"};
		String [] logicals={"<",">","=","&","|","!"};
		MyStack thestack=new MyStack();
		while(!q.isEmpty()){
		String value = (String) q.dequeue();
		//System.out.println(value);
		
		if(isNumber(value)){
			//System.out.println("I am a number! " + value);
			thestack.push(value);
			//System.out.println("Pushing on to stack: "+ value);
		}
		else if (Arrays.asList(operator).contains(value)){
			//System.out.println("I am an operation! " + value);
			String result=operation(value,thestack);
			//System.out.println("The result of the operation is: "+result);
			thestack.push(result);	
		}
		
		}
		String finalanswer=(String) thestack.peek();
		
		return finalanswer;
		
		
	}

}		



