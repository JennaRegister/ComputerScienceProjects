import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CalcPanel extends JPanel{
	public JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	public JPanel graph;
	public JPanel texts;
	public double n1,n2,n3,n4,n5,n6,n7,n8;
	public double [] values = new double [8];
	public JButton calculate;
	public JButton starbucks;
	public JButton gambling;
	JPanel button;
	
	public CalcPanel(){
		setLayout(new BorderLayout());
		setBackground(new Color(150,0,250));
		
		graph = new GraphP();
		texts = new JPanel();
		button = new JPanel();
		texts.setLayout(new GridLayout(9,2));
		texts.setBackground(new Color(150,0,250));
		
		t1=new JTextField(8);
		t2=new JTextField(8);
		t3=new JTextField(8);
		t4=new JTextField(8);
		t5=new JTextField(8);
		t6=new JTextField(8);
		t7=new JTextField(8);
		t8=new JTextField(8);
		
		
		l1= new JLabel("Daily savings: ");
		l2 = new JLabel("Current Age: ");
		l3= new JLabel("Starting amount: ");
		l4= new JLabel("Retirement age: ");
		l5= new JLabel("Annual retirement income: ");
		l6= new JLabel("Life Expectancy: ");
		l7= new JLabel("Interest Rate: ");
		l8= new JLabel("Rate of Inflation: ");
		
		calculate=new JButton("Calculate");
		starbucks= new JButton("Daily Starbucks");
		gambling=new JButton("Gambling Problem"); 
		t1.addActionListener(new Listen());
		t2.addActionListener(new Listen());
		t3.addActionListener(new Listen());
		t4.addActionListener(new Listen());
		t5.addActionListener(new Listen());
		t6.addActionListener(new Listen());
		t7.addActionListener(new Listen());
		t8.addActionListener(new Listen());
		
		calculate.addActionListener(new Calc());
		starbucks.addActionListener(new Listen2());
		gambling.addActionListener(new Listen3());
		
		
		texts.add(l1);
		texts.add(t1);
		texts.add(l2);
		texts.add(t2);
		texts.add(l3);
		texts.add(t3);
		texts.add(l4);
		texts.add(t4);
		texts.add(l5);
		texts.add(t5);
		texts.add(l6);
		texts.add(t6);
		texts.add(l7);
		texts.add(t7);
		texts.add(l8);
		texts.add(t8);
		texts.add(starbucks);
		texts.add(gambling);
		button.add(calculate);
		add(button,BorderLayout.SOUTH);
		add(texts, BorderLayout.NORTH);
		add(graph,BorderLayout.CENTER);
		button.setVisible(true);
		texts.setVisible(true);
		graph.setVisible(true);
			
		 
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
	}
	private class Listen implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double n1 = Double.parseDouble(t1.getText());
			double n2 = Double.parseDouble(t2.getText());
			double n3 = Double.parseDouble(t3.getText());
			double n4 = Double.parseDouble(t4.getText());
			double n5 = Double.parseDouble(t5.getText());
			double n6 = Double.parseDouble(t6.getText());
			double n7 = Double.parseDouble(t7.getText());
			double n8 = Double.parseDouble(t8.getText());
			values[0]=n1;
			values[1]=n2;
			values[2]=n3;
			values[3]=n4;
			values[4]=n5;
			values[5]=n6;
			values[6]=n7;
			values[7]=n8;
			/*for(int i =0; i<values.length;i++){
				System.out.println(values[i]);
			}*/
			
		}
		
	}
	private class Listen2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double j1 = Double.parseDouble(t1.getText());
			values[0]=j1-3;
			for(int i =0; i<values.length;i++){
				System.out.println(values[i]);
			}
			
		}
	}
	private class Listen3 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double g1 = Double.parseDouble(t1.getText());
			values[0]=g1-500;
			for(int i =0; i<values.length;i++){
				System.out.println(values[i]);
			}
			
		}
	}
	private class Calc implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double result = 0;
			double result2=0;
			double inflation =0;
			double ARI=0;
			add(graph, BorderLayout.CENTER);
			graph.setVisible(true);
			double years = values[5]-values[1];
			double [] balance = new double [(int) years];
			
			for(int i =0; i<values[3]-values[1]; i++){
				result = ((values[2]+(values[0]*365*i))*(Math.pow((1.0+values[6]), i)));
				balance[i]=result;
				
			}
			
			/*for(int k=1; k<values[5]-values[3];k++){
				inflation1=1+values[7];
				result2=balance[(int) (values[3]-values[1])]-(inflation1*values[4]*k);*/
				
				  ARI=values[4];
				  inflation=1+values[7];
				  for(int j = (int) (values[3]-values[1]); j<years;j++){
				 ARI=ARI*inflation;
				 result2=(balance[j-1]*(1.0+values[6]))-ARI;
				 balance[j] = result2;
				 
				/*for (int j =(int) j=1; j<((int) values[3]-values[1])){
				
				result3=result2
				
				int j =(int) ((int) values[3]-values[1]);
				balance[k+j]=result2;
				
				}*/
			}
			for(int c =0; c<balance.length;c++){
				System.out.println(balance[c]);
			}
		
		     ((GraphP) graph).setArray(balance);
		     ((GraphP) graph).setYears((int) years);
		     graph.repaint();
		}
	}
	
	public class GraphP extends JPanel {
		double [] vals;
		int years = 80; 
		public void setArray(double [] a) {
			vals = a;
		}
		public void setYears(int n){
			years=n;
		}
		public GraphP(){
			setBackground(Color.BLACK);
			setPreferredSize(new Dimension(400,200));
			vals=new double[years];
			for(int i = 0; i<years;i++){
				vals[i]=i;
			}
		}
			private double getmin(double[]a){
				double r = a[0];
				for(int i=0; i<vals.length;i++){
					r=((r>a[i])?a[i]:r);
				}
				return r;
			}
			private double getmax(double[] a){
				double r=a[0];
				for(int i=0;i<vals.length;i++){
					r=((r<a[i])?a[i]:r);
				}
				return r;
			}
			public void paintComponent(Graphics page){
				super.paintComponent(page);
				int w = this.getWidth();
				int h= this.getHeight();
				int mid = h/2;
				int bwidth = w/years;
				double min = getmin(vals);
				double max = getmax(vals);
				double factor = mid/Math.max(Math.abs(min), Math.abs(max));
				
				for(int g=0; g <vals.length;g++){
					int bheight=(int)Math.floor(factor * vals[g]);
					if(vals[g] >=0){
						page.setColor(Color.GREEN);
						page.fillRect(g*bwidth, mid-bheight, bwidth, bheight);
						page.setColor(Color.BLACK);
						page.drawRect(g*bwidth, mid-bheight, bwidth, bheight);
						
					}
					else{
						page.setColor(Color.RED);
						page.fillRect(g* bwidth, mid, bwidth, -bheight);
						page.setColor(Color.BLACK);
						page.drawRect(g*bwidth,mid,bwidth,-bheight);
					}
				}
				page.setColor(Color.WHITE);
				page.drawString(Math.max(Math.abs(min), Math.abs(max))+" ", 5, 15);
				page.drawString("-"+Math.max(Math.abs(min), Math.abs(max))+" ", 5, h-15);
				
		
			
		}

}
}
