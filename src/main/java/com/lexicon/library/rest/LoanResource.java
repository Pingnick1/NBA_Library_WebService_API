package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	public Response insertLoan(Loan loan) throws URISyntaxException {
		lda.insertLoan(loan);
	return	Response
	.created(new URI("http://localhost:8080/NBA_Library_WebService_API/rest/loan")).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAllLoans(){
		return Response.ok(lda.findAllLoans()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response findByIdLoan(@PathParam("id") int id){
		return Response.ok(lda.findByIdLoan(id)).build();
	}
	
	@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteLoan(@PathParam("id") int id){
        lda.deleteLoan(id);
		//please do something here
		return Response.ok().build();
    }
	
	@PUT
	@Path("/{loanId}/book/{bookId}")
	public Response addBookToLoan(@PathParam("loanId") int loanId, @PathParam("bookId") int bookId) throws URISyntaxException {
		lda.addBookToLoan(loanId, bookId);
		return	Response.ok().build();
	}
}
