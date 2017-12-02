package com.epsi.edc1.library.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.epsi.edc1.library.Library;
import com.epsi.edc1.library.impl.exception.AllBooksAlreadyReturnedException;
import com.epsi.edc1.library.impl.exception.BookNotFoundException;
import com.epsi.edc1.library.impl.exception.UnavailableBookException;

/**
 * This class allow us to use the implemented methods of the Library interface.
 * 
 * @author Alexis Dubus
 * @author Adrian Gandon
 */
public class LibraryImplements implements Library {

	/**
	 * The library list of book. Some book can have the same title or ISBN, but the
	 * ID must differ.
	 */
	private final List<Book> books = new ArrayList<>();

	/**
	 * The global list of book. The book in this list can be add to the books list.
	 */
	private final List<Book> globalBooks = new ArrayList<>();
	

	/**
	 * The user list of the library. They have access to the library book.
	 */
	private final List<User> users = new ArrayList<>();

	/**
	 * The constructor of that class.
	 * Allow after the initialization to do many super things !
	 */
	public LibraryImplements() {
		initBooks();
		initUsers();
		initGlobalBooks();
	}

	/**
	 * Methods that allow us to give some "Book" to our library by an initialization
	 * of a list.
	 */
	private void initBooks() {
		// First book of Ray Bradbury in the library
		books.add(new Book("9780671870", "9780671870000", "Ray Bradbury", "Fahrenheit 451", true, "978"));
		// Second book of Ray Bradbury in the library
		books.add(new Book("9780671870", "9780671870000", "Ray Bradbury", "Fahrenheit 451", true, "1"));
		books.add(new Book("0307763057", "0307763057000", "Benoît Cavrois", "Life is potatoes", true, "42"));
		books.add(new Book("0070070070", "0070070070000", "James Bond", "Agent 007", true, "7"));
		books.add(new Book("2323232323", "2323232323000", "I am an author", "I am a title", true, "2323001"));
	}

	/**
	 * Methods that allow us to give some "Book" to the book which "exist in the
	 * world" by an initialization of a list. We can add book to this list by using
	 * the "addBook" method.
	 */
	private void initGlobalBooks() {
		globalBooks.add(new Book("0307763055", "0307763055000", "Julien Petit", "Le Havre : Le port du monde ?", true, "6"));
		globalBooks.add(new Book("0307763056", "0307763056000", "Julien Petit", "La VR de demain", true, "10"));
		globalBooks.add(new Book("2323232323233", "2323232323233000", "I am an author", "I am a title", true, "2323001"));
	}

	/**
	 * Methods that allow us to give some "User" to our library by an initialization
	 * of a list.
	 */
	private void initUsers() {
		users.add(new User("Benoît", "Cavrois", 9, "bCavrois"));
		users.add(new User("Adrian", "Gandon", 23, "aGandon"));
		users.add(new User("Alexis", "Dubus", 42, "aDubus"));
		users.add(new User("Julien", "Petit", 20, "jPetit"));
		users.add(new User("I am the user", "I am the surname", 23, "I am the username"));
	}

	public Optional<Book> getBook(final String id) {
		for (final Book book : books) {
			// Search trough books
			if (id.equals(book.getId())) {
				return Optional.of(book);
			}
		}
		// By default, return an empty Optional
		return Optional.empty();
	}

	public Optional<String> addBook(final String isbn) {
		for (final Book book : globalBooks) {
			// Search trough globalBooks
			if (isbn.equals(book.getISBN_10()) || isbn.equals(book.getISBN_13())) {
				books.add(book);
				return Optional.of(book.getId());
			}
		}
		// By default, return an empty Optional
		return Optional.empty();
	}

	public void borrowBook(final String id, final String username)
			throws UnavailableBookException, BookNotFoundException {
		boolean bookNotFound = true;
		int countNumberUnavalaibleBook = 0;
		int countNumberOkIsbnBook = 0;
		if (!userExistInList(username)) {
			// If the user isn't in the library user list, he hasn't the right access
			return;
		} else {
			for (int i = 0; i < books.size(); i++) {
				Book book = books.get(i);
				// If the id is equals, it's the good book
				if (id.equals(book.getId()))
				{
					countNumberOkIsbnBook++;
					// Check if the book is present in the library in case someone already borrowed it
					if (book.isPresent())
					{
						User theUser = getUserInList(username);
						if (!theUser.getBooks().contains(book)) {
							// In case the user have already another book
							book.setIsPresent(false);
							// The book is now unavailable in the library
							books.get(i).setIsPresent(false);
							// The user now get his book
							theUser.addBook(book);
							return;
						}
					} else {
						countNumberUnavalaibleBook++;
					}
				}
			}
		}
		// Part with the Exception
		// If all book with the given ID aren't present
		if (countNumberOkIsbnBook == countNumberUnavalaibleBook)
		{
			// The book is unavailable in the library
			throw new UnavailableBookException();
		}
		if (bookNotFound) {
			// The book wasn't found
			throw new BookNotFoundException();
		}
	}

	/**
	 * This method allow us to check if a user exist in the list of user.
	 * 
	 * @param username
	 *            The username (like a pseudo) of that user. This is a string.
	 * @return boolean Return true if the user pass in parameter (by it's username)
	 *         exist in our user list.
	 */
	private boolean userExistInList(final String username) {
		for (final User user : users) {
			// Identification is done with the username
			if (username.equals(user.getUsername()))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * This method allow us to get a user who exist in the list of our user.
	 * 
	 * @param username
	 *            The username (like a pseudo) of that user. This is a string.
	 * @return User If the user exist in our list, we return it.
	 */
	private User getUserInList(final String username) {
		for (final User user : users) {
			// Identification is done with the username
			if (username.equals(user.getUsername())) {
				return user;
			}
		}
		// By default, return null
		return null;
	}

	public void returnBook(final String id, final String username)
			throws BookNotFoundException, AllBooksAlreadyReturnedException {
		///////////// Part search of the book /////////////
		Book returnedBook = null;
		int counterBook = 0;
		boolean bookFind = false;

		// We search the returned book
		while (counterBook <= books.size() && bookFind == false) {
			returnedBook = books.get(counterBook);
			if (returnedBook.getId().equals(id)) {
				bookFind = true;
			}
			counterBook++;
		}
		// If we haven't find the book, we throw an exception
		if (counterBook <= books.size() && !bookFind) {
			throw new BookNotFoundException();
		}

		///////////// Part search of the user /////////////
		int counterUser = 0;
		boolean userFind = false;
		User userWhoReturnBook = null;
		// We search the user who has returned the book
		while (counterUser <= users.size() && userFind == false) {
			userWhoReturnBook = users.get(counterUser);
			if (username.contains(userWhoReturnBook.getUsername())) {
				userFind = true;
			}
			counterUser++;
		}
		// If we haven't find the book, we throw an exception
		if (counterUser <= users.size() && userFind == false) {
			throw new AllBooksAlreadyReturnedException();
		}

		///////////// Part return the book /////////////
		// Because our counter variable is equals to the longer of the list and the list
		///////////// begin at 0, we need to subtract 1 to the counter variable
		users.get(counterUser - 1).returnBorrowBook(returnedBook);
		books.get(counterBook - 1).isPresent();
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Book> searchBooks(final String searchTerm) {
		// Init the list<Book>
		List<Book> list = new ArrayList<Book>();
		for (final Book book : books) {
			// All test are done here
			String isbn_13 = book.getISBN_10();
			String isbn_10 = book.getISBN_13();
			if (book.getAuthor().contains(searchTerm) || book.getTitle().contains(searchTerm)
					|| isbn_13.contains(searchTerm) || isbn_10.contains(searchTerm)) {
				list.add(book);
			}
		}
		return list;
	}
}
