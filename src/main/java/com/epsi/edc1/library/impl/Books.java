package com.epsi.edc1.library.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epsi.edc1.library.Library;
import com.epsi.edc1.library.impl.AllBooksAlreadyReturnedException;
import com.epsi.edc1.library.impl.Book;
import com.epsi.edc1.library.impl.BookNotFoundException;
import com.epsi.edc1.library.impl.UnavailableBookException;
import com.epsi.edc1.library.impl.User;

/**
 * Libray implementation
 * @author Alexis Dubus 
 * @author Adrian Gandon
 */
public class Books implements Library  {
	
	private List<Book> listBook = new ArrayList<Book>(); //the library list of book
	private List<Book> listBookTotal = new ArrayList<Book>(); //the global list of book
	private List<User> listUser = new ArrayList<User>(); //the user list of book
	
	/**
	 * constructor, where the init method are used
	 */
	public Books()
	{
		initListeBook();
		initListeUser();
		initListeBookTotal();
	}
	
	/**
	 * init the library list book
	 */
	private void initListeBook()
	{
		listBook.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "1"));
		listBook.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "42"));
		listBook.add(new Book("007", "James Bond", "Agent 007", true, "7"));
	}
	
	/**
	 * init the global list of book
	 */
	private void initListeBookTotal()
	{
		listBookTotal.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "1"));
		listBookTotal.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "42"));
		listBookTotal.add(new Book("123456", "Julien Petit", "Les licornes et moi", false, "2"));
		listBookTotal.add(new Book("858585", "Julien Petit", "La VR de demain", false, "3"));
		listBookTotal.add(new Book("007", "007", "007", true, "7"));
	}
	
	/**
	 * init the user library user list
	 */
	private void initListeUser()
	{
		listUser.add( new User("Benoît", "Cavrois", 42, "bCavrois"));
		listUser.add( new User("Adrian", "Gandon", 23, "aGandon"));
		listUser.add( new User("Alexis", "Dubus", 42, "aDubus"));
		listUser.add( new User("Julien", "Petit", 20, "jPetit"));
	}

	public Optional<Book> getBook(String id) {
		for(int i = 0; i < listBook.size(); i++)
		{
			Book book = listBook.get(i);
			if(id.equals(book.getId()))
			{
				return Optional.of(book);
			}
		}
		return  Optional.of(new Book()); //by default, send an empty Optional<Book>
	}

	public Optional<String> addBook(String isbn) {
		for(int i = 0; i < listBookTotal.size(); i++)
		{
			Book book = listBookTotal.get(i);
			if(isbn.equals(book.getISBN()))
			{
				listBook.add(book);
				return  Optional.of(book.getISBN());
			}
		}
		return  Optional.of(""); //by default, return a Optionnal of an empty string
	}
	
	public void borrowBook(String id, String username) throws UnavailableBookException, BookNotFoundException {
		boolean bookNotFound = true;
		int countNumberUnavalaibleBook = 0; 
		int countNumberOkIsbnBook = 0;
		if(userExistInList(username))
		{
			return; //if the user isn't in the library book, he hasn't the access right
		}
		else
		{
			for(int i = 0; i < listBook.size(); i++)
			{
				Book book = listBook.get(i);
				if(id.equals(book.getId()))//if the id is equals, it's the good book
				{
					countNumberOkIsbnBook++;
					if(book.isPresent())
					{
						User theUser = getUserInList(username);
						if(theUser.getBook().getId().equals(null)) { //in case the user have already another book
							book.setIsPresent(false); 
							listBook.get(i).setIsPresent(false);//the book is now unavailable in the library
							theUser.setBook(book); 
							return;
						}
					}
					else
					{
						countNumberUnavalaibleBook++;
					}
				}
			}
		}
		if(countNumberOkIsbnBook == countNumberUnavalaibleBook) //if all book with the given id aren't present
		{
			throw new UnavailableBookException();
		}
		if(bookNotFound)
		{
			throw new BookNotFoundException();
		}
	}
	
	/**
	 * check if a user is in the list
	 * @param username
	 * @return boolean
	 */
	private boolean userExistInList(String username)
	{
		boolean exist = false;//the user doesn't exist in the list by default
		for(int i = 0; i < listUser.size(); i++)
		{
			User user = listUser.get(i);
			if(username.equals(user.getUsername()))
			{
				return true;
			}
		}
		return exist;
	}
	
	/**
	 * get a unique user in the list
	 * @param username
	 * @return User
	 */
	private User getUserInList(String username)
	{
		User userStd = new User();
		if(userExistInList(username)) {	
			for(int i = 0; i < listUser.size(); i++)
			{
				User user = listUser.get(i);
				if(username.equals(user.getUsername()))
				{
					return user;
				}
			}	
		}
		return userStd; //by default, an empty user is returned
	}

	public void returnBook(String id, String username) {
		
	}
	
	
	
	public List<Book> getBooks(){
		return listBook;
	}

	public List<Book> searchBooks(String searchTerm) {
		List<Book>  list = new ArrayList<Book>(); //init the list<Book>
		for(int i = 0; i < listBook.size(); i++)
		{
			Book book = listBook.get(i);
			if(book.getAuthor().contains(searchTerm) || book.getTitle().contains(searchTerm) || book.getISBN().contains(searchTerm)) //all test are done here
			{
				list.add(book);
			}
		}
		return list;
	} 
	
}
