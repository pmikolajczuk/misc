package pl.mikolaj.restjersey;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Alien> getAliens() {
        System.out.println("AlienResource.getAliens() called");
        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien getAlien(@PathParam("id") int id) {
        System.out.println("AlienResource.getAlien() called with id: " + id);
        return repo.getAlien(id);
    }

    @POST
    @Path("alien")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Alien createAlien(Alien alien) {
        System.out.println("AlienResource.createAlien() called with alien: " + alien);
        repo.create(alien);
        return alien;
    }
}
