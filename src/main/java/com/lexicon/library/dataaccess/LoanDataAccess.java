package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Loan;

public interface LoanDataAccess {

	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#insertLoan(com.lexicon.library.domain.Loan)
	 */
	void insertLoan(Loan loan);

	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#findAllLoan()
	 */
	List<Loan> findAllLoan();

	/* (non-Javadoc)
	 * @see com.lexicon.library.dataaccess.LoanDataAccessjhg#findByIdLoan(java.lang.String)
	 */
	Loan findByIdLoan(int id);

}