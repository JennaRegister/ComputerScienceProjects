import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Grid extends JPanel{
	public Grid(){
		setLayout(new GridLayout(2,2));
		setBackground(new Color(200,0,200));
		JButton pressme1=new JButton("Where");
		JButton pressme2=new JButton("Art");
		JButton pressme3=new JButton("Thou");
		JButton pressme4=new JButton("Romeo?");
		add(pressme1);
		add(pressme2);
		add(pressme3);
		add(pressme4);
		
		
	}
	

}
