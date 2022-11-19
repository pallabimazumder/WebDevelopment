package com.nri;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblBook")
public class Book {
	
	@Id
	@Column(name = "bookID")
	private int bId;
	
	@Column(name = "bookName")
	private String bName;
	
	@Column(name = "bookAuthor")
	private String bAuthor;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bId, String bName, String bAuthor) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	
}
