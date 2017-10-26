package com.epsi.edc.library.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.User;

public class BookTests {
	@Test
	public void bookSimpleGettersTest() {
		// Preparation
		Book aTestBook = new Book("1234", "TestAuthor", "TestTitle", false, "1");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN(), equalTo("1234"));
		assertThat(aTestBook.getAuthor(), equalTo("TestAuthor"));
		assertThat(aTestBook.getTitle(), equalTo("TestTitle"));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo("1"));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}
	
	@Test
	public void bookSpecialsCaractersGettersTest() {
		// Preparation
		Book aTestBook = new Book("12345", "T€st-@uth0r", "Test_²&é/*-+.0123456789<>,;:!§/.?ù*$^¨£µ%¤~#{}[]|`^@°'(-è_çà)=Title", true, "2");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN(), equalTo("12345"));
		assertThat(aTestBook.getAuthor(), equalTo("T€st-@uth0r"));
		assertThat(aTestBook.getTitle(), equalTo("Test_²&é/*-+.0123456789<>,;:!§/.?ù*$^¨£µ%¤~#{}[]|`^@°'(-è_çà)=Title"));
		assertThat(aTestBook.isPresent(), equalTo(true));
		assertThat(aTestBook.getId(), equalTo("2"));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}
	
	@Test
	public void bookLongParametersGettersTest() {
		// Preparation
		Book aTestBook = new Book("1234567891011121314151617181920212223242526272829303132", "TestAuthoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", "TestTitleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", false, "1234567891011121314151617181920212223242526272829303132");
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN(), equalTo("1234567891011121314151617181920212223242526272829303132"));
		assertThat(aTestBook.getAuthor(), equalTo("TestAuthoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aTestBook.getTitle(), equalTo("TestTitleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo("1234567891011121314151617181920212223242526272829303132"));
			// Sets test
		aTestBook.setIsPresent(false);
		assertThat(aTestBook.isPresent(), equalTo(false));
		// End
	}
	
	@Test
	public void bookDefaultConstructor() {
		// Preparation
		Book aTestBook = new Book();
		// Begin
			// Gets tests
		assertThat(aTestBook.getISBN(), equalTo(null));
		assertThat(aTestBook.getAuthor(), equalTo(null));
		assertThat(aTestBook.getTitle(), equalTo(null));
		assertThat(aTestBook.isPresent(), equalTo(false));
		assertThat(aTestBook.getId(), equalTo(null));
			// Sets test
		aTestBook.setIsPresent(true);
		assertThat(aTestBook.isPresent(), equalTo(true));
		// End
	}
}
