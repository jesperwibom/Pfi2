
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
		this.dog = new Dog(dog.getDogName());
	}
	
	//getDog är ett lämpligare namn
	public String getInfo(){
		String info;
		if(dog != null){
			info = (this.name+" has a dog called "+dog.getDogName()+".");
			
		} else {
			info = (this.name+" has no dog!");
		}
		return info;
	}
	
}
