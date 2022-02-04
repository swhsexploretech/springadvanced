package com.design.pattern.factory.method;

public class Factory {

	public IPerson getPerson(String type) { 	
		switch(type){ 
			case "Urban":
				return new CityPerson();
			case "Rural":
				return new Villager();
			default:
				return new CityPerson();
		} 
	}
}


