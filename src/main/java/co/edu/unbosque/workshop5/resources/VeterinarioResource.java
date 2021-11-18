package co.edu.unbosque.workshop5.resources;


import co.edu.unbosque.workshop5.resources.pojos.UsuarioPOJO;
import co.edu.unbosque.workshop5.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/veterinarios")
public class VeterinarioResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UsuarioPOJO vet) {
        Optional<UsuarioPOJO> persitedVet = new VetService().createVet(vet);
        return persitedVet.isPresent() ?
                Response.status(Response.Status.ACCEPTED)
                        .entity(persitedVet.get())
                        .build() :
                Response.serverError()
                        .entity("El usuario veterinario no pudo ser generado")
                        .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Response update(UsuarioPOJO vet, @PathParam("username") String username) {
        Optional<UsuarioPOJO> updatedVet = new VetService().updateVet(vet, username);
        return Response.ok().entity(updatedVet).build();
    }
}
