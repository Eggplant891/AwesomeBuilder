package com.ronma.AwesomeCalc.nauts;

import java.util.ArrayList;

public class Naut {
	
	private String name;
	private int solarStart;
	private int solarPerMin;
	private int health;
	private double movement;
	private double height;
	private ArrayList<Ability> abilities;
	
	public Naut(String name) {
		this.name = name;
		solarStart = 200;
		solarPerMin = 30;
		abilities = new ArrayList<Ability>();
	}
	
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getSolarPerMin() {
		return solarPerMin;
	}

	public void setSolarPerMin(int solarPerMin) {
		this.solarPerMin = solarPerMin;
	}

	public int getSolarStart() {
		return solarStart;
	}

	public void setSolarStart(int solarStart) {
		this.solarStart = solarStart;
	}

	public double getMovement() {
		return movement;
	}

	public void setMovement(double movement) {
		this.movement = movement;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(ArrayList<Ability> abilities) {
		this.abilities = abilities;
	}
	
	public void addAbility(Ability a){
		abilities.add(a);
	}
	
}
