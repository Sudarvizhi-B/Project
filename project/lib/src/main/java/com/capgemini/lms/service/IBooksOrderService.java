package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.entities.BooksOrder;

public interface IBooksOrderService {
	public BooksOrder placeBooksOrder(BooksOrder book);
	public BooksOrder cancelOrder(int orderId);
	public BooksOrder updateOrder(BooksOrder order);
	public List<BooksOrder> viewOrdersList();
	public BooksOrder viewOrderById(int orderId);
}
