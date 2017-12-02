package com.epsi.edc1.library.impl;

import java.util.ArrayList;
import java.util.List;
import com.epsi.edc1.library.impl.Book;

/**
 * User object class. For Users management and creation.
 * 
 * @author Adrian Gandon
 * @author Alexis Dubus
 *
 */
public class User {
	
	/**
	 * The name of the user.
	 */
	private String name;
	
	/**
	 * The surname of the user.
	 */
	private String surname;
	
	/**
	 * The username of the user.
	 */
	private String username; // Is used like an id.
	
	/**
	 * The age of the user.
	 */
	private int age;
	
	/**
	 * The list of book the user borrowed.
	 */
	private List<Book> booksBorrow = new ArrayList<>(); // A user can borrow only a book once a time.

	/**
	 * Allow to create a user class object with all attributes set as null.
	 */
	public User() {

	}

	/**
	 * Allow you to build a User object with the parameters sent in argument.
	 * 
	 * @param name
	 *            The name of that user.
	 *            This is a string.
	 * @param surname
	 *            The surname of that user.
	 *            This is a string.
	 * @param age
	 *            The age of that user.
	 *            This is an integer.
	 * @param username
	 *            The username (like a pseudo) of that user.
	 *            This is a string.
	 */
	public User(final String name, final String surname, final int age, final String username) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.username = username;
	}

	/**
	 * Allow you to recover the name of that user.
	 * 
	 * @return The name of that user.
	 * 			This is a string.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Allow you to recover the surname of that user.
	 * 
	 * @return The surname of that user.
	 * 			This is a string.
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * Allow you to recover the age of that user.
	 * 
	 * @return The age of that user.
	 * 			This is an integer.
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Allow you to recover the username of that user.
	 * 
	 * @return The username (like a pseudo) of that user.
	 * 			This is a string.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Allow to recover the bookBorrow borrow per that user.
	 * 
	 * @return The bookBorrow that has been borrow per that user.
	 * 				This is a List<Book> Object
	 */
	public List<Book> getBooks() {
		return booksBorrow;
	}

	/**
	 * Allow you to change the actual bookBorrow for that user.
	 * 
	 * @param aBook
	 *            The bookBorrow that has been borrow per that user.
	 *            This is a bookBorrow object class.
	 */
	public void addBook(final Book aBook) {
		this.booksBorrow.add(aBook);
	}

	/**
	 * Allow you to reset the bookBorrow value. 
	 * Can be useful if the user return a borrow book but didn't take another one.
	 */
	public void returnBorrowBook(final Book aBook) {
		this.booksBorrow.remove(aBook);
	}
}
