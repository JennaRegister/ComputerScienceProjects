package Lab2;
import java.util.Scanner ;
public class Part5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//header
		System.out.println("Man, populations are growing FAST! Let's do some analysis.");
		//initialization
		Scanner scan = new Scanner(System.in);
		//input
		System.out.println("What is the current population?");
		String currpopstring = scan.next();
		System.out.println("What is the current year?");
		String curryearstring = scan.next();
		System.out.println("What is the annual growth rate? (Percent value)");
		String anngrowthstring = scan.next();
		System.out.println("What is the year in the future I am estimating for?");
		String yeareststring = scan.next();
		
		//convert strings to usable doubles
		double currpop = Double.parseDouble(currpopstring);
		double curryear = Double.parseDouble(curryearstring);
		double anngrowth = Double.parseDouble(anngrowthstring);
		double yearest = Double.parseDouble(yeareststring);
		double numyears = yearest - curryear;
		//population calculation
		double futpop = currpop * Math.pow(1.0 + (anngrowth/100),numyears);
		
		
		//output
		System.out.println("The population in year " + yearest + " will be " + futpop + " people.");
		//sassy footer
		System.out.println("Underground cities or Moon colony, take your pick.");
		
		
		

	}

}
