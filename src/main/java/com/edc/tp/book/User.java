package com.edc.tp.book;

/**
 * Class User, pour la gestion des utilisateurs
 * @author Adrian Gandon
 * @author Alexis Dubus 
 *
 */
public class User {
	private String name; 
	private String surname;
	private int age; 
	private String ID;
	
	public User()
	{
		
	}
	
	public User(String name, String surname, int age, String id)
	{
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setID(id);
	}
	
	
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
	
	
}
