
public class Human {
	
	private Dog dog;
	private String name;
	
	public Human(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public Dog buyDog(){
		return dog;
	}
	
	public String getInfo(){
		String info = "info";
		return info;
	}
	
}
