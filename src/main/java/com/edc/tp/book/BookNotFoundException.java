package com.edc.tp.book;

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
