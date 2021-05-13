package com.capgemini.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.lms.entities.DamagedBooks;

public class DamagedBooksDaoImpl implements IDamagedBooksDao{

	@Override
	public DamagedBooks addDamagedBooks(DamagedBooks book) {
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
	public DamagedBooks updateDamagedBookDetails(DamagedBooks damagedbooks) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		DamagedBooks damagedbook = em.find(DamagedBooks.class, damagedbooks.getId());
		damagedbook.setDescription(damagedbooks.getDescription());
		damagedbook.setId(damagedbooks.getId());
		damagedbook.setQuantity(damagedbooks.getQuantity());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return damagedbook;
	}

	@Override
	public List<DamagedBooks> viewDamagedBooksList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from DamagedBooks");
		List<DamagedBooks> bookslist = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return bookslist;
	}

	@Override
	public DamagedBooks viewDamagedBookById(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		DamagedBooks damagedbook = em.find(DamagedBooks.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return damagedbook;
	}

}
