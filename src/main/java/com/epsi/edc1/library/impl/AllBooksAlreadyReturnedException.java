package com.epsi.edc1.library.impl;

public class AllBooksAlreadyReturnedException extends Exception {

	private String message  = "All books which have this ID has already been return.";
	
	public AllBooksAlreadyReturnedException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
}
