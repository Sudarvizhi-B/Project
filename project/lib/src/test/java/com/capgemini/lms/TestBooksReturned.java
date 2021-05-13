package com.capgemini.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.service.BooksReturnedServiceImpl;
import com.capgemini.lms.service.IBooksReturnedService;

public class TestBooksReturned {
	
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
	
IBooksReturnedService booksReturnedService = new BooksReturnedServiceImpl();
	
	@Test
	
	void testReturnedBooks() {
		BooksReturned returnedbooks = new BooksReturned();
		Books books = new Books();
		returnedbooks.setId(1);
		returnedbooks.setDelayedDays(3);
		returnedbooks.setPenalty(30);
		returnedbooks.setPenaltyStatus("Pending");
		returnedbooks.setReturnedDate(Date.valueOf("2021-05-04"));
		books.setBookid(2);
		returnedbooks.getBooks();
		
		
		BooksReturned booksReturned = booksReturnedService.returnBooks(returnedbooks);
		System.out.println(booksReturned);
		
		assertEquals(3, booksReturned.getDelayedDays());
	}
	
	@Test
	@Disabled
	void testUpdateReturnedBooksDetails() {
		BooksReturned returnedbooks = new BooksReturned();
		returnedbooks.setId(2);
		returnedbooks.setDelayedDays(3);
		returnedbooks.setPenalty(30);
		returnedbooks.setPenaltyStatus("Paid");
		returnedbooks.setReturnedDate(Date.valueOf("2021-05-04"));
		
		
		BooksReturned booksReturned = booksReturnedService.updateReturnedBookDetails(returnedbooks);
		System.out.println(booksReturned);
		
		assertEquals(3, booksReturned.getDelayedDays());
		
	}
	
	@Test
	
	void testReturnedBooksList() {
		
	}
	
	@Test
	@Disabled
	void testDelayedBooksList() {
		
	}


}
