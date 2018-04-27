package com.lexicon.library.rest;


import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
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
	
	@Inject
    private Validator validator;
	
	@Inject
    private Logger log;
	
	/**---------------------------------
	* Create Member
	* POST http://<adress>:<port>/NBA_Library_WebService_API/rest/member
	* JSON: {"firstName":"<firstname>", "surName":"<lastname>", "email":"<email>", "status":"ACTIVE"}
	* Returns: 
	* 	Success:	201 - Created
	* 	Fail: 		304 - Not modified  (if email already exist, ETag i headern på meddelandet="Email already exist!")
	*----------------------------------*/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(Member member) throws URISyntaxException {
		Response.ResponseBuilder builder = null;
			
		try {
            // Validates member using bean validation
            validateMember(member);
		
            dao.insert(member);

            // Create an "ok" response
            builder = Response.ok();
		
		}catch (ConstraintViolationException ce) {
            // Handle bean validation issues
            builder = createViolationResponse(ce.getConstraintViolations());
        } catch (ValidationException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("email", "Email taken");
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
				
		/*
		if(dao.insert(member)) {
			return	Response.created(new URI("localhost:8080/NBA_Library_WebService_API/rest/member")).build();
		}
		else {
			return Response.notModified("Email already exist!").build();
		}*/    
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
		try {
			Member m = dao.findMemberByEmail(email);
			return Response.ok(m).build();
		}catch(NoResultException e) {
			return Response.noContent().build();
		}			
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
	* PUT: http://<adress>:<port>/booklibrary/member/{memberid}/status/{newStatus}
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
	
	
	
	
	/**
     * <p>
     * Validates the given Member variable and throws validation exceptions based on the type of error. If the error is standard
     * bean validation errors then it will throw a ConstraintValidationException with the set of the constraints violated.
     * </p>
     * <p>
     * If the error is caused because an existing member with the same email is registered it throws a regular validation
     * exception so that it can be interpreted separately.
     * </p>
     * 
     * @param member Member to be validated
     * @throws ConstraintViolationException If Bean Validation errors exist
     * @throws ValidationException If member with the same email already exists
     */
    private void validateMember(Member member) throws ConstraintViolationException, ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Member>> violations = validator.validate(member);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }

        // Check the uniqueness of the email address
        if (emailAlreadyExists(member.getEmail())) {
            throw new ValidationException("Unique Email Violation");
        }
    }
	
    /**
     * Creates a JAX-RS "Bad Request" response including a map of all violation fields, and their message. This can then be used
     * by clients to show violations.
     * 
     * @param violations A set of violations that needs to be reported
     * @return JAX-RS response containing all violations
     */
    private Response.ResponseBuilder createViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }

    /**
     * Checks if a member with the same email address is already registered. This is the only way to easily capture the
     * "@UniqueConstraint(columnNames = "email")" constraint from the Member class.
     * 
     * @param email The email to check
     * @return True if the email already exists, and false otherwise
     */
    public boolean emailAlreadyExists(String email) {
    	Member member = null;
    	try {
        	member = dao.findMemberByEmail(email);
        	
        } catch (Throwable e) {
            //return true;// ignore
        }
        return member != null;
    }
		
}
