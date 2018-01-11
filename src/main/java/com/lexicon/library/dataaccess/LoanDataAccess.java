package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Loan;


public interface LoanDataAccess {

	void insertLoan(Loan loan, int memberId);

	List<Loan> findAllLoans();

	Loan findByIdLoan(int id);

	void deleteLoan(int id);

	void addBookToLoan(int loanId, int bookId);

}