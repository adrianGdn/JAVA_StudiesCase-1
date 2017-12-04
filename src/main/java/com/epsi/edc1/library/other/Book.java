package com.epsi.edc1.library.other;

/**
 * Book class object. For book management and creation.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 *
 */
public class Book {

	/**
	 * The author of the book.
	 */
	private String author;
	
	/**
	 * The ISBN10 of the book.
	 */
	private String ISBN_10;
	
	/**
	 * The ISBN13 of the book.
	 */
	private String ISBN_13;
	
	/**
	 * The title of the book.
	 */
	private String title;
	
	/**
	 * Status of the book presence.
	 */
	private boolean isPresent;
	
	/**
	 * The ID of the book.
	 */
	private String id;

	/**
	 * Allow to create a book class object with all attributes set as null.
	 */
	public Book() {

	}

	/**
	 * Allow you to build a book object.
	 * 
	 * @param theISBN
	 *            The ISBN value of the book. You can put a ISBN13 or a ISBN10.
	 *            This is a string.
	 * @param author
	 *            The author of that book.
	 *            This is a string.
	 * @param title
	 *            The title of that book.
	 *            This is a string.
	 * @param isPresent
	 *            True if this book is present in the library, false in other case.
	 *            This is a boolean.
	 * @param id
	 *            The ID of the book.
	 *            The ID must be unique, it will be used to identify the book.
	 */
	public Book(final String theISBN, final String author, final String title, final boolean isPresent,
			final String id) {
		if (theISBN.length() == 10) {
			this.ISBN_10 = theISBN;
		} else if (theISBN.length() == 13) {
			this.ISBN_13 = theISBN;
		}
		this.author = author;
		this.title = title;
		this.isPresent = isPresent;
		this.id = id;
	}
	
	/**
	 * Allow you to build a book object.
	 *
	 * @param isbn10
	 *            The ISBN_10 value of the book.
	 *            This is a string.
	 * @param isbn13
	 *            The ISBN_13 value of the book.
	 *            This is a string.
	 * @param author
	 *            The author of that book.
	 *            This is a string.
	 * @param title
	 *            The title of that book.
	 *            This is a string.
	 * @param isPresent
	 *            True if this book is present in the library, false in other case.
	 *            This is a boolean.
	 * @param id
	 *            The ID of the book.
	 *            The ID must be unique, it will be used to identify the book.
	 */
	public Book(final String isbn10, final String isbn13, final String author, final String title, final boolean isPresent,
			final String id) {
		this.ISBN_10 = isbn10;
		this.ISBN_13 = isbn13;
		this.author = author;
		this.title = title;
		this.isPresent = isPresent;
		this.id = id;
	}


	/**
	 * Allow you to recover the id of that book.
	 * 
	 * @return The id of that book. This is a string.
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Allow you to recover the author of that book.
	 * 
	 * @return The author of that book.
	 * 			This is a string.
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Allow you to recover the ISBN_10 value of that book.
	 * 
	 * @return The ISBN value of the book.
	 * 			This is a string.
	 */
	public String getISBN_10() {
		return this.ISBN_10;
	}

	/**
	 * Allow you to recover the ISBN_13 value of that book.
	 * 
	 * @return The ISBN value of the book.
	 * 			This is a string.
	 */
	public String getISBN_13() {
		return this.ISBN_13;
	}

	/**
	 * Allow you set the ISBN_13 value of that book.
	 * 
	 * @param ISBN_13
	 *            The ISBN13 value of the book.
	 *            This is a string.
	 */
	public void setISBN_13(final String ISBN_13) {
		this.ISBN_13 = ISBN_13;
	}

	/**
	 * Allow you set the ISBN_10 value of that book.
	 * 
	 * @param ISBN_10
	 *            The ISBN10 value of the book.
	 *            This is a string.
	 */
	public void setISBN_10(final String ISBN_10) {
		this.ISBN_10 = ISBN_10;
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
	 * @return True if this book is present in the library, false in other case.
	 *         This is a boolean.
	 */
	public boolean isPresent() {
		return this.isPresent;
	}

	/**
	 * Allow to set the isPresent status of the book.
	 * 
	 * @param present
	 *            Set as true if this book is present in the library, false in other case.
	 *            This is a boolean.
	 */
	public void setIsPresent(final boolean present) {
		this.isPresent = present;
	}
}
