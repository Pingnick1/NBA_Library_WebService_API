package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
//import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lexicon.library.domain.Book;
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
		//Query q = em.createQuery("select m from Member m");
		//List<Member> members = q.getResultList();
		
		//return members;
		
		
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
		//Query query = em.createQuery("select * from Member");
		return query.getResultList();
	}
	
	@Override
	public Member findMemberById(int id) {
		return em.find(Member.class, id);	
	}
	
	@Override
	public Member findMemberByEmail(String email) {
		TypedQuery<Member> query = em.createQuery("SELECT member FROM Member member WHERE member.email = :replace", Member.class);		
		query.setParameter("replace", email);
		return query.getSingleResult();
	}

	
	@Override
	public List<Member> findMembersByFirstName(String firstName) {
		TypedQuery<Member> query = em.createQuery("SELECT member FROM Member member WHERE member.firstName = :replace", Member.class);	
		query.setParameter("replace", firstName);
		return query.getResultList();
	}
	
	@Override
	public List<Member> findMembersBySurName(String surName) {
		TypedQuery<Member> query = em.createQuery("SELECT member FROM Member member WHERE member.surName = :replace", Member.class);
		query.setParameter("replace", surName);
		return query.getResultList();
	}
	
}
