package com.capgemini.lms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.annotations.Parameter;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;

public class BooksDaoImpl implements IBooksDao {

	@Override
	public Books addBook(Books book) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return book;
	}

	@Override
	public Books updateBookDetails(Books books) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Books book = em.find(Books.class, books.getBookid());
		book.setBookid(books.getBookid());
		book.setAuthor(books.getAuthor());
	    book.setIsbn_code(books.getIsbn_code());
	    book.setPublished_year(books.getPublished_year());
	    book.setQuantity(books.getQuantity());
	    book.setShelf_details(books.getShelf_details());
	    book.setSubject(books.getSubject());
	    book.setTitle(books.getTitle());
		book.setBook_cost(books.getBook_cost());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return book;
	}

	@Override
	public Books removeBook(int bookid) {
		Books book = new Books();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Books findbook = em.find(Books.class, bookid);
		em.remove(findbook);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return book;
	}

	@Override
	public List<Books> searchBookByTitle(String title) throws BookNotFoundException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select t from Books where t.title = :title");
		em.setProperty(title, query);
		List<Books> books = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return books;
	}

	@Override
	public List<Books> searchBookBySubject(String subject) {
		Books book = new Books();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery(("select s from books where s.subject = :subject"));
		em.setProperty(subject, query);
		List<Books> books = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return books;
	}

	@Override
	public List<Books> viewAllBooks() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("from Books");
		List<Books> books = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return books;
	}

}
