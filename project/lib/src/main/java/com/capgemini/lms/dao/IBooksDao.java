package com.capgemini.lms.dao;

import java.util.List;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;

public interface IBooksDao {
	public Books addBook(Books book);
	public Books updateBookDetails(Books book);
	public Books removeBook(int bookid);
	public List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
	public List<Books> searchBookBySubject(String keyword);
	public List<Books> viewAllBooks();
}
