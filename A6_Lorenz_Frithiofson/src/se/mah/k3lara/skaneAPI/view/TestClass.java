package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class TestClass {

	public static void main(String[] args) {
		String searchURL = Constants.getURL("80000","81216",20); //Ber�ttar om start- och slutdestination. Malm� C = 80000,  Lund C, 81216 Malm� Gatorg 80100, H�ssleholm C 93070
		System.out.println(searchURL);
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); //H�mtar alla m�jliga resor och l�gger i en ArrayList.
		for (Journey journey : journeys.getJourneys()) {
			System.out.println(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			System.out.println(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
		
	   System.out.println("// Stations when searching for stations containing \"Malm\"");
		ArrayList<Station> searchStations = new ArrayList<Station>(); //Skapar en ny ArrayList av typen Station.
		searchStations.addAll(Parser.getStationsFromURL("")); //Den hittar alla Stations fr�n Urlet som inneh�ller "Malm" och stoppar in dem i ArrayListan searchStations.
		for (Station s: searchStations){
			System.out.println(s.getStationName() +" number:" +s.getStationNbr());
		}
	}
}

