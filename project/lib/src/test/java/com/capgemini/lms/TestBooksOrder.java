package com.capgemini.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;
import com.capgemini.lms.service.BooksOrderserviceImpl;
import com.capgemini.lms.service.IBooksOrderService;

public class TestBooksOrder {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("teardown");
	}
	
	IBooksOrderService booksOrderService = new BooksOrderserviceImpl();
	
	@Test
	@Disabled
	void testPlaceBooksOrder() {
		BooksOrder booksorder = new BooksOrder();
		Books book = new Books();
		book.setBookid(2);
		booksorder.setBooks(book);
		booksorder.setOrderId(2);
		Date orderdate = Date.valueOf("2021-04-26");
		booksorder.setOrderDate(orderdate);
		booksorder.setOrderStatus("Ordered");
		booksorder.setQuantity(20);
		
		BooksOrder orderedbooks = booksOrderService.placeBooksOrder(booksorder);
		System.out.println(orderedbooks);
		assertEquals("Ordered", booksorder.getOrderStatus());
	}
	
	@Test
	@Disabled
	void testCancelOrder() {
		BooksOrder booksorder = new BooksOrder();
		BooksOrder cancelorder = booksOrderService.cancelOrder(3);
		System.out.println(cancelorder);
		
		assertEquals(15, booksorder.getQuantity());
	}
	
	@Test
	@Disabled
	void testUpdateOrder() {
		BooksOrder booksorder = new BooksOrder();
		booksorder.setOrderId(1);
		Date orderdate = Date.valueOf("2021-04-26");
		booksorder.setOrderDate(orderdate);
		booksorder.setOrderStatus("Ordered");
		booksorder.setQuantity(12);
		
		BooksOrder orderedbooks = booksOrderService.updateOrder(booksorder);
		System.out.println(orderedbooks);
		
		assertEquals(1,booksorder.getOrderId());
	}
	
	@Test
	@Disabled
	void testViewOrdersList() {
		List<BooksOrder> orderlist = booksOrderService.viewOrdersList();
		System.out.println(orderlist);
		assertEquals(4,orderlist.size());
	}
	
	@Test
	@Disabled
	void testViewOrderById() {
		BooksOrder orderbyId = booksOrderService.viewOrderById(1);
		System.out.println(orderbyId);
		assertEquals("Delivered",orderbyId.getOrderStatus());
	}
	

}
