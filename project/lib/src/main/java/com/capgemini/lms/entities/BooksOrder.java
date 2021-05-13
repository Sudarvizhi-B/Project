package com.capgemini.lms.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BooksOrder {
	@Id
	private int orderId;
	private int quantity;
	private Date orderDate;
	private String orderStatus;
	
	@OneToOne
	@JoinColumn(name = "book_id")
	private Books books;
	
	public BooksOrder() {}
	
	public BooksOrder(int orderId, int quantity, Date orderDate, String orderStatus, Books books) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.books = books;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "BooksOrder [orderId=" + orderId + ", quantity=" + quantity + ", orderDate="
				+ orderDate + ", orderStatus=" + orderStatus + "]\n";
	}

}
