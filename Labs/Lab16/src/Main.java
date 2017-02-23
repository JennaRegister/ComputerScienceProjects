import javax.swing.JFrame;


public class Main {
	public static void main(String [] args){
		Flow flow = new Flow();
		Grid grid = new Grid();
		Border border=new Border();
		Nested nested=new Nested();
		JFrame frame = new JFrame("Flow");
		JFrame frame2= new JFrame("Grid");
		JFrame frame3= new JFrame("Border");
		JFrame frame4 = new JFrame("Nested");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.add(flow);
		frame.setSize(300,150);
		frame2.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame2.add(grid);
		frame2.setSize(300,300);
		frame3.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame3.add(border);
		frame3.setSize(600,150);
		frame4.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame4.add(nested);
		frame4.setSize(600,600);
		frame4.setVisible(true);
		frame3.setVisible(true);
		frame2.setVisible(true);
		frame.setVisible(true);
		
	}

}
