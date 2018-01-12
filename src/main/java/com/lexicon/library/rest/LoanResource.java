package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.LoanDataAccess;
import com.lexicon.library.domain.Loan;

/** 
 * This resource takes in JSON Strings. Example:
 * To make startDate the current date:
 * {"endDate":"2017-12-09"}
 *  * to set your own startDate:
 * {"startDate":"2017-12-09", "endDate":"2017-12-09"}
 */
@Path("/loan")
public class LoanResource {

	
	@Inject
	LoanDataAccess lda;

	
	/** 
	 * Find a specific Loan with id as parameter.
	 * http://<adress>:<port>/NBA_Library_WebService_API/rest/loan/member/{memberId}
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/member/{memberId}")
	public Response insertLoan(Loan loan, @PathParam("memberId") int memberId) throws URISyntaxException {
		lda.insertLoan(loan, memberId);
	return	Response
	.created(new URI("http://localhost:8080/NBA_Library_WebService_API/rest/loan")).build();
	}
	
	/** 
	 * Get all the loans from the database.
	 * http://<adress>:<port>/NBA_Library_WebService_API/rest/loan/
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAllLoans(){
		return Response.ok(lda.findAllLoans()).build();
	}

	/** 
	 * Find a specific Loan with id as parameter.
	 * http://<adress>:<port>/NBA_Library_WebService_API/rest/loan/{id}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findByIdLoan(@PathParam("id") int id){
		return Response.ok(lda.findByIdLoan(id)).build();
	}
	
	/**
	 * Delete a specific Loan with id as parameter.
	 * http://<adress>:<port>/NBA_Library_WebService_API/rest/loan/{id}
	 */	
	@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteLoan(@PathParam("id") int id){
        lda.deleteLoan(id);
		//please do something here
		return Response.ok().build();
    }
	
	/**
	 * Add a specific book to a specific loan using their IDs as parameters. Multiple books can be set to a loan.
	 * http://<adress>:<port>/NBA_Library_WebService_API/rest/loan/{loanId}/book/{bookId}
	 */
	@PUT
	@Path("/{loanId}/book/{bookId}")
	public Response addBookToLoan(@PathParam("loanId") int loanId, @PathParam("bookId") int bookId) throws URISyntaxException {
		lda.addBookToLoan(loanId, bookId);
		return	Response.ok().build();
	}
	/*
	@DELETE
	@Path("/{loanId}/book/{bookId}")
	public Response RemoveBookToLoan(@PathParam("loanId") int loanId, @PathParam("bookId") int bookId) throws URISyntaxException {
		lda.addBookToLoan(loanId, bookId);
		return	Response.ok().build();
	}
	*/
}
