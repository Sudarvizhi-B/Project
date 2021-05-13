package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dao.BooksReturnedDaoImpl;
import com.capgemini.lms.dao.IBooksReturnedDao;
import com.capgemini.lms.entities.BooksReturned;

public class BooksReturnedServiceImpl implements IBooksReturnedService{
	IBooksReturnedDao booksReturnedDao = new BooksReturnedDaoImpl();
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		return booksReturnedDao.returnBooks(returned);
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
		return booksReturnedDao.updateReturnedBookDetails(booksReturned);
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		return booksReturnedDao.viewReturnedBooksList();
	}

	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		return booksReturnedDao.viewDelayedBooksList();
	}

}
