import se.mah.k3lara.skaneAPI.xmlparser.Parser;




public class UpdateThread extends Thread{
		private Parser parser;
		private GUI gui;
	
		public UpdateThread(Parser p, GUI g){
			this.parser = p;
			this.gui = g; 
		}	
	public void run(){
		while(true){
	
		try {
			gui.updateTimes();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		}
		
	}
	
}
