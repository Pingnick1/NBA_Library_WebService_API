package com.lexicon.library.dataaccess;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lexicon.library.domain.Book;
import com.lexicon.library.domain.Loan;
import com.lexicon.library.domain.Member;

@Stateless
public class LoanDataAccessProductionVersion implements LoanDataAccess{

	@Inject
	private EntityManager em;
	
	/** 
	 * Insert a loan, and connect it to a an existing member in the database.
	 */
	@Override
	public void insertLoan(int memberId) {
		LocalDate now = LocalDate.now();
		LocalDate endDate = LocalDate.now().plusDays(40);
		
		Loan loan = new Loan(endDate.toString());
		
		Member member = em.find(Member.class, memberId);
		em.persist(loan);
		loan.setMember(member);

	}
	
	/** 
	 * Insert a loan with a specific end date, and connect it to a an existing member in the database.
	 */
	@Override
	public void insertLoan(String endDate, int memberId) {
		Loan loan = new Loan(endDate);
		Member member = em.find(Member.class, memberId);
		em.persist(loan);
		loan.setMember(member);

	}
	
	/** 
	 * Get all the loans from the database.
	 */
	@Override
	public List<Loan> findAllLoans() {
		Query q = em.createQuery("select loan from Loan loan");
		List<Loan> Loans = q.getResultList();
		
		return Loans;
	}
	
	/** 
	 * Find a specific Loan with id as parameter.
	 */
	@Override
	public Loan findByIdLoan(int id) {
		
		return em.find(Loan.class, id);		
		
	}
	
	/**
	 * Delete a specific Loan with id as parameter.
	 */
	@Override
	public void deleteLoan(int id) {
		Loan loan = em.find(Loan.class, id);
		em.remove(loan);
	}
	
	/**
	 * Add a specific book to a specific loan using their IDs as parameters. Multiple books can be set to a loan.
	 */
	@Override
	public void addBookToLoan(int loanId,int bookId) {
		Loan loan = em.find(Loan.class, loanId);
		Book book=em.find(Book.class, bookId);
		loan.setBook(book);
		book.setLoan(loan);
		em.merge(book);
		em.merge(loan);
		
		//em.merge(book);
	}
	
//	@Override
//	public void updateLoan(int id) {
//		Loan loan = em.find(Loan.class, id);
//		em.remove(loan);
//	}


	
}
