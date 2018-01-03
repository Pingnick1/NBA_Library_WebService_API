package com.lexicon.library.dataaccess;

import java.util.List;
import com.lexicon.library.domain.Member;

public interface MemberDataAccess {
	public void insert(Member newEmployee);
	
	public List<Member> findAll();
	
	public List<Member> findBySurname(String surName);
}
