import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;


public class ColorPanel extends JPanel{
	private int x,y;
	private int moveit=10;
	private int i=0;
	
	Color [] colors = {Color.magenta, Color.cyan, Color.yellow, Color.pink,Color.orange};
	Color c= colors[0];
	
	
	public ColorPanel(){
		super();
		addKeyListener(new MovinandListenin());
		setBackground(Color.black);
		setFocusable(true);
		x=100/2;
		y=50/2;
				
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(c);
		g.fillRect(x, y, 100, 50);
	}
	
	private class MovinandListenin implements KeyListener{
		public void keyPressed (KeyEvent e){
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				y-=moveit;
				break;
			case KeyEvent.VK_DOWN:
				y+=moveit;
				break;
			case KeyEvent.VK_LEFT:
				x-=moveit;
				break;
			case KeyEvent.VK_RIGHT:
				x+=moveit;
				break;
			case KeyEvent.VK_ENTER:
				i++;
				c=colors[(i%5)];
				
				
			}
			repaint();
		}
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
			
		}
		
	}


