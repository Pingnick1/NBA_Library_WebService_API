package com.lexicon.library.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.lexicon.library.domain.Loan;

@Stateless
@Alternative
@TestingDao
public interface LoanDataAccessTestingVersion {
	
	public List<Loan> findAllLoan(){
		
		Loan l1= new Loan('2018-01-4' ,'2018-02-1');
		Loan l2= new Loan('2018-01-1' ,'2018-02-1');
		Loan l3= new Loan('2018-01-1' ,'2018-02-1');
		
		List<Loan> listAllLoan = new ArrayList<Loan>();
		
		listAllLoan.add(l1);
		listAllLoan.add(l2);
		listAllLoan.add(l3);
		
		return listAllLoan;
	}

}
