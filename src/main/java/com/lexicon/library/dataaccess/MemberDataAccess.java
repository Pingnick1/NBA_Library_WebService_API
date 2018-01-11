package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.lexicon.library.domain.Member;

@Local
public interface MemberDataAccess {
	public void insert(Member newMember);
	
	public List<Member> findAll();
	
	public List<Member> findBySurname(String surName);
}
