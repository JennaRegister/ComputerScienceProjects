import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel{
	Color [][] board;
	Color seafoam= new Color(51,255,204);
	Color or=new Color(255,123,36);
	Color pink= new Color(255,36,167);
	Color green= new Color(0,204,0);
	Color lav = new Color(255,255,0);
	Color purp = new Color(150,0,255);
	ActionListener taskPerformer;
	Block piece;
	Square square;
	Long longp;
	LPiece lpiece;
	JPiece jpiece;
	ZPiece zpiece;
	SPiece spiece;
	SuperBlock [] pieces;
	SuperBlock rnd;
	Location [][] temp={{new Location(-1,0),new Location(0,0),new Location(1,0),new Location(0,1)},{new Location(0,-1),new Location(0,0),new Location(1,0),new Location(0,1)},{new Location(-1,0),new Location(0,0),new Location(1,0),new Location(0,-1)},{new Location(-1,0),new Location(0,0),new Location(0,1),new Location(0,-1)}};
	int Xsize=19, Ysize=24;
	int score=1;
	boolean timercheck = true;
	public GamePanel(){
		
		setLayout(new BorderLayout());
		setBackground(Color.gray);
		setPreferredSize(new Dimension(812,777));
		addKeyListener(new OrientListener());
		setFocusable(true);
		int count=0;
		piece= new Block(seafoam,0,new Location(Xsize/2,3),temp);
		square= new Square(or,0,new Location(Xsize/2,3),temp);
		longp=new Long(pink,0,new Location(Xsize/2,3),temp);
		lpiece=new LPiece(green,0,new Location(Xsize/2,3),temp);
		jpiece=new JPiece(lav,0,new Location(Xsize/2,3),temp);
		zpiece=new ZPiece(Color.blue,0,new Location(Xsize/2,3),temp);
		spiece=new SPiece(purp,0,new Location(Xsize/2,3),temp);
		pieces = new SuperBlock[7];
		pieces[0]= piece;
		pieces[1]= square;
		pieces[2]=longp;
		pieces[3]=lpiece;
		pieces[4]=jpiece;
		pieces[5]=zpiece;
		pieces[6]=spiece;
		int ind=new Random().nextInt(pieces.length);
		rnd=pieces[ind];
		
		board=new Color[Xsize][Ysize];
		for(int i=0;i<board.length;i++)
			for(int j=0;j<3;j++)
				board[i][j]=(((count++%2)==0)?Color.red:Color.green);
		for(int i=0;i<board.length;i++)
			for(int j=3;j<board[i].length;j++)
				board[i][j]=(((count++%2)==0)?Color.black:Color.black);
			
		taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent e){
						
				int samex=(rnd.getL().x);
				int samey=(rnd.getL().y);
				int newy=samey+1;
				boolean check=false;
				for(int i=0; i<rnd.blocks[rnd.orient].length;i++){
					if((board[samex + rnd.blocks[rnd.orient][i].x][newy+rnd.blocks[rnd.orient][i].y]!=Color.black)||(rnd==pieces[2]&& rnd.orient==0 && (newy==Ysize-3))){	
						check=true;	
					}
					
				}
				if((newy>=Ysize-2)||check){
					for(int i=0; i<rnd.blocks[rnd.orient].length;i++){
						int tempx=samex + rnd.blocks[rnd.orient][i].x;
						int tempy=(newy-1)+rnd.blocks[rnd.orient][i].y;
						board[tempx][tempy]=rnd.getColor();	
					}
					for(int c=0;c<board.length;c++){
						if(board[c][3]!=Color.black){
							timercheck=false;
							((Timer)e.getSource()).stop();
							System.out.println("You lose");
							
						}
					}
					
					int fullrowcheck=checkBoard();
					if(fullrowcheck!=0){
						move(board,fullrowcheck);
					}
					if (timercheck){
					int ind=new Random().nextInt(pieces.length);
					rnd=pieces[ind];
					score+=1;
					System.out.println("Current score: "+ score);
					newy=3;
					samex=Xsize/2;
					rnd.orient=0;
					
				}}
				if(timercheck){
				rnd.setL(new Location(samex,newy));
				repaint();
				}
				
				
			}
		};
		Timer timer = new Timer(200,taskPerformer);
		timer.start();

		
	}
	public void paintComponent(final Graphics g){
		super.paintComponent(g);
		int w=this.getWidth();
		int h=this.getHeight();
		final int bwidth=w/Xsize;
		final int bheight=h/Ysize;
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				g.setColor(board[i][j]);
				g.fillRect(i*bwidth, j*bheight, bwidth, bheight);
				g.setColor(Color.black);
				g.drawRect(i*bwidth, j*bheight, bwidth, bheight);
			}
		}
	
		for(int i=0; i<rnd.blocks[rnd.orient].length;i++){
			g.setColor(rnd.color);
			g.fillRect((rnd.l.x+rnd.blocks[rnd.orient][i].x)*bwidth, (rnd.l.y+rnd.blocks[rnd.orient][i].y)*bheight, bwidth, bheight);
			g.setColor(Color.black);
			g.drawRect((rnd.l.x+rnd.blocks[rnd.orient][i].x)*bwidth, (rnd.l.y+rnd.blocks[rnd.orient][i].y)*bheight, bwidth, bheight);
		}
		

	}
	public int checkBoard(){
		boolean test=true;
		for(int h=0;h<board.length;h++){
			for(int i=3;i<board[h].length;i++){
				for(int j=0;j<board.length;j++){
					if(board[j][i]==Color.black){
					test=false;
					j=board.length-1;
					
				}	
					else {
						test=true;
					}
			}
			if(test==true){
				return i;
				
			}
			
		}
				
	}
	return 0;
		}

	public void move(Color [][] a, int k){
		for(int i=k; i>3; i--){
			for(int j=0; j<board.length;j++){
				
				a[j][i]=a[j][i-1];
			}
		}
	}

	
	private class OrientListener implements KeyListener{
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				if(++rnd.orient>=rnd.blocks.length)
					rnd.orient=0;
				
				
				repaint();
				break;
			case KeyEvent.VK_LEFT:
				
				int samex2=(rnd.getL().x);
				int samey2=(rnd.getL().y);
				boolean check2=false;
				for(int i=0; i<rnd.blocks[rnd.orient].length;i++){
					int tempx=(samex2-1) + rnd.blocks[rnd.orient][i].x;
					int tempy=samey2+rnd.blocks[rnd.orient][i].y;
	
					if(tempx<0||(board[tempx][tempy]!=Color.black)){
						check2=true;
						
					}
				}
				if(check2){	
					
						rnd.l.x-=0;
				}
				else{
						rnd.l.x-=1;
				}	
				
				break;
			case KeyEvent.VK_RIGHT:
				int samex3=(rnd.getL().x);
				int samey3=(rnd.getL().y);
				boolean check3=false;
				for(int i=0; i<rnd.blocks[rnd.orient].length;i++){
					int tempx=(samex3+1) + rnd.blocks[rnd.orient][i].x;
					int tempy=samey3+rnd.blocks[rnd.orient][i].y;
					if(tempx>=Xsize||(tempy<0)||(board[tempx][tempy]!=Color.black)){
						check3=true;
					}
				}
				if(check3){	
					
					rnd.l.x+=0;
			
				}
				else{
					rnd.l.x+=1;
					}	
				
				break;	
			}
			repaint();
		}
	
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
	}
	
	

}
