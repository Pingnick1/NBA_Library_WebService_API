package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lexicon.library.domain.Member;

@Stateless
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@Inject
	private EntityManager em;
	
	/**
	 * 	Create new member.
	 */
	@Override
	public void insert(Member newMember) {
		em.persist(newMember);
	}

	/**
	 * Get all members.
	 * 
	 */
	@Override
	public List<Member> findAll() {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
		return query.getResultList();
	}
	
	/**
	 * 	Find member by ID
	 */
	@Override
	public Member findMemberById(int id) {
		return em.find(Member.class, id);	
	}
	
	/**
	 * 	Find member by Email
	 */
	@Override
	public Member findMemberByEmail(String email) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.email LIKE ?1", Member.class);		
		query.setParameter(1, email);
		return query.getSingleResult();
	}

	/**
	 * 	Find members by firstname
	 * 	param String 
	 */
	@Override
	public List<Member> findMembersByFirstName(String firstName) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.firstName LIKE ?1", Member.class);	
		query.setParameter(1, "%" + firstName + "%");
		return query.getResultList();
	}
	
	/**
	 *  Find members by lastname.
	 */
	@Override
	public List<Member> findMembersBySurName(String surName) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.surName LIKE ?1", Member.class);
		query.setParameter(1, "%" + surName + "%");
		return query.getResultList();
	}
	
}