package com.epsi.edc1.library.impl;

public class UnavailableBookException extends Exception {

private String message  = "Book actually not available.";
	
	public UnavailableBookException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
	
}
