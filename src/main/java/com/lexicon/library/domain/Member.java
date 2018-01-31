package com.lexicon.library.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
    @NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String firstName;
	
	@NotNull
	@Size(min = 1, max = 25)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
	private String surName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private memberStatus status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="member")
	private Set<Loan> loan;
	

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
