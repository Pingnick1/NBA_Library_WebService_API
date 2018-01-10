package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
//import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lexicon.library.domain.Member;

@Stateless
//@Default
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@Inject
	private EntityManager em;
	
	@Override
	public void insert(Member newMember) {
		em.persist(newMember);
	}

	@Override
	public List<Member> findAll() {
		Query q = em.createQuery("select member from Member member");
		List<Member> members = q.getResultList();
		return members;
	}

	@Override
	public List<Member> findBySurname(String surName) {

		return null;
	}

}
