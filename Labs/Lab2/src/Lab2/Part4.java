package Lab2;
import javax.swing.JOptionPane;

public class Part4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "For some reason, your basic brain can only understand the concept of seconds. Similar to a clock, I can give you a HAND. Ha ha, get it?");
		String secondsstring = JOptionPane.showInputDialog("Enter the number of seconds: ");
		int seconds = Integer.parseInt(secondsstring);
		int hours = seconds/3600;
		int mins = seconds/60;
		int min_remain = mins%60;
		int sec_remain = seconds%60;
		JOptionPane.showMessageDialog(null, seconds + " seconds is equal to " + hours + " hours, " + min_remain + " minutes, " + sec_remain + " seconds.");
		
		
		

	}

}
