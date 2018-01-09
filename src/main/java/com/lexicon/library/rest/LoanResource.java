package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.LoanDataAccess;
import com.lexicon.library.domain.Loan;


@Path("/loan")
public class LoanResource {

	
	@Inject
	LoanDataAccess lda;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveLoan(Loan loan) throws URISyntaxException {
		lda.insertLoan(loan);
	return	Response
	.created(new URI("localhost:8080/NBA_Library_WebService_API/rest/loan")).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLoans(){
		return Response.ok(lda.findAllLoan()).build();
		//return dao.findAllLoan();
	}
	
	
}
