package com.edc.tp.book;

public class Book {
	
	private String auteur;
	private String ISBN;
	private String titre;
	
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
	
	public Book(String iSBN, String auteur, String titre)
	{
		this.setISBN(iSBN);
		this.setAuteur(auteur);
		this.setTitre(titre);
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
	
	public String toString()
	{
		return "Ce livre à pour titre : "+ this.getTitre()+ ", son code ISBN est : "+ this.getISBN()+ ", son auteur est : "+ this.getAuteur();
	}

}
