package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;

public interface IBookService {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book) throws BookNotFoundException;
	public Books removeBook(int bookid) throws BookNotFoundException;
	public List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
	public List<Books> searchBookBySubject(String keyword) throws BookNotFoundException;
	public List<Books> viewAllBooks();
}
