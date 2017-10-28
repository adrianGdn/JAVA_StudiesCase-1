package com.epsi.edc1.library.impl.exception;

/**
 * It's a class that allow us to generate exception.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 */
public class UnavailableBookException extends Exception {
	private String message  = "Book actually not available.";
	
	/**
	 * The default constructor of that class. It allow us to use the method oh that class.
	 */
	public UnavailableBookException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
}
