package com.lexicon.library.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Book {
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@NotNull
	private String title;
	@NotNull
	private String genre;
	@NotNull
	private String author;
	private String shelf = "Unknown";
	@NotNull
	private long isbn;
	private String publishingHouse;

	private int noOfPages;
	
	private bookStatus status = bookStatus.AVAILABLE;

	@OneToOne(mappedBy = "book")
	private Loan loan;

	public Book() {

	}


	public Book(String title, String genre, String author,
			long isbn) {
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.isbn = isbn;
	}


	public bookStatus getStatus() {
		return status;
	}


	public void setStatus(bookStatus status) {
		this.status = status;
	}


	public Loan getLoan() {
		return loan;
	}


	public void setLoan(Loan loan) {
		this.loan = loan;
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
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
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
