package com.example.rs;

import com.example.model.Person;
import com.example.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    private PersonService personService; // CDI can inject EJBs

    @GET
    public List<Person> getAll() {
        return personService.list();
    }

    @POST
    public Response create(Person p, @Context UriInfo uriInfo) {
        Person created = personService.create(p);
        UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(String.valueOf(created.getId()));
        return Response.created(ub.build()).entity(created).build();
    }
}
