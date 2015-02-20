import java.util.Calendar;


public class ClockThread extends Thread {
	private ClockInterface clockInterface;
	
	public ClockThread(ClockInterface clockInterface){
		this.clockInterface = clockInterface;
		
		
	}
	
	@Override
	public void run(){
		while(true){
			
			Calendar calendar =  Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			
			
			clockInterface.update(hour, minute, second);
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}
}
