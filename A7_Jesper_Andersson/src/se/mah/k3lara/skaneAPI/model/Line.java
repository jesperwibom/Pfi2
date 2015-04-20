package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

public class Line {
	private String line;	//lineNo
	private Calendar depTime;
	private String depTimeDeviation;
	private String lineType;
	private String destination;
	private String runNo;
	
	
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
	public String getLineType() {
		return lineType;
	}
	public void setLineType(String lineType) {
		this.lineType = lineType;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String towards) {
		this.destination = towards;
	}
	public String getRunNo() {
		return runNo;
	}
	public void setRunNo(String runNo) {
		this.runNo = runNo;
	}
	
	
	//getTimeToDeparture
	
	//More methods here for the rest of the tags
	//And perhaps some special methods ????
	
}
