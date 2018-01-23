package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lexicon.library.domain.Member;

@Stateless
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@Inject
	private EntityManager em;
	
	/**
	 * 	Create new member.
	 * 	@param New Member
	 * 
	 */
	@Override
	public void insert(Member newMember) {
		em.persist(newMember);
	}

	/**
	 * @Get all members.
	 * @return List of all Members.
	 */
	@Override
	public List<Member> findAll() {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
		return query.getResultList();
	}
	
	/**
	 * 	Find member by ID
	 * 	@param Member Id
	 * 	@return	Member
	 */
	@Override
	public Member findMemberById(int id) {
		return em.find(Member.class, id);	
	}
	
	/**
	 * 	Find member by Email
	 * @param email
	 * @return Member that matches email
	 */
	@Override
	public Member findMemberByEmail(String email) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.email LIKE ?1", Member.class);		
		query.setParameter(1, email);
		return query.getSingleResult();
	}

	/**
	 * 	Find members by firstname
	 * 	@param firstname
	 *  @return List of Member
	 */
	@Override
	public List<Member> findMembersByFirstName(String firstName) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.firstName LIKE ?1", Member.class);	
		query.setParameter(1, "%" + firstName + "%");
		return query.getResultList();
	}
	
	/**
	 *  Find members by lastname.
	 *  @param surname
	 *  @return	List of Members
	 */
	@Override
	public List<Member> findMembersBySurName(String surName) {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.surName LIKE ?1", Member.class);
		query.setParameter(1, "%" + surName + "%");
		return query.getResultList();
	}

	
	/**
	 *  Find members by firstName, surName or email.
	 *  @param criteria
	 *  @return	List of Members
	 */
	@Override
	public List<Member> findMember(String criteria) {
		//TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.firstName LIKE ?1 OR m.surName LIKE ?1 OR m.email LIKE ?1 ", Member.class);
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.firstName LIKE ?1 OR m.surName LIKE ?1 OR m.email LIKE ?1 ", Member.class);
		
		query.setParameter(1, "%" + criteria + "%");
		//query.setParameter(2, "%" + criteria + "%");
		//query.setParameter(3, "%" + criteria + "%");
		
		return query.getResultList();
	}
	
}
