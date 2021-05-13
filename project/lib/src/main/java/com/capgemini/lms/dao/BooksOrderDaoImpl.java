package com.capgemini.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksOrder;

public class BooksOrderDaoImpl implements IBooksOrderDao{

	@Override
	public BooksOrder placeBooksOrder(BooksOrder bookorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(bookorder);		
		em.getTransaction().commit();
		em.close();
		emf.close();
		return bookorder;
	}

	@Override
	public BooksOrder cancelOrder(int orderId) {
		BooksOrder booksorder = new BooksOrder();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BooksOrder cancelorder = em.find(BooksOrder.class, orderId);
		em.remove(cancelorder);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return cancelorder;
	}

	@Override
	public BooksOrder updateOrder(BooksOrder booksorder) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BooksOrder updatebook = em.find(BooksOrder.class, booksorder.getOrderId());
		updatebook.setBooks(booksorder.getBooks());
		updatebook.setQuantity(booksorder.getQuantity());
		updatebook.setOrderDate(booksorder.getOrderDate());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return updatebook;
	}

	@Override
	public List<BooksOrder> viewOrdersList() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from BooksOrder");
		List<BooksOrder> orderedList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return orderedList;
	}

	@Override
	public BooksOrder viewOrderById(int orderId) {
		BooksOrder booksorder = new BooksOrder();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		BooksOrder book = em.find(BooksOrder.class, orderId);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return book;
	}

}
