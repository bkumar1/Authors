package com.keywords.authors.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.keywords.authors.constants.AuthorConstants.*;
import com.keywords.authors.exception.AuthorException;
import com.keywords.authors.model.AuthorRequest;
import com.keywords.authors.model.AuthorResponse;
import com.keywords.authors.service.AuthorService;

/**
 * 
 * @author BrijendraK
 */

@RestController
@RequestMapping(AUTHOR_BASE_URI)
public class AuthorController {
	private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
	@Autowired
	private AuthorService authorService;
	private AuthorResponse authorResponse = null;

	/**
	 * Create Author
	 * @param authorRequest
	 * @return
	 * @throws AuthorException
	 */

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest authorRequest)
			throws AuthorException {
		log.info("createAuthor call Satrt");

		try {
			authorResponse = authorService.createAuthor(authorRequest);
		} catch (Exception ex) {
			throw new AuthorException(ex.getMessage());
		}

		log.info("createAuthor call end");
		return ResponseEntity.ok().body(authorResponse);
	}

	/**
	 * Delete Author
	 * @param authorRequest
	 * @return
	 * @throws AuthorException
	 */
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorResponse> deleteAuthor(@Valid @RequestBody AuthorRequest authorRequest)
			throws AuthorException {
		log.info("deleteAuthor call start");

		try {
			authorResponse = authorService.deleteAuthor(authorRequest);
		} catch (Exception ex) {
			throw new AuthorException(ex.getMessage());
		}

		log.info("deleteAuthor call end");
		return ResponseEntity.ok().body(authorResponse);

	}
	
	/**
	 * Update Author
	 * @param authorRequest
	 * @return
	 * @throws AuthorException
	 */

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorResponse> updateAuthor(@Valid @RequestBody AuthorRequest authorRequest)
			throws AuthorException {
		log.info("updateAuthor call start");

		try {
			authorResponse = authorService.updateAuthor(authorRequest);
		} catch (Exception ex) {
			throw new AuthorException(ex.getMessage());
		}

		log.info("updateAuthor call end");
		return ResponseEntity.ok().body(authorResponse);

	}
	
	/**
	 * 
	 * @param name
	 * @param year
	 * @return
	 * @throws AuthorException
	 */
	@RequestMapping(value=VIEW_BOOKSTITLE_URI,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthorResponse> getBooks(@PathVariable("name") String name,
			@PathVariable("year") String year)
			throws AuthorException {
		log.info("updateAuthor call start");

		try {
			authorResponse = authorService.getBooks(name,year);
		} catch (Exception ex) {
			throw new AuthorException(ex.getMessage());
		}

		log.info("updateAuthor call end");
		return ResponseEntity.ok().body(authorResponse);

	}

}