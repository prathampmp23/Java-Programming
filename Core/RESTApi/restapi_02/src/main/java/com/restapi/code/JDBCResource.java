package com.restapi.code;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class JDBCResource {
    // to see new changes on browser go to
    // v MAVEN (in side bar pannel bottom)
    // Lifecycle ->
    // 1.clean
    // 2.package
    // 3.deploy

    AlienRepository repo = new AlienRepository();

    // get all aliens
    @GET // http://localhost:8080/restapi_02/api/aliens
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Alien> getAlien() {
        System.out.println("Get all Aliens is called!");
        return repo.getAliens();
    }

    // *** Path param *** //
    // get alien based on id
    @GET // ->>> http://localhost:8080/restapi_02/api/aliens/101
    @Path("{id}") // {id} is just a placeholder
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Alien getAlien(@PathParam("id") int id) { // @PathParam("id") value from this assign to "int id"
        System.out.println("Get alien with id called!");
        return repo.getAlien(id);
    }

    // add new alien
    @POST // -->>> http://localhost:8080/restapi_02/api/aliens with XML Body
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Alien creatAlien(Alien a) {
        System.out.println("CreateAlien is called!");
        repo.createAlien(a);
        return a;
    }

    // update user with specified id
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void updateAlien(Alien a, @PathParam("id") int id) {
        System.out.println("UpdateAlien is called!");
        repo.updateAlien(a, id);
    }

    // Delete user with specific id
    @DELETE
    @Path("{id}")
    public Alien deleteAlien(@PathParam("id") int id) {
        System.out.println("DeleteAlien is called!");
        Alien a = repo.getAlien(id);
        if (a.getId() != 0)
            repo.deleteAlien(id);
        return a;
    }
}
