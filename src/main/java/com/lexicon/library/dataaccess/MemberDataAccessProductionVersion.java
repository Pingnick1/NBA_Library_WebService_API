package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
//import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lexicon.library.domain.Member;

@Stateless
//@Default
@ProductionDao
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@PersistenceContext
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
