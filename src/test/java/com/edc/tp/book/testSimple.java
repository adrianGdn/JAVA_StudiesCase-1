package com.edc.tp.book;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import java.util.Optional;
import org.junit.Test;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.Books;

public class testSimple {
	Book milleNeufCentQuatreVingtQuatre = new Book();
	Book fahrenheit451 = new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true);
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
		Book book = new Book("007", "James Bond", "Agent 007", true);
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Les bugs et moi", true);
		Optional<Book> optionnalB = Optional.of(book);
		String messageErreur = "An error has occur when trying to get a book from the library.";
		/*
		 * Java est assez agacant sur les égalités entre les objets, donc ce que fait la ligne de code suivante : 
		 * On a donc un optional<Book> du livre que l'on veut tester. On compare son getISBN() au getISBN() du livre de la bibliothéque que l'on a demander. 
		 */
		assertEquals(messageErreur, optionnalB.get().getISBN(), listeGBooks.getBook(book.getISBN()).get().getISBN());
		assertEquals(messageErreur, book.getISBN(), listeGBooks.getBook(book.getISBN()).get().getISBN());
		assertEquals(messageErreur, benoitBook.getISBN(), listeGBooks.getBook(benoitBook.getISBN()).get().getISBN());
		assertEquals(messageErreur, "007", listeGBooks.getBook(book.getISBN()).get().getISBN());
	}

}
