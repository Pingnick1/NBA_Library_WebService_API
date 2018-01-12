package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lexicon.library.dataaccess.MemberDataAccess;
import com.lexicon.library.domain.Member;

@Path("/member")
public class MemberRestResource {
	
	@Inject
	MemberDataAccess dao;
	
	/**---------------------------------
	* Create Member
	* POST http://<adress>:<port>/NBA_Library_WebService_API/rest/member
	* JSON: {"firstName":"<firstname>", "surName":"<lastname>", "email":"<email>"}
	*----------------------------------*/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Member member) throws URISyntaxException {
		dao.insert(member);
	return	Response
	.created(new URI("localhost:8080/NBA_Library_WebService_API/rest/member")).build();
	}
	
	/**---------------------------------
	* Get All Members
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/all
	*----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAllMembers(){
		return Response.ok(dao.findAll()).build();
	}
	
	/**---------------------------------
	* Find Member By Id
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/id/<id>
	*----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Response getMemberById(@PathParam("id") int id){
		return Response.ok(dao.findMemberById(id)).build();
	}
	
	/**---------------------------------
	* Find Member By Email
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/email/<email>
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/email/{email}")
	public Response getMemberByEmail(@PathParam("email") String email){
		return Response.ok(dao.findMemberByEmail(email)).build();
	}
	
	/**---------------------------------
	* Find Members by firstName
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/firstname/<firstname>
	*----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/firstname/{firstName}")
	public Response getMembersByFirstName(@PathParam("firstName") String firstName){
		return Response.ok(dao.findMembersByFirstName(firstName)).build();
	}
	
	/**---------------------------------
	* Find Members by surName
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/surname/<surname>
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/surname/{surName}")
	public Response getMembersBySurName(@PathParam("surName") String surName){
		return Response.ok(dao.findMembersBySurName(surName)).build();
	}
		
}
