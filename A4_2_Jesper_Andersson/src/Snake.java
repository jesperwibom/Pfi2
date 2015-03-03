
public class Snake extends Animal{
	
	private boolean poisonus;
	
	public Snake(String latinName, boolean poisonus) {
		super(latinName);
		this.poisonus = poisonus;
	}

	public boolean isPoisonus(){
		return this.poisonus;
	}

	@Override
	public String getInfo() {
		String pos;
		if(isPoisonus()){
			pos = "poisonus";
		}else{
			pos = "not poisonus";
		}
		String info = "The snake "+getFriendlyName()+" lat: "+getLatinName()+" is "+pos+".";
		return info;
	}
}
