package com.evertonmaldonado.exception;

public class FileInitializationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7408154222333911933L;
	
	private static final String DEFAULT_MESSAGE = "Exception initializing the comment file: ";

	public FileInitializationException(){
		super(DEFAULT_MESSAGE);
	}

	public FileInitializationException(String fileName){
		super(DEFAULT_MESSAGE + fileName);
	}

	public FileInitializationException(String fileName, Throwable cause){
		super(DEFAULT_MESSAGE + fileName, cause);
	}

	public FileInitializationException(Throwable cause){
		super(cause);
	}
}