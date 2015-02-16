
public class Snake extends Animal {
	
	private boolean poisounus;
	
	public Snake(String friendlyName, String latinName, boolean poisounus) {
		super(friendlyName, latinName);
		this.poisounus = poisounus;
	}
	public boolean isPoisounus(){
		return poisounus;
	}
	@Override
	public String getInfo() {
		
		String info = "";
		
		if(isPoisounus()){
			info = "Ormen " + this.getFriendlyName() + "/" + this.getLatinName() + " �r giftig." + "\n";
		}else {
			info = "Ormen" + this.getFriendlyName() + "/" + this.getLatinName() + " �r ofarlig" + "\n";
		}
		return info;
	}

}
