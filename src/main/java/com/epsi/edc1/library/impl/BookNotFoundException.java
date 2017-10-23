package com.epsi.edc1.library.impl;

public class BookNotFoundException extends Exception {
	private String message  = "Book not found.";
	
	public BookNotFoundException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
}
