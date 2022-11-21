package com.nri.VII_HibernateNativeQuery;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {
	
	@Id
	private int libId;
	private String libName;
	private double libFees;
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLibId() {
		return libId;
	}
	public void setLibId(int libId) {
		this.libId = libId;
	}
	public String getLibName() {
		return libName;
	}
	public void setLibName(String libName) {
		this.libName = libName;
	}
	public double getLibFees() {
		return libFees;
	}
	public void setLibFees(double libFees) {
		this.libFees = libFees;
	}
	@Override
	public String toString() {
		return "Library [libId=" + libId + ", libName=" + libName + ", libFees=" + libFees + "]";
	}
	
	
}
