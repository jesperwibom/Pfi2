import java.util.Calendar;

public class ClockThread extends Thread{
	
	private ClockInterface clockInterface;
	private Calendar calendar;
	
	public ClockThread(ClockInterface cI){
		clockInterface = cI;
	}
	
	
	//fungerar inte ännu, fortsätt här imorgon.
	public void run(){
		while(true){
			calendar.get(0);
			clockInterface.update(0,0,0);
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}