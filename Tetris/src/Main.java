import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Jenna's Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new GamePanel();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	

}
