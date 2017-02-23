import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import java.awt.*;

import javax.swing.*;


public class Concentration extends JFrame{
	JButton play;
	CardButton button;
	CardButton [] cbarray = new CardButton[52];
	ActionListener taskPerformer;
	Timer t1;
	int count;
	int rank1;
	JLabel intro = new JLabel();
	int score=0;
	int turns=0;
	ArrayList <CardButton> selected = new ArrayList<CardButton>(2);
	JLabel scorelabel = new JLabel("Your Score: " + score);
	JLabel turnlabel= new JLabel("Turns: " + turns);
	
	public Concentration(){
		super();
		JFrame frame = new JFrame("Bees and Balloons: a Concentration Game");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,485);
		JPanel board = new JPanel(new BorderLayout());
		JPanel cards = new JPanel(new GridLayout(4,13));
		JPanel topmenu = new JPanel(new FlowLayout());
		JPanel scoremenu= new JPanel(new FlowLayout());
		frame.add(board);
		board.add(cards, BorderLayout.CENTER);
		board.add(topmenu, BorderLayout.NORTH);
		board.add(scoremenu,BorderLayout.SOUTH);
		cards.setBackground(new Color(250,250,0));
		topmenu.setBackground(new Color(250,250,0));
		topmenu.add(intro);
		scoremenu.setBackground(new Color(250,250,0));
		scoremenu.add(scorelabel);
		scoremenu.add(turnlabel);
		
		
		play = new JButton("Let's Play");
		play.addActionListener(new ButtonHandler2());
		topmenu.add(play);
		
		Deck deck1 = new Deck();
		deck1.Shuffle();
		ImageIcon back = new ImageIcon (getClass().getResource("image/bcard.png"));
		for(int i =0; i<52;i++){
			ImageIcon front = new ImageIcon(getClass().getResource(deck1.deck.get(i).getFace()));
			button = new CardButton(front,back,deck1.deck.get(i).getRank());
			cbarray[i]=button;
			button.addActionListener(new ButtonHandler());
			cards.add(button);
		}
		frame.setVisible(true);
		board.setVisible(true);
		cards.setVisible(true);
		topmenu.setVisible(true);
		
		taskPerformer= new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0; i<cbarray.length;i++){
				boolean check = cbarray[i].isFlipped();
				if (check == true){
				cbarray[i].flip();
				}
				}
			}
		};
		t1 = new Timer(2000,taskPerformer);
		t1.setRepeats(false);
				
			
		}
		public class ButtonHandler implements ActionListener{
			int rank2;
			CardButton clicked;
			public void actionPerformed(ActionEvent e){
					clicked = (CardButton) e.getSource();
					selected.add(clicked);
					
					if(count<1){
						rank1=clicked.getRank();
					}
					rank2=clicked.getRank();
					
					
					
					
				
				if(!clicked.isFlipped() && !t1.isRunning()){
					clicked.flip();
					count++;	
				}
				
				if(count>1){
					
					if(rank1==rank2){
						System.out.println("That's a match homie!");
						selected.get(0).setBack(new ImageIcon(getClass().getResource("image/win.gif")));
						//selected.get(0).setEnabled(false);
						repaint();
						
						selected.get(1).setBack(new ImageIcon(getClass().getResource("image/win.gif")));
						//selected.get(1).setEnabled(false);
						repaint();
						score++;
						System.out.println(score);
						scorelabel.setText("Your Score: " + Integer.toString(score));
						repaint();
						if(score==26){
							scorelabel.setText("Congratulations!");
						}
						
					}
					t1.start();
					count=0;
					selected.remove(0);
					selected.remove(0);
					turns++;
					turnlabel.setText("Turns: " +turns);
					repaint();
					if(score==26){
						scorelabel.setText("Congratulations! You completed Bees and Balloons in " + turns + " turns!");
						turnlabel.setText(" ");
					}
				}
				
			}
		}
		public class ButtonHandler2 implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				if(event.getSource() ==play){
					intro.setForeground(Color.black);
					intro.setText("Welcome to the matching game, Bees and Balloons. Flip the cards to find matches. But BEE quick and pay attention! Let's see how well you can do. ");
					play.setVisible(false);
		
				}
			
			}
		}
	
	public static void main(String [] args){
		Concentration game = new Concentration();
		
		
	}
}
	