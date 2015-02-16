
public class Dog extends Mammal{

	private boolean stupid;
	
	public Dog(String friendlyName, String latinName, int gestationTime, boolean stupid){
		super(friendlyName, latinName, gestationTime);
		this.stupid = stupid;
	}
	
	public boolean isStupid(){
		return stupid;
	}

	@Override
	public String getInfo() {
		
		String info = "";
		
		if(isStupid()){
			info = "Hunden " + this.getFriendlyName() + "/" + this.getLatinName() + " �r dr�ktig i " + this.getGestationTime() + " m�nader och �r inte smart." + "\n";
		}else {
			info = "Hunden" + this.getFriendlyName() + "/" + this.getLatinName() + "�r dr�ktig i " + this.getGestationTime() + " m�nader och �r super smart" + "\n";
		}
		return info;
	}
	
}
