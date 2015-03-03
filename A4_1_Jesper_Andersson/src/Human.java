
public class Human {
	
	private Dog dog;
	private String name;
	
	public Human(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//setDog är ett lämpligare namn...
	public void buyDog(Dog dog){
		
	}
	
	//getDog är ett lämpligare namn
	public String getInfo(){
		
		return dog.getDogName();
	}
	
}
