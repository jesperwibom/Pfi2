
public class Dog extends Mammal{
	
	private boolean stupid;
	
	public Dog(String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
	}
	
	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName) {
		super(latinName, gestationTime);
		setFriendlyName(friendlyName);
		this.stupid = stupid;
	}

	@Override
	public String getInfo() {
		String stu;
		if(isStupid()){
			stu = "stupid";
		}else{
			stu = "not stupid";
		}
		String info = "The dog "+getFriendlyName()+" lat: "+getLatinName()+" nurses for "+getGestationTime()+" months and is "+stu+".";
		return info;
	}
	
	public boolean isStupid(){
		return stupid;
	}
}
