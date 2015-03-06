package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;



import se.mah.k3lara.skaneAPI.view.SearchGUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread {
	private Parser parser;
	private SearchGUI gui;

	public StationsThread(Parser p,SearchGUI g) {
		this.parser = p;
		this.gui = g;
	}
	@Override
	public void run(){
		
		gui.searchStations = new ArrayList<Station>();
		
		gui.textArea.setText("Searching.....");
		
		gui.searchStations.addAll(Parser.getStationsFromURL(gui.sökSträng.getText()));
		gui.textArea.setText(null);
		for (Station s: gui.searchStations){
			gui.textArea.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
	}
	}
}
