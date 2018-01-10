package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.lexicon.library.domain.Loan;

@Stateless
public class LoanDataAccessProductionVersion implements LoanDataAccess{

	@Inject
	private EntityManager em;
	
	@Override
	public void insertLoan(Loan loan) {
		em.persist(loan);

	}
	
	@Override
	public List<Loan> findAllLoans() {
		Query q = em.createQuery("select loan from Loan loan");
		List<Loan> Loans = q.getResultList();
		
		return Loans;
	}
	
	@Override
	public Loan findByIdLoan(int id) {
		
		return em.find(Loan.class, id);		
		
	}
	
	@Override
	public void deleteLoan(Loan loan) {
		em.remove(loan);
	}

	
}
