package com.nri.I_HibernetBasic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "tblcustomer")
public class customer {
	
	@Id
	@Column(name = "customerid")
	private int custid;
	
	@Column(name = "customername")
	private String custname;
	
	@Column(name = "customercity")
	private String custcity;
	
	private Orders order;
	
	
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustcity() {
		return custcity;
	}
	public void setCustcity(String custcity) {
		this.custcity = custcity;
	}
	
	
	@Override
	public String toString() {
		return "customer [custid=" + custid + ", custname=" + custname + ", custcity=" + custcity + "]";
	}
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
	
	
}
