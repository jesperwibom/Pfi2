
public abstract class Mammal extends Animal{
	
	private int gestationTime;
	
	public Mammal(String latinName, int gestationTime, boolean stupid){
		super(latinName);
	}
	
	public int getGestationTime(){
		return gestationTime;
	}
}
