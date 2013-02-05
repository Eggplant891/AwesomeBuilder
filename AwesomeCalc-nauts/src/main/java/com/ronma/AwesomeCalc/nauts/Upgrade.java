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
