
public class Complex {
	private double real;
	private double imagine;
	
	public Complex(double r, double i){
		real = r;
		imagine=i;
		
	}
	//toString
	public String toString(){
		return("(" + real + ";" + imagine + ")");
	}
	//set methods
		public void setreal(double r)
		{
			real= r;
		}
		public void setimagine(double i)
		{
			imagine = i;
		}
		
		//get methods
		public double getreal()
		{
			return real;
		}
		public double getimagine()
		{
			return imagine;
		}
		//ADDITION
		public static Complex addcomps(Complex c1, Complex c2){
			double reals = ((c1.real) + (c2.real));
			double imagines = ((c1.imagine) + (c2.imagine));
			Complex result = new Complex (reals, imagines);
			return result;	
		}
		public Complex addcomps(Complex c){
			double reals = ((real) + (c.real));
			double imagines = ((imagine) + (c.imagine));
			Complex result = new Complex (reals, imagines);
			return result;	
		}
		//SUBTRACTION
		public static Complex subcomps(Complex c1, Complex c2){
			double reals = ((c1.real) - (c2.real));
			double imagines = ((c1.imagine) - (c2.imagine));
			Complex result = new Complex (reals, imagines);
			return result;	
		}
		public Complex subcomps(Complex c){
			double reals = ((real) - (c.real));
			double imagines = ((imagine) - (c.imagine));
			Complex result = new Complex (reals, imagines);
			return result;	
		}
		//MULTIPLICATION
		public static Complex mulcomps(Complex c1, Complex c2){
			double reals= ((c1.real)*(c2.real))-((c1.imagine)*(c2.imagine));
			double imagines = ((c1.imagine)*(c2.real))+((c1.real)*(c2.imagine));
			Complex result = new Complex (reals, imagines);
			return result;	
		}
		public Complex mulcomps(Complex c){
			double reals= ((real)*(c.real))-((imagine)*(c.imagine));
			double imagines = ((imagine)*(c.real))+((real)*(c.imagine));
			Complex result = new Complex (reals, imagines);
			return result;		
		}
		//DIVISION
		public static Complex divcomps(Complex c1, Complex c2){
			double reals = ((((c1.real)*(c2.real))+((c1.imagine)*(c2.imagine)))/((Math.pow(c2.real,2))+(Math.pow(c2.imagine, 2))));
			double imagines = ((((c1.imagine)*(c2.real))-((c1.real)*(c2.imagine)))/((Math.pow(c2.real,2))+(Math.pow(c2.imagine, 2))));
			Complex result = new Complex (reals, imagines);
			return result;
			
		}
		public Complex divcomps(Complex c){
			double reals = ((((real)*(c.real))+((imagine)*(c.imagine)))/((Math.pow(c.real,2))+(Math.pow(c.imagine, 2))));
			double imagines = ((((imagine)*(c.real))-((real)*(c.imagine)))/((Math.pow(c.real,2))+(Math.pow(c.imagine, 2))));
			Complex result = new Complex (reals, imagines);
			return result;
			
		}
		//POLAR
		public static Complex polar(Complex c){
			double angle = 0;
			double radius = Math.sqrt(((Math.pow(c.real, 2))+((Math.pow(c.imagine, 2)))));
			if (c.real > 0){
				angle = Math.atan2(c.imagine,c.real)*(180.0/(Math.PI));
			}
			if (c.real < 0){
				angle = (Math.atan2(c.imagine,c.real))+(Math.PI)*(180.0/(Math.PI));	
			}
			Complex result = new Complex(radius, angle);
			return result;
		}

}
