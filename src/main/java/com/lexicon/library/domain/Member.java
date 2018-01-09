package com.lexicon.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String surName;
	
	public Member() {}
	
	public Member(String firstName, String surName) {
		super();
		
		
		this.firstName = firstName;
		this.surName = surName;

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
	
	
	@Override
	public String toString() {
		return "Member: " + firstName + " " + surName;
	}
	
	
}
