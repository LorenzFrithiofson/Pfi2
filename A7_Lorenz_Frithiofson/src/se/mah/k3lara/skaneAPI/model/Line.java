package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

public class Line {
	private String line;
	private Calendar depTime;
	private String depTimeDeviation;
	private String stopPoint;
	public Line() {
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Calendar getDepTime() {
		return depTime;
	}
	public void setDepTime(Calendar depTime) {
		this.depTime = depTime;
	}
	public String getDepTimeDeviation() {
		return depTimeDeviation;
	}
	public void setDepTimeDeviation(String depTimeDeviation) {
		this.depTimeDeviation = depTimeDeviation;
	}
	
	public String getStopPoint(){
		return stopPoint;
	}
	
	public void setStopPoint(String stopPoint){
		this.stopPoint = stopPoint;
	}
	//More methods here for the rest of the tags
	//And perhaps some special methods ????
	
}
