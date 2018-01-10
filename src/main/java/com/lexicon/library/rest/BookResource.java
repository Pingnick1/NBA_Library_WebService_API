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

import com.lexicon.library.dataaccess.BookDataAccess;
import com.lexicon.library.domain.Book;
import com.lexicon.library.domain.Loan;

@Path("/book")
public class BookResource {
	
	@Inject
	BookDataAccess bda;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Book book) throws URISyntaxException {
		bda.insert(book);
	return	Response.created(new URI("http://localhost:8080/NBA_Library_WebService_API/rest/book")).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks(){
		return Response.ok(bda.findAll()).build();
	}
	
	
	

}
