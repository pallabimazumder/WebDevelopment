package com.nri.III_HibernateMapping;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)    //cascade --> any changes in parent table will change the child table also

	private List<Orders> order;             //creating the foreign key

	
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
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> listOrd) {
		this.order = (List<Orders>) listOrd;
	}
	
}
