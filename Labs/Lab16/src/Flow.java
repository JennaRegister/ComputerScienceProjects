import java.awt.*;

import javax.swing.*;



public class Flow extends JPanel {
	public Flow(){
		setLayout(new FlowLayout());
		setBackground(new Color(150,0,250));
		JButton pressme1=new JButton("Press Me!");
		JButton pressme2=new JButton("No, press ME!");
		JButton pressme3=new JButton("DO NOT press me.");
		JButton pressme4=new JButton("DEFINITELY don't press me.");
		add(pressme1);
		add(pressme2);
		add(pressme3);
		add(pressme4);
		
		
		
	}

}
