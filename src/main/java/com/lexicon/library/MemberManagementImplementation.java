/**
 * 	Deprecated Class and not used.
 * 
 */

package com.lexicon.library;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lexicon.library.dataaccess.MemberDataAccess;
import com.lexicon.library.domain.Member;

@Stateless
public class MemberManagementImplementation implements MemberManagementService {

	@Inject
	private MemberDataAccess dao;
	
	@Override
	public void registerMember(Member newMember) {
		dao.insert(newMember);
	}

	@Override
	public List<Member> getAllMembers() {
		return dao.findAll();
	}

	@Override
	public List<Member> searchBySurname(String surName) {
		return dao.findMembersBySurName(surName);
	}

}
