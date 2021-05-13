package com.capgemini.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.service.BookServiceImpl;
import com.capgemini.lms.service.IBookService;

public class TestBooks {
	
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

	IBookService bookService = new BookServiceImpl();
	
	@Test
	@Disabled
	void testAddBook() {
		Books book = new Books();
		book.setBookid(4);
		book.setAuthor("A.Nagoor Kani");
		book.setIsbn_code("976-6-10-181502-8");
		book.setBook_cost(1000);
		book.setPublished_year(2019);
		book.setQuantity(18);
		book.setShelf_details("Shelf 4");
		book.setSubject("Control Systems");
		book.setTitle("Control Systems Engineering");
		
		Books persistedbook = bookService.addBook(book);
		System.out.println(persistedbook);
		
		assertEquals("A.Nagoor Kani",book.getAuthor());
		assertEquals(1000,book.getBook_cost());
		assertEquals("Shelf 4", book.getShelf_details());
	}
	
	@Test
	@Disabled
	void testUpdateBookDetails() throws BookNotFoundException {
		Books book = new Books();
		book.setBookid(3);
		book.setAuthor("Anastasia H. Cortes");
		book.setIsbn_code("765-1-15-150218-5");
		book.setBook_cost(1300);
		book.setPublished_year(2015);
		book.setQuantity(13);
		book.setShelf_details("Shelf 2");
		book.setSubject("Business & Management");
		book.setTitle("Principles of Management");
		Books updatebook = bookService.updateBookDetails(book);
		System.out.println(updatebook);
		
		assertEquals("Shelf 2", book.getShelf_details());
		
	}
	
	@Test
	@Disabled
	void testRemoveBook() throws BookNotFoundException {
		Books book = new Books();
		Books deletebook = bookService.removeBook(1);
		System.out.println(deletebook);
		
		assertEquals(1, book.getBookid());
	}
	
	@Test
	@Disabled
	void testSearchBookByTitle() throws BookNotFoundException{
		List<Books> searchingbook = bookService.searchBookByTitle("Principles of Management");
		System.out.println(searchingbook);
			
		assertEquals(2, searchingbook.size());
	}
	
	@Test
	
	void testSearchBookBySubject() throws BookNotFoundException {
		List<Books> searchingbook = bookService.searchBookBySubject("Fiction");
		System.out.println(searchingbook);
		
		assertEquals(1, searchingbook.size());
	}
	
	@Test
	@Disabled
	void testViewAllBooks() {
		List<Books> allbooks = bookService.viewAllBooks();
		System.out.println(allbooks);
		
		assertEquals(4, allbooks.size());
	}
	

}
