package com.edc.tp.book;

import com.edc.tp.book.Book;

/**
 * Class User, pour la gestion des utilisateurs
 * @author Adrian Gandon
 * @author Alexis Dubus 
 *
 */
public class User {
	private String name; 
	private String surname;
	private String username;
	private int age; 
	private String ID;
	private Book book;//un utilisateur ne peut emprunté qu'un seul livre
	
	public User()
	{
		
	}
	
	public User(String name, String surname, int age, String id, String username)
	{
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setID(id);
		this.setUsername(username);
	}
	
	
	/* début des getters/setters */
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getID() {
		return this.ID;
	}
	public void setID(String iD) {
		this.ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	} 
	/* fin des getters/setters */
	
}
