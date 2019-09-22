package com.keywords.authors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keywords.authors.model.AuthorRequest;
/**
 * 
 * @author BrijendraK
 *
 */
public interface AuthorRepository extends JpaRepository<AuthorRequest, String>{

}
