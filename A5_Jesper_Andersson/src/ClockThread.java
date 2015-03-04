import java.util.Calendar;

public class ClockThread extends Thread{
	
	private ClockInterface clockInterface;
	
	public ClockThread(ClockInterface cI){
		this.clockInterface = cI;
	}

	public void run(){
		while(true){
			try {
				clockInterface.update(Calendar.getInstance().get(Calendar.HOUR_OF_DAY),Calendar.getInstance().get(Calendar.MINUTE),Calendar.getInstance().get(Calendar.SECOND));
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
