package com.keywords.authors.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.keywords.authors.exception.AuthorException;
import com.keywords.authors.model.AuthorRequest;
import com.keywords.authors.model.AuthorResponse;
import com.keywords.authors.repository.AuthorRepository;
import com.keywords.authors.service.AuthorService;

/**
 * 
 * @author BrijendraK 
 *
 */
@Service
public class AuthorServiceImpl implements AuthorService {
	private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
	@Autowired
	private AuthorRepository repository;
	private AuthorResponse authorResponse;

	

	@Override
	public AuthorResponse createAuthor(AuthorRequest authorRequest) throws AuthorException {

		log.info("Author detail insetion - DB call Start");

		Optional<AuthorRequest> author = repository.findById(authorRequest.getName());

		if (!author.isPresent()) {
			authorRequest = repository.save(authorRequest);
			if (null != authorRequest) {
				authorResponse.setName(authorRequest.getName());
				authorResponse.setMessage("Author created successfully");
				authorResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
				log.info("Author created successfully");
			}
		} else {
			throw new AuthorException("author is not present- not created");
		}

		log.info("Author detail insetion DB call End");
		return authorResponse;
	}

	@Override
	public AuthorResponse deleteAuthor(AuthorRequest authorRequest) throws AuthorException {

		log.info("Author detail delete DB call Start");

		Optional<AuthorRequest> author = repository.findById(authorRequest.getName());
		if (author.isPresent()) {

			repository.delete(author.get());
			authorResponse.setName(authorRequest.getName());
			authorResponse.setMessage("Author deleted successfully");
			authorResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
			log.info("Author deleted successfully");

		} else {
			throw new AuthorException("author is not present- not deleted");
		}

		log.info("Author detail delete DB call End");
		return authorResponse;
	}

	
	@Override
	public AuthorResponse updateAuthor(AuthorRequest authorRequest) throws AuthorException {
		log.info("Author detail update DB call Start");

		Optional<AuthorRequest> author = repository.findById(authorRequest.getName());

		if (author.isPresent()) {

			authorRequest = repository.save(author.get());
			authorResponse.setName(authorRequest.getName());
			authorResponse.setMessage("Author updated successfully");
			authorResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));
			log.info("Author updated successfully");

		} else {
			throw new AuthorException("author is not present- not updated");
		}

		log.info("Author detail update DB call end");
		return authorResponse;

	}

	
	@Override
	public AuthorResponse getBooks(String name, String year) throws AuthorException {
		log.info("get books detail DB call start");
		List<AuthorRequest> booksList = repository.findAll();
		if(!booksList.isEmpty())
		{
			authorResponse.setBooks(booksList);
		}else{
			throw new AuthorException("books is not present- not get");
		}
		log.info("get books detail DB call end");
		return authorResponse;
	}

}
