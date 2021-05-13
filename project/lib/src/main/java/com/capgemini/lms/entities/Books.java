package com.capgemini.lms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Books {
	@Id
	private int bookid;
	private String title;
	private String subject;
	private String author;
	private int published_year;
	private String isbn_code;
	private int quantity;
	private double book_cost;
	private String shelf_details;
	
	@OneToOne(mappedBy = "books")
	private BooksOrder booksorder;
	
	@OneToOne(mappedBy="books")
	private DamagedBooks damagedbooks;
	
	//@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinColumn(name="id")
	//private List<BooksReturned> booksreturned;

	public Books() {}

	public Books(int bookid, String title, String subject, String author, int published_year, String isbn_code,
			int quantity, double book_cost, String shelf_details) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.published_year = published_year;
		this.isbn_code = isbn_code;
		this.quantity = quantity;
		this.book_cost = book_cost;
		this.shelf_details = shelf_details;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public String getIsbn_code() {
		return isbn_code;
	}

	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBook_cost() {
		return book_cost;
	}

	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}

	public String getShelf_details() {
		return shelf_details;
	}

	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}

	public BooksOrder getBooksorder() {
		return booksorder;
	}

	public void setBooksorder(BooksOrder booksorder) {
		this.booksorder = booksorder;
	}

	public DamagedBooks getDamagedbooks() {
		return damagedbooks;
	}

	public void setDamagedbooks(DamagedBooks damagedbooks) {
		this.damagedbooks = damagedbooks;
	}
	/*
	public List<BooksReturned> getBooksreturned() {
		return booksreturned;
	}

	public void setBooksreturned(List<BooksReturned> booksreturned) {
		this.booksreturned = booksreturned;
	}
	*/
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", subject=" + subject + ", author=" + author
				+ ", published_year=" + published_year + ", isbn_code=" + isbn_code + ", quantity=" + quantity
				+ ", book_cost=" + book_cost + ", shelf_details=" + shelf_details + "]\n";
	}
	
}
