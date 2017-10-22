package com.epsi.edc1.library.impl;

public class BookNotFoundException extends Exception {
	private String message  = "Livre Non trouvé !";
	
	public BookNotFoundException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
}
