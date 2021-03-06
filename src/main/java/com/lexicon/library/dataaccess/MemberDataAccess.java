/**
 * 	Member DAO Interface
 */

package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Local;
//import javax.ws.rs.core.Response.ResponseBuilder;

import com.lexicon.library.domain.Member;
import com.lexicon.library.domain.memberStatus;

@Local
public interface MemberDataAccess {
	
	public void insert(Member newMember);
	
	public Member findMemberById(int id);
	
	public Member findMemberByEmail(String email);
	
	public List<Member> findAll();
	
	public List<Member> findMembersBySurName(String surName);
	
	public List<Member> findMembersByFirstName(String firstName);

	public List<Member> findMember(String criteria);

	public Member setMemberStatus(int memberId, memberStatus newStatus);
	
	public memberStatus getMemberStatus(int memberId);

	public List<memberStatus> getMemberPossibleStatus();

	public List<Member> findMembersByStatus(memberStatus status);

	public boolean deleteMember(int memberid);

	public boolean removeMember(int memberid);

}
