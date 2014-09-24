package com.evertonmaldonado.exception;

public class CommentFileInitializationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7408154222333911933L;
	
	private static final String DEFAULT_MESSAGE = "Exception initializing the comment file: ";

	public CommentFileInitializationException(){
		super(DEFAULT_MESSAGE);
	}

	public CommentFileInitializationException(String fileName){
		super(DEFAULT_MESSAGE + fileName);
	}

	public CommentFileInitializationException(String fileName, Throwable cause){
		super(DEFAULT_MESSAGE + fileName, cause);
	}

	public CommentFileInitializationException(Throwable cause){
		super(cause);
	}
}