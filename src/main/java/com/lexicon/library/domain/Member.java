package com.lexicon.library.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String firstName;
	private String surName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="loan", nullable=false)
	private Loan loan;
	
	public Member() {	}
	
	public Member(String firstName, String surName) {
		super();
		
		
		this.firstName = firstName;
		this.surName = surName;

	}
}
