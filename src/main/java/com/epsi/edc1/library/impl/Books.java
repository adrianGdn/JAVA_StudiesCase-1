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
 * Library implementation
 * @author Alexis Dubus 
 * @author Adrian Gandon
 */
public class Books implements Library  {
	
	private List<Book> listBook = new ArrayList<Book>(); //the library list of book. Some book can have the same title or ISBN, but the ID must differ. 
	private List<Book> listBookGlobal = new ArrayList<Book>(); //the global list of book. The book in this list can be add to the listBook
	private List<User> listUser = new ArrayList<User>(); //the user list of the library. They have access to the library book
	
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
		listBook.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "978"));//first book of Ray Bradbury in the library
		listBook.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "1"));//second book of Ray Bradbury in the library
		listBook.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "42"));
		listBook.add(new Book("007", "James Bond", "Agent 007", true, "7"));
		listBook.add(new Book("23232", "I am an author", "I am a title", true, "2323001"));
	}
	
	/**
	 * init the global list of book
	 * They can be add to listBook with addBook
	 */
	private void initListeBookTotal()
	{
		listBookGlobal.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true, "4"));
		listBookGlobal.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true, "43"));
		listBookGlobal.add(new Book("123456", "Julien Petit", "Les licornes et moi", true, "6"));
		listBookGlobal.add(new Book("858585", "Julien Petit", "La VR de demain", true, "10"));
		listBookGlobal.add(new Book("007", "007", "007", true, "21"));
	}
	
	/**
	 * init the library user list
	 */
	private void initListeUser()
	{
		listUser.add(new User("Benoît", "Cavrois", 42, "bCavrois"));
		listUser.add(new User("Adrian", "Gandon", 23, "aGandon"));
		listUser.add(new User("Alexis", "Dubus", 42, "aDubus"));
		listUser.add(new User("Julien", "Petit", 20, "jPetit"));
		listUser.add(new User("I am the user", "I am the surname", 23, "I am the username"));
	}

	public Optional<Book> getBook(String id) {
		for(int i = 0; i < listBook.size(); i++)//search trough listBook
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
		for(int i = 0; i < listBookGlobal.size(); i++)//search trough listBookGlobal
		{
			Book book = listBookGlobal.get(i);
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
		if(!userExistInList(username))
		{
			return; //if the user isn't in the library book, he hasn't the right access
		}
		else
		{
			for(int i = 0; i < listBook.size(); i++)
			{
				Book book = listBook.get(i);
				if(id.equals(book.getId()))//if the id is equals, it's the good book
				{
					countNumberOkIsbnBook++;
					if(book.isPresent())//check if the book is present in the library in case someone already borrow it
					{
						User theUser = getUserInList(username);
						if(theUser.getBook() == null) { //in case the user have already another book
							book.setIsPresent(false); 
							listBook.get(i).setIsPresent(false);//the book is now unavailable in the library
							theUser.setBook(book); //the user now get his book
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
		//part with the Exception
		if(countNumberOkIsbnBook == countNumberUnavalaibleBook) //if all book with the given id aren't present
		{
			throw new UnavailableBookException();//the is unavailable in the library
		}
		if(bookNotFound)
		{
			throw new BookNotFoundException();//the book wasn't found
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
			if(username.equals(user.getUsername()))//identification is done with the username
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
	public User getUserInList(String username)
	{
		User userStd = new User();
		if(userExistInList(username)) {	
			for(int i = 0; i < listUser.size(); i++)
			{
				User user = listUser.get(i);
				if(username.equals(user.getUsername()))//identification is done with the username
				{
					return user;
				}
			}	
		}
		return userStd; //by default, an empty user is returned
	}

	public void returnBook(String id, String username) throws BookNotFoundException, AllBooksAlreadyReturnedException {
		///////////// Part search of the book /////////////
		Book returnedBook = null;
		int counterBook = 0;
		boolean bookFind = false;
		
		// We search the returned book
		while (counterBook <= listBook.size() && bookFind == false) {
			returnedBook = listBook.get(counterBook);
			if (returnedBook.getId().equals(id)) {
				bookFind = true;
			}
			counterBook++;
		}
		// If we haven't find the book, we throw an exception
		if (counterBook <= listBook.size() && bookFind == false) {
			throw new BookNotFoundException();
		}
		
		
		///////////// Part search of the user /////////////
		int counterUser = 0;
		boolean userFind = false;
		User userWhoReturnBook = null;
		// We search the user who has returned the book
		while (counterUser <= listUser.size() && userFind == false) {
			userWhoReturnBook = listUser.get(counterUser);
			if (username. contains(userWhoReturnBook.getUsername())) {
				userFind = true;
			}
			counterUser++;
		}
		// If we haven't find the book, we throw an exception
		if (counterUser <= listUser.size() && userFind == false) {
			throw new AllBooksAlreadyReturnedException();
		}
		
		///////////// Part return the book /////////////
		listUser.get(counterUser).returnBorrowBook();
		listBook.get(counterBook).isPresent();
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
