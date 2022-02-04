package com.demo.jpa.ssc;

public class SSCData {
	
	private int categoryID;
	
	private String keyDesc;
	
	private String keyValue;
	

	public SSCData() {
		super();
	}

	public SSCData(int categoryID, String keyDesc, String keyValue) {
		super();
		this.categoryID = categoryID;
		this.keyDesc = keyDesc;
		this.keyValue = keyValue;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getKeyDesc() {
		return keyDesc;
	}

	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	@Override
	public String toString() {
		return "SSCData [categoryID=" + categoryID + ", keyDesc=" + keyDesc + ", keyValue=" + keyValue + "]";
	}

	
	

}
