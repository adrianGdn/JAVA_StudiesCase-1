package com.edc.tp.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.edc.tp.book.Book;
import com.edc.tp.book.BookNotFoundException;
import com.edc.tp.book.AllBooksAlreadyReturnedException;
import com.edc.tp.book.UnavailableBookException;

public class Books implements Booker  {
	
	List<Book> listBook = new ArrayList<Book>();
	
	public Books()
	{
		initListe();
	}
	
	public void initListe()
	{
		Book fahrenheit451 = new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451");
		Book a = new Book("978-0671870362", "Benoît Cavrois", "Les bugs et moi");
		Book b = new Book("778-0671875162");
		listBook.add(fahrenheit451);
		listBook.add(a);
		listBook.add(b);
	}

	public Optional<Book> getBook(String id) {
		for(int i = 0; i < listBook.size(); i++)
		{
			Book book = listBook.get(i);
			String isbn = book.getISBN();
			if(id.equals(isbn))
			{
				Optional<Book> a = Optional.of(book);
				return a;
			}
		}
		Book b = new Book();
		Optional<Book> a = Optional.of(b);
		  
		return a;
	}

	public Optional<String> addBook(String isbn) {
		Optional<String> a = Optional.of(isbn);
		
		return a;
	}

	public void borrowBook(String id, String username) {
		
	}

	public void returnBook(String id, String username) {
		
	}
}
