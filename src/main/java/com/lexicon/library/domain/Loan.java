package com.lexicon.library.domain;


import java.time.LocalDate;
import java.util.Set;

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



@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate startDate;
	private LocalDate endDate;
	private loanStatus status;
	
	@OneToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	private Book books;
	
//	@ManyToOne(cascade=CascadeType.PERSIST)
//	private Member member;
	
	public Loan() {
		super();
	}
	public Loan(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
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
	
}
