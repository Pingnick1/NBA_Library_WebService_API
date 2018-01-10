package com.lexicon.library.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;




@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String startDate;
	private String endDate;
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	@NotNull
	private loanStatus status = loanStatus.ACTIVE;
	
	@OneToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name = "BOOK_ID")
//	@NotNull
	private Book book;
	
	public Loan() {
	}
	
	public Loan(String startDate, String endDate) {
		this.startDate =startDate;
		this.endDate = endDate;
	}

	

	public Loan(String endDate) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String stringStartDate = now.format(formatter);
		this.startDate = stringStartDate;
		this.endDate = endDate;
	}

	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public loanStatus getStatus() {
		return status;
	}
	public void setStatus(loanStatus status) {
		this.status = status;
	}
	
}
