import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Game");
		String[] names =
		      {"images/dog.jpg","images/fish.jpg" };
		JPanel bpath = new BinaryPath("What is your favorite color?",names[0],names[1]);
		frame.setSize(400,400);
		
		frame.add(bpath);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}
