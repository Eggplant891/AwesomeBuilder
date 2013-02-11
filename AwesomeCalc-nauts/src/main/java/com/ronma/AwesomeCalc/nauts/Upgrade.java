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
	
	@Column(name = "MAX_RANK")
	Integer max_rank;
	
	@Column(name = "SOLAR_COST")
	Integer solar;

	@Column(name = "RESOURCE_IMG_NAME")
	String resImgName;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getResImgName() {
		return resImgName;
	}

	public void setResImgName(String resImgName) {
		this.resImgName = resImgName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
