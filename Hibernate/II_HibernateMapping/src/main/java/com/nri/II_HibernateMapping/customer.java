package com.nri.II_HibernateMapping;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	@JoinColumn(name = "ordid")
	private Orders order;             //creating the foreign key
	
	
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
