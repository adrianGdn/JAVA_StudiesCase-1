package com.epsi.edc1.library.impl.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.User;

/**
 * @author Adrian Gandon
 */
public class UserTests {
	/**
	 * A test which check the getters of the User class with simple values.
	 */
	@Test
	public void userSimpleGettersTest() {
		// Preparation
		User aUserTest = new User("TestFirstName", "TestSecondName", 1, "TestUsername");
		Book aTestBook = new Book("1234567899", "TestAuthor", "TestTitle", false, "1");
		// Begin
			// Gets tests
		assertThat(aUserTest.getName(), equalTo("TestFirstName"));
		assertThat(aUserTest.getSurname(), equalTo("TestSecondName"));
		assertThat(aUserTest.getAge(), equalTo(1));
		assertThat(aUserTest.getUsername(), equalTo("TestUsername"));
			// Methods tests
		assertThat(aUserTest.getBooks().size(), equalTo(0));
				// We set a book to the user
		aUserTest.addBook(aTestBook);
		List<Book> aListTestBook = new ArrayList<Book>();
		aListTestBook.add(aTestBook);
		assertThat(aUserTest.getBooks(), equalTo(aListTestBook));
				// We return the book of the user
		aUserTest.returnBorrowBook(aTestBook);
		assertThat(aUserTest.getBooks().size(), equalTo(0));
		// End
	}

	/**
	 * A test which check the getters of the User class with special character
	 * values.
	 */
	@Test
	public void userSpecialsCharactersGettersTest() {
		// Preparation
		User aUserTest = new User("f!rst_N@m€", "Sécond-Näme", 2, "Test*/*%:;,?.+-çé'&²~#{([])}|`-è_çUsernàme");
		Book aTestBook = new Book("1234567800", "T€st-@uth0r",
				"Test_²&é/*-+.0123456789<>,;:!§/.?ù*$^¨£µ%¤~#{}[]|`^@°'(-è_çà)=Title", false, "1");
		// Begin
			// Gets tests
		assertThat(aUserTest.getName(), equalTo("f!rst_N@m€"));
		assertThat(aUserTest.getSurname(), equalTo("Sécond-Näme"));
		assertThat(aUserTest.getAge(), equalTo(2));
		assertThat(aUserTest.getUsername(), equalTo("Test*/*%:;,?.+-çé'&²~#{([])}|`-è_çUsernàme"));
			// Methods tests
		assertThat(aUserTest.getBooks().size(), equalTo(0));
				// We set a book to the user
		aUserTest.addBook(aTestBook);
		List<Book> aListTestBook = new ArrayList<Book>();
		aListTestBook.add(aTestBook);
		assertThat(aUserTest.getBooks(), equalTo(aListTestBook));
				// We return the book of the user
		aUserTest.returnBorrowBook(aTestBook);
		assertThat(aUserTest.getBooks().size(), equalTo(0));
		// End
	}

	/**
	 * A test which check the getters of the User class with long values.
	 */
	@Test
	public void userLongParametersGettersTest() {
		// Preparation
		User aUserTest = new User(
				"TestFirstNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
				"TestSecondNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
				1999999999,
				"TestUsernameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		Book aTestBook = new Book("1234567890",
				"TestAuthoreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
				"TestTitleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", false,
				"1234567891011121314151617181920212223242526272829303132");
		// Begin
			// Gets tests
		assertThat(aUserTest.getName(),
				equalTo("TestFirstNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aUserTest.getSurname(),
				equalTo("TestSecondNameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
		assertThat(aUserTest.getAge(), equalTo(1999999999));
		assertThat(aUserTest.getUsername(),
				equalTo("TestUsernameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
			// Methods tests
		assertThat(aUserTest.getBooks().size(), equalTo(0));
			// We set a book to the user
		aUserTest.addBook(aTestBook);
		List<Book> aListTestBook = new ArrayList<Book>();
		aListTestBook.add(aTestBook);
		assertThat(aUserTest.getBooks(), equalTo(aListTestBook));
			// We return the book of the user
		aUserTest.returnBorrowBook(aTestBook);
		assertThat(aUserTest.getBooks().size(), equalTo(0));
		// End
	}

	/**
	 * A test which check the getters of the User class default constructor.
	 */
	@Test
	public void userDefaultConstructor() {
		// Preparation
		User aUserTest = new User();
		Book aTestBook = new Book("1234567890", "TestAuthor", "TestTitle", false, "1");
		// Begin
			// Gets tests
		assertThat(aUserTest.getName(), equalTo(null));
		assertThat(aUserTest.getSurname(), equalTo(null));
		assertThat(aUserTest.getAge(), equalTo(0));
		assertThat(aUserTest.getUsername(), equalTo(null));
			// Methods tests
		assertThat(aUserTest.getBooks().size(), equalTo(0));
				// We set a book to the user
					// With a null value set
		aUserTest.addBook(null);
		assertThat(aUserTest.getBooks().size(), equalTo(1));
					// With a default constructor
		aUserTest.addBook(new Book());
		assertNotEquals(aUserTest.getBooks(), equalTo(null));
					// With a real value set
		aUserTest.addBook(aTestBook);
		
		assertThat(aUserTest.getBooks().size(), equalTo(3));
				// We return the book of the user
		aUserTest.returnBorrowBook(aTestBook);
		assertThat(aUserTest.getBooks().size(), equalTo(2));
		// End
	}
}
