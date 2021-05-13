package com.capgemini.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DamagedBooks {
	@Id
	private int id;
	private int quantity;
	private String description; 
	
	@OneToOne
	@JoinColumn(name = "book_id")
	private Books books;
	
	public DamagedBooks() {}
	
	public DamagedBooks(int id, int quantity, String description, Books books) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.description = description;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Books getBook() {
		return books;
	}

	public void setBook(Books books) {
		this.books = books;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DamagedBooks [id=" + id + ", quantity=" + quantity + ", description=" + description + "]\n";
	}
	
}
