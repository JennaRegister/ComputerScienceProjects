import javax.swing.JFileChooser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Project1 {
	public static void main (String [] args) throws Exception{
		
		//My own testing
		Rational r1 = new Rational(2,3);
		Rational r2 = new Rational(4,5);
		Rational r3 = new Rational(2,1);
		Rational r4 = new Rational(2,1);
		System.out.println(r1.addrats(r2));
		System.out.println(Rational.addrats(r1,r2));
		System.out.println(r1.subrats(r2));
		System.out.println(Rational.subrats(r1,r2));
		System.out.println(r2.mulrats(r1));
		System.out.println(Rational.mulrats(r1, r2));
		System.out.println(r1.divrats(r2));
		System.out.println(Rational.divrats(r1, r2));
		System.out.println(r1.equals(r2));
		System.out.println(Rational.equals(r1,r2));
		System.out.println(r1.compareit(r2));
		
		
		Complex c1 = new Complex(2,-3);
		Complex c2 = new Complex(1,1);
		System.out.println(Complex.addcomps(c1, c2));
		System.out.println(c1.addcomps(c2));
		System.out.println(Complex.subcomps(c1, c2));
		System.out.println(c1.subcomps(c2));
		System.out.println(Complex.mulcomps(c1, c2));
		System.out.println(c1.mulcomps(c2));
		System.out.println(Complex.divcomps(c1, c2));
		System.out.println(c1.divcomps(c2));
		System.out.println(Complex.polar(c1));
		System.out.println("\n");
		
		//attempt at reading from the file
		JFileChooser chooseit = new JFileChooser();
		int val = chooseit.showOpenDialog(null);
		if(val == JFileChooser.APPROVE_OPTION);{
			Scanner scan = new Scanner(chooseit.getSelectedFile());
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				String[] splits = line.split(",");//split at the commas
				ArrayList<String> nums = new ArrayList<String>();//initializing variables
				ArrayList<String> dens = new ArrayList<String>();
				String tempsplits = null;
				String splitit = null;
				String [] splitit2 = null;
				for(int i=0;i<splits.length;i++){
					tempsplits = splits[i];
					splitit= tempsplits.replace("/", " ");//replace / with nothing
					System.out.println(splitit);
					splitit2 = splitit.split(" ");
				}
					for(int j=0;j<splitit2.length;j++){
						nums.add(splitit2[j]);//making a list of numerators to work with
					}
					for(int g=1; g<splitit2.length;g+=2){
						dens.add(splitit2[g]);//making a list of denominators to work with
					}
					//would use numerators and denominators to make Rational numbers to perform operations on
					/*for(int m=0;m<nums.size();m++){
						int numsi= Integer.parseInt(nums.get(m));
						int densi= Integer.parseInt(dens.get(m));
						Rational r = new Rational(numsi,densi);
						//System.out.println(r);
						
					}*/
				}
			}
	}
}
				
				
		
				
		
				
			
			
		

		

	

