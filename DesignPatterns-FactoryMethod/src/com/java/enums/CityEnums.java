package com.java.enums;

public enum CityEnums {	
	
	Bangalore("Bangalore","IT City","Traffic"),
	Hassan("Hassan","MCF","Nature");
	
	
	CityEnums(String city, String known, String famous) {
		this.cityName=city;
		this.knownFor=known;
		this.famousFor=famous;		
	}

	private String cityName;
	
	private String knownFor;
	
	private String famousFor;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getKnownFor() {
		return knownFor;
	}

	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}

	public String getFamousFor() {
		return famousFor;
	}

	public void setFamousFor(String famousFor) {
		this.famousFor = famousFor;
	} 

}
