package co.edu.unbosque.workshop5.resources;

import co.edu.unbosque.workshop5.resources.pojos.PetPOJO;
import co.edu.unbosque.workshop5.services.PetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/mascotas")
public class MascotaResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(PetPOJO pet) {
        Optional<PetPOJO> persistedPet = new PetService().createPet(pet);
        return persistedPet.isPresent() ?
                Response.status(Response.Status.CREATED)
                        .entity(persistedPet.get())
                        .build() :
                Response.serverError()
                        .entity("La mascota no pudo ser generada")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{pet_id}")
    public Response update(PetPOJO pet, @PathParam("pet_id") Integer petId) {
        Optional<PetPOJO> updatedPet = new PetService().updatePet(pet, petId);
        return Response.ok().entity(updatedPet).build();
    }
}
