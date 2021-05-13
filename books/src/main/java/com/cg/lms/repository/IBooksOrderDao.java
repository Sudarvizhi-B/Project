package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.lms.entity.BooksOrder;

@RepositoryRestResource(collectionResourceRel="booksorder", path="booksorder")
public interface IBooksOrderDao extends JpaRepository<BooksOrder, Integer> {
	
	@Query(value = "select * from books_order where book_id=:bookId", nativeQuery=true)
	BooksOrder findBooksOrderByBookId(@Param("bookId") int bookId);
}
