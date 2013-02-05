package com.ronma.AwesomeCalc.nauts;

public class Upgrade {
	
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
