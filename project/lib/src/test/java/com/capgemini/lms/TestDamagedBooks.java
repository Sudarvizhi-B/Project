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
import com.capgemini.lms.entities.DamagedBooks;
import com.capgemini.lms.service.DamagedBooksServiceImpl;
import com.capgemini.lms.service.IDamagedBooksService;

public class TestDamagedBooks {
	
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
	
	IDamagedBooksService damagedBookService = new DamagedBooksServiceImpl();
	
	@Test
	@Disabled
	void testAddDamagedBook() {
		DamagedBooks damagedbook = new DamagedBooks();
		Books book = new Books();
		book.setBookid(2);
		damagedbook.setBook(book);
		damagedbook.setId(2);
		damagedbook.setBook(book);
		damagedbook.setQuantity(3);
		damagedbook.setDescription("Pages Not Sequencial");
		DamagedBooks damaged = damagedBookService.addDamagedBooks(damagedbook);
		System.out.println(damaged);
		
		assertEquals(3, damaged.getQuantity());
		
		}
	
	@Test
	@Disabled
	void testUpdateDamagedBookDetails() {
		DamagedBooks damagedbook = new DamagedBooks();
		damagedbook.setId(1);
		damagedbook.setQuantity(3);
		damagedbook.setDescription("Tore");
		DamagedBooks damaged = damagedBookService.updateDamagedBookDetails(damagedbook);
		System.out.println(damaged);
		
		assertEquals("Tore", damaged.getDescription());
	}
	
	@Test
	@Disabled
	void testViewDamagedBookList() {
		List<DamagedBooks> listofbooks = damagedBookService.viewDamagedBooksList();
		System.out.println(listofbooks);
		
		assertEquals(2, listofbooks.size());
	}
	
	@Test
	@Disabled
	void testViewDamagedBookById() {
		DamagedBooks damagedbook = damagedBookService.viewDamagedBookById(2);
		System.out.println(damagedbook);
		
		assertEquals(1, damagedbook.getQuantity());
	}
	

}
