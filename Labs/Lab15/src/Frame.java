import javax.swing.*;

import java.awt.*;


public class Frame {
	public static void main(String[] args) {
		ColorPanel panel = new ColorPanel();
		JFrame win = new JFrame("Color Fun");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.add(panel);
		win.setSize(300,300);
		win.setVisible(true);
	}

}
