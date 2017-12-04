package com.epsi.edc1.library.impl.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.epsi.edc1.library.other.Book;

/**
 * @author Adrian Gandon
 */
public class BookTests {
	/**
	 * A test which check the getters of the Book class with simple values.
	 */
	@Test
	public void bookSimpleGettersTest() {
		// Preparation
		Book aTestBook = new Book("1234544444", "1234544444000", "TestAuthor", "TestTitle", false, "1");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN_10(), equalTo("1234544444"));
		assertThat(aTestBook.getISBN_13(), equalTo("1234544444000"));
		assertThat(aTestBook.getAuthor(), equalTo("TestAuthor"));
		assertThat(aTestBook.getTitle(), equalTo("TestTitle"));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo("1"));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}

	/**
	 * A test which check the getters of the Book class with special character
	 * values.
	 */
	@Test
	public void bookSpecialsCharactersGettersTest() {
		// Preparation
		Book aTestBook = new Book("1234500000", "1234500000000", "T€st-@uth0r",
				"Test_²&é/*-+.0123456789<>,;:!§/.?ù*$^¨£µ%¤~#{}[]|`^@°'(-è_çà)=Title", true, "2");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN_10(), equalTo("1234500000"));
		assertThat(aTestBook.getISBN_13(), equalTo("1234500000000"));
		assertThat(aTestBook.getAuthor(), equalTo("T€st-@uth0r"));
		assertThat(aTestBook.getTitle(),
				equalTo("Test_²&é/*-+.0123456789<>,;:!§/.?ù*$^¨£µ%¤~#{}[]|`^@°'(-è_çà)=Title"));
		assertThat(aTestBook.isPresent(), equalTo(true));
		assertThat(aTestBook.getId(), equalTo("2"));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}

	/**
	 * A test which check the getters of the Book class with long values.
	 */
	@Test
	public void bookLongParametersGettersTest() {
		// Preparation
		Book aTestBook = new Book("1234567898765","1234567898765000",
				"TestAuthoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
				"TestTitleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", false,
				"1234567891011121314151617181920212223242526272829303132");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN_10(), equalTo("1234567898765"));
		assertThat(aTestBook.getISBN_13(), equalTo("1234567898765000"));
		assertThat(aTestBook.getAuthor(),
				equalTo("TestAuthoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aTestBook.getTitle(),
				equalTo("TestTitleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo("1234567891011121314151617181920212223242526272829303132"));
			// Sets test
		aTestBook.setIsPresent(false);
		assertThat(aTestBook.isPresent(), equalTo(false));
		// End
	}

	/**
	 * A test which check the getters of the Book class default constructor.
	 */
	@Test
	public void bookDefaultConstructor() {
		// Preparation
		Book aTestBook = new Book();
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN_10(), equalTo(null));
		assertThat(aTestBook.getISBN_13(), equalTo(null));
		assertThat(aTestBook.getAuthor(), equalTo(null));
		assertThat(aTestBook.getTitle(), equalTo(null));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo(null));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}
	
	/**
	 * A test which check the get method for ISBN values of the Book class.
	 */
	@Test
	public void bookGetISBNTest() {
		// Preparation
		Book bookISBN10 = new Book("1234567810", "TestAuthor", "TestTitle", false, "1");
		Book bookISBN13 = new Book("1234567891013", "TestAuthor", "TestTitle", false, "1");
		Book bookWithBadISBN = new Book("1", "TestAuthor", "TestTitle", false, "1");
		// Begin
			// Gets tests
				// For an ISBN 10
		assertThat(bookISBN10.getISBN_10(), equalTo("1234567810"));
		assertThat(bookISBN10.getISBN_13(), equalTo(null));
				// For an ISBN 13
		assertThat(bookISBN13.getISBN_10(), equalTo(null));
		assertThat(bookISBN13.getISBN_13(), equalTo("1234567891013"));
				// For a bad ISBN
		assertThat(bookWithBadISBN.getISBN_10(), equalTo(null));
		assertThat(bookWithBadISBN.getISBN_13(), equalTo(null));
		// End		
	}
	
	/**
	 * A test which check the set method for ISBN values of the Book class.
	 */
	@Test
	public void bookSetISBNTest() {
		// Preparation
		Book bookISBN10 = new Book("1234567810", "TestAuthor", "TestTitle", false, "1");
		bookISBN10.setISBN_13("1234567891013");
		
		Book bookISBN13 = new Book("1234567891013", "TestAuthor", "TestTitle", false, "1");
		bookISBN13.setISBN_10("1234567810");
		
		Book bookWithBadISBN = new Book("1", "TestAuthor", "TestTitle", false, "1");
		bookWithBadISBN.setISBN_10("1234567810");
		bookWithBadISBN.setISBN_13("1234567891013");
		
		// Begin
			// Gets tests
				// For an ISBN 10
		assertThat(bookISBN10.getISBN_10(), equalTo("1234567810"));
		assertThat(bookISBN10.getISBN_13(), equalTo("1234567891013"));
				// For an ISBN 13
		assertThat(bookISBN13.getISBN_10(), equalTo("1234567810"));
		assertThat(bookISBN13.getISBN_13(), equalTo("1234567891013"));
				// For a bad ISBN at the beginning
		assertThat(bookWithBadISBN.getISBN_10(), equalTo("1234567810"));
		assertThat(bookWithBadISBN.getISBN_13(), equalTo("1234567891013"));
		// End		
	}
}
