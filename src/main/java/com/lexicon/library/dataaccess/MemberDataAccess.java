package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Member;

public interface MemberDataAccess {

	void insert(Member newMember);

	List<Member> findAll();

	List<Member> findBySurname(String surName);

}