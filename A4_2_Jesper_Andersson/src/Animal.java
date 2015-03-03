
public abstract class Animal {
	public String latinName;
	public String friendlyName;
	
	public Animal(String latinName) {
		this.latinName = latinName;
	}
	
	public abstract String getInfo();
	
	public void setFriendlyName(String name){
		this.friendlyName = name;
	}
	
	public String getFriendlyName(){
		return this.friendlyName;
	}
}
