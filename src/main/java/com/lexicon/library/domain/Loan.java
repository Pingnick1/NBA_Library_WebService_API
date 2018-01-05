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



@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	private Member member;
//	private Book book;
	private LocalDate startDate;
	private LocalDate endDate;
	private boolean active=true;
	
	@OneToMany(mappedBy="book", fetch=FetchType.LAZY)
	private Set<Book> books;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn (name="id", nullable = false)
	private Member member;
	
	public Loan() {
		super();
	}
	public Loan(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isActive() {
		return active;
	}
	public void setActiveFalse(boolean active) {
		this.active = false;
	} 
	
}
