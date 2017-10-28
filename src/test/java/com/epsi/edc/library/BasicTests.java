package com.epsi.edc.library;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.Books;


/**
 * @author Alexis Dubus
 */
public class BasicTests {
	@Test
	public void testVideEtPlein() {
		Book milleNeufCentQuatreVingtQuatre = new Book();
		Book fahrenheit451 = new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "1");

		assertThat(milleNeufCentQuatreVingtQuatre.getAuthor(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getISBN(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getTitle(), equalTo(null));

		assertThat(fahrenheit451.getAuthor(), equalTo("Ray Bradbury"));
		assertThat(fahrenheit451.getISBN(), equalTo("978-0671870362"));
		assertThat(fahrenheit451.getTitle(), equalTo("Fahrenheit 451"));
	}
	
	@Test
	public void testGetFromListeBiblio() {
		Books listeGBooks = new Books();
		Book book = new Book("007", "James Bond", "Agent 007", true, "7");
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Life is potatoes", true, "42");
		Optional<Book> optionnalB = Optional.of(book);
		String messageErreur = "An error has occured when trying to get a book from the library.";
		
		assertEquals(messageErreur, optionnalB.get().getISBN(), listeGBooks.getBook(book.getId()).get().getISBN());
		assertEquals(messageErreur, book.getISBN(), listeGBooks.getBook(book.getId()).get().getISBN());
		assertEquals(messageErreur, benoitBook.getISBN(), listeGBooks.getBook(benoitBook.getId()).get().getISBN());
		assertEquals(messageErreur, "007", listeGBooks.getBook(book.getId()).get().getISBN());
	}
	
	@Test
	public void testSearch() {
		Books listeGBooks = new Books();
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Life is potatoes", true, "42");
		String messageErreur = "An error has occured when trying to search a book from the library.";
		List<Book>  listBenoit = new ArrayList<Book>();
		listBenoit.add(benoitBook);
		List<Book>  listOutput = listeGBooks.searchBooks("2345");
		
		assertEquals(messageErreur, listBenoit.get(0).getISBN(), listOutput.get(0).getISBN());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput.size());
		List<Book>  listOutput2 = listeGBooks.searchBooks(" potatoes"); 
		assertEquals(messageErreur, listBenoit.get(0).getISBN(), listOutput2.get(0).getISBN());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput2.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput2.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput2.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput2.size());
		
		List<Book> listOutputEmpty = listeGBooks.searchBooks(" uyhosdunhoeu zpxdcièeuygxikuzytexgikr g eiy rzeiuycgbifhebxghno_zeby girecgh binuk "); 
		assertEquals(messageErreur, 0, listOutputEmpty.size()); //the search result is empty
	}
}
