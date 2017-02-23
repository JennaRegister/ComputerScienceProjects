import java.awt.*;
import javax.swing.*;

public class Nested extends JPanel {
	public Nested(){
		setLayout(new GridLayout(3,1));
		Flow f = new Flow();
		Grid g = new Grid();
		Border b = new Border();
		add(f);
		add(g);
		add(b);
		
		
	}

}
