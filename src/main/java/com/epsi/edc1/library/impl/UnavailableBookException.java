package com.epsi.edc1.library.impl;

public class UnavailableBookException extends Exception {

private String message  = "Livre indisponible.";
	
	public UnavailableBookException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
	
}
