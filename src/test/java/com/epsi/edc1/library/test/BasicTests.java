package com.epsi.edc1.library.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

import com.epsi.edc1.library.impl.LibraryImpl;
import com.epsi.edc1.library.other.Book;

/**
 * @author Alexis Dubus
 */
public class BasicTests {
	@Test
	public void testVideEtPlein() {
		Book milleNeufCentQuatreVingtQuatre = new Book();
		Book fahrenheit451 = new Book("9780671870", "9780671870362", "Ray Bradbury", "Fahrenheit 451", true, "1");

		assertThat(milleNeufCentQuatreVingtQuatre.getAuthor(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getISBN_13(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getTitle(), equalTo(null));

		assertThat(fahrenheit451.getAuthor(), equalTo("Ray Bradbury"));
		assertThat(fahrenheit451.getISBN_13(), equalTo("9780671870362"));
		assertThat(fahrenheit451.getTitle(), equalTo("Fahrenheit 451"));
	}

	@Test
	public void testGetFromListeBiblio() {
		LibraryImpl listeGBooks = new LibraryImpl();
		Book book = new Book("0070070070", "0070070070000", "James Bond", "Agent 007", true, "7");
		Book benoitBook = new Book("0307763057", "0307763057000", "Benoît Cavrois", "Life is potatoes", true, "42");
		Optional<Book> optionnalB = Optional.of(book);
		String messageErreur = "An error has occured when trying to get a book from the library.";

		assertEquals(messageErreur, optionnalB.get().getISBN_10(), listeGBooks.getBook(book.getId()).get().getISBN_10());
		assertEquals(messageErreur, book.getISBN_10(), listeGBooks.getBook(book.getId()).get().getISBN_10());
		assertEquals(messageErreur, benoitBook.getISBN_10(), listeGBooks.getBook(benoitBook.getId()).get().getISBN_10());
		assertEquals(messageErreur, "0070070070", listeGBooks.getBook(book.getId()).get().getISBN_10());
	}

	@Test
	public void testSearch() {
		LibraryImpl listeGBooks = new LibraryImpl();
		Book benoitBook = new Book("0307763057", "0307763057000", "Benoît Cavrois", "Life is potatoes", true, "42");
		String messageErreur = "An error has occured when trying to search a book from the library.";
		List<Book> listBenoit = new ArrayList<Book>();
		listBenoit.add(benoitBook);
		List<Book> listOutput = listeGBooks.searchBooks("0307763057");

		assertEquals(messageErreur, listBenoit.get(0).getISBN_10(), listOutput.get(0).getISBN_10());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput.size());
		List<Book> listOutput2 = listeGBooks.searchBooks(" potatoes");
		assertEquals(messageErreur, listBenoit.get(0).getISBN_10(), listOutput2.get(0).getISBN_10());
		assertEquals(messageErreur, listBenoit.get(0).getAuthor(), listOutput2.get(0).getAuthor());
		assertEquals(messageErreur, listBenoit.get(0).getId(), listOutput2.get(0).getId());
		assertEquals(messageErreur, listBenoit.get(0).getTitle(), listOutput2.get(0).getTitle());
		assertEquals(messageErreur, listBenoit.size(), listOutput2.size());

		List<Book> listOutputEmpty = listeGBooks
				.searchBooks(" uyhosdunhoeu zpxdcièeuygxikuzytexgikr g eiy rzeiuycgbifhebxghno_zeby girecgh binuk ");
		assertEquals(messageErreur, 0, listOutputEmpty.size()); // The search result is empty
	}
}
