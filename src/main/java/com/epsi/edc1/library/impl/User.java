package com.epsi.edc1.library.impl;

import com.epsi.edc1.library.impl.Book;

/**
 * User object class. For Users management and creation.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 *
 */
public class User {
	private String name;
	private String surname;
	private String username; // Is used like an id.
	private int age;
	private Book bookBorrow; // A user can borrow only one bookBorrow once a time.

	/**
	 * Allow to create a user class object with all attributes set as null.
	 */
	public User() {

	}

	/**
	 * Allow you to build a User object with the parameters sent in argument.
	 * 
	 * @param name
	 *            The name of that user. This is a string.
	 * @param surname
	 *            The surname of that user. This is a string.
	 * @param age
	 *            The age of that user. This is an integer.
	 * @param username
	 *            The username (like a pseudo) of that user. This is a string.
	 */
	public User(String name, String surname, int age, String username) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.username = username;
		// On the creation, the user hasn't any bookBorrow set.
		this.bookBorrow = null;
	}

	/**
	 * Allow you to recover the name of that user.
	 * 
	 * @return The name of that user. This is a string.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Allow you to recover the surname of that user.
	 * 
	 * @return The surname of that user. This is a string.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Allow you to recover the age of that user.
	 * 
	 * @return The age of that user. This is an integer.
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Allow you to recover the username of that user.
	 * 
	 * @return The username (like a pseudo) of that user. This is a string.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Allow to recover the bookBorrow borrow per that user.
	 * 
	 * @return The bookBorrow that has been borrow per that user. This is a
	 *         bookBorrow object class.
	 */
	public Book getBook() {
		return bookBorrow;
	}

	/**
	 * Allow you to change the actual bookBorrow for that user.
	 * 
	 * @param aBook
	 *            The bookBorrow that has been borrow per that user. This is a
	 *            bookBorrow object class.
	 */
	public void setBook(Book aBook) {
		this.bookBorrow = aBook;
	}

	/**
	 * Allow you to reset the bookBorrow value. Can be useful if the user return a
	 * borrow book but didn't take another one.
	 */
	public void returnBorrowBook() {
		this.bookBorrow = null;
	}
}
