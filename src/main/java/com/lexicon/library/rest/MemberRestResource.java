package com.lexicon.library.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

import com.lexicon.library.dataaccess.MemberDataAccess;
import com.lexicon.library.domain.Member;
import com.lexicon.library.domain.memberStatus;

@Path("/member")
public class MemberRestResource {
	
	@Inject
	MemberDataAccess dao;
	
	/**---------------------------------
	* Create Member
	* POST http://<adress>:<port>/NBA_Library_WebService_API/rest/member
	* JSON: {"firstName":"<firstname>", "surName":"<lastname>", "email":"<email>", "status":"ACTIVE"}
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
		List<Member> memberList = dao.findAll();
		
		if(memberList.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(memberList).build();
	}
	
	/**---------------------------------
	* Find Member By Id
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/id/{id}
	* param id
	* param string
	*----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Response getMemberById(@PathParam("id") int id){
		return Response.ok(dao.findMemberById(id)).build();
	}
	
	/**---------------------------------
	* Find Member By Email
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/email/{email}
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/email/{email}")
	public Response getMemberByEmail(@PathParam("email") String email){
		Member m = dao.findMemberByEmail(email);
		
		if(m==null)
			return Response.noContent().build();
		else
			return Response.ok(m).build();
	}
	
	/**---------------------------------
	* Find Members by firstName
	* @param firstname
	* {@code} GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/firstname/{firstname}
	*----------------------------------*/ 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/firstname/{firstName}")
	public Response getMembersByFirstName(@PathParam("firstName") String firstName){
		List<Member> memberList = dao.findMembersByFirstName(firstName);
		
		if(memberList.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(memberList).build();
		
		//return Response.ok(dao.findMembersByFirstName(firstName)).build();
	}
	
	/**---------------------------------
	* Find Members by surName
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/surname/{surname}
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/surname/{surName}")
	public Response getMembersBySurName(@PathParam("surName") String surName){
		List<Member> memberList = dao.findMembersBySurName(surName);
		
		if(memberList.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(memberList).build();
		
		//return Response.ok(dao.findMembersBySurName(surName)).build();
	}
	
	/**---------------------------------
	* Find Members by firstName, surName or email
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/criteria/{criteria}
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/criteria/{criteria}")
	public Response getMemberByAnything(@PathParam("criteria") String criteria){
		List<Member> memberList = dao.findMember(criteria);
		
		if(memberList.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(memberList).build();		
		
		//return Response.ok(dao.findMember(criteria)).build();
	}
	
	/**---------------------------------
	* Find Members by status
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/status/{status}
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status/{status}")
	public Response getMembersByStatus(@PathParam("status") memberStatus status){
		List<Member> memberList = dao.findMembersByStatus(status);
		
		if(memberList.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(memberList).build();	
		//return Response.ok(dao.findMembersByStatus(status)).build();
	}
	
	/**---------------------------------
	* Set Member status
	* PUT: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/{memberid}/status/{newStatus}
	*-----------------------------------*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{memberid}/status/{newStatus}")
	public Response setMemberStatus(@PathParam("memberid") int memberid, @PathParam("newStatus") memberStatus newStatus){
		
		return Response.ok(dao.setMemberStatus(memberid, newStatus)).build();
	}
	
	/**---------------------------------
	* Get Member status
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/{memberid}/status
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{memberid}/status")
	public Response getMemberStatus(@PathParam("memberid") int memberid){
		
		return Response.ok(dao.getMemberStatus(memberid)).build();
	}
	
	/**---------------------------------
	* Get All possible Member Status
	* GET: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/status
	*-----------------------------------*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status")
	public Response getMemberPossibleStatus(){
		
		return Response.ok(dao.getMemberPossibleStatus()).build();
	}
	
	/**---------------------------------
	* Get Delete member from Member, HARD
	* DELETE: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/id/{memberid}
	*-----------------------------------*/
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{memberid}")
	public Response deleteMember(@PathParam("memberid") int memberid){
		
		return Response.ok(dao.deleteMember(memberid)).build();
	}
	
	/**---------------------------------
	* Set Delete member from Member, SOFT (Just change status)
	* PUT: http://<adress>:<port>/NBA_Library_WebService_API/rest/member/id/{memberid}
	*-----------------------------------*/
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{memberid}")
	public Response removeMember(@PathParam("memberid") int memberid){
		
		return Response.ok(dao.removeMember(memberid)).build();
	}
		
}
