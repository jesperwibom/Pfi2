
public abstract class Animal {
	private String latinName = "noLatinName";
	private String friendlyName = "noName";
	
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
	
	//Detta ingår inte i klassdiagrammet men jag förstår inte annars hur jag ska få tag på latinName om det inte ska vara public/protected?
	public String getLatinName(){
		return this.latinName;
	}
	
}
