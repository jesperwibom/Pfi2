import java.util.Calendar;

public class ClockThread extends Thread{
	
	private ClockInterface clockInterface;
	
	public ClockThread(ClockInterface cI){
		clockInterface = cI;
	}

	public void run(){
		while(true){
			try {
				Calendar calendar = Calendar.getInstance();
				clockInterface.update(calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
				Thread.sleep(900);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
