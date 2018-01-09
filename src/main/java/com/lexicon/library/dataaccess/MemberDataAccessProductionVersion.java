package com.lexicon.library.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lexicon.library.domain.Member;

@Stateless
//@Default
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.MemberDataAccess#insert(com.lexicon.library.domain.Member)
	 */
	@Override
	public void insert(Member newMember) {

	}

	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.MemberDataAccess#findAll()
	 */
	@Override
	public List<Member> findAll() {
		
		Query q = em.createQuery("select member from Member member");
		List<Member> members = q.getResultList();
		
		return members;
	}

	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.MemberDataAccess#findBySurname(java.lang.String)
	 */
	@Override
	public List<Member> findBySurname(String surName) {

		return null;
	}

}