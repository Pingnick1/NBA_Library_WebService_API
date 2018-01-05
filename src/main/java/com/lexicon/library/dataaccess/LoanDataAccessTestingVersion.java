package com.lexicon.library.dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.lexicon.library.domain.Loan;

@Stateless
@Alternative
@TestingDao
public class LoanDataAccessTestingVersion implements LoanDataAccess {
	
	public List<Loan> findAllLoan(){
		String date="2018-01-02";
		String edate="2018-01-29";
		
		LocalDate d=LocalDate.parse(date);
		LocalDate ed=LocalDate.parse(edate);
		
		Loan l1= new Loan( d,ed);
		Loan l2= new  Loan( d,ed);
		Loan l3= new  Loan( d,ed);
		
		List<Loan> listAllLoan = new ArrayList<Loan>();
		
		listAllLoan.add(l1);
		listAllLoan.add(l2);
		listAllLoan.add(l3);
		
		return listAllLoan;
	}

}
