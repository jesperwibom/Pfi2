package se.mah.k3lara.skaneAPI.view;

import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class UpdateRunnable implements Runnable{
	
	private String name;
	private GUI gui;
	private String stationID = "80046";
	private static int counter = 0;
	private final int SLEEP_TIME = 3000;
	
	public UpdateRunnable(String name, String stationID, GUI gui){
		this.name = name;
		this.gui = gui;
		this.stationID = stationID;
	}
	
	@Override
	public void run() {
		while(true){
			try{
			
				Lines lines = Parser.getStationResults(new Station(stationID));
				gui.setCurrentLines(lines);
				
				gui.setScreenDepartures();
				
				counter++;
				System.out.println(name+" updated: "+counter);
				Thread.sleep(SLEEP_TIME);
	
			} catch (Exception e){
				
			}
		}
	}
}