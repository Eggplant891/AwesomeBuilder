package com.ronma.AwesomeCalc.nauts;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "NAUT")
public class Naut {
	
	@Id
	@Column(name = "NAUT_ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "NAUT_NAME")
	private String name;
	
	@Column(name = "NAUT_SOLAR_START")
	private Integer solarStart;
	
	@Column(name = "NAUT_SOLAR_PER_MIN")
	private Integer solarPerMin;
	
	@Column(name = "NAUT_HEALTH")
	private Integer health;
	
	@Column(name = "NAUT_MOVEMENT")
	private double movement;
	
	@Column(name = "NAUT_HEIGHT")
	private double height;
	
	@Column(name = "RESOURCE_IMG_NAME")
	String resImgName;
	
	@OneToMany
	@Column(name = "ABILITY_ID")
	private ArrayList<Ability> abilities;

	@Override
	public String toString() {
		return name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSolarStart() {
		return solarStart;
	}

	public void setSolarStart(Integer solarStart) {
		this.solarStart = solarStart;
	}

	public Integer getSolarPerMin() {
		return solarPerMin;
	}

	public void setSolarPerMin(Integer solarPerMin) {
		this.solarPerMin = solarPerMin;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
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
	
}
