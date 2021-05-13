package com.idols.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import bean.Idols;

public class IdolsdaoImpl implements IIdolsdao{

	@Override
	public Idols add(Idols idol) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(idol);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return idol;
	}

	@Override
	public List<Idols> allidols() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("from Idols");
		List<Idols> idols = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		return idols;
	}

	@Override
	public Idols updateIdol(Idols idol) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Idols idols = em.find(Idols.class, idol.getName());
		idols.setPopularsolo(idol.getPopularsolo());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		return idols;
	}

}
