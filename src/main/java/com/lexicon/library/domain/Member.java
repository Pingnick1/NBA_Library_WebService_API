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
	
	private String firstName;
	private String surName;
	
	public Member() {	}
	
	public Member(String firstName, String surName) {
		super();
		
		
		this.firstName = firstName;
		this.surName = surName;

	}
}
