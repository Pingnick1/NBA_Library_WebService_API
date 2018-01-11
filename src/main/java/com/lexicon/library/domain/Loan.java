package com.lexicon.library.domain;


import java.util.Date;
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
	
	private Date startDate;
	private Date endDate;
	@NotNull
	private loanStatus status = loanStatus.ACTIVE;
	
	@OneToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name = "BOOK_ID")
//	@NotNull
	private Book book;
	
	public Loan() {
	}
	
	public Loan(Date startDate,Date endDate) {
		this.startDate =startDate;
		this.endDate = endDate;
	}

	

	public Loan(Date endDate) {
//		Date date = new java.sql.Date(System.currentTimeMillis());
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String stringStartDate = now.format(formatter);
		this.endDate = endDate;
	}

	
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public loanStatus getStatus() {
		return status;
	}
	public void setStatus(loanStatus status) {
		this.status = status;
	}
	
}
