package com.capgemini.lms.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BooksReturned {
	
	@Id
	private int id;
	private Date returnedDate;
	private int delayedDays;
	private double penalty;
	private String penaltyStatus;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="books_booksreturned",
			   joinColumns=@JoinColumn(name="book_id"))
	private List<Books> books = new ArrayList<>();

	public BooksReturned(int id, Date returnedDate, int delayedDays, double penalty, String penaltyStatus) {
		super();
		this.id = id;
		this.returnedDate = returnedDate;
		this.delayedDays = delayedDays;
		this.penalty = penalty;
		this.penaltyStatus = penaltyStatus;
	}

	public BooksReturned() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	public int getDelayedDays() {
		return delayedDays;
	}

	public void setDelayedDays(int delayed_Days) {
		this.delayedDays = delayed_Days;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public String getPenaltyStatus() {
		return penaltyStatus;
	}

	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BooksReturned [id=" + id + ", returnedDate=" + returnedDate + ", delayedDays=" + delayedDays
				+ ", penalty=" + penalty + ", penaltyStatus=" + penaltyStatus + "]\n";
	}
	
	
}
