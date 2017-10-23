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
 * 
 * @author Alexis Dubus 
 * @author Adrian Gandon
 */
public class Books implements Library  {
	
	private List<Book> listBook = new ArrayList<Book>();
	private List<Book> listBookTotal = new ArrayList<Book>();
	private List<User> listUser = new ArrayList<User>();
	
	public Books()
	{
		initListeBook();
		initListeUser();
		initListeBookTotal();
	}
	
	private void initListeBook()
	{
		listBook.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true));
		listBook.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true));
		listBook.add(new Book("007", "James Bond", "Agent 007", true));
	}
	private void initListeBookTotal()
	{
		listBookTotal.add(new Book("978-0671870362", "Ray Bradbury", "Fahrenheit 451", true));
		listBookTotal.add(new Book("12345", "Benoît Cavrois", "Les bugs et moi", true));
		listBookTotal.add(new Book("123456", "Julien Petit", "Les licornes et moi", false));
		listBookTotal.add(new Book("858585", "Julien Petit", "La VR de demain", false));
		listBookTotal.add(new Book("007", "007", "007", true));
	}
	
	private void initListeUser()
	{
		listUser.add( new User("Benoît", "Cavrois", 42, "42", "bCavrois"));
		listUser.add( new User("Adrian", "Gandon", 23, "23", "aGandon"));
		listUser.add( new User("Alexis", "Dubus", 42, "91", "aDubus"));
		listUser.add( new User("Julien", "Petit", 20, "20", "jPetit"));
	}

	public Optional<Book> getBook(String id) {
		for(int i = 0; i < listBook.size(); i++)
		{
			Book book = listBook.get(i);
			if(id.equals(book.getISBN()))
			{
				Optional<Book> a = Optional.of(book);
				return a;
			}
		}
		return  Optional.of(new Book()); //par défaut, return un livre vide
	}

	public Optional<String> addBook(String isbn) {
		for(int i = 0; i < listBookTotal.size(); i++)
		{
			Book book = listBook.get(i);
			if(isbn.equals(book.getISBN()))
			{
				listBook.add(book);
				return  Optional.of(book.getISBN());
			}
		}
		return  Optional.of(""); //par défaut, on return un optional d'une chaine de caractére vide
	}
	
	public void borrowBook(String id, String username) throws UnavailableBookException, UnavailableBookException {
		boolean bookNotFound = true;
		if(userExisteInListe(username))
		{
			return; //si l'utilisateur n'est pas dans la liste des utilisateur de la bibliothéque, il n'a rien a faire ici !
		}
		else
		{
			for(int i = 0; i < listBook.size(); i++)
			{
				Book book = listBook.get(i);
				if(id.equals(book.getISBN()))
				{
					if(book.isPresent())
					{
						getUserInListe(username).setBook(book); //@toDo géré le cas ou un utilisateur a déja un livre
						return;
					}
					else
					{
						throw new UnavailableBookException();
					}
				}
			}
		}
		if(bookNotFound)
		{
			throw new UnavailableBookException();
		}
	}
	
	/**
	 * vérifie si l'utilisateur est bien présent dans la liste
	 * @param username
	 * @return boolean
	 */
	private boolean userExisteInListe(String username)
	{
		boolean existe = false;
		for(int i = 0; i < listUser.size(); i++)
		{
			User user = listUser.get(i);
			if(username.equals(user.getUsername()))
			{
				return true;
			}
		}
		return existe;
	}
	
	/**
	 * récupére un utilisateur unique dans la liste
	 * @param username
	 * @return User
	 */
	private User getUserInListe(String username)
	{
		User userStd = new User();
		if(userExisteInListe(username)) {	
			for(int i = 0; i < listUser.size(); i++)
			{
				User user = listUser.get(i);
				if(username.equals(user.getUsername()))
				{
					return user;
				}
			}	
		}
		return userStd;
	}

	public void returnBook(String id, String username) {
		
	}
	
	
	
	public List<Book> getBooks(){
		return listBook;
	}

	public List<Book> searchBooks(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
