import java.util.Random;

public class Reel {		
	
	public Symbol[] spin(){		
		
		Symbol s1 = new Symbol();
		Symbol s2 = new Symbol();
		Symbol s3 = new Symbol();
		Symbol s4 = new Symbol();
		Symbol s5 = new Symbol();
		Symbol s6 = new Symbol();
		
		s1.setImage("img/bell.png");
		s2.setImage("img/cherry.png");
		s3.setImage("img/lemon.png");
		s4.setImage("img/plum.png");
		s5.setImage("img/redseven.png");
		s6.setImage("img/watermelon.png");
		
		s1.setValue(6);
		s2.setValue(2);
		s3.setValue(3);
		s4.setValue(4);
		s5.setValue(7);
        s6.setValue(5);
		
		Symbol[] imagelist1 = {s1,s2,s3,s4,s5,s6} ;
		
		 Random rnd = new Random();
		 
		 
		 for(int i=imagelist1.length-1;i>=0;i--){
			 
			 int index= rnd.nextInt(i+1);
			Symbol a = imagelist1[index];
			imagelist1[index]=imagelist1[i];
			imagelist1[i] =  a;			 
			
		 }	
		 
		 return imagelist1;	 
		
	}
	
	

	/* private void spinBtActionPerformed(ActionEvent evt){
		 
		// Reel r = new Reel();
			
		Symbol[] imgList1 = spin();
		Symbol[] imgList2 = spin();
		Symbol[] imgList3 = spin();
		
		for(int a=0; a<imgList1.length;a++){
			
			System.out.println("\""+imgList1[a].getImage()+"\"");
			
			ImageIcon img1 = new ImageIcon(imgList1[a].getImage());
			reel3.setIcon(img1);
		}
		
		for(int a=0; a<imgList2.length;a++){
			
			System.out.println("\""+imgList2[a].getImage()+"\"");
			
			ImageIcon img2 = new ImageIcon(imgList2[a].getImage());
			reel2.setIcon(img2);
		}
		
		for(int a=0; a<imgList3.length;a++){
			
			System.out.println("\""+imgList3[a].getImage()+"\"");
			
			ImageIcon img3 = new ImageIcon(imgList3[a].getImage());
			reel1.setIcon(img3);
		}
			
			
	 }
	
	 private void betOneBtActionPerformed(ActionEvent evt){
		 
		 betCount++;		 
		 betAreaVal.setText("  "+Integer.toString(betCount));
	 }
	 
	 private void betMaxBtActionPerformed(ActionEvent evt){
		 
		 betCount = betCount+3;		 
		 betAreaVal.setText("  "+Integer.toString(betCount));
	 }
	
	

	public static void main(String[] args) {

		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Reel();
	            }
	        });
	}
	
*/
}
