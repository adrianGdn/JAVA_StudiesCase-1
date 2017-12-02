package com.epsi.edc1.library.impl.exception;

/**
 * It's a class that allow us to generate exception.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 */
@SuppressWarnings("serial")
public class AllBooksAlreadyReturnedException extends Exception {
	private String message = "All books which have this ID has already been return.";

	/**
	 * The default constructor of that class.
	 * It allow us to use the method oh that class.
	 */
	public AllBooksAlreadyReturnedException() {
	}

	@Override
	public String toString() {
		return message;
	}
}
