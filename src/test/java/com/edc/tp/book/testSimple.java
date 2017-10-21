package com.edc.tp.book;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import com.edc.tp.book.Books;

import org.junit.Test;

public class testSimple {
	Book milleNeufCentQuatreVingtQuatre = new Book();
	Book fahrenheit451 = new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451");
	Books listeGBooks = new Books();
	@Test
	public void testVideEtPlein() {
		//assertThat(("0"), equalTo("0"));
		assertThat(milleNeufCentQuatreVingtQuatre.getAuteur(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getISBN(), equalTo(null));
		assertThat(milleNeufCentQuatreVingtQuatre.getTitre(), equalTo(null));

		assertThat(fahrenheit451.getAuteur(), equalTo("Ray Bradbury"));
		assertThat(fahrenheit451.getISBN(), equalTo("978-0671870362"));
		assertThat(fahrenheit451.getTitre(), equalTo("Fahrenheit 451"));
		assertThat(fahrenheit451.toString(), equalTo("Ce livre à pour titre : Fahrenheit 451, son code ISBN est : 978-0671870362, son auteur est : Ray Bradbury"));
		fahrenheit451.setAuteur("ray bradbury");

		assertThat(fahrenheit451.getAuteur(), equalTo("ray bradbury"));
		assertThat(fahrenheit451.toString(), equalTo("Ce livre à pour titre : Fahrenheit 451, son code ISBN est : 978-0671870362, son auteur est : ray bradbury"));
	}
	
	@Test
	public void testGetFromListe() {
		Book b = new Book("778-0671875162");
		Optional<Book> optionnalB = Optional.of(b);
		Optional<Book> optionnalB2 = Optional.of(b);
		assertEquals(optionnalB, optionnalB2);
		assertEquals(optionnalB, listeGBooks.getBook(b.getISBN()));
		//(optionnal451, equalTo(listeGBooks.getBook(fahrenheit451.getISBN()) ));
	}

}
