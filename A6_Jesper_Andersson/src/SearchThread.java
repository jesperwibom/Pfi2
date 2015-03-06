import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;


public class SearchThread extends Thread{
	
	private SearchGUI GUI;
	private String search;
	private String from;
	private String to;
	
	public SearchThread(SearchGUI GUI, String search){
		this.search = search;
		this.GUI = GUI;
	}
	
	public SearchThread(SearchGUI GUI, String from, String to){
		this.from = from;
		this.to = to;
		this.GUI = GUI;
	}
	
	public void run(){
		if(search == null){
			String search = Constants.getURL(from, to, 1);
			Journeys journeys = Parser.getJourneys(search);
			ArrayList<Journey> list = journeys.getJourneys();
			GUI.setJourneyText(list.get(0));
		} else {
			GUI.setStationText(Parser.getStationsFromURL(search));
		}
	}
}
