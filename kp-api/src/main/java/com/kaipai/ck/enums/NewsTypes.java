package com.kaipai.ck.enums;

public enum NewsTypes {

	WEEK("WEEK-NEWS"),
	OFFIC("OFFIC-NEWS"),
	PROF("PROF-NEWS"),
	ACT("ACT-NEWS"),
	STOCK("STOCK-NEWS"),
	MOVIE("MOVIE-NEWS");
	
	private String value;
	
	private NewsTypes(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
