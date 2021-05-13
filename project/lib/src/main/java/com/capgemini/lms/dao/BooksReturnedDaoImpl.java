package com.capgemini.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.lms.entities.BooksReturned;

public class BooksReturnedDaoImpl implements IBooksReturnedDao {

	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(returned);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return returned;
	}

	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
		BooksReturned booksreturned = new BooksReturned();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		BooksReturned bookreturned = em.find(BooksReturned.class, booksreturned.getId());
		bookreturned.setId(booksreturned.getId());
		bookreturned.setDelayedDays(booksreturned.getDelayedDays());
		bookreturned.setPenalty(booksreturned.getPenalty());
		bookreturned.setPenaltyStatus(booksreturned.getPenaltyStatus());
		bookreturned.setReturnedDate(booksreturned.getReturnedDate());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		return bookreturned;
	}

	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from BooksReturned");
		List<BooksReturned> returnedbooks = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return returnedbooks;
	}

	@Override
	public List<BooksReturned> viewDelayedBooksList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		return null;
	}

}
