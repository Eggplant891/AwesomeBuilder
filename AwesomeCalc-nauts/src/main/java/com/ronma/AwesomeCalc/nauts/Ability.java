package com.ronma.AwesomeCalc.nauts;

import java.util.ArrayList;
import java.util.List;

public class Ability {

	private String name;
	
	double damage;
	double cooldown;
	
	List<Effect> effects;
	List<Upgrade> upgrades;
	
	public Ability(String name) {
		effects = new ArrayList<Effect>();
		upgrades = new ArrayList<Upgrade>();
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

	public List<Effect> getEffects() {
		return effects;
	}

	public void setEffects(List<Effect> effects) {
		this.effects = effects;
	}
	
	public void addEffect(Effect e){
		effects.add(e);
	}
	
	
	
}
