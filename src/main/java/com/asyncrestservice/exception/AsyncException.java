package com.asyncrestservice.exception;

/**
 * @author Kalidass Mahalingam
 *
 */
public class AsyncException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AsyncException() {
		super();
	}

	public AsyncException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AsyncException(String message, Throwable cause) {
		super(message, cause);
	}

	public AsyncException(String message) {
		super(message);
	}

	public AsyncException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}

}
