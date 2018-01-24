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
	
	@NotNull
	private memberStatus status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="member")
	//@JoinColumn(name="LOAN_ID", nullable=true)
	private Set<Loan> loan;
	
//	public Set<Loan> getLoan() {
//		return loan;
//	}

	/**
	 * Set loan
	 * @param loan
	 */
	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}

	/**
	 * Get member id
	 * @return MemberId
	 */
	public Integer getId() {
		return id;
	}

	public Member() {	
		
	}		// Required empty constructor
	
	/**
	 * Constructor
	 * 
	 * @param firstName
	 * @param surName
	 * @param email
	 */
	public Member(String firstName, String surName, String email) {
		super();

		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
	}

	public memberStatus getStatus() {
		return status;
	}

	public void setStatus(memberStatus status) {
		this.status = status;
	}

	/**
	 * 
	 * @return Firstname
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set firstname
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Get surname
	 * @return String surname
	 */
	public String getSurName() {
		return surName;
	}
	
	/**
	 * Set surname
	 * @param surName String with surname
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	/**
	 * Return email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email
	 * @param email E-mail adress
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return String
	 */
	@Override	
	public String toString() {
		return "Member: " + firstName + " " + surName + ", " + email;
	}
	
	
}
