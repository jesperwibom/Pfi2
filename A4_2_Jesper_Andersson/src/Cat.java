
public class Cat extends Mammal{

	private int numberOfLives;
	
	public Cat(String latinName, int gestationTime, int nrLives) {
		super(latinName, gestationTime);
		setNumberOfLives(nrLives);
	}

	@Override
	public String getInfo() {
		String info = "The cat "+getFriendlyName()+" lat: "+getLatinName()+" nurses for "+getGestationTime()+" months and has "+getNumberOfLives()+".";
		return info;
	}
	
	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

}
