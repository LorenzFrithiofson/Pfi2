
public class Cat extends Mammal{

	private int numberOfLifes;
	
	public Cat(String friendlyName, String latinName, int gesetationTime, int numberOfLifes){
		super(friendlyName, latinName, gesetationTime);
		this.numberOfLifes = numberOfLifes;
		
	}
	
	public int getNumberOfLifes(){
		return numberOfLifes;
	}

	public int setNumberOfLifes(){
		return numberOfLifes;
	}

	@Override
	public String getInfo() {
		
		String info = "";
		
		info = "Katten " + this.getFriendlyName() + "/" + this.getLatinName() + " är dräktig i " + this.getGestationTime() + " månader och har " + this.getNumberOfLifes() + " liv." + "\n";
		
		return info;
	}
	
}
