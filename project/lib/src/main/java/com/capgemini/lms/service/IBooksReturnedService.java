package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.BooksReturned;

public interface IBooksReturnedService {
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned);
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList();
}
