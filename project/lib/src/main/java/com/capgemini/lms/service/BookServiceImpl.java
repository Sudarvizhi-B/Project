package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dao.BooksDaoImpl;
import com.capgemini.lms.dao.IBooksDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;

public class BookServiceImpl implements IBookService {
	IBooksDao bookDao = new BooksDaoImpl();
	@Override
	public Books addBook(Books book) {
		return bookDao.addBook(book);
	}

	@Override
	public Books updateBookDetails(Books book) throws BookNotFoundException {
		if(bookDao.updateBookDetails(book) == null) {
			throw new BookNotFoundException("Book not found");
		}
		return bookDao.updateBookDetails(book);
	}

	@Override
	public Books removeBook(int bookid) throws BookNotFoundException {
		if(bookDao.removeBook(bookid) == null) {
			throw new BookNotFoundException("Book not found");
		}
		return bookDao.removeBook(bookid);
	}

	@Override
	public List<Books> searchBookByTitle(String keyword) throws BookNotFoundException {
		if(bookDao.searchBookByTitle(keyword) == null) {
			throw new BookNotFoundException("Book not found");
		}
		return bookDao.searchBookByTitle(keyword);
	}

	@Override
	public List<Books> searchBookBySubject(String keyword) throws BookNotFoundException {
		if(bookDao.searchBookBySubject(keyword) == null) {
			throw new BookNotFoundException("Book not found");
		}
		return bookDao.searchBookBySubject(keyword);
	}

	@Override
	public List<Books> viewAllBooks() {
		return bookDao.viewAllBooks();
	}

}
