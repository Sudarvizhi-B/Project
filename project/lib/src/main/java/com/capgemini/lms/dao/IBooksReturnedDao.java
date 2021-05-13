package com.capgemini.lms.dao;

import java.util.List;

import com.capgemini.lms.entities.BooksReturned;

public interface IBooksReturnedDao {
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned);
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();
}
