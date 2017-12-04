package com.epsi.edc1.library.impl.exception;

/**
 * It's a class that allow us to generate exception.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 */
@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {
	private final String message = "Book not found.";

	/**
	 * The default constructor of that class.
	 * It allow us to use the method oh that class.
	 */
	public BookNotFoundException() {
	}

	/**
	 * return the message of the exception. It's a String
	 */
	@Override
	final public String toString() {
		return message;
	}
}
