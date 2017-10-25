package com.edc.tp.book;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

import com.epsi.edc1.library.impl.AllBooksAlreadyReturnedException;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.BookNotFoundException;
import com.epsi.edc1.library.impl.Books;
import com.epsi.edc1.library.impl.UnavailableBookException;
import com.epsi.edc1.library.impl.User;

public class testSimple {
	Book milleNeufCentQuatreVingtQuatre = new Book();
	Book fahrenheit451 = new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "1");
	Books listeGBooks = new Books();
	@Test
	public void testVideEtPlein() {
		//assertThat(("0"), equalTo("0"));
		assertThat(milleNeufCentQuatreVingtQuatre.getAuthor(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getISBN(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getTitle(), equalTo(null));

		assertThat(fahrenheit451.getAuthor(), equalTo("Ray Bradbury"));
		assertThat(fahrenheit451.getISBN(), equalTo("978-0671870362"));
		assertThat(fahrenheit451.getTitle(), equalTo("Fahrenheit 451"));
	}
	
	@Test
	public void testGetFromListeBiblio() {
		Book book = new Book("007", "James Bond", "Agent 007", true, "7");
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "42");
		Optional<Book> optionnalB = Optional.of(book);
		String messageErreur = "An error has occured when trying to get a book from the library.";
		assertEquals(messageErreur, optionnalB.get().getISBN(), listeGBooks.getBook(book.getId()).get().getISBN());
		assertEquals(messageErreur, book.getISBN(), listeGBooks.getBook(book.getId()).get().getISBN());
		assertEquals(messageErreur, benoitBook.getISBN(), listeGBooks.getBook(benoitBook.getId()).get().getISBN());
		assertEquals(messageErreur, "007", listeGBooks.getBook(book.getId()).get().getISBN());
	}
	
	
	@Test
	public void testSearch() {
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "42");
		String messageErreur = "An error has occured when trying to search a book from the library.";
		List<Book>  listBenoit = new ArrayList<Book>();
		listBenoit.add(benoitBook);
		List<Book>  listOutput = listeGBooks.searchBooks("2345"); 
		assertEquals(messageErreur, listBenoit.get(0).getISBN(), listOutput.get(0).getISBN());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput.size());
		List<Book>  listOutput2 = listeGBooks.searchBooks(" bugs "); 
		assertEquals(messageErreur, listBenoit.get(0).getISBN(), listOutput2.get(0).getISBN());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput2.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput2.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput2.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput2.size());
		
		List<Book>  listOutputEmpty = listeGBooks.searchBooks(" uyhosdunhoeu zpxdcièeuygxikuzytexgikr g eiy rzeiuycgbifhebxghno_zeby girecgh binuk "); 
		assertEquals(messageErreur, 0, listOutputEmpty.size());//the search result is empty
	}
	
	@Test
	public void testReturnedBook() throws BookNotFoundException, AllBooksAlreadyReturnedException, UnavailableBookException {
		// Preparation
		Book aNewBook = new Book("23232", "I am an author", "I am a title", true, "2323001");
		User aNewUser = new User("I am the user", "I am the surname", 23, "I am the username");
		List<Book>  aNewListOfBooks = new ArrayList<Book>();
		aNewListOfBooks.add(aNewBook);
		List<User>  aNewListOfUsers = new ArrayList<User>();
		aNewListOfUsers.add(aNewUser);
		String errorMessage = "An error has occur when trying to returned the book.";
		
		// Execution
			// Preparation test
		assertEquals(errorMessage, true, aNewListOfBooks.get(0).isPresent());
		assertEquals(errorMessage, null, aNewListOfUsers.get(0).getBook());
		aNewListOfUsers.get(0).setBook(aNewListOfBooks.get(0));
		aNewListOfBooks.get(0).setIsPresent(false);
		assertEquals(errorMessage, false, aNewListOfBooks.get(0).isPresent());
		assertEquals(errorMessage, aNewBook, aNewListOfUsers.get(0).getBook());
			// Real test
		Books aBooks = new Books();
				// Check for "borrowBook" function
		aBooks.borrowBook(aNewBook.getId(), aNewUser.getUsername());
		System.out.println(aBooks.getBook(aNewBook.getId()).get().isPresent());
		assertEquals(errorMessage, false, aBooks.getBook(aNewBook.getId()).get().isPresent()); // Doesn't work
		assertEquals(errorMessage, aBooks.getBook(aNewBook.getId()), aBooks.getUserInList(aNewUser.getUsername()).getBook());
				// Check for "returnBook" function
		aBooks.returnBook(aNewBook.getId(), aNewUser.getUsername());
		assertEquals(errorMessage, true, aBooks.getBook(aNewBook.getId()).isPresent());
		assertEquals(errorMessage, null, aBooks.getUserInList(aNewUser.getUsername()).getBook());
	}

}
