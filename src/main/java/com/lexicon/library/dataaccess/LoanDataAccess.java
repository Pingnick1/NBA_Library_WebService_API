package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Loan;

public interface LoanDataAccess {

	List<Loan> findAllLoans();

	Loan findByIdLoan(int id);

	void deleteLoan(int id);

	void addBookToLoan(int loanId, int bookId);

	void insertLoan(String endDate, int memberId);

	void insertLoan(int memberId);

	

}