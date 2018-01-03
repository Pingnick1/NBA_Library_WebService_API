package com.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private String id;

	@NotNull
	private String title;
	@NotNull
	private String genre;
	@NotNull
	private String author;
	private String shelf = "Unknown";
	@NotNull
	private String isbn;
	private String publishingHouse;
	private int noOfPages;



	public Book() {

	}


	public Book(String title, String genre, String author,
			String isbn, String publishingHouse, int noOfPages) {
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.isbn = isbn;
		this.publishingHouse = publishingHouse;
		this.noOfPages = noOfPages;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public int getNoOfPages() {
		return noOfPages;
	}


}
