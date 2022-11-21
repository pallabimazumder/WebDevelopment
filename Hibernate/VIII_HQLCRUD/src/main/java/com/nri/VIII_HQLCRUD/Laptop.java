package com.nri.VIII_HQLCRUD;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Laptop {
	
	@Id
	private int lapId;
	private String lapName;
	
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", lapName=" + lapName + "]";
	}
	
	

}
