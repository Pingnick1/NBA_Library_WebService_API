package com.lexicon.library.dataaccess;

import java.util.List;

import com.lexicon.library.domain.Loan;


public interface LoanDataAccess {
	
	public abstract List<Loan> findAllLoan();

}