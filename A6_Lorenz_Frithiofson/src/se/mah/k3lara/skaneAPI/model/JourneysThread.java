package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;




import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.view.SearchGUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {
	
	private Parser parser;
	private SearchGUI gui;
	
	public JourneysThread(Parser p, SearchGUI g) {
		this.parser = p;
		this.gui = g;
	}
	@Override
	public void run(){
		
		gui.searchresult.setText("Searching.....\n");
		
		String searchURL = Constants.getURL(gui.från.getText() + "",gui.till.getText(),1);
		Journeys journeys = Parser.getJourneys(searchURL);
		gui.searchresult.setText(null);
		
		for (Journey journey : journeys.getJourneys()) {
			gui.searchresult.setText(journey.getStartStation()+" - ");
			gui.searchresult.append(journey.getEndStation()+ "");
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			gui.searchresult.append("\nDeparts " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. \nAnd it is "+journey.getDepTimeDeviation()+" min late");
		} 
	}
	
}
