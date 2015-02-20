
public class ClockLogic implements ClockInterface{
	
	private DigitalClockGUI ClockGUI;
	private int alarmHours;
	private int alarmMinutes;
	private int hours;
	private int minutes;
	
		public ClockLogic(DigitalClockGUI clockIn) {
			this.ClockGUI = clockIn;
			
			Thread t = new ClockThread(this);
			t.start();
		}
		
		public void setAlarm(int hours, int minutes){
			this.alarmHours = hours;
			this.alarmMinutes = minutes;
		}
		
		public void clearAlarm(){
			this.alarmHours = 0;
			this.alarmMinutes = 0;
		}

		@Override
		public void update(int hours, int minutes, int seconds) {
			String time = "";
			time = (String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
			
			ClockGUI.setTimeOnLabel(time);
			
			if (alarmHours == hours && alarmMinutes == minutes){
				ClockGUI.alarm(true);
			} else{
				ClockGUI.alarm(false);
			}
			
			
		}

}


