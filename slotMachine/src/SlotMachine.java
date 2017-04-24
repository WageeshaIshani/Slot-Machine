import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class SlotMachine {
	
	//initializing
	
	JFrame frm;
	JButton reel1 ;
	JButton reel2 ;
	JButton reel3 ;
	JButton spinBt;
	JButton addCoinBt;
	JButton betOneBt ;
	JButton betMaxBt ;
	JButton resetBt ;
	JLabel betArea;
	JLabel betAreaVal;
	JLabel creditArea;
	JLabel creditAreaVal;
	JButton stat;
	
	private int betCount;
	private int credits;
	private int cnt;
	private String displayImg01;
	private String displayImg02;
	private String displayImg03;
	private int symbolVal;
	private int wins;
	private int loss;
	
	//constructor
	SlotMachine(){
		
		betCount=0;
		credits=10;
		wins=0;
		loss=0;
		//cnt=1;
		
		frm = new JFrame("SlotMachine GUI");
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		
		ImageIcon img = new ImageIcon("img/bell.png");
		
		reel1 = new JButton(img);
		reel2 = new JButton(img);
		reel3 = new JButton(img);		
		
		addCoinBt = new JButton("Add Coin");
		betOneBt = new JButton("Bet One");
		betMaxBt = new JButton("Bet Max");
		resetBt = new JButton("Reset");
		spinBt = new JButton("Spin");
		betArea = new JLabel("Bet Area");
		betAreaVal = new JLabel("  "+Integer.toString((betCount)));
		creditArea = new JLabel("Credit Area");
		creditAreaVal = new JLabel("  "+Integer.toString((credits)));
		stat = new JButton("Statistics");
				
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new LineBorder(Color.BLUE,20));
		frm.add(panel);
		panel.add(reel1,BorderLayout.EAST);
		panel.add(reel2,BorderLayout.CENTER);
		panel.add(reel3, BorderLayout.WEST);
		
		JPanel panel2 = new JPanel(new GridLayout(2,5,5,10));	
		panel2.setBorder(new LineBorder(Color.BLUE,20));
		panel2.setBackground(Color.BLUE);
		frm.add(panel2,BorderLayout.SOUTH);		
		panel2.add(betMaxBt);			
		panel2.add(betOneBt);		
		panel2.add(betArea);		
		panel2.add(betAreaVal);
		panel2.add(spinBt);
		panel2.add(resetBt);
		panel2.add(addCoinBt);
		panel2.add(creditArea);
		panel2.add(creditAreaVal);
		panel2.add(stat);
		

		betArea.setForeground(Color.white);
		creditArea.setForeground(Color.white);
		betAreaVal.setForeground(Color.white);
		creditAreaVal.setForeground(Color.white);
		
		betAreaVal.setFont(new Font("Tahoma", 1, 14));
		creditAreaVal.setFont(new Font("Tahoma", 1, 14));
		creditAreaVal.setBorder(new LineBorder(Color.WHITE,1));
		betAreaVal.setBorder(new LineBorder(Color.WHITE,1));
		
		
		frm.pack();
		
		spinBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	spinBtActionPerformed(evt);
            }
        });
	betOneBt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	betOneBtActionPerformed(evt);
        }
    });
	betMaxBt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	betMaxBtActionPerformed(evt);
        }
    });
	addCoinBt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	addCoinBtActionPerformed(evt);
        }
    });
	resetBt.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	resetBtActionPerformed(evt);
        }
    });
	reel3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	reel3ActionPerformed(evt);
        }
    });
	reel2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	reel2ActionPerformed(evt);
        }
    });
	reel1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	reel1ActionPerformed(evt);
        }
    });
	stat.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	statActionPerformed(evt);
        }
    });
	
		
	}

	
	//Spin button method
	private void spinBtActionPerformed(ActionEvent evt){
		//check credits before spin
		if(credits==0){
			
			JOptionPane.showMessageDialog(null, "Credit value is Zero. You cannot play");
			
		}
		else{
			//check bet amount before spin
		if(betCount!=0){		
		//create thread
		Thread t = new Thread(){
			
			Reel r1 = new Reel();				
			Symbol[] imgList1 = r1.spin();
			
			//override run method
			public void run(){
				cnt=1;
				//create infinite loop
				while(cnt>0){		
					for(int a=0; a<imgList1.length;a++){
						
						System.out.println("******"+imgList1[a].getImage());
						
						ImageIcon img1 = new ImageIcon(imgList1[a].getImage());
						reel3.setIcon(img1);//set images to the reel button
						
						try {
						      Thread.sleep(100);
						     } catch (InterruptedException e) {
						      
						     }		
						//stop loop when one of the reels are clicked
						if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
							cnt=0;
							 displayImg01=reel3.getIcon().toString();//get the stopped image
							 symbolVal=imgList1[a].getValue();//get the value of symbol
							
							break;
						}else{
							cnt++;
						}
					}
					
				}			
				
			}
			
		};
		
		Thread t2 = new Thread(){
			
			
			Reel r2 = new Reel();				
			Symbol[] imgList2 = r2.spin();
			
			
			public void run(){			
				cnt=1;
			while(cnt>0){	
					
				for(int b=0; b<imgList2.length;b++){
					
					System.out.println("##########"+imgList2[b].getImage());
					
					ImageIcon img2 = new ImageIcon(imgList2[b].getImage());
					reel2.setIcon(img2);
					
					try {
					      Thread.sleep(100);
					     } catch (InterruptedException e) {
					      
					     }
					
					if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
						cnt=0;
						 displayImg02=reel2.getIcon().toString();
						 
						break;
					}else{
						cnt++;
					}
				}
				
			}
			
			}
			
		};
		
		Thread t3 = new Thread(){
			
			Reel r3 = new Reel();			
			Symbol[] imgList3 = r3.spin();
			
			public void run(){
				cnt=1;
			while(cnt>0){	
				
				for(int c=0; c<imgList3.length;c++){
					
					System.out.println("-------"+imgList3[c].getImage());
					
					ImageIcon img3 = new ImageIcon(imgList3[c].getImage());
					reel1.setIcon(img3);
					
					try {
					      Thread.sleep(100);
					     } catch (InterruptedException e) {
					      
					     }
					if((reel3.getModel().isPressed()==true) || (reel2.getModel().isPressed()==true) || (reel1.getModel().isPressed()==true)){
						cnt=0;
						displayImg03=reel1.getIcon().toString();						
						break;
					}else{
						cnt++;
					}
				}
											
			}
			
							
			}
			
		};	
		
			
	
		t.start();
		t2.start();
		t3.start();	
		
		
		}else{
			JOptionPane.showMessageDialog(null, "Bet some credits to spin.");
			
		}
		}
			
	 }
	
	 private void betOneBtActionPerformed(ActionEvent evt){
		 
		 if(1<=credits){
			 
			 betCount+=1;		 
			 betAreaVal.setText("  "+Integer.toString(betCount));
			 
			 credits = credits-1;
			 creditAreaVal.setText("  "+Integer.toString(credits));
		 }
		 
		 
	 }
	 
	 private void betMaxBtActionPerformed(ActionEvent evt){
		 
		 if(3<=credits){
		 
			 betCount = betCount+3;		 
			 betAreaVal.setText("  "+Integer.toString(betCount));
		 
			 credits = credits-3;
			 creditAreaVal.setText("  "+Integer.toString(credits));
		 }
	 }
	 
	 private void addCoinBtActionPerformed(ActionEvent evt){
		 
		 credits+=1;
		 creditAreaVal.setText("  "+Integer.toString(credits));
	 }
	 
	 private void resetBtActionPerformed(ActionEvent evt){
		 
		 credits= credits+betCount;
		 betCount=0;
		 betAreaVal.setText("  "+Integer.toString(betCount));
		 creditAreaVal.setText("  "+Integer.toString(credits));
		 
	 }
	 
	 private void reel3ActionPerformed(ActionEvent evt){
		
		if(displayImg01.equals(displayImg02) && displayImg02.equals(displayImg03)){
			 
			 credits = credits + (betCount*symbolVal);
			 betCount=0;
			 betAreaVal.setText(Integer.toString(betCount));
			 creditAreaVal.setText(Integer.toString(credits));
			 JOptionPane.showMessageDialog(null, "YOU WIN!!!");
			 wins+=1;
			 
		 }
		 else if(displayImg02.equals(displayImg01)){
			 System.out.println("Machine");
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
				
			
		}
		 else if(displayImg01.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else if(displayImg02.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else{
			 betCount=0;
			 betAreaVal.setText("  "+Integer.toString(betCount));
			 JOptionPane.showMessageDialog(null, "You lost.");
			 loss+=1;
		 }
		
	 }
	 
	 private void reel2ActionPerformed(ActionEvent evt){
		 		 
		 if(displayImg01.equals(displayImg02) && displayImg02.equals(displayImg03)){
			
			 credits = credits + (betCount*symbolVal);
			 betCount=0;
			 betAreaVal.setText(Integer.toString(betCount));
			 creditAreaVal.setText(Integer.toString(credits));
			 JOptionPane.showMessageDialog(null, "YOU WIN!!!");
			 wins+=1;
		 }
		 else if(displayImg02.equals(displayImg01)){
			
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
				
			
		}
		 else if(displayImg01.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else if(displayImg02.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else{
			 betCount=0;
			 betAreaVal.setText("  "+Integer.toString(betCount));
			 JOptionPane.showMessageDialog(null, "You lost.");
			 loss+=1;
		 }
	 }
	 private void reel1ActionPerformed(ActionEvent evt){
				
		 if(displayImg01.equals(displayImg02) && displayImg02.equals(displayImg03)){
			
			 credits = credits + (betCount*symbolVal);
			 betCount=0;
			 betAreaVal.setText(Integer.toString(betCount));
			 creditAreaVal.setText(Integer.toString(credits));
			 JOptionPane.showMessageDialog(null, "YOU WIN!!!");
			 wins+=1;
		 }
		 else if(displayImg02.equals(displayImg01)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");				
			
		}
		 else if(displayImg01.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else if(displayImg02.equals(displayImg03)){
			 
			 JOptionPane.showMessageDialog(null, "You have a free spin.");
		 }
		 else{
			 betCount=0;
			 betAreaVal.setText("  "+Integer.toString(betCount));
			 JOptionPane.showMessageDialog(null, "You lost.");
			 loss+=1;
		 }
			 
	 }
	 
	 private void statActionPerformed(ActionEvent evt){
		 
		 JDialog d = new JDialog(frm,true);
		 JPanel p = new JPanel(new GridLayout(4,2,2,2));
		 JLabel lblWin = new JLabel("Wins: ");
		 JLabel lblWinNo = new JLabel("");
		 JLabel lblLoss = new JLabel("Losses: ");
		 JLabel lblLossNo = new JLabel("");
		 JLabel lblAvgCredit = new JLabel("Avg");
		 JLabel lblAvgCreditVal = new JLabel("Avg");
		 JButton saveBt = new JButton("Save");
		 
		 p.setBorder(new LineBorder(null,10));
		 lblWin.setBorder(new LineBorder(Color.BLACK,2));
		 lblLoss.setBorder(new LineBorder(Color.BLACK,2));
		 lblWinNo.setBorder(new LineBorder(Color.BLACK,2));
		 lblAvgCreditVal.setBorder(new LineBorder(Color.BLACK,2));
		 lblAvgCredit.setBorder(new LineBorder(Color.BLACK,2));
		 lblLossNo.setBorder(new LineBorder(Color.BLACK,2));
		 Container pane = (Container) d.getContentPane().add(p);
		 p.add(lblWin);
		 p.add(lblWinNo);
		 p.add(lblLoss);		 
		 p.add(lblLossNo);
		 p.add(lblAvgCredit);
		 p.add(lblAvgCreditVal);
		 p.add(saveBt);
		 d.setSize(450, 200);		
		 d.setVisible(true);
		
		 lblWinNo.setText(Integer.toString(wins));
		 lblLossNo.setText(Integer.toString(loss));
		 
	 }
	

	public static void main(String[] args) {

		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new SlotMachine();
	            }
	        });
	}
}
