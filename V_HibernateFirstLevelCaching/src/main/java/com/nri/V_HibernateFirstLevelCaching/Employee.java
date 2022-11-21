package com.nri.V_HibernateFirstLevelCaching;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable 
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Employee {
	
	
	@Id       //primary key
	private int empid;
	private String empname;
	private String empcity;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpcity() {
		return empcity;
	}
	public void setEmpcity(String empcity) {
		this.empcity = empcity;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empcity=" + empcity + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
