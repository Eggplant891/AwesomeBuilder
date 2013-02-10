package com.ronma.AwesomeCalc.nauts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UPGRADE")
public class Upgrade {
	
	@Id
	@Column(name = "UPGRADE_ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name = "UPGRADE_NAME")
	private String name;
	
	@Column(name = "UPGRADE_DESCRIPTION")
	String description;
	
	@Column(name = "UPGRADE_ICON")
	String icon;
	
	@Column(name = "UPGRADE_ICON")
	Integer max_rank;
	
	@Column(name = "UPGRADE_ICON")
	Integer solar;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getMax_rank() {
		return max_rank;
	}

	public void setMax_rank(Integer max_rank) {
		this.max_rank = max_rank;
	}

	public Integer getSolar() {
		return solar;
	}

	public void setSolar(Integer solar) {
		this.solar = solar;
	}

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
	

}
