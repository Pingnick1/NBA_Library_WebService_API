package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.lexicon.library.domain.Book;
import com.lexicon.library.domain.Loan;

@Stateless
public class LoanDataAccessProductionVersion implements LoanDataAccess{

	@Inject
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#insertLoan(com.lexicon.library.domain.Loan)
	 */
	@Override
	public void insertLoan(Loan loan) {
		em.persist(loan);

	}
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#findAllLoans()
	 */
	@Override
	public List<Loan> findAllLoans() {
		Query q = em.createQuery("select loan from Loan loan");
		List<Loan> Loans = q.getResultList();
		
		return Loans;
	}
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#findByIdLoan(int)
	 */
	@Override
	public Loan findByIdLoan(int id) {
		
		return em.find(Loan.class, id);		
		
	}
	
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#deleteLoan(int)
	 */
	@Override
	public void deleteLoan(int id) {
		Loan loan = em.find(Loan.class, id);
		em.remove(loan);
	}
	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccess#addBookToLoan(int, int)
	 */
	@Override
	public void addBookToLoan(int loanId,int bookId) {
		Loan loan = em.find(Loan.class, loanId);
		Book book=em.find(Book.class, bookId);
		loan.setBook(book);
		//fuckbook.setLoan(loan);
		em.merge(loan);
		//em.merge(book);
	}

	
}
