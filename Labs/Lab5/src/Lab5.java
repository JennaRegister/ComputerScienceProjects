import java.util.Scanner;
public class Lab5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you a wizard or a muggle?");
		String blood= scan.next();
		System.out.println("How old are you?");
		double age= scan.nextDouble();
		if ((age <= 11) && blood.equalsIgnoreCase("Muggle"))
		{
			{
			System.out.println("You may be a wizard yet! Just keep waiting for that Hogwarts letter!");
			}
		if ((age >=11) && blood.equalsIgnoreCase("Muggle")){
			System.out.println("Sorry love, it's time to stop waiting for the Hogwarts letter and move on with your life.");
			}
		}
		else{
			System.out.print("\tYou have violated the International Statute of Wizarding Secrecy.\n\tExpect a Ministry Official at your place of residence once you conclude reading this letter.\n\t\tHoping you are well,\n\t\tMafalda Hopkirk");
		}
		System.out.println("\n\n\nIt's pretty "+ (blood.equalsIgnoreCase("Wizard")?"magical":"boring") + " being a " + blood + ".");
	}

}
