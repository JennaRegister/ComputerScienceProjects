import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class BinaryPath extends JPanel {
	public BinaryPath(String label, String pic, String pic2){
		setLayout(new BorderLayout());
		setBackground(new Color(170,0,200));
		JPanel top = new JPanel();
		JPanel bot = new JPanel();
		JLabel question = new JLabel(label);
		ImageIcon image = new ImageIcon (getClass().getResource(pic));
		ImageIcon image2 = new ImageIcon (getClass().getResource(pic2));
		JLabel im1= new JLabel(image);
		JLabel im2= new JLabel(image2);
		im2.setLocation(30, 30);
		Grid2 doubgrid = new Grid2("Choose me!", "No, choose me!");
		add(im1,BorderLayout.WEST);
		add(im2,BorderLayout.EAST);
		add(doubgrid, BorderLayout.SOUTH);
		add(question, BorderLayout.NORTH);
	
	}
	

}
