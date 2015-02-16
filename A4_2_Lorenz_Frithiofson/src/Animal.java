
public abstract class Animal {
	private String latinName;
	private String friendlyName;
	
	public Animal(String friendlyName, String latinName){
		this.latinName = latinName;
		this.friendlyName = friendlyName;
		
	}
	
	public String getLatinName() {
		return latinName;
	}
	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	public abstract String getInfo();
}
