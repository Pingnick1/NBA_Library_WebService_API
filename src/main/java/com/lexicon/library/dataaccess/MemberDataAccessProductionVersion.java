package com.lexicon.library.dataaccess;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lexicon.library.domain.Loan;
import com.lexicon.library.domain.Member;
import com.lexicon.library.domain.memberStatus;

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
		
		return query.getResultList();
	}
	
	/**
	 *  Find members by firstName, surName or email.
	 *  @param memberId
	 *  @param newStatus
	 *  @return	Member
	 */
	@Override
	public Member setMemberStatus(int memberId, memberStatus newStatus) {
		Member m =  em.find(Member.class, memberId);
		
		m.setStatus(newStatus);
		em.merge(m);
		
		return m;
	}
	
	/**
	 *  Get member status
	 *  @param memberId
	 *  @return	Member
	 */
	@Override
	public memberStatus getMemberStatus(int memberId) {
		Member m =  em.find(Member.class, memberId);	
		return m.getStatus();
	}
	
	/**
	 *  Get All possible statuses
	 *  @return	List<memberStatus>
	 */
	@Override
	public List<memberStatus> getMemberPossibleStatus() {
		List<memberStatus> newList = Arrays.asList(memberStatus.values());
		
		return newList;	
	}

	/**
	 * Get Members by Status
	 * @param Status
	 */
	@Override
	public List<Member> findMembersByStatus(memberStatus status) {
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.status=?1", Member.class);		
		query.setParameter(1, status.name());
		
		return query.getResultList();
	}

	@Override
	public boolean deleteMember(int memberid) {
		Member m = em.find(Member.class, memberid);
		em.remove(m);
		return true;
	}
}
