package com.nri;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblLibrary")
public class Library {
	
	@Id
	@Column(name = "libraryId")
	private int libId;
	
	@Column(name = "libraryName")
	private String libName;
	
	@Column(name = "libraryFees")
	private int libFees;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Book> books;
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Library(int libId, String libName, int libFees, List<Book> books) {
		super();
		this.libId = libId;
		this.libName = libName;
		this.libFees = libFees;
		this.books = books;
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

	public int getLibFees() {
		return libFees;
	}

	public void setLibFees(int libFees) {
		this.libFees = libFees;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Library [libId=" + libId + ", libName=" + libName + ", libFees=" + libFees + ", books=" + books + "]";
	}
	

}
