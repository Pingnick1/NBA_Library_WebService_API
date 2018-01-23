/**
 * 	Member DAO Interface
 */

package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Local;

import com.lexicon.library.domain.Member;

@Local
public interface MemberDataAccess {
	
	public void insert(Member newMember);
	
	public Member findMemberById(int id);
	
	public Member findMemberByEmail(String email);
	
	public List<Member> findAll();
	
	public List<Member> findMembersBySurName(String surName);
	
	public List<Member> findMembersByFirstName(String firstName);

	public List<Member> findMember(String criteria);

}
