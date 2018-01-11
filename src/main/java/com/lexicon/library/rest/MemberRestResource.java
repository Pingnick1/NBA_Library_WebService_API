package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.MemberDataAccess;
import com.lexicon.library.domain.Member;

@Path("/member")
public class MemberRestResource {
	
	@Inject
	MemberDataAccess dao;
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Member member) throws URISyntaxException {
		dao.insert(member);
	return	Response
	.created(new URI("localhost:8080/personNotes/rest/member")).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMembers(){
		return Response.ok(dao.findAll()).build();
		//return dao.getAllPerson();
	}
	
	/*
	@POST
	@Path("/{id}/note")
	public Response addNoteToPerson(Long id, @QueryParam("text") String text) throws URISyntaxException {
		dao.addNoteToPerson(id , text);
		return	Response
				.created(new URI("localhost:8080/personNotes/rest/person/" + id +"/note/" + text)).build();
	}
	*/
	
	
	
	
	
	

}
