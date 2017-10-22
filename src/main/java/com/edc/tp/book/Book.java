package com.edc.tp.book;

/**
 * Class Book, pour la gestion des livres
 * @author Adrian Gandon
 * @author Alexis Dubus
 *
 */
public class Book {
	
	private String auteur;
	private String ISBN;
	private String titre;
	private boolean estPresent; 
	
	public Book()
	{
		
	}
	
	public Book(String iSBN)
	{
		this.setISBN(iSBN);
	}
	
	public Book(String iSBN, String auteur)
	{
		this.setISBN(iSBN);
		this.setAuteur(auteur);
	}
	
	public Book(String iSBN, String auteur, String titre, boolean present)
	{
		this.setISBN(iSBN);
		this.setAuteur(auteur);
		this.setTitre(titre);
		this.setPresent(present);
	}
	
	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getISBN() {
		return this.ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public boolean isPresent() {
		return estPresent;
	}

	public void setPresent(boolean estPresent) {
		this.estPresent = estPresent;
	}

	public String toString()
	{
		return "Ce livre à pour titre : "+ this.getTitre()+ ", son code ISBN est : "+ this.getISBN()+ ", son auteur est : "+ this.getAuteur();
	}

	public boolean equals(Book obj) {
        return super.equals(obj);
    }
}
