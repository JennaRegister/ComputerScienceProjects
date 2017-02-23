import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Border extends JPanel{
	public Border(){
		setLayout(new BorderLayout());
		setBackground(new Color(100,0,250));
		JButton pressme1=new JButton("1000101001^0");
		JButton pressme2=new JButton("2! = 2 x 1 = 2");
		JButton pressme3=new JButton("(sqrt(3))^2");
		JButton pressme4=new JButton("4");
		JButton pressme5=new JButton("sqrt(5) is regarded as a sacred number in Egypt, due to Euclid's work with the Golden mean.");
		add(pressme1,BorderLayout.NORTH);
		add(pressme2,BorderLayout.WEST);
		add(pressme3,BorderLayout.CENTER);
		add(pressme4,BorderLayout.EAST);
		add(pressme5,BorderLayout.SOUTH);
		
		
		
	}

}
