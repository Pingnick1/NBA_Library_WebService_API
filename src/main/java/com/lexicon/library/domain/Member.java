package com.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String surName;
	private String email;
	
//	@ManyToOne(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="loan", nullable=false)
//	private Loan loan;
	
	public Member() {	}
	
	public Member(String firstName, String surName, String email) {
		super();

		this.firstName = firstName;
		this.surName = surName;
		this.email = email;

	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member: " + firstName + " " + surName + ", " + email;
	}
	
	
}
