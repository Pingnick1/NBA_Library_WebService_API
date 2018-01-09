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
	
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#insertLoan(com.lexicon.library.domain.Loan)
	 */
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#insertLoan(com.lexicon.library.domain.Loan)
	 */
	@Override
	public void insertLoan(Loan loan) {
		em.persist(loan);

	}
	
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#findAllLoan()
	 */
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#findAllLoan()
	 */
	@Override
	public List<Loan> findAllLoan() {
		Query q = em.createQuery("select loan from Loan loan");
		List<Loan> Loans = q.getResultList();
		
		return Loans;
	}
	
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#findByIdLoan(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#findByIdLoan(int)
	 */
	@Override
	public Loan findByIdLoan(int id) {
		
		return em.find(Loan.class, id);		
		
	}
	
}
