import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
public class Grid2 extends JPanel {
	public Grid2(String ch1, String ch2){
	setLayout(new FlowLayout());
	setBackground(new Color(170,0,200));
	JButton choice1=new JButton(ch1);
	JButton choice2=new JButton(ch2);
	choice1.setSize(160, 40);
	add(choice1);
	add(choice2);
	}

}
