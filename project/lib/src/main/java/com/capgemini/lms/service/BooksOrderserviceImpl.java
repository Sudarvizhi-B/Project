package com.capgemini.lms.service;

import java.util.List;

import com.capgemini.lms.dao.BooksOrderDaoImpl;
import com.capgemini.lms.dao.IBooksOrderDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;

public class BooksOrderserviceImpl implements IBooksOrderService {
	IBooksOrderDao booksOrderdao = new BooksOrderDaoImpl();
	@Override
	public BooksOrder placeBooksOrder(BooksOrder book) {
		return booksOrderdao.placeBooksOrder(book);
	}

	@Override
	public BooksOrder cancelOrder(int orderId) {
		return booksOrderdao.cancelOrder(orderId);
	}

	@Override
	public BooksOrder updateOrder(BooksOrder order) {
		return booksOrderdao.updateOrder(order);
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		return booksOrderdao.viewOrdersList();
	}

	@Override
	public BooksOrder viewOrderById(int orderId) {
		return booksOrderdao.viewOrderById(orderId);
	}

}
