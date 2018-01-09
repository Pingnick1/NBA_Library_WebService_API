package com.lexicon.library.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.BookDataAccess;

@Path("/book")
public class BookResource {
    
    @Inject
    BookDataAccess bda;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks(){
        return Response.ok(bda.findAll()).build();
        //return dao.getAllPerson();
    }
    
    
    

}