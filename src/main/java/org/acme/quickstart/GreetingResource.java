package org.acme.quickstart;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }


    @GET
    @Path("forbidden")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response forbidden() {
        return Response.ok().build();
    }
}
