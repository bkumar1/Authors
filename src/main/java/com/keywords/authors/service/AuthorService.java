package com.keywords.authors.service;

import org.springframework.data.jpa.repository.Query;

import com.keywords.authors.exception.AuthorException;
import com.keywords.authors.model.AuthorRequest;
import com.keywords.authors.model.AuthorResponse;

/**
 * @author BrijendraK
 *
 */
public interface AuthorService {

	public AuthorResponse createAuthor(AuthorRequest authorRequest) throws AuthorException;
	public AuthorResponse deleteAuthor(AuthorRequest authorRequest) throws AuthorException;
	public AuthorResponse updateAuthor(AuthorRequest authorRequest) throws AuthorException;
	@Query("SELECT A.titile FROM AuthorRequest A  WHERE A.name= (:name) and A.year=(:year)")
	public AuthorResponse getBooks(String name, String year) throws AuthorException;

}
