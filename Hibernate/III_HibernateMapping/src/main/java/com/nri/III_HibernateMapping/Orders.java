package com.nri.III_HibernateMapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "tblorders")
public class Orders {
	
	
	@Id
	@Column(name="orderid")
	private int ordId;
	
	@Column(name = "ordername")
	private String ordName;
	
	@Column(name = "orderprice")
	private int ordPrice;
	
	@ManyToOne
	private customer customers; 
	
	public customer getCustomers() {
		return customers;
	}


	public void setCustomers(customer customers) {
		this.customers = customers;
	}

	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOrdId() {
		return ordId;
	}


	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}


	public String getOrdName() {
		return ordName;
	}


	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}


	public int getOrdPrice() {
		return ordPrice;
	}


	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}


	@Override
	public String toString() {
		return "Orders [ordId=" + ordId + ", ordName=" + ordName + ", ordPrice=" + ordPrice + "]";
	}
	
	
	
}
