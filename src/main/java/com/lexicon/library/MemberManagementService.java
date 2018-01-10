package com.lexicon.library;

import java.util.List;

import javax.ejb.Remote;

import com.lexicon.library.domain.Member;

@Remote
public interface MemberManagementService {
	
	public void registerMember(Member newMember);
	
	public List<Member> getAllMembers();
	
	public List<Member> searchBySurname(String surName);
}
