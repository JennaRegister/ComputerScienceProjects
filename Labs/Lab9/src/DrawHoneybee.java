import java.awt.*;
import javax.swing.JFrame;


import javax.swing.JPanel;
public class DrawHoneybee extends JPanel {
	public DrawHoneybee(){
		super();
		setBackground(Color.white);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Color honey = new Color(255,215,0);
		//head
		g.setColor(Color.black);
		g.fillArc(128, 42, 20, 20, 0, 360);
		g.fillArc(153, 42, 20, 20, 0, 360);
		g.drawLine(150, 50, 135, 30);
		g.drawLine(154, 50, 170, 30);
		g.drawLine(135, 30, 125, 25);
		g.drawLine(170,30,180,25);
		g.drawArc(128,40,45,45,0,360);
		g.setColor(honey);
		g.fillArc(128,40,45,45,0,360);
		
		

		g.setColor(honey);
		g.fillOval(125, 100, 50, 100);
		g.setColor(Color.black);
		g.drawOval(125, 100, 50, 100);
		g.drawArc(125,75,50,50,0,360);
		g.setColor(honey);
		g.fillArc(125,75,50,50,0,360);
		
		g.setColor(Color.black);
		//stripes
		g.fillRect(130,120,41,6);
		g.fillRect(127,135,47,6);
		g.fillRect(125,150,52,6);
		g.fillRect(127,165,47,6);
		g.fillRect(130,180,41,6);
		
		//wing1
		g.drawLine(133,80,15,70);
		g.drawLine(15, 70, 50, 120);
		g.drawLine(50, 120, 127, 110);
		g.drawLine(133, 80, 50, 120);
		g.drawLine(15, 70, 90, 100);
		g.drawLine(35, 100, 90, 100);
		g.drawLine(90, 100, 95, 114);
		
		//wing2
		g.drawLine(170,80,285,70);
		g.drawLine(285,70,250,120);
		g.drawLine(250,120,175,110);
		g.drawLine(170,80,250,120);
		g.drawLine(285, 70, 210, 100);
		g.drawLine(210, 100, 265, 100);
		g.drawLine(210, 100, 210, 114);
		
		//text
		g.drawString("BUZZ", 190, 170);
		g.drawString("BUZZ", 210, 190);
		g.drawString("BUZZ", 185, 210);
		g.drawString("BUZZ", 210, 230);
		g.drawString("BUZZ", 190, 250);
		g.drawString("BUZZ", 210, 270);
		
		
		
		
	}
	public static void main(String[] args) {
		DrawHoneybee panel = new DrawHoneybee();
		JFrame win = new JFrame("Honeybee");
		win.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		win.add(panel);
		win.setSize(300,300);
		win.setVisible(true);
	}

}