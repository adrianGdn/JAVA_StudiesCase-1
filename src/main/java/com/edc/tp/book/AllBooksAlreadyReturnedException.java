package com.edc.tp.book;

public class AllBooksAlreadyReturnedException extends Exception {

	private String message  = "Tout les livres avec cette identifiant on déja été retourné!";
	
	public AllBooksAlreadyReturnedException()
	{
	}
	
	@Override
	public String toString()
	{
		return message;
	}
}
