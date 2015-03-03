
public abstract class Mammal extends Animal{
	
	private int gestationTime;
	
	public Mammal(String latinName, int gestationTime){
		super(latinName);
	}
	
	public int getGestationTime(){
		return gestationTime;
	}
}
