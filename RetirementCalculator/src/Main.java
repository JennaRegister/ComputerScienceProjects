import java.awt.*;
import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new CalcPanel();
		//JPanel gpan= new Graph();
		frame.add(panel);
		//frame.add(gpan);
		//frame.setSize(350,400);
		frame.pack();
		frame.setVisible(true);
	}

}
