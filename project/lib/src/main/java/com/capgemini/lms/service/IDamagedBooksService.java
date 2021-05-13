package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.DamagedBooks;

public interface IDamagedBooksService {
	public DamagedBooks addDamagedBooks(DamagedBooks book);
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedbooks);
	public List<DamagedBooks> viewDamagedBooksList();
	public DamagedBooks viewDamagedBookById(int id);
}
