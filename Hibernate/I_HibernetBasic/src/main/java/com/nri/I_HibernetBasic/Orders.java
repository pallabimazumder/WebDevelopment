package com.nri.I_HibernetBasic;

import javax.persistence.Embeddable;

@Embeddable
public class Orders {
	
	private int ordId;
	private String ordName;
	private int ordPrice;
	
	
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
