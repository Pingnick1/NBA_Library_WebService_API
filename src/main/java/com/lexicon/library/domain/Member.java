package com.lexicon.library.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull	
	private String firstName;
	
	@NotNull
	private String surName;
	
	@Email
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="member")
	//@JoinColumn(name="LOAN_ID", nullable=true)
	private Set<Loan> loan;
	
//	public Set<Loan> getLoan() {
//		return loan;
//	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}

	public Integer getId() {
		return id;
	}

	public Member() {	
		
	}		// Required empty constructor
	
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
