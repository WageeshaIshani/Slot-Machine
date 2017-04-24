
public class Symbol implements ISymbol {
	
	protected String image;
	protected int value;
	
	public void setImage(String img){
		
		image = img;
		
	}
	public String getImage(){
		
		return image;
		
	}
	public void setValue(int v){
		
		value = v;
	}
	
	public int getValue(){
		
		return value;
	}
	
	public int compare(String imgPath){
		
		if(getImage().equals(imgPath)){
			return getValue();
		}
		else{
			return 0;
		}
		
	}

	public static void main(String[] args) {
		

	}

}
