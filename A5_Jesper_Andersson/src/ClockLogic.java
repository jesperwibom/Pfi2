
public class ClockLogic implements ClockInterface{
	
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	
	public ClockLogic(DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		Thread cThread = new ClockThread(this);
		cThread.start();
	}
	
	public void setAlarm(int hours, int minutes){
		
	}
	
	public void clearAlarm(){
		
	}
	
	public void update(int hourIn, int minuteIn, int secondIn){
		
	}
}