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
		assertThat(fahrenheit451.toString(), equalTo("Ce livre à pour titre : Fahrenheit 451, son code ISBN est : 978-0671870362, son auteur est : Ray Bradbury"));
	}
	
	@Test
	public void testGetFromListeBiblio() {
		Book book = new Book("007", "007", "007", true);
		Book benoitBook = new Book("12345", "Benoît Cavrois", "Les bugs et moi", true);
		Optional<Book> optionnalB = Optional.of(book);
		String messageErreur = "pb sur la récupération d'un livre de la bibliothéque";
		/*
		 * Java est assez agacant sur les égalités entre les objets, donc ce que fait la ligne de code suivante : 
		 * On a donc un optional<Book> du livre que l'on veut tester. On compare son toString() au toString() du livre de la bibliothéque que l'on a demander. 
		 */
		assertEquals(messageErreur, optionnalB.get().toString(), listeGBooks.getBook(book.getISBN()).get().toString());
		assertEquals(messageErreur, book.toString(), listeGBooks.getBook(book.getISBN()).get().toString());
		assertEquals(messageErreur, benoitBook.toString(), listeGBooks.getBook(benoitBook.getISBN()).get().toString());
		assertNotEquals(messageErreur, book.toString(), listeGBooks.getBook(benoitBook.getISBN()).get().toString());
	}

}
