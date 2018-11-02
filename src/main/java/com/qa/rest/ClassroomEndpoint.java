package com.qa.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.IClassroomService;

@Path("/Classroom")
public class ClassroomEndpoint {
	
	@Inject
	private IClassroomService service;

	@Path("/getAllClassrooms")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllClassrooms();
	}

	@Path("/createClassroom")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String classroom) {
		return service.createClassroom(classroom);
	}
	
	@Path("/updateClassroom")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(String classroom) {
		return service.updateClassroom(classroom);
	}

	@Path("/deleteClassroom/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteClassroom(id);
	}

	public void setService(IClassroomService service) {
		this.service = service;
	}

}
