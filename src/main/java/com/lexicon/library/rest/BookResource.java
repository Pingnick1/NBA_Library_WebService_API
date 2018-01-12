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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.BookDataAccess;
import com.lexicon.library.domain.Book;
import com.lexicon.library.domain.Genres;

@Path("/book")
public class BookResource {
	
	@Inject
	BookDataAccess bda;
	
	
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Book book) throws URISyntaxException {
		bda.insert(book);
	return	Response.created(new URI("http://localhost:8080/NBA_Library_WebService_API/rest/book")).build();
	}
	
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response update(String updateColumn, String updateValue) throws URISyntaxException {
//		bda.insert();
//	return	Response.created(new URI("http://localhost:8080/NBA_Library_WebService_API/rest/book")).build();
//	}
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/id/{id}
	@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Response delete(@PathParam("id") int id){
        bda.deleteBook(id);
		return Response.ok().build();	
	}
	
	
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks(){
		return Response.ok(bda.findAll()).build();
	}
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Response findById(@PathParam("id") int id){
		return Response.ok(bda.findById(id)).build();
	}
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/title	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/title/{title}")
	public Response findByTitle(@PathParam("title") String title){
		return Response.ok(bda.findByTitle(title)).build();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/genre/{genre}")
	public Response findByGenre(@PathParam("genre") Genres genre){
		return Response.ok(bda.findByGenre(genre)).build();
	}
	
	@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        bda.deleteBook(id);
		return Response.ok().build();	
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/genre/{genre}")
//	public Response findByGenre(@PathParam("genre" ) ){
//		return Response.ok(bda.findByGenre(id)).build();
//	}
	
	
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/author/{author}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/author/{author}")
	public Response findByAuthor(@PathParam("author") String author){
		return Response.ok(bda.findByAuthor(author)).build();
	}
	
	
	
//	http://localhost:8080/NBA_Library_WebService_API/rest/book/isbn/{isbn}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/isbn/{isbn}")
	public Response findByISBN(@PathParam("isbn") long isbn){
		return Response.ok(bda.findByISBN(isbn)).build();
	}
	
}
