package com.epsi.edc.library;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.LibraryImplements;
import com.epsi.edc1.library.impl.User;
import com.epsi.edc1.library.impl.exception.AllBooksAlreadyReturnedException;
import com.epsi.edc1.library.impl.exception.BookNotFoundException;
import com.epsi.edc1.library.impl.exception.UnavailableBookException;

/**
 * @author Adrian Gandon
 */
public class LibraryTests {
	/**
	 * A test for the "returnBook" and "borrowBook" which comes from the Library.
	 */
	@Test
	public void testReturnedAndBorrowBook()
			throws BookNotFoundException, AllBooksAlreadyReturnedException, UnavailableBookException {
		// Preparation
		Book aNewBook = new Book("2323223222", "I am an author", "I am a title", true, "2323001");
		User aNewUser = new User("I am the user", "I am the surname", 23, "I am the username");
		List<Book> aNewListOfBooks = new ArrayList<Book>();
		aNewListOfBooks.add(aNewBook);
		List<User> aNewListOfUsers = new ArrayList<User>();
		aNewListOfUsers.add(aNewUser);
		String errorMessage = "An error has occur when trying to return the book.";
		String errorMessage2 = "An error has occur when trying to get the book.";

		// Execution
		// Preparation test
		assertEquals(errorMessage, true, aNewListOfBooks.get(0).isPresent());
		assertEquals(errorMessage, null, aNewListOfUsers.get(0).getBook());
		aNewListOfUsers.get(0).setBook(aNewListOfBooks.get(0));
		aNewListOfBooks.get(0).setIsPresent(false);
		assertEquals(errorMessage, false, aNewListOfBooks.get(0).isPresent());
		assertEquals(errorMessage, aNewBook, aNewListOfUsers.get(0).getBook());
		// Real test
		LibraryImplements aBooks = new LibraryImplements();
		// Check for "borrowBook" function
		aBooks.borrowBook(aNewBook.getId(), aNewUser.getUsername());
		assertEquals(errorMessage2, false, aBooks.getBook(aNewBook.getId()).get().isPresent());
		assertEquals(errorMessage2, aBooks.getBook(aNewBook.getId()).get(),
				aBooks.getUserInList(aNewUser.getUsername()).getBook());
		// Check for "returnBook" function
		aBooks.returnBook(aNewBook.getId(), aNewUser.getUsername());
		assertEquals(errorMessage, true, aBooks.getBook(aNewBook.getId()).isPresent());
		assertEquals(errorMessage, null, aBooks.getUserInList(aNewUser.getUsername()).getBook());
		// End
	}

	/**
	 * A test for the "getBook" and "addBook" which comes from the Library.
	 */
	@Test
	public void testAddGetBook() {
		// Preparation
		LibraryImplements aBooksPacket = new LibraryImplements();
		Book aTestBook = new Book("0070070070", "James Bond", "Agent 007", true, "7");
		Book aSecondTestBook = new Book("0307763056", "Julien Petit", "La VR de demain", true, "10");
		String errorMessage = "An error has occur when trying to get the book.";

		// Execution
		// Check for "getBook" function
		assertEquals(errorMessage, aTestBook.getId(), aBooksPacket.getBook("7").get().getId());
		assertEquals(errorMessage, aTestBook.getISBN(), aBooksPacket.getBook("7").get().getISBN());
		assertEquals(errorMessage, aTestBook.getAuthor(), aBooksPacket.getBook("7").get().getAuthor());
		assertEquals(errorMessage, aTestBook.getTitle(), aBooksPacket.getBook("7").get().getTitle());
		assertEquals(errorMessage, aTestBook.isPresent(), aBooksPacket.getBook("7").get().isPresent());
		// Check for "addBook" function
		Optional<String> retour = aBooksPacket.addBook("0307763056");
		System.out.println(retour.get());
		assertEquals(errorMessage, aSecondTestBook.getId(), aBooksPacket.getBook("10").get().getId());
		assertEquals(errorMessage, aSecondTestBook.getISBN(), aBooksPacket.getBook("10").get().getISBN());
		assertEquals(errorMessage, aSecondTestBook.getAuthor(), aBooksPacket.getBook("10").get().getAuthor());
		assertEquals(errorMessage, aSecondTestBook.getTitle(), aBooksPacket.getBook("10").get().getTitle());
		assertEquals(errorMessage, aSecondTestBook.isPresent(), aBooksPacket.getBook("10").get().isPresent());
		// End
	}

	/**
	 * A test for the "getBooks" which come from the Library.
	 */
	@Test
	public void testGetBooks() {
		// Preparation
		LibraryImplements aBooksPacket = new LibraryImplements();
		List<Book> aTestListBook;
		// These following book are book which's in the library.
		Book aFirstTestBook = new Book("9780671870362", "Ray Bradbury", "Fahrenheit 451", true, "978");
		Book aSecondTestBook = new Book("9780671870362", "Ray Bradbury", "Fahrenheit 451", true, "1");
		Book aThirdTestBook = new Book("0307763057", "Benoît Cavrois", "Life is potatoes", true, "42");
		Book aFourTestBook = new Book("0070070070", "James Bond", "Agent 007", true, "7");
		Book aFiveTestBook = new Book("2323232323233", "I am an author", "I am a title", true, "2323001");
		String errorMessage = "An error has occur when trying to get the book.";

		// Execution
		aTestListBook = aBooksPacket.getBooks();
		// First book, which is at index 0
		assertEquals(errorMessage, aFirstTestBook.getId(), aTestListBook.get(0).getId());
		assertEquals(errorMessage, aFirstTestBook.getISBN(), aTestListBook.get(0).getISBN());
		assertEquals(errorMessage, aFirstTestBook.getAuthor(), aTestListBook.get(0).getAuthor());
		assertEquals(errorMessage, aFirstTestBook.getTitle(), aTestListBook.get(0).getTitle());
		assertEquals(errorMessage, aFirstTestBook.isPresent(), aTestListBook.get(0).isPresent());
		// Second book, which is at index 1
		assertEquals(errorMessage, aSecondTestBook.getId(), aTestListBook.get(1).getId());
		assertEquals(errorMessage, aSecondTestBook.getISBN(), aTestListBook.get(1).getISBN());
		assertEquals(errorMessage, aSecondTestBook.getAuthor(), aTestListBook.get(1).getAuthor());
		assertEquals(errorMessage, aSecondTestBook.getTitle(), aTestListBook.get(1).getTitle());
		assertEquals(errorMessage, aSecondTestBook.isPresent(), aTestListBook.get(1).isPresent());
		// Third book, which is at index 2
		assertEquals(errorMessage, aThirdTestBook.getId(), aTestListBook.get(2).getId());
		assertEquals(errorMessage, aThirdTestBook.getISBN(), aTestListBook.get(2).getISBN());
		assertEquals(errorMessage, aThirdTestBook.getAuthor(), aTestListBook.get(2).getAuthor());
		assertEquals(errorMessage, aThirdTestBook.getTitle(), aTestListBook.get(2).getTitle());
		assertEquals(errorMessage, aThirdTestBook.isPresent(), aTestListBook.get(2).isPresent());
		// The book in position four, which is at index 3
		assertEquals(errorMessage, aFourTestBook.getId(), aTestListBook.get(3).getId());
		assertEquals(errorMessage, aFourTestBook.getISBN(), aTestListBook.get(3).getISBN());
		assertEquals(errorMessage, aFourTestBook.getAuthor(), aTestListBook.get(3).getAuthor());
		assertEquals(errorMessage, aFourTestBook.getTitle(), aTestListBook.get(3).getTitle());
		assertEquals(errorMessage, aFourTestBook.isPresent(), aTestListBook.get(3).isPresent());
		// The book in position five, which is at index 4
		assertEquals(errorMessage, aFiveTestBook.getId(), aTestListBook.get(4).getId());
		assertEquals(errorMessage, aFiveTestBook.getISBN(), aTestListBook.get(4).getISBN());
		assertEquals(errorMessage, aFiveTestBook.getAuthor(), aTestListBook.get(4).getAuthor());
		assertEquals(errorMessage, aFiveTestBook.getTitle(), aTestListBook.get(4).getTitle());
		assertEquals(errorMessage, aFiveTestBook.isPresent(), aTestListBook.get(4).isPresent());
		// End
	}

	/**
	 * A test for the "searchBook" which come from the Library.
	 */
	@Test
	public void testSearchBooks() {
		// Preparation
		LibraryImplements aBooksList = new LibraryImplements();
		Book aTestBook = new Book("0070070070", "James Bond", "Agent 007", true, "7");
		String errorMessage = "An error has occured when trying to search a book from the library.";
		List<Book> aSearchResultList;

		// Execution
		// Search by author
		aSearchResultList = aBooksList.searchBooks("James");
		// We check if the book found is the correct one
		assertEquals(errorMessage, aTestBook.getAuthor(), aSearchResultList.get(0).getAuthor());
		assertEquals(errorMessage, aTestBook.getId(), aSearchResultList.get(0).getId());
		assertEquals(errorMessage, aTestBook.getISBN(), aSearchResultList.get(0).getISBN());
		assertEquals(errorMessage, aTestBook.getTitle(), aSearchResultList.get(0).getTitle());
		assertEquals(errorMessage, aTestBook.isPresent(), aSearchResultList.get(0).isPresent());
		// Search by title
		aSearchResultList = aBooksList.searchBooks("Agent");
		// We check if the book found is the correct one
		assertEquals(errorMessage, aTestBook.getAuthor(), aSearchResultList.get(0).getAuthor());
		assertEquals(errorMessage, aTestBook.getId(), aSearchResultList.get(0).getId());
		assertEquals(errorMessage, aTestBook.getISBN(), aSearchResultList.get(0).getISBN());
		assertEquals(errorMessage, aTestBook.getTitle(), aSearchResultList.get(0).getTitle());
		assertEquals(errorMessage, aTestBook.isPresent(), aSearchResultList.get(0).isPresent());
		// Search by ISBN
		aSearchResultList = aBooksList.searchBooks("007");
		// We check if the book found is the correct one
		assertEquals(errorMessage, aTestBook.getAuthor(), aSearchResultList.get(0).getAuthor());
		assertEquals(errorMessage, aTestBook.getId(), aSearchResultList.get(0).getId());
		assertEquals(errorMessage, aTestBook.getISBN(), aSearchResultList.get(0).getISBN());
		assertEquals(errorMessage, aTestBook.getTitle(), aSearchResultList.get(0).getTitle());
		assertEquals(errorMessage, aTestBook.isPresent(), aSearchResultList.get(0).isPresent());
		// Search by title, with two book found
		aSearchResultList = aBooksList.searchBooks("978");
		assertEquals(errorMessage, 2, aSearchResultList.size());
		// Search with no result found
		aSearchResultList = aBooksList.searchBooks("I'm not real");
		assertEquals(errorMessage, 0, aSearchResultList.size());
	}
}
