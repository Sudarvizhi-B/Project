package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dao.DamagedBooksDaoImpl;
import com.capgemini.lms.dao.IDamagedBooksDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;

public class DamagedBooksServiceImpl implements IDamagedBooksService{
	IDamagedBooksDao damagedbooksdao = new DamagedBooksDaoImpl();
	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks book) {
		return damagedbooksdao.addDamagedBooks(book);
	}

	@Override
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedbooks) {
		return damagedbooksdao.updateDamagedBookDetails(damagedbooks);
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		return damagedbooksdao.viewDamagedBooksList();
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) {
		return damagedbooksdao.viewDamagedBookById(id);
	}

}
