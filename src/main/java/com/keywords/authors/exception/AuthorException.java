package com.keywords.authors.exception;

/**
 * @author BrijendraK
 *
 */
public class AuthorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param exception
	 */
	public AuthorException(String exception) {
		super(exception);
	}

}