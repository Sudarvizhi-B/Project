package com.cg.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.lms.entity.Books;

@RepositoryRestResource(collectionResourceRel="books", path="books")
public interface IBooksDao extends JpaRepository<Books, Integer>{
	
	List<Books> findAllByTitle(String title);
	
	List<Books> findAllBySubject(String subject);
}
