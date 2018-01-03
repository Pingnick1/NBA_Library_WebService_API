package com.lexicon.library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.lexicon.library.domain.Member;


@Stateless
//@Alternative
@TestingDao
public class MemberDataAccessTestingVersion implements MemberDataAccess {

	@Override
	public void insert(Member newMember) {
		

	}

	@Override
	public List<Member> findAll() {
		Member e1 = new Member("Niklas", "Svensson");
		Member e2 = new Member("Sune", "Gunvaldsson");
		Member e3 = new Member("Test", "Pettersson");
		List<Member> members = new ArrayList<Member>();
		
		members.add(e1);
		members.add(e2);
		members.add(e3);
		
		return members;
	}

	@Override
	public List<Member> findBySurname(String surName) {
		
		return null;
	}

}
