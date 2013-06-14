package com.github.xseignard.mavenGrunt.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.github.xseignard.mavenGrunt.server.db.GeeksRepo;

@Path("/geek")
public class GeekResource {

	@GET
	@Path("/likes/{like:.*}")
	@Produces("application/json")
	public Response find(@PathParam("like") String like,
			@QueryParam("limit") Integer limit, @QueryParam("skip") Integer skip) {
		String geeks = new GeeksRepo().find(like, limit, skip);
		return Response.status(200).entity(geeks).build();
	}

}
