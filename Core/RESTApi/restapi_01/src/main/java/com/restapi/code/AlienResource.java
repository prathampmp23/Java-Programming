package com.restapi.code;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

    // get object on link http://localhost:8080/restapi_01/api/aliens
    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // public Alien getAlien() {
    //     System.out.println("Alien is called!");
    //     Alien a1 = new Alien();
    //     a1.setName("Pratham");
    //     a1.setPoints(60);
    //     return a1;
    // }

    // to see new changes on browser go to
    // v MAVEN (in side bar pannel bottom)
    // Lifecycle ->
    // 1.clean
    // 2.package
    // 3.deploy

    // then we get new changes on browser

    // to get list of objects
    // @GET
    // @Produces(MediaType.APPLICATION_XML)
    // public List<Alien> getAlien() {
    //     System.out.println("Alien is called!");
    //     Alien a1 = new Alien();
    //     a1.setId(101);
    //     a1.setName("Pratham");
    //     a1.setPoints(60);

    //     Alien a2 = new Alien();
    //     a2.setId(102);
    //     a2.setName("Rishabh");
    //     a2.setPoints(50);
    //     List<Alien> list = Arrays.asList(a1, a2);
    //     return list;
    // }

    AlienRepository repo = new AlienRepository();

    // get all (list) aliens
    @GET
    // content negotiation - pass array for XML and JSON requested data
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML }) 
    public List<Alien> getAlien() {
        System.out.println("AlienRepository is called!");
        return repo.getAliens();
    }
    
    // *** content negotiation ***
    // if client say i want JSON then server send JSON
    // if client say i want XML then sever send XML
    
    // for this we need to add dependency ->
    // org.glassfish.jersey.media
    // jersey-media-json-jackson
    // get all (list) aliens
    
    // ** order matters ** browser select 1st one if method not specified
    // @Produces({ 
    //      MediaType.APPLICATION_JSON,  // 1st
    //      MediaType.APPLICATION_XML    // 2nd
    // }) 


    // public List<Alien> getAlien() {
    //     System.out.println("AlienRepository is called!");
    //     return repo.getAliens();
    // }

    // *** Path param *** //
    @GET
    @Path("{id}") // {id} is just a placeholder
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Alien getAlien(@PathParam("id") int id) { // @PathParam("id") value from this assign to "int id"
        return repo.getAlien(id);
    }

    // add new alien
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Alien creatAlien(Alien a) {
        System.out.println("CreateAlien is called!");
        repo.createAlien(a);
        return a;
    }
}
