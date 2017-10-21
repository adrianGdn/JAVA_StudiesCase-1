package com.edc.tp.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.edc.tp.book.Book;
import com.edc.tp.book.BookNotFoundException;
import com.edc.tp.book.AllBooksAlreadyReturnedException;
import com.edc.tp.book.UnavailableBookException;

/**
 * 
 * @author Alexis Dubus 
 * @author Adrian Gandon
 */
public class Books implements Booker  {
	
	List<Book> listBook = new ArrayList<Book>();
	
	public Books()
	{
		initListe();
	}
	
	public void initListe()
	{
		listBook.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451"));
		listBook.add(new Book("978-0671870362", "Benoît Cavrois", "Les bugs et moi"));
		listBook.add(new Book("007", "007", "007"));
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
		Optional<Book> a = Optional.of(new Book());
		  
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
	
	/*List<Book>	getBooks(){
		return listBook;
	} */
}
