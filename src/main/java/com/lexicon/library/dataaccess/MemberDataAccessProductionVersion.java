package com.lexicon.library.dataaccess;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//import com.lexicon.library.domain.Loan;
import com.lexicon.library.domain.Member;
import com.lexicon.library.domain.memberStatus;

@Stateless
public class MemberDataAccessProductionVersion implements MemberDataAccess {

	@Inject
	private EntityManager em;
	

	
	/********************************************************
	 * 	Create new member.
	 * 	@param New Member
	 * 
	 ********************************************************/
	@Override
	public void insert(Member newMember) {
		//Member m = findMemberByEmail(newMember.getEmail());
		//if(m == null) {
		em.persist(newMember);
		//return true;
		//}			
		//else {
		//	return false;
		//}
	}

	/********************************************************
	 * @Get all members.
	 * @return List of all Members.
	 ********************************************************/
	@Override
	public List<Member> findAll() {
		Query query = em.createNativeQuery("SELECT * FROM Member m", Member.class);
		return query.getResultList();
	}
	
	/********************************************************
	 * 	Find member by ID
	 * 	@param Member Id
	 * 	@return	Member
	 ********************************************************/
	@Override
	public Member findMemberById(int id) {
		return em.find(Member.class, id);	
	}
	
	/********************************************************
	 * 	Find member by Email
	 * @param email
	 * @return Member that matches email
	 * @throws NoResultException
	 ********************************************************/
	@Override
	public Member findMemberByEmail(String email) throws NoResultException { 
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
//        Root<Member> member = criteria.from(Member.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
//        criteria.select(member).where(cb.equal(member.get("email"), email));
//        return em.createQuery(criteria).getSingleResult();
		
		
		Member m = null;
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.email LIKE ?1", Member.class);		
		query.setParameter(1, email);
		m = (Member) query.getSingleResult();
		return m; //(Member) query.getSingleResult();
		

	}

	/********************************************************
	 * 	Find members by firstname
	 * 	@param firstname
	 *  @return List of Member
	 ********************************************************/
	@Override
	public List<Member> findMembersByFirstName(String firstName) {
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.firstName LIKE ?1", Member.class);	
		query.setParameter(1, "%" + firstName + "%");
		return query.getResultList();
	}
	
	/********************************************************
	 *  Find members by lastname.
	 *  @param surname
	 *  @return	List of Members
	 ********************************************************/
	@Override
	public List<Member> findMembersBySurName(String surName) {
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.surName LIKE ?1", Member.class);
		query.setParameter(1, "%" + surName + "%");
		return query.getResultList();
	}

	
	/********************************************************
	 *  Find members by firstName, surName or email.
	 *  @param criteria
	 *  @return	List of Members
	 ********************************************************/
	@Override
	public List<Member> findMember(String criteria) {
		//TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.firstName LIKE ?1 OR m.surName LIKE ?1 OR m.email LIKE ?1 ", Member.class);
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.firstName LIKE ?1 OR m.surName LIKE ?1 OR m.email LIKE ?1 ", Member.class);		
		query.setParameter(1, "%" + criteria + "%");
		
		return query.getResultList();
	}
	
	/********************************************************
	 *  Find members by firstName, surName or email.
	 *  @param memberId
	 *  @param newStatus
	 *  @return	Member
	 ********************************************************/
	@Override
	public Member setMemberStatus(int memberId, memberStatus newStatus) {
		Member m =  em.find(Member.class, memberId);
		m.setStatus(newStatus);
		em.merge(m);
		
		return m;
	}
	
	/********************************************************
	 *  Get member status
	 *  @param memberId
	 *  @return	Member
	 ********************************************************/
	@Override
	public memberStatus getMemberStatus(int memberId) {
		Member m =  em.find(Member.class, memberId);	
		return m.getStatus();
	}
	
	/********************************************************
	 *  Get All possible statuses
	 *  @return	List<memberStatus>
	 ********************************************************/
	@Override
	public List<memberStatus> getMemberPossibleStatus() {
		List<memberStatus> newList = Arrays.asList(memberStatus.values());
		
		return newList;	
	}

	/********************************************************
	 * Get Members by Status
	 * @param Status
	 ********************************************************/
	@Override
	public List<Member> findMembersByStatus(memberStatus status) {
		Query query = em.createNativeQuery("SELECT * FROM Member m WHERE m.status=?1", Member.class);		
		query.setParameter(1, status.name());
		
		return query.getResultList();
	}

	/********************************************************
	 * Delete Member by ID Hard, remove from DB completely
	 * @param memberId
	 ********************************************************/
	@Override
	public boolean deleteMember(int memberid) {
		Member m = em.find(Member.class, memberid);
		em.remove(m);
		return true;
	}

	/********************************************************
	 * Remove Member by Id, just change status to UNACTIVE
	 * @param memberId
	 ********************************************************/
	@Override
	public boolean removeMember(int memberid) {
		Member m = em.find(Member.class, memberid);
		m.setStatus(memberStatus.UNACTIVE);
		em.merge(m);

		return true;
	}
}
