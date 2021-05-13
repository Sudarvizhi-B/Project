package com.capgemini.lms.dao;

import java.util.List;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;

public interface IBooksOrderDao {
	public BooksOrder placeBooksOrder(BooksOrder book);
	public BooksOrder cancelOrder(int orderId);
	public BooksOrder updateOrder(BooksOrder booksorder);
	public List<BooksOrder> viewOrdersList();
	public BooksOrder viewOrderById(int orderId);
}
