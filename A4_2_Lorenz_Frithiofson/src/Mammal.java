
public abstract class Mammal extends Animal{
	
	private int gestationTime;

	public Mammal(String friendlyName, String latinName, int gestationTime){
		super(friendlyName, latinName);
		this.gestationTime = gestationTime;
	}
	
	public int getGestationTime(){
		return gestationTime;
	}

	@Override
	public String getInfo() {

		return null;
	}

}
