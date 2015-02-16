
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
			info = "Hunden " + this.getFriendlyName() + "/" + this.getLatinName() + " är dräktig i " + this.getGestationTime() + " månader och är inte smart." + "\n";
		}else {
			info = "Hunden" + this.getFriendlyName() + "/" + this.getLatinName() + "är dräktig i " + this.getGestationTime() + " månader och är super smart" + "\n";
		}
		return info;
	}
	
}
