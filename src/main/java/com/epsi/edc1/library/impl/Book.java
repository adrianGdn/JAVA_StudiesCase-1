package com.epsi.edc1.library.impl;

/**
 * Book class object.
 * For book management and creation.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 *
 */
public class Book {
	
	private String author;
	private String theISBN;
	private String title;
	private boolean isPresent; 
	
	/////////////////////////////////////// Did we really need all that constructors ?
	public Book()
	{
		/////////////////////////////////// Is really useful ?
	}
	
	public Book(String theISBN)
	{
		this.theISBN = theISBN;
	}
	
	public Book(String theISBN, String author)
	{
		this.theISBN = theISBN;
		this.author = author;
	}
	
	/**
	 * Allow you to build a book object.
	 * 
	 * @param theISBN The ISBN value of the book. This is a string.
	 * @param author The author of that book. This is a string.
	 * @param title The title of that book. This is a string.
	 * @param isPresent True if this book is present in the library, false in other case. This is a boolean.
	 */
	public Book(String theISBN, String author, String title, boolean isPresent)
	{
		this.theISBN = theISBN;
		this.author = author;
		this.title = title;
		this.isPresent = isPresent;
	}
	
	/**
	 * Allow you to recover the author of that book.
	 * 
	 * @return The author of that book. This is a string.
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Allow you to recover the ISBN value of that book.
	 * 
	 * @return The ISBN value of the book. This is a string.
	 */
	public String getISBN() {
		return this.theISBN;
	}

	/**
	 * Allow you to recover the title of that book.
	 * 
	 * @return The title of that book. This is a string.
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Allow to know if the book is in the library (true) or not (false).
	 * 
	 * @return True if this book is present in the library, false in other case. This is a boolean.
	 */
	public boolean isPresent() {
		return isPresent;
	}

	public boolean equals(Book obj) {
		//////////////////////////////////////////////////////// What's that ?
        return super.equals(obj);
    }
}
