package com.cg.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.lms.entity.DamagedBooks;

@RepositoryRestResource(collectionResourceRel="damagedbooks", path="damagedbooks")
public interface IDamagedBooksDao extends JpaRepository<DamagedBooks, Integer> {

}
