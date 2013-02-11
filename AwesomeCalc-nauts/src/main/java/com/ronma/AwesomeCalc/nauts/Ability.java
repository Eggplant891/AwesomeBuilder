package com.ronma.AwesomeCalc.nauts;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ABILITY")
public class Ability {

	@Id
	@Column(name = "ABILITY_ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ABILITY_NAME")
	private String name;
	
	@Column(name = "ABILITY_DAMAGE")
	double damage;
	
	@Column(name = "ABILITY_DURATION")
	double duration;
	
	@Column(name = "ABILITY_COOLDOWN")
	double cooldown;
	
	@Column(name = "RESOURCE_IMG_NAME")
	String resImgName;
	
	@ManyToOne
	@JoinColumn(name = "NAUT_ID")
	private Naut naut;
	
	@ManyToMany
	@JoinTable(name="ABILITY_UPGRADES",
		joinColumns={@JoinColumn(name="ABILITY_ID")},
		inverseJoinColumns={@JoinColumn(name="UPGRADE_ID")})
	List<Upgrade> upgrades;

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

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getCooldown() {
		return cooldown;
	}

	public void setCooldown(double cooldown) {
		this.cooldown = cooldown;
	}

	public String getResImgName() {
		return resImgName;
	}

	public void setResImgName(String resImgName) {
		this.resImgName = resImgName;
	}

	public Naut getNaut() {
		return naut;
	}

	public void setNaut(Naut naut) {
		this.naut = naut;
	}

	public List<Upgrade> getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(List<Upgrade> upgrades) {
		this.upgrades = upgrades;
	}
	
	
}
