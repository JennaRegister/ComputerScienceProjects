
public class Rational {
	private int numer;
	private int denom;
	
	
	public Rational(int n, int d){
		numer =n;
		denom=d;
		if (denom ==0){
			System.out.println("The denominator cannot be 0."); //primitive Exception handling
			System.exit(0); //Sorry, too bad! Give me a real denom next time.
		}
	}
	//toString
	public String toString(){
		if (denom ==1){
			return (numer + "\n");	//when dividing by 1, you get the numerator! We don't want to see something "over one"
		}
		else {
			return (numer + "/" + denom); //the slash will indicate the fractionation between the numerator and denominator
		}
		
	}
	//set methods
	public void setnumer(int n)
	{
		numer= n;
	}
	public void setdenom(int d)
	{
		denom = d;
	}
	
	//get methods
	public int getnumer()
	{
		return numer;
	}
	public int getdenom()
	{
		return denom;
	}
	//ADDITION
	public Rational addrats(Rational r){  //dynamic method, adds to itself instead of taking 2 parameters
		int numerator = (numer * r.denom) + (denom * r.numer);
		int denominator = denom * r.denom;
		Rational result = new Rational(numerator, denominator);
		return result;	
	}
	
	public static Rational addrats(Rational r1, Rational r2){  //static method takes 2 parameters
		int numerator = (r1.numer * r2.denom) + (r1.denom * r2.numer);
		int denominator = r1.denom * r2.denom;
		Rational result = new Rational(numerator, denominator);
		return result;	
	}
	//SUBTRACTION
	public Rational subrats(Rational r){
		int numerator = (numer * r.denom) - (denom * r.numer);
		int denominator = denom * r.denom;
		Rational result = new Rational(numerator, denominator);
		return result;		
	}
	public static Rational subrats(Rational r1, Rational r2){
		int numerator = (r1.numer * r2.denom) - (r1.denom * r2.numer);
		int denominator = r1.denom * r2.denom;
		Rational result = new Rational(numerator, denominator);
		return result;	
	}
	//MULTIPLICATION
	public Rational mulrats(Rational r){
		int numerator = numer * r.numer;
		int denominator = denom * r.denom;
		Rational result = new Rational(numerator, denominator);
		return result;
	}
	public static Rational mulrats(Rational r1, Rational r2){
		int numerator = (r1.numer * r2.numer);
		int denominator = r1.denom * r2.denom;
		Rational result = new Rational(numerator, denominator);
		return result;	
	}
	//DIVISION
	public Rational divrats(Rational r){ //will be read as r1 DIVIDED BY r2 	e.g. r1.divrats(r2) == r1/r2
		int recipnum= r.denom;
		int recipden= r.numer;
		int firstnum= numer;
		int firstden=denom;
		Rational first= new Rational(firstnum,firstden);
		Rational recip= new Rational(recipnum,recipden);
		Rational result = Rational.mulrats(first,recip);
		return result;
	}
	public static Rational divrats(Rational r1, Rational r2){
		int recipnum=r2.denom;
		int recipden= r2.numer;
		Rational recip= new Rational(recipnum, recipden);
		Rational result = Rational.mulrats(r1,recip);
		return result;	
	}
	//EQUALS
	public boolean equals(Rational r){
		boolean equal=false;
		if ((r.numer==numer)&&(r.denom==denom)){
			equal=true;
		}
		return equal;
	}
	public static boolean equals(Rational r1, Rational r2){
		boolean equal=false;
		if((r1.numer==r2.numer)&&(r1.denom==r2.denom)){
			equal=true;
		}
		return equal;
	}
	//COMPARETO
	public int compareit(Rational r){
		double dec1=((numer)*1.0)/((denom));
		double dec2=((r.numer)*1.0)/((r.denom));
		int result=0;
		if (dec1>dec2){
			result = 1;
		}
		if(dec1<dec2){
			result= -1;
		}
		if(dec1==dec2){
			result= 0;
		}
		return result;
	}
	public static int compareit(Rational r1, Rational r2){
		double dec1=((r1.numer)*1.0)/((r1.denom));
		double dec2=((r2.numer)*1.0)/((r2.denom));
		int result=0;
		if (dec1>dec2){
			result = 1;
		}
		if(dec1<dec2){
			result= -1;
		}
		if(dec1==dec2){
			result= 0;
		}
		return result;
	}
	
	
}
