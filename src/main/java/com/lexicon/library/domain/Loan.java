package com.lexicon.library.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;




@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotNull
	private LocalDate startDate;
//	@DateTimeFormat(SimpleDate)
	private LocalDate endDate;
	
	@NotNull
	private loanStatus status = loanStatus.ACTIVE;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="loan")
//	@JoinColumn(name = "BOOK_ID")
//	@NotNull
	private Set<Book> books;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name = "MEMBER_ID")
//	@NotNull
	private Member member;

	public Loan() {
	}

	public Loan(String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		LocalDate now = LocalDate.now();
		this.startDate = now;
		this.endDate = LocalDate.parse(endDate.substring(0, 10), formatter);
	}

	public Loan(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		this.startDate = LocalDate.parse(startDate.substring(0, 10), formatter);
		this.endDate = LocalDate.parse(endDate.substring(0, 10), formatter);
	}

	


	public void setBook(Book book) {
		books.add(book);
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public loanStatus getStatus() {
		return status;
	}
	public void setStatus(loanStatus status) {
		this.status = status;
	}

//	public Member getMember() {
//		return member;
//	}
	
	public void setMember(Member member) {
		this.member = member;
	}	
	
}
